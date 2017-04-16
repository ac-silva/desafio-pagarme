package PagarMe.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Matchers.eq;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.HttpServerErrorException;

import PagarMe.api.handler.CardHandler;
import PagarMe.api.model.Card;

public class CardHandlerTest {
	@Mock
	private RestClient client;
	private CardHandler handler;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		handler = new CardHandler(client);
		Card card = new Card();
		card.setId("card_cj1jrfgsx0002ln6eo1ggutly");
		card.setHolderName("teste");
		card.setCardNumber("45646554");
		card.setCvv("46465");
		card.setExpirationDate("1218");
		try {
			when(client.create(any(), eq(Card.class))).thenReturn(card);
			when(client.get(anyLong(), eq(Card.class))).thenReturn(card);
		} catch (HttpServerErrorException | IOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCreateCard() {
		Card card = new Card();
		card.setHolderName("teste");
		card.setCardNumber("45646554");
		card.setCvv("46465");
		card.setExpirationDate("1218");
		try {
			card = handler.createCard(card);
		} catch (HttpServerErrorException | IOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetCard() {
		try {
			Card card = handler.getCard(5467l);
			assertEquals("45646554", card.getCardNumber());
		} catch (HttpServerErrorException e) {
			fail(e.getMessage());
		}
	}

}
