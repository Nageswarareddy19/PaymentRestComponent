package com.payment.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.entity.PaymentEntity;
import com.payment.model.PaymentModel;
import com.payment.model.PaymentResponse;
import com.payment.repository.PaymentRepositoy;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Service
public class PaymentServiceImpl implements PaymentService {

	public PaymentServiceImpl() {
		System.out.println("PaymentServiceImpl()::0-param constructor");
	}

	@Autowired
	private PaymentRepositoy paymentRepo;

	@Override
	public PaymentResponse payNow(PaymentModel model) {

		System.out.println("payNow() method is called");
		PaymentEntity entity = new PaymentEntity();

		BeanUtils.copyProperties(model, entity);
		entity.setPaymentDate(new Date());
		entity.setTxId(new Random().nextInt(10000));
		entity = paymentRepo.save(entity);

		PaymentResponse response = new PaymentResponse();
		response.setStatus("Sucess");
		response.setMessage(" Transaction sucessful with amount is:" + entity.getAmount().toString());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss a");
		String format = sdf.format(new Date());
		response.setTxdate(format);
		response.setTxId(entity.getTxId().toString());

		return response;
	}

	@Override
	public List<PaymentModel> findByVendorName(String vendor) {
		List<PaymentEntity> entities = paymentRepo.findByVendor(vendor);

		List<PaymentModel> listModel = new ArrayList<>();

		for (PaymentEntity entity : entities) {
			if (entity.getVendor() != null) {
				PaymentModel model = new PaymentModel();
				BeanUtils.copyProperties(entity, model);
				model.setTxId(entity.getTxId().toString());
				listModel.add(model);
			} else {
				return null;
			}

		}

		return listModel;

	}

}
