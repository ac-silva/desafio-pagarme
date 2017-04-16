package PagarMe.api.handler;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import PagarMe.api.RestClient;
import PagarMe.api.model.BankAccount;

public class BankAccountHandler {
	private RestClient client;
	
	public BankAccountHandler(RestClient client) {
		this.client = client;
	}

	public BankAccount createBankAccount(BankAccount bankAccount) throws JsonParseException, JsonMappingException, IOException {
		return this.client.create(bankAccount, BankAccount.class);
	}

	public BankAccount getBankAccount(Long id) {
		return this.client.get(id, BankAccount.class);
	}

}
