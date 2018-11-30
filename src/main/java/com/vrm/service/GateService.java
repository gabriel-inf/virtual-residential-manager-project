package com.vrm.service;

import java.util.ArrayList;

import com.vrm.data.CondominiumDAO;
import com.vrm.data.Database;
import com.vrm.data.PersonDAO;
import com.vrm.model.Gate;
import com.vrm.model.Person;
import com.vrm.model.User;

public class GateService {
	
	public void openGateService(ArrayList<Person> authorizedPeople, ArrayList<Person> peopleThatEntered) throws Exception {
		CameraService cameraService = new CameraService();
		ElevatorService elevatorService = new ElevatorService();
		CondominiumDAO condominiumDAO = new CondominiumDAO();
		Gate gate = condominiumDAO.getCondominiumGate();
		
		Database.getInstance().log("#Gate service");
		
		Database.getInstance().log("#Opening gate");
		gate.open();
		boolean isThereIntruders = cameraService.isThereIntruders(authorizedPeople, peopleThatEntered, gate.getGateCamera());
		if(isThereIntruders) {
			Database.getInstance().log("#There are intruders!");
			condominiumDAO.getCondominiumAlarmSystem().activateAlarms();
		}else{
			Database.getInstance().log("#There are no intruders");

			for (Person person : peopleThatEntered) {
				elevatorService.callElevator(person, 100, true);
			}
			

		}
		
		Database.getInstance().log("#Closing gate");
		gate.close();
	}
	
	public void sendNotification(int apartmentNumber) throws Exception {
		PersonDAO personDAO = new PersonDAO();
		CondominiumDAO condominiumDAO = new CondominiumDAO();
		Gate gate = condominiumDAO.getCondominiumGate();
		User userToNotify;
		
		userToNotify = personDAO.getUserByApartmentNumber(apartmentNumber);
		if(userToNotify != null) {
			userToNotify.addNotification("Person waiting to enter", new CameraService().capturePhoto(gate.getGateCamera()));
		}
	}
	
	public void answerNotification(boolean status, Person personEntering, ArrayList<Person> peopleThatEntered, int apartmentNumber) throws Exception {
		PersonDAO personDAO = new PersonDAO();
		User userNotificated;
		
		userNotificated = personDAO.getUserByApartmentNumber(apartmentNumber);
		userNotificated.replyNotification();
		
		if(status) {
			ArrayList<Person> authorizedPeople = new ArrayList<>();
			authorizedPeople.add(personEntering);
			this.openGateService(authorizedPeople, peopleThatEntered);
		}
	}
	
}
