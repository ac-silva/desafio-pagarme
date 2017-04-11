package PagarMe.api.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Card {
	private long id;
	private String brand;
	private String country;
	private String fingerprint;
	private boolean valid;
	
	@JsonProperty("holder_name")
	private String holderName;
	
	@JsonProperty("first_digits")
	private String firstDigits;
	
	@JsonProperty("last_digits")
	private String lastDigits;
	
	@JsonProperty("expiration_date")
	private Date expirationDate;
	
	@JsonProperty("date_created")
	private Date createdAt;
	
	@JsonProperty("date_updated")
	private Date updatedAt;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getFirstDigits() {
		return firstDigits;
	}
	public void setFirstDigits(String firstDigits) {
		this.firstDigits = firstDigits;
	}
	public String getLastDigits() {
		return lastDigits;
	}
	public void setLastDigits(String lastDigits) {
		this.lastDigits = lastDigits;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFingerprint() {
		return fingerprint;
	}
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
