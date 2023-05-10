package com.dareen.Project.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.dareen.Project.model.Ck_Orderdetails;
import com.dareen.Project.model.Orderdetails;


public interface OrderDetailRepository extends JpaRepository<Orderdetails, Ck_Orderdetails> {

}