package com.sample.spring_ws_sample.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sample.spring_ws_sample.exceptions.DatabaseException;
import com.sample.spring_ws_sample.exceptions.ResourceNotFoundException;
import com.sample.spring_ws_sample.model.entities.User;
import com.sample.spring_ws_sample.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Integer id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // returns an object of the type User that is inside obj
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public void delete(Integer id) {
		try {
			if(userRepository.existsById(id)) {
				userRepository.deleteById(id);
			} else {
				throw new ResourceNotFoundException(id);
			}
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Integer id, User user) {
		try {
			// A monitored object. FindById gets the database object, 
			// getReferenceById gets only a reference, for you to change later.
			User entity = userRepository.getReferenceById(id);
			updateUserData(entity, user);
			return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateUserData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}
	 

}
