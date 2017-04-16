package PagarMe.api.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BankAccount {
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("object")
	private String object;
	
	@JsonProperty("bank_code")
	private String bankCode;
	
	@JsonProperty("agencia")
	private String angencia;
	
	@JsonProperty("agencia_dv")
	private String angenciaDv;
	
	@JsonProperty("conta")
	private String conta;
	
	@JsonProperty("conta_dv")
	private String contaDv;
	
	@JsonProperty("document_type")
	private String documentType;
	
	@JsonProperty("document_number")
	private String cpf;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("legal_name")
	private String legalName;
	
	@JsonProperty("charge_transfer_fees")
	private boolean chargeTransferFees;
	
	@JsonProperty("date_created")
	private Date dateCreated;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBankCode() {
		return bankCode;
	}
	
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	public String getAngencia() {
		return angencia;
	}
	
	public void setAngencia(String angencia) {
		this.angencia = angencia;
	}
	
	public String getAngenciaDv() {
		return angenciaDv;
	}
	
	public void setAngenciaDv(String angenciaDv) {
		this.angenciaDv = angenciaDv;
	}
	
	public String getContaDv() {
		return contaDv;
	}
	
	public void setContaDv(String contaDv) {
		this.contaDv = contaDv;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getLegalName() {
		return legalName;
	}
	
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	
	public boolean isChargeTransferFees() {
		return chargeTransferFees;
	}
	
	public void setChargeTransferFees(boolean chargeTransferFees) {
		this.chargeTransferFees = chargeTransferFees;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
