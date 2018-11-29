package com.vrm.systemexceptions;

public class UnableToVinculateException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UnableToVinculateException(int id, String name) {	//	Thrown when vinculating an user to a visitor. 
		super("There was a problem vinculating the visitor (Id:"+id+",Name:"+name+") to an user");
	}
	public UnableToVinculateException() {
		super("There was a problem vinculating the SchedulePattern to the user");
	}

}
