package com.vrm.controller;

import com.vrm.model.Groups;
import com.vrm.model.User;
import com.vrm.service.PersonService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	private PersonService personService = new PersonService();

	public User userLogin(String login, String password) throws Exception {
		User user = this.personService.loginUser(login, password);
		return user;
	}

	public void userRegister(String name, String login, String password, int apartmentNumber, int floor, int building, Groups group) throws Exception {
		this.personService.registerUser(name, login, password, apartmentNumber, floor, building, group);
	}

	public void visitorRegister(String name, Groups group, User userToVinculate) throws Exception{
		this.personService.registerVisitor(name,group, userToVinculate);
	}
}