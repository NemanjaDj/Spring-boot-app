package com.nemanja.springboot.web.Springbootapp.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemanja.springboot.web.Springbootapp.dao.UserDao;
import com.nemanja.springboot.web.Springbootapp.model.Todo;
import com.nemanja.springboot.web.Springbootapp.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	public void addUserTodo(User user, Todo todo) {
		Set<Todo> todos = user.getTodos();
		todos.add(todo);
		user.setTodos(todos);
		userDao.save(user);
	}
	
	public void saveUser(User user) {
		userDao.save(user);
	}
	
}
