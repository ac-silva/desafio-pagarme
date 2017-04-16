package PagarMe.api;

import java.io.IOException;
import java.util.List;

import org.apache.http.NameValuePair;
import org.springframework.web.client.HttpServerErrorException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import PagarMe.api.model.SplitRule;

public interface RestClient {
	public <T> T create(Object obj, Class<T> class1) throws JsonParseException, JsonMappingException, IOException, HttpServerErrorException ;
	public <T> List<T> getAll(Class<T> class1) throws HttpServerErrorException;
	public <T> T get(long id, Class<T> class1) throws HttpServerErrorException;
	public <T> T get(String id, Class<T> class1) throws HttpServerErrorException;
	public <T> T get(List<NameValuePair> vars, Class<T> class1) throws JsonParseException, JsonMappingException, IOException;
	public <T> T get(Long id, String string, Class<T> class1);
}
