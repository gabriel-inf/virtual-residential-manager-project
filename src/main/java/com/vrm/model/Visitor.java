package com.vrm.model;

import java.util.ArrayList;

import com.vrm.systemexceptions.UnableToVinculateException;

public class Visitor extends Person{
	private ArrayList<User> usersVinculatedTo;
	
	public Visitor(int id, String name, Groups group, User userToVinculate) throws Exception {
		super(id, name, null, group, !creatingUser); 	//	Using null for the photo attribute.
		usersVinculatedTo = new ArrayList<User>();
		if(userToVinculate != null)
			usersVinculatedTo.add(userToVinculate);
		else
			throw new UnableToVinculateException(id, name);
	}
	
	public ArrayList<User> getUsersVinculatedTo() {
		return this.usersVinculatedTo;
	}
	@Override
	public String toString() {
		return "[Id:" + this.getId() + ", Name: "+this.getName()+", Photo: "+this.getPhoto()+", Group: "+this.getGroup()+
				", VinculatedTo: "+this.getUsersVinculatedTo()+"]";
	}
	
}
