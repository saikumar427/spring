package com.sai.spring.ssm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.spring.ssm.domain.Payment;

public interface PayementRepository extends JpaRepository<Payment, Long> {

}
