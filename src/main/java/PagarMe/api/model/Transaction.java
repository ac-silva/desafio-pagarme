package PagarMe.api.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Transaction.
 */
public class Transaction {
	/** Número identificador da transação. */
	private long id;
	
	/** Para cada atualização no processamento da transação, esta propriedade será alterada, 
	* e o objeto transaction retornado como resposta através da sua URL de postback ou 
	* após o término do processamento da ação atual. 
	*/
	private String status;
	
	/** Motivo/agente responsável pela validação ou anulação da transação.  */
	@JsonProperty("status_reason")
	private String statusReason;
	
	/** Adquirente responsável pelo processamento da transação */
	private Acquirer acquirer;
	
	/** Código de autorização retornado pela bandeira. */
	@JsonProperty("authorization_code")
	private long authorizationCode;
	
	/** Texto que irá aparecer na fatura do cliente depois do nome da loja.
	 * Max 13 caracteres */
	@JsonProperty("soft_descriptor")
	private String softDescriptor;
	
	/** Código que identifica a transação no adquirente. */
	private long tid;
	
	/** Código que identifica a transação no adquirente. */
	private long nsu;
	
	/** Valor, em centavos, da transação. */
	private Double amount;
	
	/** Valor, em centavos, capturado da transação. */
	@JsonProperty("paid_amount")
	private Double paidAmount;
	
	/** Número de parcelas/prestações a serem cobradas. */
	private int installments;
	
	/** Custo da transação para o lojista. */
	private Double cost;
	
	/** Objeto com dados do boleto */
	private Boleto boleto;

	/** IP de origem que criou a transção, podendo ser ou do 
	 * seu cliente (quando criado via checkout ou utilizando card_hash) ou do servidor. */
	private String ip;
	
	/** Dados do cliente. */
	@JsonProperty("customer")
	private Customer customer;
	
	/** Dados do cartão usado na transação. */
	@JsonProperty("card")
	private Card card;
	
	/** Data de criação da transação no formato. */
	@JsonProperty("date_created")
	private Date createdAt;
	
	/** Data de atualização da transação no formato ISODate. */
	@JsonProperty("date_updated")
	private Date updatedAt;
	
	/**
	 * Instantiates a new transaction.
	 */
	public Transaction(){
		this.boleto   = new Boleto();
		this.acquirer = new Acquirer();
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Gets the status reason.
	 *
	 * @return the status reason
	 */
	public String getStatusReason() {
		return statusReason;
	}
	
	/**
	 * Sets the status reason.
	 *
	 * @param statusReason the new status reason
	 */
	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}
	
	/**
	 * Sets the acquirer id.
	 *
	 * @param id the new acquirer id
	 */
	@JsonProperty("acquirer_id")
	public void setAcquirerId(long id) {
		this.acquirer.setId(id);
	}
	
	/**
	 * Sets the acquirer name.
	 *
	 * @param name the new acquirer name
	 */
	@JsonProperty("acquirer_name")
	public void setAcquirerName(String name) {
		this.acquirer.setName(name);;
	}
	
	/**
	 * Sets the acquirer response code.
	 *
	 * @param responseCode the new acquirer response code
	 */
	@JsonProperty("acquirer_response_code")
	public void setAcquirerResponseCode(String responseCode) {
		this.acquirer.setResponseCode(responseCode);
	}
	
	/**
	 * Sets the acquirer.
	 *
	 * @param acquirer the new acquirer
	 */
	public void setAcquirer(Acquirer acquirer) {
		this.acquirer = acquirer;
	}
	
	/**
	 * Gets the authorization code.
	 *
	 * @return the authorization code
	 */
	public long getAuthorizationCode() {
		return authorizationCode;
	}
	
	/**
	 * Sets the authorization code.
	 *
	 * @param authorizationCode the new authorization code
	 */
	public void setAuthorizationCode(long authorizationCode) {
		this.authorizationCode = authorizationCode;
	}
	
	/**
	 * Gets the soft descriptor.
	 *
	 * @return the soft descriptor
	 */
	public String getSoftDescriptor() {
		return softDescriptor;
	}
	
	/**
	 * Sets the soft descriptor.
	 *
	 * @param softDescriptor the new soft descriptor
	 */
	public void setSoftDescriptor(String softDescriptor) {
		this.softDescriptor = softDescriptor;
	}
	
	/**
	 * Gets the tid.
	 *
	 * @return the tid
	 */
	public long getTid() {
		return tid;
	}
	
	/**
	 * Sets the tid.
	 *
	 * @param tid the new tid
	 */
	public void setTid(long tid) {
		this.tid = tid;
	}
	
	/**
	 * Gets the nsu.
	 *
	 * @return the nsu
	 */
	public long getNsu() {
		return nsu;
	}
	
	/**
	 * Sets the nsu.
	 *
	 * @param nsu the new nsu
	 */
	public void setNsu(long nsu) {
		this.nsu = nsu;
	}
	
	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	
	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	/**
	 * Gets the paid amount.
	 *
	 * @return the paid amount
	 */
	public Double getPaidAmount() {
		return paidAmount;
	}
	
	/**
	 * Sets the paid amount.
	 *
	 * @param paidAmount the new paid amount
	 */
	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}
	
	/**
	 * Gets the installments.
	 *
	 * @return the installments
	 */
	public int getInstallments() {
		return installments;
	}
	
	/**
	 * Sets the installments.
	 *
	 * @param installments the new installments
	 */
	public void setInstallments(int installments) {
		this.installments = installments;
	}
	
	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public Double getCost() {
		return cost;
	}
	
	/**
	 * Sets the cost.
	 *
	 * @param cost the new cost
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	/**
	 * Gets the boleto.
	 *
	 * @return the boleto
	 */
	public Boleto getBoleto() {
		return boleto;
	}
	
	/**
	 * Sets the boleto URL.
	 *
	 * @param url the new boleto URL
	 */
	@JsonProperty("boleto_url")
	public void setBoletoURL(String url) {
		this.boleto.setUrl(url);
	}
	
	/**
	 * Sets the boleto barcode.
	 *
	 * @param barcode the new boleto barcode
	 */
	@JsonProperty("boleto_barcode")
	public void setBoletoBarcode(String barcode){
		this.boleto.setBarcode(barcode);
	}
	
	/**
	 * Sets the boleto barcode.
	 *
	 * @param expirationDate the new boleto barcode
	 */
	@JsonProperty("boleto_expiration_date")
	public void setBoletoBarcode(Date expirationDate){
		this.boleto.setExpirationDate(expirationDate);
	}
	
	/**
	 * Gets the ip.
	 *
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	
	/**
	 * Sets the ip.
	 *
	 * @param ip the new ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * Sets the customer.
	 *
	 * @param customer the new customer
	 */
	public void setCustomer(Customer customer) {
		
		this.customer = customer;
	}
	
	/**
	 * Gets the card.
	 *
	 * @return the card
	 */
	public Card getCard() {
		return card;
	}
	
	/**
	 * Sets the card.
	 *
	 * @param card the new card
	 */
	public void setCard(Card card) {
		this.card = card;
	}
	
	/**
	 * Gets the created at.
	 *
	 * @return the created at
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	
	/**
	 * Sets the created at.
	 *
	 * @param createdAt the new created at
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	/**
	 * Gets the updated at.
	 *
	 * @return the updated at
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	/**
	 * Sets the updated at.
	 *
	 * @param updatedAt the new updated at
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
