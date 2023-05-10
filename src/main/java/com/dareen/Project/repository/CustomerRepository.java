package com.dareen.Project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dareen.Project.model.Customers;


public interface CustomerRepository extends JpaRepository<Customers, Integer> {

}