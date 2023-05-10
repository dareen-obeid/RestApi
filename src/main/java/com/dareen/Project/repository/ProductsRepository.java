package com.dareen.Project.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dareen.Project.model.Products;




public interface ProductsRepository extends JpaRepository<Products, String> {


}