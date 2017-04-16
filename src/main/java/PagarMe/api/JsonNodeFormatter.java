package PagarMe.api;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class JsonNodeFormatter.
 */
public class JsonNodeFormatter {
	
	/**
	 * Decode.
	 *
	 * @param data the data
	 * @return the json node
	 * @throws JsonParseException the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public JsonNode decode(byte data[]) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		InputStream is 		= new ByteArrayInputStream(data);
		return mapper.readValue(is, JsonNode.class);
	}
	
	/**
	 * Encode.
	 *
	 * @param json the json
	 * @return the byte[]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public byte[] encode(JsonNode json) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsBytes(json);
	}

}
