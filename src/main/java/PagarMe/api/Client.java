package PagarMe.api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


/**
 * The Class RestClient.
 */
public class Client implements RestClient{
	private String apiKey;
	private String baseURI;
	private RestTemplate restTemplate;
	
	
	
	/**
	 * Instantiates a new client.
	 *
	 * @param baseURI the base URI
	 * @param apiKey the api key
	 * @param timeout the timeout
	 * @throws KeyManagementException the key management exception
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws KeyStoreException the key store exception
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public Client(String baseURI, String apiKey, int ...timeout) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, JsonParseException, JsonMappingException, IOException{
		this.baseURI 	  = baseURI;
		this.apiKey  	  = apiKey;
		createSecurityRestTemplate();
		setApiKey();
		if(timeout.length > 0) setTimeout(timeout[0]); 
	}
	
	/**
	 * Instantiates a new rest client.
	 *
	 * @param baseURI the base URI
	 * @param apiKey the api key
	 * @param restTemplate the rest template
	 * @param timeout the timeout
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public Client(String baseURI, String apiKey, RestTemplate restTemplate, int ...timeout) throws JsonParseException, JsonMappingException, IOException{
		this.baseURI 	  = baseURI;
		this.apiKey  	  = apiKey;
		this.restTemplate = restTemplate;
		setApiKey();
		if(timeout.length > 0) setTimeout(timeout[0]); 
	}
	
	
	/**
	 * Sets the timeout.
	 *
	 * @param timeout the new timeout
	 */
	private void setTimeout(int timeout){
		HttpComponentsClientHttpRequestFactory factory = (HttpComponentsClientHttpRequestFactory) this.restTemplate.getRequestFactory();
		factory.setConnectTimeout(timeout);
		this.restTemplate.setRequestFactory(factory);
	}
	
	/**
	 * Sets the rest template.
	 *
	 * @param restTemplate the new rest template
	 * @throws JsonParseException the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void setRestTemplate(RestOperations restTemplate) throws JsonParseException, JsonMappingException, IOException {
		this.restTemplate = (RestTemplate) restTemplate;
		setApiKey();
	}

	/**
	 * Sets the api key.
	 *
	 * @throws JsonParseException the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void setApiKey() throws JsonParseException, JsonMappingException, IOException{
		ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add((HttpRequest request, byte[] body, ClientHttpRequestExecution execution) -> {
			if(body.length > 0) {
				body = addTokenInObject(body, new JsonNodeFormatter());
			}else{
				try {
					request = addTokenInURI(request);
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
			return execution.execute(request, body);
		});
		this.restTemplate.setInterceptors(interceptors);
	}
	
	/**
	 * Adds the token in object.
	 *
	 * @param obj the obj
	 * @param jsonFormat the json format
	 * @return the byte[]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private byte[] addTokenInObject(byte obj[], JsonNodeFormatter jsonFormat) throws IOException{
		ObjectNode json = (ObjectNode) jsonFormat.decode(obj);
		json.put("api_key", this.apiKey);
		return jsonFormat.encode(json);
	}
	
	private HttpRequest addTokenInURI(HttpRequest request) throws IOException, URISyntaxException{
		ClientHttpRequest clientRequest = (ClientHttpRequest) request;
		List<NameValuePair> params = new ArrayList<>() ; 
		params.add(new BasicNameValuePair("api_key",  this.apiKey));
		String url 	  = URLEncodedUtils.format(params, "UTF-8");
		URI src    	  = new URI(request.getURI().toString().concat("?").concat(url));
		clientRequest = new HttpComponentsClientHttpRequestFactory().createRequest(src, request.getMethod());
		return clientRequest;
	}
	
	/**
	 * Creates the.
	 *
	 * @param <T> the generic type
	 * @param obj the obj
	 * @param class1 the class 1
	 * @return the t
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@SuppressWarnings("unchecked")
	public <T> T create(Object obj, Class<T> class1) throws JsonParseException, JsonMappingException, IOException, HttpServerErrorException {
		try{
			String res 	= this.restTemplate.postForObject(getURI(class1), obj, String.class);
			if(res instanceof String){
				ObjectMapper mapper = new ObjectMapper();
				JsonNode obj2  		= mapper.readValue(res, JsonNode.class);
				return (T) mapper.readValue(obj2.toString(), class1);
			}else{
				return (T) obj;
			}
		}catch(HttpClientErrorException e){
			System.out.println("deu erro");
			System.out.println(e.getMessage());
			System.out.println(e.getResponseBodyAsString());
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see PagarMe.api.RestClient#get(java.lang.Class)
	 */
	@Override
	public <T> T get(long id, Class<T> class1) throws HttpServerErrorException {
		return this.restTemplate.getForObject(getURI(class1).concat("/").concat(String.valueOf(id)), class1);
	}
	
	/* (non-Javadoc)
	 * @see PagarMe.api.RestClient#get(java.lang.Class)
	 */
	@Override
	public <T> T get(String id, Class<T> class1) throws HttpServerErrorException {
		return this.restTemplate.getForObject(getURI(class1).concat("/").concat(String.valueOf(id)), class1);
	}
	
	/* (non-Javadoc)
	 * @see PagarMe.api.RestClient#getAll(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getAll(Class<T> class1) throws HttpServerErrorException{
		return this.restTemplate.getForObject(getURI(class1), List.class);
	}
	
	/**
	 * Gets the uri.
	 *
	 * @param <T> the generic type
	 * @param class1 the class 1
	 * @return the uri
	 */
	private <T> String getURI(Class<T> class1){
		return this.baseURI.concat("/").concat(camelCaseToLowerUnderscore(class1.getSimpleName()));
	}

	/**
	 * Gets the api key.
	 *
	 * @return the api key
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * Gets the base URI.
	 *
	 * @return the base URI
	 */
	public String getBaseURI() {
		return baseURI;
	}
	
	/**
	 * Camel case to lower underscore.
	 *
	 * @param camelString the camel string
	 * @return the string
	 */
	private String camelCaseToLowerUnderscore(String camelString){
		String underscoreString = camelString.replaceAll("(.)(\\p{Upper})", "$1_$2").toLowerCase();
		if(!camelString.contains("CardHashKey")) {
			underscoreString = underscoreString.concat("s");
		}else{
			underscoreString = "transactions/".concat(underscoreString);
		}
		return underscoreString;
	}

	/**
	 * Creates the security rest template.
	 *
	 * @throws KeyManagementException the key management exception
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws KeyStoreException the key store exception
	 */
	private void createSecurityRestTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException{
		TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
		SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
		        .loadTrustMaterial(null, acceptingTrustStrategy)
		        .build();
		SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
		
		HttpComponentsClientHttpRequestFactory requestFactory =
		        new HttpComponentsClientHttpRequestFactory();
		
		 HttpClient httpClient = HttpClientBuilder.create()
                .disableCookieManagement()
                .useSystemProperties()
                .setSSLSocketFactory(csf)
                .build();
		requestFactory.setHttpClient(httpClient);
		this.restTemplate = new RestTemplate(requestFactory);
	}

	@Override
	public <T> T get(List<NameValuePair> vars, Class<T> class1) throws JsonParseException, JsonMappingException, IOException, HttpServerErrorException {
		String url = URLEncodedUtils.format(vars, "UTF-8");
		return this.restTemplate.getForObject(getURI(class1).concat("?").concat(url), class1);
	}

	@Override
	public <T> T get(Long obj, String param1, Class<T> class1) {
		String url = this.baseURI.concat("/").concat(param1).concat("/").concat(String.valueOf(obj));
		url 	   = url.concat(camelCaseToLowerUnderscore(class1.getSimpleName())).concat("s");
		return this.restTemplate.getForObject(url, class1);
	}
	
}	
