package com.nemanja.springboot.web.Springbootapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nemanja.springboot.web.Springbootapp.model.Todo;
import com.nemanja.springboot.web.Springbootapp.model.User;
import com.nemanja.springboot.web.Springbootapp.service.TodoService;
import com.nemanja.springboot.web.Springbootapp.service.UserService;

@Controller
@SessionAttributes("name")
public class TodoController {

	
	@Autowired
	TodoService service;

	@Autowired
	private UserService userService;

	// data picker
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// date format dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@GetMapping("/list-todos")
	public String showTodos(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = userService.findByUsername(username);
		model.put("todos", service.retrieveTodos(user));
		return "list-todos";
	}

	@GetMapping("/add-todo")
	public String showTodoPage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("username", name);
		model.addAttribute("todo", new Todo(userService.findByUsername(name), "", new Date(), false));
		return "todo";
	}

	@PostMapping("/add-todo")
	public String AddTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		if (result.hasErrors()) {
			return "todo";
		}
		service.addTodo(userService.findByUsername(username), todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}

	@GetMapping("/delete-todo")
	public String deleteTodo(@RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}

	@GetMapping("/update-todo")
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = service.retrieveTodo(id);
		model.put("todo", todo);
		return "todo";
	}

	@PostMapping("/update-todo")
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		service.update(todo);
		return "redirect:/list-todos";
	}
}
