package com.dareen.Project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dareen.Project.model.Ck_Paymentid;
import com.dareen.Project.model.Payments;


public interface PaymentRepository extends JpaRepository<Payments, Ck_Paymentid> {

}