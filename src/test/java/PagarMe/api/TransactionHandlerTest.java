package PagarMe.api;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import PagarMe.api.handler.TransactionHandler;
import PagarMe.api.model.Boleto;
import PagarMe.api.model.Card;
import PagarMe.api.model.Transaction;
import junit.framework.TestCase;

public class TransactionHandlerTest extends TestCase {
	private Transaction transaction;
	private TransactionHandler handler;
	@Mock
	private RestClient client;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		transaction = new Transaction();
		handler     = new TransactionHandler(client);
	}
	
	@Test
	public void testCreateCreditCardTransaction(){
		try {
			Transaction t = new Transaction();
			t.setCard(new Card());
			when(client.create(any(), eq(Transaction.class))).thenReturn(t);
			Transaction response = handler.createCreditCardTransaction(transaction);
			assertTrue(response.getCard() instanceof Card);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testBoletoTransaction(){
		try {
			Transaction t = new Transaction();
			t.setBoletoBarcode("1234567890");
			when(client.create(any(), eq(Transaction.class))).thenReturn(t);
			Transaction response = handler.createBoletoTransaction(transaction);
			assertTrue(response.getBoleto() instanceof Boleto);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testGetTransaction(){
		try {
			Transaction t = new Transaction();
			t.setBoletoBarcode("1234567890");
			when(client.get(anyLong(), eq(Transaction.class))).thenReturn(t);
			Transaction response = handler.getTransaction(75355l);
			assertEquals("1234567890", response.getBoleto().getBarcode());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testGetAllTransaction(){
		try {
			List<Transaction> transactions = new ArrayList<Transaction>();
			transactions.add(new Transaction());
			transactions.add(new Transaction());
			when(client.getAll(eq(Transaction.class))).thenReturn(transactions);
			List<Transaction> response = handler.getAllTransactions();
			assertEquals(2, response.size());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
}
