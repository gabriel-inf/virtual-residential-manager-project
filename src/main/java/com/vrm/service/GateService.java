package com.vrm.service;

import java.util.ArrayList;

import com.vrm.data.CondominiumDAO;
import com.vrm.data.PersonDAO;
import com.vrm.model.Gate;
import com.vrm.model.Person;
import com.vrm.model.User;

public class GateService {
	//Modify all the methods that are receiving gate as parameter to receive gateId, and then get the gate object
	//from Database
	
	public void openGateService(ArrayList<Person> authorizedPeople, ArrayList<Person> peopleThatEntered, Gate gate) throws Exception {
		CameraService cameraService = new CameraService();
		CondominiumDAO condominiumDAO = new CondominiumDAO();
		
		gate.open();
		boolean isThereIntruders = cameraService.isThereIntruders(authorizedPeople, peopleThatEntered, gate.getGateCamera());
		if(isThereIntruders) {
			condominiumDAO.getCondominiumAlarmSystem().activateAlarms();
		}

		gate.close();
	}
	
	public void sendNotification(int apartmentNumber, Gate gate) throws Exception {
		PersonDAO personDAO = new PersonDAO();
		User userToNotify;
		
		userToNotify = personDAO.getUserByApartmentNumber(apartmentNumber);
		if(userToNotify != null) {
			userToNotify.addNotification("Person waiting to enter", new CameraService().capturePhoto(gate.getGateCamera()));
		}
	}
	
	public void answerNotification(boolean status, Person personEntering, ArrayList<Person> peopleThatEntered, int apartmentNumber, Gate gate) throws Exception {
		PersonDAO personDAO = new PersonDAO();
		User userNotificated;
		
		userNotificated = personDAO.getUserByApartmentNumber(apartmentNumber);
		userNotificated.replyNotification();
		
		if(status) {
			ArrayList<Person> authorizedPeople = new ArrayList<>();
			authorizedPeople.add(personEntering);
			this.openGateService(authorizedPeople, peopleThatEntered, gate);
		}
	}
	
}
