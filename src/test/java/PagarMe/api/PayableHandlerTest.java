package PagarMe.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import PagarMe.api.handler.PayableHandler;
import PagarMe.api.model.Payable;

public class PayableHandlerTest {
	@Mock
	private RestClient client;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		Payable payable = new Payable();
		payable.setId(545665465l);
		payable.setStatus("waiting_fund");
		
		List<Payable> payables = new ArrayList<>();
		payables.add(payable);
		payables.add(new Payable());
		
		when(client.get(anyLong(), eq(Payable.class))).thenReturn(payable);
		when(client.getAll(eq(Payable.class))).thenReturn(payables);
	}
	
	@Test
	public void testGet() {
		PayableHandler handler = new PayableHandler(client);
		Payable payable 	   = handler.getPayable(545665465l);
		assertEquals("waiting_fund", payable.getStatus());
	}
	
	@Test
	public void testGetAll() {
		PayableHandler handler = new PayableHandler(client);
		List<Payable> payables = handler.getAllPayables();
		assertEquals(2, payables.size());
	}

}
