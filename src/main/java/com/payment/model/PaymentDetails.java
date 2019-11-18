package com.payment.model;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="payment-details")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentDetails {
	
	@XmlElement(name="payment")
	private List<PaymentModel> model;

	public List<PaymentModel> getModel() {
		return model;
	}


	public void setModel(List<PaymentModel> model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "PaymentDetails [model=" + model + "]";
	}

	
	
	
	
}


