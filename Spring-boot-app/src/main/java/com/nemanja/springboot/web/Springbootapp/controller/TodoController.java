package com.nemanja.springboot.web.Springbootapp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nemanja.springboot.web.Springbootapp.model.Todo;
import com.nemanja.springboot.web.Springbootapp.service.TodoService;

@Controller
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model){
		//String name = (String) model.get("name");
		model.put("todos", service.retrieveTodos("in28Minutes"));
		return "list-todos";
	}
	
	@RequestMapping(value="/add-todo", method = RequestMethod.GET)
	public String showTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, "in28Minutes", "", new Date(), false));
		return "todo";
	}
	
	@RequestMapping(value="/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/add-todo", method = RequestMethod.POST)
	public String AddTodo(ModelMap model, Todo todo) {
		service.addTodo("in28Minutes", todo.getDesc(), new Date(), false);
		return "redirect:/list-todos";
	}
}
