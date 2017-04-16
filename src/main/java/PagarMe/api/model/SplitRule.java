package PagarMe.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SplitRule {
	@JsonProperty("id")
	private long id;
	@JsonProperty("charge_processing_fee")
	private boolean chargeProcessingFee;
	@JsonProperty("liable")
	private boolean liable;
	@JsonProperty("percentage")
	private Float percentage;
	@JsonProperty("amount")
	private Long amount;
	@JsonProperty("recipient_id")
	private String recipientId;
	@JsonIgnore
	private Recipient recipient;
	
	public SplitRule(){
		this.liable 			 = true;
		this.chargeProcessingFee = true;
	}
	
	public SplitRule(Recipient recipient){
		this.setRecipient(recipient);
		this.liable 			 = true;
		this.chargeProcessingFee = true;
	}

	public SplitRule createMonetaryRule() {
		this.setPercentage(null);
		return this;
	}

	public SplitRule createPercentageRule() {
		this.setAmount(null);
		return this;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isChargeProcessingFee() {
		return chargeProcessingFee;
	}

	public void setChargeProcessingFee(boolean chargeProcessingFee) {
		this.chargeProcessingFee = chargeProcessingFee;
	}

	public boolean isLiable() {
		return liable;
	}

	public void setLiable(boolean liable) {
		this.liable = liable;
	}

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	public Long getAmount() {
		return amount;
	}
	
	public void setRecipientId(String id){
		this.recipientId = id;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Recipient getRecipient() {
		return recipient;
	}

	public void setRecipient(Recipient recipient) {
		this.recipientId = recipient.getId();
		this.recipient   = recipient;
	}

	public String getRecipientId() {
		return recipientId;
	}
	
}
