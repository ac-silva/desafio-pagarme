package pagar.me.desafio;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import PagarMe.api.RestClient;
import PagarMe.api.handler.PayableHandler;
import PagarMe.api.model.Payable;
import spark.ModelAndView;
import spark.TemplateEngine;

public class PayableController {
	private PayableHandler handler;
	
	public PayableController(RestClient client, TemplateEngine engine){
		this.handler = new PayableHandler(client);
		get("/payable", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			List<Payable> list        = handler.getAllPayables();
			model.put("payables", list);
			model.put("showPayables", list.size() > 0);
			return new ModelAndView(model, "payables.html");
		}, engine);
	}
}
