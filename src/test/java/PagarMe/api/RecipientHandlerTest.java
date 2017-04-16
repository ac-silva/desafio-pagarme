package PagarMe.api;

import static org.mockito.Mockito.when;

import java.io.IOException;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Matchers.eq;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import PagarMe.api.handler.RecipientHandler;
import PagarMe.api.model.BankAccount;
import PagarMe.api.model.Recipient;
import junit.framework.TestCase;

public class RecipientHandlerTest extends TestCase{
	
	@Mock
	private RestClient client;

	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		Recipient recipient 	= new Recipient();
		BankAccount bankAccount = new BankAccount();
		recipient.setId("re_ci9bucss300h1zt6dvywufeqc");
		bankAccount.setCpf("25146455732");
		recipient.setBankAccount(bankAccount);
		try {
			when(client.create(any(), eq(Recipient.class))).thenReturn(recipient);
			when(client.get(anyString(), eq(Recipient.class))).thenReturn(recipient);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCreateRecipient(){
		try {
			Recipient recipient 	 = new Recipient();
			RecipientHandler handler = new RecipientHandler(client);
			recipient = handler.createRecipient(recipient);
			assertEquals("re_ci9bucss300h1zt6dvywufeqc", recipient.getId());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetRecipient(){
		RecipientHandler handler = new RecipientHandler(client);
		Recipient recipient      = handler.getRecipient("re_ci9bucss300h1zt6dvywufeqc");
		assertEquals("25146455732", recipient.getBankAccount().getCpf());
	}
	
}
