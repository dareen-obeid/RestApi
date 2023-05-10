package com.dareen.Project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.dareen.Project.model.Orders;


public interface OrderRepository extends JpaRepository<Orders, Integer> {

}