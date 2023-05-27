package com.sample.spring_ws_sample.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.spring_ws_sample.model.entities.User;

@RestController
@RequestMapping(value = "users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1, "Teste", "Teste@teste.com", "000", "senha");
		return ResponseEntity.ok().body(u);
	}

}
