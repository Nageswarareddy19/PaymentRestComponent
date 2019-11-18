package com.payment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import com.payment.entity.PaymentEntity;
import com.payment.model.PaymentModel;
import com.payment.model.PaymentResponse;
import com.payment.repository.PaymentRepositoy;

@SpringBootTest
public class PaymentServiceTest {

	@InjectMocks
	private PaymentServiceImpl service;

	@Mock
	private PaymentRepositoy paymentMockRepo;

	@Test
	public void payNowTest() {

		PaymentModel model = new PaymentModel();
		model.setAmount(2000.00);
		model.setVendor("phonepe");
		PaymentEntity entity = new PaymentEntity();
		BeanUtils.copyProperties(model, entity);
		entity.setTxId(new Random().nextInt(10000));
		when(paymentMockRepo.save(Mockito.any(PaymentEntity.class))).thenReturn(entity);
		PaymentResponse response = service.payNow(model);
		assertEquals(response.getTxId(), entity.getTxId().toString());

	}

	@Test
	public void findByVendorNameTestPositive() {
		List<PaymentEntity> listEntities = new ArrayList<PaymentEntity>();
		String vendorName = "phonepe";
		PaymentEntity entity1 = new PaymentEntity();
		entity1.setVendor(vendorName);
		entity1.setAmount(2000.00);
		entity1.setTxId(new Random().nextInt(10000));
		listEntities.add(entity1);
		PaymentEntity entity2 = new PaymentEntity();
		entity2.setVendor(vendorName);
		entity2.setAmount(4000.00);
		entity2.setTxId(new Random().nextInt(10000));
		listEntities.add(entity2);
		PaymentEntity entity3 = new PaymentEntity();
		entity3.setVendor(vendorName);
		entity3.setAmount(4000.00);
		entity3.setTxId(new Random().nextInt(10000));
		listEntities.add(entity3);
		when(paymentMockRepo.findByVendor(vendorName)).thenReturn(listEntities);
		List<PaymentModel> listModel = service.findByVendorName(vendorName);
		assertEquals(listEntities.size(), listModel.size());

	}

	
	@Test
	public void findByVendorNameTestNegetive2() {
		List<PaymentEntity> listEntities = new ArrayList<PaymentEntity>();
		
		
		when(paymentMockRepo.findByVendor("phonepe")).thenReturn(listEntities);
		List<PaymentModel> listModel = service.findByVendorName(null);
		assertEquals(listEntities.size(), listModel.size());

	}

}
