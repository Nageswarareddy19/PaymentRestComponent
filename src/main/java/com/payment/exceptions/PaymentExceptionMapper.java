package com.payment.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class PaymentExceptionMapper {

	@ExceptionHandler(value = TranscationFailedException.class)
	public ResponseEntity<ErrorResponse> handleTransactionFailedException() {
		ErrorResponse response = new ErrorResponse();
		response.setErrorCode("Payment-001");
		response.setErrorDescription(
				"payment transaction is failed due to some techincal issues please try some other time");
		response.setDate(new Date());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(value = PaymentHistoryNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlePaymentHistoryNotFoundException() {
		ErrorResponse response = new ErrorResponse();
		response.setErrorCode("Payment-002");
		response.setErrorDescription("Fetching payment history is failed");
		response.setDate(new Date());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);

	}

}
