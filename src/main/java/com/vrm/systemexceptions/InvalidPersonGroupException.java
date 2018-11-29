package com.vrm.systemexceptions;

public class InvalidPersonGroupException extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidPersonGroupException() {
		super("The informed person group is not valid");
	}
}
