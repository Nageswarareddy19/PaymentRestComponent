package com.payment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.exceptions.PaymentHistoryNotFoundException;
import com.payment.exceptions.TranscationFailedException;
import com.payment.model.PaymentDetails;
import com.payment.model.PaymentModel;
import com.payment.model.PaymentResponse;
import com.payment.service.PaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Payment GateWay Service")
@RestController
public class PaymentRestController {
	public PaymentRestController() {
		System.out.println("PaymentRestController() method is called");
	}

	@Autowired
	private PaymentService payService;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Transcation is successfully compleded"),
			@ApiResponse(code = 500, message = "Internal servler error") })

	@ApiOperation(value = "This method is used to perform transaction")

	@PostMapping(value = "/pay", consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	public ResponseEntity<PaymentResponse> doPaymentNow(
			@ApiParam(value = "you have to pay some amount ") @RequestBody PaymentModel model) {
		PaymentResponse response = payService.payNow(model);

		if (response != null) {
			return new ResponseEntity<PaymentResponse>(response, HttpStatus.OK);
		} else {
			throw new TranscationFailedException("Payment process is failed");
		}

	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = " retriving Payment history is sucessfull"),
			@ApiResponse(code = 400, message = "Bad request") })
	@ApiOperation(value = "This method is used for based on vendor name payment history is displayed ")
	@GetMapping(value = "/getTrans/{vendor}", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<PaymentModel>> getTranscations(
			@ApiParam(value = "vendor name like paytm,gpay,phonepe", required = true) @PathVariable("vendor") String vendor) {
		List<PaymentModel> listModel = payService.findByVendorName(vendor);

		if (!listModel.isEmpty()) {

			return new ResponseEntity<List<PaymentModel>>(listModel, HttpStatus.OK);
		} else {
			throw new PaymentHistoryNotFoundException("paymeny history is not found");
		}

	}

}
