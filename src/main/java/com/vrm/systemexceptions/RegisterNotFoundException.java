package com.vrm.systemexceptions;

public class RegisterNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public RegisterNotFoundException() {
		super("No register was found in the database");
	}
}
