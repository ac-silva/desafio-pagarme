package PagarMe.api.handler;

import java.io.IOException;

import org.springframework.web.client.HttpServerErrorException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import PagarMe.api.RestClient;
import PagarMe.api.model.Card;

public class CardHandler {
	private RestClient client;
	
	public CardHandler(RestClient client) {
		this.client = client;
	}

	public Card createCard(Card card) throws HttpServerErrorException, JsonParseException, JsonMappingException, IOException {
		return this.client.create(card, Card.class);
	}

	public Card getCard(Long id) {
		return this.client.get(id, Card.class);
	}

}
