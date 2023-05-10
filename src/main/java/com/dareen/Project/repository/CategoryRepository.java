package com.dareen.Project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dareen.Project.model.Categories;


public interface CategoryRepository extends JpaRepository<Categories, String> {

}