package com.payment.service;


import java.util.List;

import com.payment.model.PaymentModel;
import com.payment.model.PaymentResponse;

public interface PaymentService {

	public PaymentResponse payNow(PaymentModel  model);
	
	public List<PaymentModel> findByVendorName(String vendor);
	
}
