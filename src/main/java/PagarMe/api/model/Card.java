package PagarMe.api.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("brand")
	private String brand;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("finger_print")
	private String fingerprint;
	
	@JsonProperty("finger_print")
	private boolean valid;
	
	@JsonProperty("card_number")
	private String cardNumber;
	
	@JsonProperty("card_hash")
	private String cardHash;
	
	@JsonProperty("holder_name")
	private String holderName;
	
	@JsonProperty("first_digits")
	private String firstDigits;
	
	@JsonProperty("last_digits")
	private String lastDigits;
	
	@JsonProperty("expiration_date")
	private String expirationDate;
	
	@JsonProperty("card_cvv")
	private String cvv;
	
	@JsonProperty("date_created")
	private Date createdAt;
	
	@JsonProperty("date_updated")
	private Date updatedAt;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
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
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHash() {
		return cardHash;
	}
	public void setCardHash(String cardHash) {
		this.cardHash = cardHash;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
}
