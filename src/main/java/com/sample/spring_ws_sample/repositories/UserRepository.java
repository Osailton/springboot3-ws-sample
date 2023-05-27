package com.sample.spring_ws_sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.spring_ws_sample.model.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}