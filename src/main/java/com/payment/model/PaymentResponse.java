package com.payment.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)

@XmlRootElement(name = "payment-response")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentResponse {
	private String status;
	private String message;
	private String txdate;
	private String txId;
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTxdate() {
		return txdate;
	}

	public void setTxdate(String txdate) {
		this.txdate = txdate;
	}

	

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	@Override
	public String toString() {
		return "PaymentResponse [status=" + status + ", message=" + message + ", txdate=" + txdate + ", txId=" + txId
				+ ", payments=" + "]";
	}

}
