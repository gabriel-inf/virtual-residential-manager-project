package com.vrm.model;

public class ElevatorHistory {
	private int originFloor;
	private int destinationFloor;
	private int hour;
	
	public ElevatorHistory(int originFloor, int destinationFloor, int hour) {
		this.originFloor=originFloor;
		this.destinationFloor = destinationFloor;
		this.hour=hour;
	}
	public int getOriginFloor() {
		return originFloor;
	}
	public int getDestinationFloor() {
		return destinationFloor;
	}
	public int getHour() {
		return hour;
	}
	public boolean equals(ElevatorHistory elevatorHistory) {
		if(elevatorHistory != null) {
			if(elevatorHistory.getOriginFloor() == this.originFloor && elevatorHistory.getDestinationFloor() == this.destinationFloor
					&& elevatorHistory.getHour() == this.hour)
				return true;
			else
				return false;
		}
		else
			return false;
	}
}