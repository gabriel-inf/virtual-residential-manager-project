package com.vrm.model;

import java.util.ArrayList;

import javax.xml.crypto.Data;

import com.vrm.data.Database;

public class Camera {

	private int id;
	private RecognitionModule recognitionModule;
	
	public Camera() {
		// TODO Auto-generated constructor stub
	}
	
	public Camera(int id) {
		this.id = id;
		this.recognitionModule = new RecognitionModule();
	}

	public int getId() {
		return id;
	}

	public RecognitionModule getRecognitionModule() {
		return recognitionModule;
	}

	public boolean validateEntrance(ArrayList<Person> authorizedPeople, ArrayList<Person> peopleWhoEntered)
			throws Exception {
		if (peopleWhoEntered.size() <= authorizedPeople.size()) {

			for (Person entered : peopleWhoEntered) {
				if (!authorizedPeople.contains(entered)) {
					return false;
				}
			}
			return true;
		}
		Database.getInstance().log("wrong size!");
		return false;
	}

	public int getNumPeopleWaiting() {
		// Maybe we can try to implement a method that returns a random int.
		return 0;
	}

	public boolean registerEntrance() {
		// Method that will be used to register the entrance of a person/group.
		return true;
	}

	public Object captureImage() throws Exception {
		Database.getInstance().log("Camera captured image!");
		return "Image Captured";
	}
}