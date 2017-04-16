package PagarMe.api.handler;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import PagarMe.api.RestClient;
import PagarMe.api.model.Transaction;


public class TransactionHandler {
	private RestClient client;
	
	public TransactionHandler(RestClient client){
		this.client = client;
	}
	
	public Transaction createCreditCardTransaction(Transaction transaction) throws JsonParseException, JsonMappingException, IOException {
		transaction.setPaymentMethod("credit_card");
		transaction = client.create(transaction, Transaction.class);
		return transaction;
	}

	public Transaction createBoletoTransaction(Transaction transaction) throws JsonParseException, JsonMappingException, IOException {
		transaction.setPaymentMethod("boleto");
		transaction = client.create(transaction, Transaction.class);
		return transaction;
	}

	public Transaction getTransaction(Long id) {
		return client.get(id, Transaction.class);
	}

	public List<Transaction> getAllTransactions(){
		return client.getAll(Transaction.class);
	}

}
