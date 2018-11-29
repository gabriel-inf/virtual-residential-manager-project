package com.vrm.service;
import java.util.ArrayList;

import com.vrm.model.Person;
import com.vrm.data.PersonDAO;
import com.vrm.systemexceptions.InvalidPersonGroupException;
import com.vrm.model.Groups;

public class PersonService {
	private PersonDAO personDAO = new PersonDAO();
	public void registerUser(String name, String login, String password, int apartmentNumber, int floor, int building, Enum<Groups> group) throws Exception {
		if (group == Enum<Groups>.User || group == Enum<Groups>.Administrator) {
			this.personDAO.saveUser(name, login, password, apartmentNumber, floor, building, group);
		}

		throw new InvalidPersonGroupException();
	}

	public void registerVisitor(String name, Enum<Groups> group, User userToVinculate) throws Exception {
		if (group == Enum<Groups>.Visitor || group == Enum<Groups>.Maintenance) {
			this.personDAO.saveVisitor(name, group, userToVinculate);
		}

		throw new InvalidPersonGroupException();
	}

	public User loginUser(String login, String password) throws Exception {
		User user = authenticateUser(login, password);
		return user;
	}
}