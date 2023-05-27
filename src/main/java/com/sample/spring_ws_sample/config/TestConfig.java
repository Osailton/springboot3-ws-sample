package com.sample.spring_ws_sample.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sample.spring_ws_sample.model.entities.User;
import com.sample.spring_ws_sample.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Test User", "test@mail.com", "00000000", "123456");
		User u2 = new User(null, "Another Test", "another@mail.com", "99999999", "123456");
		
		repository.saveAll(Arrays.asList(u1, u2));	
	}
	
}
