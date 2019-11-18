package com.payment.exceptions;

public class PaymentHistoryNotFoundException extends RuntimeException {

	public PaymentHistoryNotFoundException(String message) {
		super(message);
	}
}
