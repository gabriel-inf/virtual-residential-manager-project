package com.vrm.service;

import java.util.ArrayList;

import com.vrm.data.CondominiumDAO;
import com.vrm.data.Database;
import com.vrm.data.PersonDAO;
import com.vrm.data.CameraDAO;
import com.vrm.model.Camera;
import com.vrm.model.Person;
import com.vrm.systemexceptions.PersonNotIdentifiedException;


public class CameraService {
	
	public Person identifyPerson(Person person, int cameraId) throws Exception {
		Database.getInstance().log("CameraService!");
		PersonDAO personDAO = new PersonDAO();
		CameraDAO cameraDAO = new CameraDAO();
		ArrayList<Person> systemPeople = new ArrayList<Person>();
		Camera camera = cameraDAO.getCameraById(cameraId);
	
		if(camera != null) {
			systemPeople.addAll(personDAO.getAllPeople());
			if(camera.getRecognitionModule().identify(person, systemPeople))
				return person;
		}
		throw new PersonNotIdentifiedException();
	}
	
	public boolean isThereIntruders(ArrayList<Person> authorizedPeople, ArrayList<Person> peopleWhoEntered, Camera camera) throws Exception {
		CondominiumDAO condominiumDAO = new CondominiumDAO();
		boolean validEntrance = camera.validateEntrance(authorizedPeople, peopleWhoEntered);
		
		if(validEntrance) {
			for (Person person : peopleWhoEntered) {
				condominiumDAO.registerPersonEntrance(person);
			}
		}
		
		return validEntrance;
		
	}
	
	public Object capturePhoto(Camera camera) {
		return camera.captureImage();
	}
//	public static void main(String[] args) throws Exception {
//		PersonDAO personDAO = new PersonDAO();
//		Person p = new Person(0, "Maria", null, Groups.Administrator, true);
//		CameraService cs = new CameraService();
//		System.out.println(cs.identifyPerson(p , 0));
//	}
}
