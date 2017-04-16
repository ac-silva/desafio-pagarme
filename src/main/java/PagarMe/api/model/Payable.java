package PagarMe.api.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payable {
	private Long id;
	private String status;
	private Long amount;
	private Integer fee;
	private Integer installment;
	@JsonProperty("transaction_id")
	private Long transactionId;
	@JsonProperty("split_role_id")
	private Long splitRoleId;
	@JsonProperty("payment_date")
	private Date paymentDate;
	private String type;
	@JsonProperty("date_created")
	private Date dateCreated;
	@JsonProperty("recipient_id")
	private Long recipientId;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Long getAmount() {
		return amount;
	}
	
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	public Integer getFee() {
		return fee;
	}
	
	public void setFee(Integer fee) {
		this.fee = fee;
	}
	
	public Integer getInstallment() {
		return installment;
	}
	
	public void setInstallment(Integer installment) {
		this.installment = installment;
	}
	
	public Long getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	
	public Long getSplitRoleId() {
		return splitRoleId;
	}
	
	public void setSplitRoleId(Long splitRoleId) {
		this.splitRoleId = splitRoleId;
	}
	
	public Date getPaymentDate() {
		return paymentDate;
	}
	
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public Long getRecipientId() {
		return recipientId;
	}
	
	public void setRecipientId(Long recipientId) {
		this.recipientId = recipientId;
	}
	
}
