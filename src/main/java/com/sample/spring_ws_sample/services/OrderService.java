package com.sample.spring_ws_sample.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.spring_ws_sample.model.entities.Order;
import com.sample.spring_ws_sample.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository OrderRepository;

	public List<Order> findAll() {
		return OrderRepository.findAll();
	}
	
	public Order findById(Integer id) {
		Optional<Order> obj = OrderRepository.findById(id);
		return obj.get(); // returns an object of the type Order that is inside obj
	}

}
