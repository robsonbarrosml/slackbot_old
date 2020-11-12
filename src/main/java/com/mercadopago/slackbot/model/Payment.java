package com.mercadopago.slackbot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
	
    private Long id;
	
    private String operation_type;

    private String payment_method_id;

    private String payment_type_id;
    
    private String site_id;
    
    private String status;
    
    private String status_detail;
    
    @JsonProperty("transaction_amount")
    private String transaction_amount;

    public String toString() {
		return 	"payment_id: "+ id + 
				"\noperation_typ: " + operation_type + 
				"\npayment_method_id: " + payment_method_id +
				"\npayment_type_id: " + payment_type_id +
				"\nsite_id: " + site_id +
				"\nstatus: " + status + 
				"\nstatus_detail: " + status_detail +
				"\ntransaction_amount: " + transaction_amount;
	}
}
