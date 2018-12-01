package com.vrm.model;

import java.util.ArrayList;

import com.vrm.data.Database;

public class Elevator {
	private Integer actualFloor;
	private Integer destinationFloor;
	private ArrayList<Integer> demandedFloors;
	private int buildingNumber;
	private Camera elevatorCamera;
	
	public Elevator(int buildingNumber, Camera elevatorCamera) {
		this.actualFloor=0;
		this.destinationFloor=null;
		this.demandedFloors=new ArrayList<Integer>();
		this.buildingNumber=buildingNumber;
		this.elevatorCamera = elevatorCamera;
	}
	
	public Integer getActualFloor() {
		return actualFloor;
	}
	public Integer getDestinationFloor() {
		return destinationFloor;
	}
	public ArrayList<Integer> getDemandedFloors() {
		return demandedFloors;
	}
	public int getBuildingNumber() {
		return buildingNumber;
	}
	
	public void call(int destinationFloor) throws Exception {


		Database.getInstance().log("Elevator from building " + this.getBuildingNumber() +  
			" was called from " + this.getActualFloor() + " to " + destinationFloor);
			
		if(this.destinationFloor==null)
			this.destinationFloor=destinationFloor;
		else
			this.demandedFloors.add(destinationFloor);
			
	}
	
	public void move() {
		if(destinationFloor!=null) {
			this.actualFloor=this.destinationFloor;
			if(!demandedFloors.isEmpty())
				this.destinationFloor=this.demandedFloors.remove(0);
		}
	}

	public Camera getElevatorCamera() {
		return elevatorCamera;
	}

	public void setElevatorCamera(Camera elevatorCamera) {
		this.elevatorCamera = elevatorCamera;
	}
}
