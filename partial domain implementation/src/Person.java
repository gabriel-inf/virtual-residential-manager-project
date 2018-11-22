import java.util.ArrayList;

import systemexceptions.InvalidPersonGroupException;

public class Person {
	
	private int id;
	private String name;
	private Object photo;
	private Enum<Groups> group;
	private ArrayList<Integer> permissions;	//	Permissions were an individual class in the simplified
											//	class diagram, but it's better to make it an attribute.
	
	static final boolean creatingUser = true; 
	
	Person(int id, String name, Object photo, Enum<Groups> group, boolean creatingUser) throws Exception {
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
	public int getId() {
		return id;
	}
	public String getName() {
		return this.name;
	}
	public Enum<Groups> getGroup() {
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
	public void setGroup(Enum<Groups> group) {
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
		if(p.getId()==this.id && p.getName() == this.name && p.getGroup() == this.group)
			return true;
		else
			return false;
	}
}
