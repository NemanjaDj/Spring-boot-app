package com.nemanja.springboot.web.Springbootapp.service;

<<<<<<< HEAD
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

=======
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nemanja.springboot.web.Springbootapp.model.Todo;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "nemanja", "Uciti Spring View", new Date(),
                false));
        todos.add(new Todo(2, "nemanja", "Uciti Angular", new Date(), false));
        todos.add(new Todo(3, "nemanja", "Uciti Hibernate", new Date(),
                false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public Todo retrieveTodo(int id) {
        for (Todo todo : todos) {
            if (todo.getId()==id) {
                return todo;
            }
        }
        return null;
    }
    
    public void update(String desc, int id) {
    	Todo todo = retrieveTodo(id);
    	todo.setDesc(desc);	
    }
    
    public void update(String desc, int id, Date date) {
    	Todo todo = retrieveTodo(id);
    	todo.setDesc(desc);	
    	todo.setTargetDate(date);
    }
    
    public void addTodo(String name, String desc, Date targetDate,
            boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
>>>>>>> branch 'master' of https://github.com/NemanjaDj/Spring-boot-app.git
}