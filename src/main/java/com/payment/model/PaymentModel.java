package com.payment.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name="payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentModel {

	
	private Integer id;
	private String txId;
	private String vendor;
	private Date paymentDate;
	private Double amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PaymentModel [id=" + id + ", txId=" + txId + ", vendor=" + vendor + ", paymentDate=" + paymentDate
				+ ", amount=" + amount + "]";
	}

}
