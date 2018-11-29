package com.vrm.controller;

import com.vrm.model.Person;
import com.vrm.service.PersonService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	private PersonService personService = new PersonService();

	public User userLogin(String login, String password) {
		User user = this.personService.loginUser(login, password);
		return user;
	}

	public void userRegister(String name, String login, String password, int apartmentNumber, int floor, int building, Enum<Groups> group) {
		this.personService.registerUser(name, login, password, apartmentNumber, floor, building, group);
	}

	public void visitorRegister(String name, Enum<Groups> group, User userToVinculate) {
		this.personService.registerUser(name, group, userToVinculate);
	}
}