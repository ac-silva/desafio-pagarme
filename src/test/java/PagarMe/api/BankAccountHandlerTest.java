package PagarMe.api;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import PagarMe.api.handler.BankAccountHandler;
import PagarMe.api.model.BankAccount;

public class BankAccountHandlerTest {
	@Mock
	private RestClient client;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		BankAccount bankAccount = new BankAccount();
		bankAccount.setId(56765l);
		bankAccount.setCpf("25146455732");
		try {
			when(client.create(any(), eq(BankAccount.class))).thenReturn(bankAccount);
			when(client.get(anyLong(), eq(BankAccount.class))).thenReturn(bankAccount);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCreateBankAccount() {
		try {
			BankAccountHandler handler = new BankAccountHandler(client);
			BankAccount bankAccount    = new BankAccount();
			bankAccount = handler.createBankAccount(bankAccount);
			assertEquals(56765, (long) bankAccount.getId());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetBankAccount() {
		BankAccountHandler handler = new BankAccountHandler(client);
		BankAccount bankAccount    = handler.getBankAccount(56765l);
		assertEquals("25146455732", bankAccount.getCpf());
	}

}
