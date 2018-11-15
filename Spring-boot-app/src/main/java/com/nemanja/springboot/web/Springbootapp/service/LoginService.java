package com.nemanja.springboot.web.Springbootapp.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean validateUser(String userid, String password) {
		// user nemanja, sifra 1234
		return userid.equalsIgnoreCase("nemanja") && password.equalsIgnoreCase("1234");

	}
}
