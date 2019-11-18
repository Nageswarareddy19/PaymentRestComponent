package com.payment.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.model.PaymentModel;
import com.payment.model.PaymentResponse;
import com.payment.service.PaymentService;

import oracle.net.aso.s;

@WebMvcTest
public class PaymentRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PaymentService service;

	@Test
	public void doPaymentNowTestPositive() throws Exception {
		PaymentModel model = new PaymentModel();
		model.setVendor("phonepe");
		model.setAmount(3400.00);
		// PaymentResponse response = service.payNow(model);
		ObjectMapper mapper = new ObjectMapper();
		String jsonObj = mapper.writeValueAsString(model);
		PaymentResponse response = new PaymentResponse();
		response.setStatus("Sucess");
		when(service.payNow(Mockito.any(PaymentModel.class))).thenReturn(response);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/pay").contentType(MediaType.APPLICATION_JSON)
				.content(jsonObj);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);

	}

	@Test
	public void doPaymentNowTestNegative() throws Exception {
		PaymentModel model = new PaymentModel();
		model.setVendor("phonepe");
		model.setAmount(3400.00);
		// PaymentResponse response = service.payNow(model);
		ObjectMapper mapper = new ObjectMapper();
		String jsonObj = mapper.writeValueAsString(model);

		when(service.payNow(Mockito.any(PaymentModel.class))).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/pay").contentType(MediaType.APPLICATION_JSON)
				.content(jsonObj);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), status);

	}

	@Test
	public void getTransactionsPostiveTest() throws Exception {
		String vendorName = "phonpe";
		PaymentModel model = new PaymentModel();
		model.setVendor("phonepe");
		model.setAmount(3400.00);
		PaymentModel model2 = new PaymentModel();
		model2.setVendor("paytm");
		model2.setAmount(5400.00);
		List<PaymentModel> listmodel = new ArrayList<>();
		listmodel.add(model);
		listmodel.add(model2);
		when(service.findByVendorName(Mockito.any(String.class))).thenReturn(listmodel);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getTrans/phonepe")
				.accept(MediaType.APPLICATION_JSON).content(vendorName);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);

	}
	@Test
	public void getTransactionsNegativeTest() throws Exception {
		String vendorName = "phonpe";

		List<PaymentModel> listmodel = new ArrayList<>();
		
		when(service.findByVendorName(Mockito.any(String.class))).thenReturn(listmodel);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getTrans/phonepe")
				.accept(MediaType.APPLICATION_JSON).content(vendorName);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.BAD_REQUEST.value(), status);

	}

}
