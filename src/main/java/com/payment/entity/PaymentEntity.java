package com.payment.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT_TAB")
public class PaymentEntity {
	@Column(name = "ID")
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "TRANSACTION_ID")
	private Integer txId;
	
	@Column(name = "VENDOR_NAME")
	private String vendor;

	@Column(name = "PAYMENT_DATE")
	private Date paymentDate;

	@Column(name = "AMOUNT")
	private Double amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTxId() {
		return txId;
	}

	public void setTxId(int i) {
		this.txId = i;
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

	public void setPaymentDate(Date date) {
		this.paymentDate = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PaymentEntity [id=" + id + ", txId=" + txId + ", vendor=" + vendor + ", paymentDate=" + paymentDate
				+ ", amount=" + amount + "]";
	}

}
