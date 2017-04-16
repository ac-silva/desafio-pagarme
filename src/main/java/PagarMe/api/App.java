package PagarMe.api;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import PagarMe.api.handler.BankAccountHandler;
import PagarMe.api.handler.CardHandler;
import PagarMe.api.handler.RecipientHandler;
import PagarMe.api.handler.TransactionHandler;
import PagarMe.api.model.Address;
import PagarMe.api.model.BankAccount;
import PagarMe.api.model.Card;
import PagarMe.api.model.Customer;
import PagarMe.api.model.Phone;
import PagarMe.api.model.Recipient;
import PagarMe.api.model.Transaction;

public class App {
   /*
    *  public static void main(String[] args){
		try {
			Client client = new Client("https://api.pagar.me/1", "ak_test_WeKhY9b8xpVNmkJgzoQFCl2YDFAbVv");
	        //BankAccount account = createBankAccount(client);
	        //Recipient recipient = createRecipient(client, account);
	        Transaction transaction = createTransaction(client);
	        System.out.println(transaction.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    */
    
    public static BankAccount createBankAccount(Client client){
    	BankAccount account 	   = new BankAccount();
    	BankAccountHandler handler = new BankAccountHandler(client);
    	account.setBankCode("341");
    	account.setAngencia("0932");
    	account.setAngenciaDv("1");
    	account.setConta("58054");
    	account.setContaDv("5");
    	account.setCpf("26268738888");
    	account.setLegalName("API BANK ACCOUNT");
        try {
			return handler.createBankAccount(account);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    public static Recipient createRecipient(Client client, BankAccount bankAccount){
    	Recipient recipient 		      = new Recipient();
        RecipientHandler recipientHandler = new RecipientHandler(client);
        recipient.setTransferInterval("weekly");
        recipient.setTransferDay(5);
        recipient.setTransferEnabled(true);
        recipient.setAutomaticAnticipationEnabled(true);
        recipient.setAnticipatableVolumePercentage(85);
        recipient.setBankAccount(bankAccount);
        try {
        	
			return recipientHandler.createRecipient(recipient);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    public static Transaction createTransaction(Client client){
        TransactionHandler handler = new TransactionHandler(client);
        Transaction t = new Transaction();
        t.setAmount(1000);
        Customer c = new Customer();
        c.setName("Aardvark Silva");
        c.setCpf("18152564000105");
        c.setEmail("aardvark.silva@pagar.me");
        Address address = new Address();
        address.setStreet("Avenida Brigadeiro Faria Lima");
        address.setStreetNumber("1811");
        address.setNeighborhood("Jardim Paulistano");
        address.setCity("São Paulo");
        address.setState("SP");
        address.setCountry("BR");
        address.setZipcode("08551330");
        c.setAddress(address);
        Phone phone = new Phone();
        phone.setDdd("11");
        phone.setDdi("55");
        phone.setNumber("957753621");
        c.setPhone(phone);
        t.setCustomer(c);

        Card card = new Card();
        card.setCardNumber("4901720080344448");
        card.setHolderName("Usuario de Teste");
        card.setExpirationDate("1218");
        card.setCvv("314");
        
        try {
        	t.setCard(new CardHandler(client).createCard(card));
        	ObjectMapper mapper = new ObjectMapper();
        	System.out.println(mapper.writeValueAsString(t));
        	return handler.createCreditCardTransaction(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
}
