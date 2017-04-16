package pagar.me.desafio;
import static spark.Spark.get;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import PagarMe.api.RestClient;
import PagarMe.api.handler.CardHandler;
import PagarMe.api.handler.TransactionHandler;
import PagarMe.api.model.Card;
import PagarMe.api.model.Customer;
import PagarMe.api.model.Transaction;
import spark.ModelAndView;
import spark.TemplateEngine;

public class TransactionController {
	private TransactionHandler handler;
	
	public TransactionController(RestClient client, TemplateEngine engine){
		this.handler = new TransactionHandler(client);
		
		get("/transaction", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			try{
				List<Transaction> list = handler.getAllTransactions();
				Transaction t = new Transaction();
				model.put("transactions", list);
				model.put("showTransactions", list.size() > 0);
			}catch(HttpClientErrorException ex){
				System.out.println(ex.getResponseBodyAsString());
			}
			return new ModelAndView(model, "transactions.html");
		}, engine);
		
		post("/transaction", (req, res) -> {
			Transaction transaction = new Transaction();
			Card card 				= new Card();
			Customer customer	 	= new Customer();
			String error            = null;
			
			try{
				boolean isBoleto = Boolean.parseBoolean(req.queryParams("is_boleto"));
				transaction.setAmount(Long.parseLong(req.queryParams("amount")));
				customer.setId(Long.parseLong(req.queryParams("customer_id")));
				transaction.setCustomer(customer);
				
				if(!isBoleto){
					card.setCardNumber(req.queryParams("card_number"));
					card.setHolderName(req.queryParams("card_holder_name"));
					card.setExpirationDate(req.queryParams("card_expiration_date"));
					card.setCvv(req.queryParams("card_cvv"));
					try{
						card = new CardHandler(client).createCard(card);
					}catch(HttpServerErrorException e){
						System.out.println(e.getMessage());
					}
					transaction.setCard(card);
					transaction = this.handler.createCreditCardTransaction(transaction);
				}else{
					transaction = this.handler.createBoletoTransaction(transaction);
				}
			}catch(Exception e){
				error = "Valores informados inválidos";
			}
			Map<String, Object> model = new HashMap<>();
			model.put("transaction", transaction);
			model.put("isError", !error.isEmpty());
			model.put("error", error);
			return new ModelAndView(model, "transactions.html");
		}, engine);
	}
}
