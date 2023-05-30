package com.sample.spring_ws_sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.spring_ws_sample.model.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}