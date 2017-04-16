package pagar.me.desafio;

import static spark.Spark.get;
import static spark.Spark.ipAddress;
import static spark.Spark.port;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;

import PagarMe.api.Client;
import spark.ModelAndView;
import spark.TemplateEngine;
import spark.servlet.SparkApplication;
import spark.template.mustache.MustacheTemplateEngine;

public class App implements SparkApplication {
    public static void main( String[] args ) {
    	String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
    	new App().init();
    }

	@Override
	public void init() {
    	ipAddress("127.0.0.1");
    	port(8080);
    	
		try {
			Client client 		  = new Client("https://api.pagar.me/1", "ak_test_WeKhY9b8xpVNmkJgzoQFCl2YDFAbVv");
			TemplateEngine engine = new MustacheTemplateEngine();
			
	    	get("/", (req, res) -> {
	    		Map<String, Object> model = new HashMap<>();
	    		List<Page> pages 		  = new ArrayList<Page>();
	    		pages.add(new Page("Transações", "transaction"));
	    		pages.add(new Page("Recebíveis", "payable"));
	    		model.put("pages", pages);
	    		return new ModelAndView(model, "index.html");
	    	}, engine);
			
			new TransactionController(client, engine);
			new PayableController(client, engine);
		} catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException | IOException e) {
			e.printStackTrace();
		}
    	
	}
}
