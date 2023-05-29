package com.sample.spring_ws_sample.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sample.spring_ws_sample.model.entities.Order;
import com.sample.spring_ws_sample.model.entities.User;
import com.sample.spring_ws_sample.repositories.OrderRepository;
import com.sample.spring_ws_sample.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Test User", "test@mail.com", "00000000", "123456");
		User u2 = new User(null, "Another Test", "another@mail.com", "99999999", "123456");
		
		Order o1 = new Order(null, Instant.parse("2023-05-28T22:17:00z"), u1);
		Order o2 = new Order(null, Instant.parse("2023-05-27T12:22:02z"), u2);
		Order o3 = new Order(null, Instant.parse("2023-05-28T22:18:44z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
}
