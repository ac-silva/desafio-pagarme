package PagarMe.api.handler;

import java.util.List;

import PagarMe.api.RestClient;
import PagarMe.api.model.Payable;

public class PayableHandler {
	private RestClient client;
	
	public PayableHandler(RestClient client) {
		this.client = client;
	}

	public Payable getPayable(Long id) {
		return this.client.get(id, Payable.class);
	}

	public List<Payable> getAllPayables() {
		return this.client.getAll(Payable.class);
	}

}
