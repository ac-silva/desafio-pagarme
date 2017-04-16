package PagarMe.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import PagarMe.api.handler.SplitRuleHandler;
import PagarMe.api.model.Recipient;
import PagarMe.api.model.SplitRule;

public class SplitRuleHandlerTest {
	@Mock
	private RestClient client;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		SplitRule result = new SplitRule();
		result.setId(100);
		when(client.get(anyLong(), any(),eq(SplitRule.class))).thenReturn(result);
	}
	
	@Test
	public void testGetSplitRuleOfTransaction() {
		Recipient recipient 	 = new Recipient();
		SplitRule splitRule      = new SplitRule(recipient);
		SplitRuleHandler handler = new SplitRuleHandler(client);
		splitRule = handler.getSplitRuleOfTransaction(45676l);
		assertEquals(100, splitRule.getId());
	}

}
