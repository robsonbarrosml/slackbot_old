package com.mercadopago.slackbot.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payment {
	
	@JsonProperty("id")
    private Long id;
	
	@JsonProperty("operation_type")
    private String operation_type;

    @JsonProperty("payment_method_id")
    private String payment_method_id;

    @JsonProperty("payment_type_id")
    private String payment_type_id;
    
    @JsonProperty("site_id")
    private String site_id;
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("status_detail")
    private String status_detail;
    
    @JsonProperty("transaction_amount")
    private String transaction_amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperation_type() {
		return operation_type;
	}

	public void setOperation_type(String operation_type) {
		this.operation_type = operation_type;
	}

	public String getPayment_method_id() {
		return payment_method_id;
	}

	public void setPayment_method_id(String payment_method_id) {
		this.payment_method_id = payment_method_id;
	}

	public String getPayment_type_id() {
		return payment_type_id;
	}

	public void setPayment_type_id(String payment_type_id) {
		this.payment_type_id = payment_type_id;
	}

	public String getSite_id() {
		return site_id;
	}

	public void setSite_id(String site_id) {
		this.site_id = site_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus_detail() {
		return status_detail;
	}

	public void setStatus_detail(String status_detail) {
		this.status_detail = status_detail;
	}

	public String getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(String transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

}
