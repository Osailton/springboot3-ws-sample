package com.sample.spring_ws_sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.spring_ws_sample.model.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
