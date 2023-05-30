package com.sample.spring_ws_sample.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.spring_ws_sample.model.entities.Category;
import com.sample.spring_ws_sample.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Category findById(Integer id) {
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.get(); // returns an object of the type Category that is inside obj
	}

}
