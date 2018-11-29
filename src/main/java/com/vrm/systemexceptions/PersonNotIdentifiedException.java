package com.vrm.systemexceptions;

public class PersonNotIdentifiedException extends Exception{

	private static final long serialVersionUID = 1L;

	public PersonNotIdentifiedException() {
		super("The person was not identified");
	}
}
