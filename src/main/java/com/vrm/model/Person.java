package com.vrm.model;

import java.util.ArrayList;

import com.vrm.systemexceptions.InvalidPersonGroupException;

public class Person {
	
	private Integer id;
	private String name;
	private Object photo;
	private Groups group;
	private ArrayList<Integer> permissions;	//	Permissions were an individual class in the simplified
											//	class diagram, but it's better to make it an attribute.
	
	static final boolean creatingUser = true; 
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(Integer id, String name, Object photo, Groups group, boolean creatingUser) throws Exception {
		final boolean groupIsConsistent = (creatingUser && (group==Groups.User || group==Groups.Administrator)) || (!creatingUser && (group==Groups.Visitor || group==Groups.Maintenance));
		if(groupIsConsistent) {
			this.id=id;
			this.name=name;
			this.photo=photo;
			this.group=group;
			this.permissions = new ArrayList<Integer>();
		}
		else
			throw new InvalidPersonGroupException();
		}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return this.name;
	}
	public Groups getGroup() {
		return this.group;
	}
	public Object getPhoto() {
		return this.photo;
	}
	public ArrayList<Integer> getPermissions() {
		return this.permissions;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGroup(Groups group) {
		this.group = group;
	}
	public void setPhoto(Object photo) {
		this.photo = photo;
	}
	
	
	public boolean isUser() {
		return this.group == Groups.User || this.group == Groups.Administrator;
	}
	public boolean checkPermissions(int destinationFloor) {
		for (Integer allowedFloor : permissions) {
			if(allowedFloor == destinationFloor) 
				return true;
		}
		return false;
	}
	
	public boolean equals(Person p) {
		if(p.getId() != null && p.getName() != null && p.getGroup() != null) {
			if(p.getId()==this.id && p.getName() == this.name && p.getGroup() == this.group)
				return true;
			else
				return false;
		}
		else
			return false;
	}
}
