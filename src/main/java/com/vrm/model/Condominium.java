package com.vrm.model;

public class Condominium {
	private Integer buildNumOfFloors;

	public Condominium(int numOfFloors) {
		this.buildNumOfFloors = numOfFloors;
	}

	public Integer getBuildNumOfFloors () {
		return buildNumOfFloors;
	}

	public void setBuildNumOfFloors (Integer numOfFloors) {
		this.buildNumOfFloors = numOfFloors;
	}	
}
