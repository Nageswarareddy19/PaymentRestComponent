package com.payment.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.payment.entity.PaymentEntity;

@Repository
public interface PaymentRepositoy extends JpaRepository<PaymentEntity, Serializable> {

	@Query(name = "select from   PaymentEntity  where vendor=:vendor")
	public List<PaymentEntity> findByVendor(@Param("vendor") String vendor);

}
