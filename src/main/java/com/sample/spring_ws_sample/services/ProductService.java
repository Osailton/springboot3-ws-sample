package com.sample.spring_ws_sample.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.spring_ws_sample.model.entities.Product;
import com.sample.spring_ws_sample.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product findById(Integer id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.get(); // returns an object of the type Product that is inside obj
	}

}
