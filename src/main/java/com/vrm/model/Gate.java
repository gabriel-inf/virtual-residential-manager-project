package com.vrm.model;


public class Gate extends CondominumDependency{
	private boolean isOpen;
	private boolean closePerson;
	private Camera gateCamera;
	
	public Gate(Camera gateCamera) {
		this.isOpen=false;
		this.closePerson=false;
		this.gateCamera = gateCamera;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public boolean isClosePerson() {
		return closePerson;
	}
	public Camera getGateCamera() {
		return gateCamera;
	}
	
	public void open() {
		if(!this.isOpen)
			this.isOpen=true;
	}
	public void close() {
		if(this.isOpen)
			this.isOpen=false;
	}
	
}
