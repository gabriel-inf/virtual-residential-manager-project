package com.vrm.data;

import java.util.ArrayList;

import com.vrm.model.User;
import org.springframework.boot.jdbc.DatabaseDriver;

import com.vrm.model.Groups;
import com.vrm.model.Person;
import com.vrm.model.Visitor;
import com.vrm.systemexceptions.RegisterNotFoundException;


public class PersonDAO {
	
	public ArrayList<Person> getAllPeople() throws Exception{
			ArrayList<Person> systemPeople = new ArrayList<Person>();
			systemPeople.addAll(Database.getInstance().getAllUsers());
			systemPeople.addAll(Database.getInstance().getAllVisitors());
			return systemPeople;
	}
	
	public User getUserById(int id) throws Exception {
		ArrayList<User> systemUsers = new ArrayList<User>(); 

		systemUsers.addAll(Database.getInstance().getAllUsers());
			
		for (User user : systemUsers) {
			if(user.getId() == id)
				return user;
		}
		throw new RegisterNotFoundException();
	}
	
	public User getUserByApartmentNumber(int apartmentNumber) throws Exception {
		ArrayList<User> systemUsers = new ArrayList<User>(); 
		systemUsers.addAll(Database.getInstance().getAllUsers());
		
		for (User user : systemUsers) {
			if(user.getApartmentNumber() == apartmentNumber)
				return user;
		}
		throw new RegisterNotFoundException();
	}
	
	public void saveUser(String name, String login, String password, int apartmentNumber, int floor, int building, Enum<Groups> group) throws Exception {
			User savingUser = new User(Database.getInstance().getAllUsers().size(), name, login, password, apartmentNumber, floor, building, group);
			Database.getInstance().save(savingUser);
	}
	
	public void saveVisitor(String name, Enum<Groups> group, User userToVinculate) throws Exception {
		//	Here we have to decide if the parameter will be an User object or the user name, id.
		Visitor savingVisitor = new Visitor(Database.getInstance().getAllUsers().size(), name, group, userToVinculate);
		Database.getInstance().save(savingVisitor);
	}
	
	public User authenticateUser(String login, String password) throws Exception {
		for(User user : Database.getInstance().getAllUsers()) {
			if (user.getLogin() == login && user.getPassword() == password)
				return user;
		}
		throw new RegisterNotFoundException();
	}
}
