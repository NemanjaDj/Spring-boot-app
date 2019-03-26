package com.nemanja.springboot.web.Springbootapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nemanja.springboot.web.Springbootapp.model.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByUsername(String username);

}
