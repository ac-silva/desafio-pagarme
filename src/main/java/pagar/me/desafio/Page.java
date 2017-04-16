package pagar.me.desafio;

public class Page {
	private String name;
	private String url;
	
	public Page(String name, String url){
		this.name = name;
		this.url  = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
