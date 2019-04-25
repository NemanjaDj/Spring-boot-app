package com.nemanja.springboot.web.Springbootapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nemanja.springboot.web.Springbootapp.model.User;
import com.nemanja.springboot.web.Springbootapp.service.UserService;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String showWelcomePage(ModelMap model) {
		model.addAttribute("name", loggingInUsername());
		return "welcome";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login-form";
	}

	@GetMapping("/registration")
	public String registrationPage(Model model) {
		// we must include this modelAttribute to be able to see registration page
		model.addAttribute("user", new User());
		return "registration";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String p = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(p);
		userService.saveUser(user);
		return "redirect:/login/";
	}
	
	public String loggingInUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		return name;
	}
}