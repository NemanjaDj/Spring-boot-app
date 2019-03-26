package com.nemanja.springboot.web.Springbootapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	
	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, mappedBy = "user")
	private Set<Todo> todos = new HashSet<>();
	
	// Constructors
	
	public User() {}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	// Getters & Setters

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Todo> getTodos() {
		return todos;
	}

	public void setTodos(Set<Todo> todos) {
		this.todos = todos;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
}
