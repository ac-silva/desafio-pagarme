package PagarMe.api.model;

public class Phone {
	private long id;
	private String number;
	private String ddi;
	private String ddd;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDdi() {
		return ddi;
	}
	public void setDdi(String ddi) {
		this.ddi = ddi;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
}
