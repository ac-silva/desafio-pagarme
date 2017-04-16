package PagarMe.api.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipient {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("bank_account")
	private BankAccount bankAccount;
	
	@JsonProperty("transfer_enabled")
	private boolean transferEnabled;
	
	@JsonProperty("last_transfer")
	private String lastTransfer;
	
	@JsonProperty("transfer_interval")
	private String transferInterval;
	
	@JsonProperty("transfer_day")
	private int transferDay;
	
	@JsonProperty("automatic_anticipation_enabled")
	private boolean automaticAnticipationEnabled;
	
	@JsonProperty("anticipatable_volume_percentage")
	private float anticipatableVolumePercentage;
	
	@JsonProperty("date_created")
	private Date dateCreated;
	
    @JsonProperty("date_updated")
	private Date dateUpdated;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public BankAccount getBankAccount() {
		return this.bankAccount;
	}
	
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public boolean isTransferEnabled() {
		return transferEnabled;
	}
	
	public void setTransferEnabled(boolean transferEnabled) {
		this.transferEnabled = transferEnabled;
	}
	
	public String getLastTransfer() {
		return lastTransfer;
	}
	
	public void setLastTransfer(String lastTransfer) {
		this.lastTransfer = lastTransfer;
	}
	
	public String getTransferInterval() {
		return transferInterval;
	}
	
	public void setTransferInterval(String transferInterval) {
		this.transferInterval = transferInterval;
	}
	
	public int getTransferDay() {
		return transferDay;
	}
	
	public void setTransferDay(int transferDay) {
		this.transferDay = transferDay;
	}
	
	public boolean isAutomaticAnticipationEnabled() {
		return automaticAnticipationEnabled;
	}
	
	public void setAutomaticAnticipationEnabled(boolean automaticAnticipationEnabled) {
		this.automaticAnticipationEnabled = automaticAnticipationEnabled;
	}
	
	public float getAnticipatableVolumePercentage() {
		return anticipatableVolumePercentage;
	}
	
	public void setAnticipatableVolumePercentage(float anticipatableVolumePercentage) {
		this.anticipatableVolumePercentage = anticipatableVolumePercentage;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public Date getDateUpdated() {
		return dateUpdated;
	}
	
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
}
