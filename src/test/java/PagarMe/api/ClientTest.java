package PagarMe.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import PagarMe.api.model.Transaction;

public class ClientTest{
	@Mock
	private RestTemplate restTemplate;
	private Client client;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		try{
			client = new Client("http://localhost", "ak_test_grXijQ4GicOa2BLGZrDRTR5qNQxJW0");
			client.setRestTemplate(restTemplate);
		}catch(Exception e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testGet(){
		try{
			Transaction result = new Transaction();
			result.setId(1001);
			when(this.restTemplate.getForObject(anyString(), eq(Transaction.class))).thenReturn(result);		
			
			Transaction t = client.get(1001, Transaction.class);
			assertEquals(1001, t.getId());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testCreate(){
		try {
			when(restTemplate.postForObject(anyString(), any(), any())).thenReturn("{\"id\": 1001}");
			Transaction transaction = new Transaction();
			transaction = client.create(transaction, Transaction.class);
			assertEquals(1001, transaction.getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public void testGetAll(){
		Transaction result = new Transaction();
		List<Transaction> transactions = new ArrayList<Transaction>();
		result.setId(1001);
		transactions.add(result);
		transactions.add(new Transaction());
		when(this.restTemplate.getForObject(anyString(), eq(List.class))).thenReturn(transactions);		
		List<Transaction> t = client.getAll(Transaction.class);
		assertEquals(2, t.size());
	}
}
