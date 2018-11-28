package com.vrm.model;

public class Camera {
	
	private int id;
	private RecognitionModule recognitionModule;
	
	public Camera(int id) {
		this.id=id;
		this.recognitionModule = new RecognitionModule();
	}
	public int getId() {
		return id;
	}
	public RecognitionModule getRecognitionModule() {
		return recognitionModule;
	}

	public int getNumPeopleWaiting() {
		//	Maybe we can try to implement a method that returns a random int.
		return 0;
	}
	public boolean registerEntrance() {
		//	Method that will be used to register the entrance of a person/group.
		return true;
	}
	public Object captureImage() {
		return "Image Captured";
	}
}
