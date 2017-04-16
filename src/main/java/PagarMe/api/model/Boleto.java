package PagarMe.api.model;

import java.util.Date;


public class Boleto {
	private String url;
	private String barcode;
	private Date expirationDate;
	private String boletoInstructions;
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getBarcode() {
		return barcode;
	}
	
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getBoletoInstructions() {
		return boletoInstructions;
	}

	public void setBoletoInstructions(String boletoInstructions) {
		this.boletoInstructions = boletoInstructions;
	}
	
}
