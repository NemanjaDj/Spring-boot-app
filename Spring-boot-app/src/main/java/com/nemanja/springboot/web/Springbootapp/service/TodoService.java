package com.nemanja.springboot.web.Springbootapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemanja.springboot.web.Springbootapp.dao.TodoDao;
import com.nemanja.springboot.web.Springbootapp.model.Todo;
import com.nemanja.springboot.web.Springbootapp.model.User;

@Service
public class TodoService {

	@Autowired
	private TodoDao todoDao;
	
    public List<Todo> retrieveTodos(User user) {
    return todoDao.findByUser(user);
    }

    public Todo retrieveTodo(int id) {
        return todoDao.findById(id);
    }
    
    public void update(Todo todo) {
    	Todo tmptodo = todoDao.findById(todo.getId());
    	tmptodo.setDesc(todo.getDesc());
    	tmptodo.setTargetDate(todo.getTargetDate());
    	todoDao.save(tmptodo);
    }
    
    public void addTodo(User user, String desc, Date targetDate,
            boolean isDone) {
    	Todo todo = new Todo(user, desc, targetDate, isDone);
    	todoDao.save(todo);
    }

    public void deleteTodo(int id) {
        todoDao.removeTodo(id);
    }

}