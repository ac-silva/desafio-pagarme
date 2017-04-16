package PagarMe.api.handler;

import PagarMe.api.RestClient;
import PagarMe.api.model.SplitRule;

public class SplitRuleHandler {
	private RestClient client;

	public SplitRuleHandler(RestClient client){
		this.client = client;
	}

	public SplitRule getSplitRuleOfTransaction(Long id) {
		return client.get(id, "transactions", SplitRule.class);
	}
}
