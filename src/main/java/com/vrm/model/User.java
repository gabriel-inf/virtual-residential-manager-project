package com.vrm.model;

import java.util.ArrayList;

import com.vrm.enums.Groups;


public class User extends Person{
	private String login;
	private String password;
	private int floor;
	private int building;
	private int apartmentNumber;
	private ArrayList<Notification> notifications;
	private ArrayList<ElevatorHistory> history;
	
	public User(int id, String name, String login, String password, int apartmentNumber, int floor, int building, Groups group) throws Exception {
			super(id, name, null, group, creatingUser);		//	Using null for the photo attribute.
			this.login = login;
			this.password = password;
			this.floor = floor;
			this.building = building;
			this.notifications = new ArrayList<Notification>();
			this.apartmentNumber = apartmentNumber;
			this.history = new ArrayList<ElevatorHistory>();
	}
	
	public String getLogin() {
		return this.login;
	}
	public String getPassword() {
		return this.password;
	}
	public int getBuilding() {
		return this.building;
	}
	public int getFloor() {
		return this.floor;
	}
	public ArrayList<Notification> getNotifications() {
		return notifications;
	}
	public int getApartmentNumber() {
		return this.apartmentNumber;
	}
	public ArrayList<ElevatorHistory> getHistory() {
		return history;
	}
	public void addCallToHistory(int originFloor, int destinationFloor, int hour) {
		this.history.add(new ElevatorHistory(originFloor, destinationFloor, hour));
	}
	public void removeCallHistory(int originFloor, int destinationFloor, int hour) {	//method used to remove from history when 
																						//it becomes a SchedulePattern.
		ElevatorHistory elevHistory = new ElevatorHistory(originFloor, destinationFloor, hour);
		for(int i=0; i<this.history.size();i++) {
			if(this.history.get(i).equals(elevHistory))
				this.history.remove(i);
		}
	}
	public int numHistoryOccurrences(int originFloor, int destinationFloor, int hour) {
		int occurrences = 0;
		ElevatorHistory elevHistory = new ElevatorHistory(originFloor, destinationFloor, hour);
		for(int i=0; i<this.history.size();i++) {
			if(this.history.get(i).equals(elevHistory))
				occurrences++;
		}
		return occurrences;	
	}
	public void addNotification(String description, Object photo) {
		this.notifications.add(new Notification(description, photo));
	}
	public void replyNotification() {
		this.notifications.remove(0);	//It always removes the first notification that was sent.
	}
	@Override
	public String toString() {
		return "[Id:" + this.getId() + ", Name: "+this.getName()+", Photo: "+this.getPhoto()+", Group: "+this.getGroup()+
				", Login: "+this.getLogin()+", Password: "+this.getPassword()+", Building: "+this.getBuilding()+
				", Floor: "+this.getFloor()+", Notifications: "+this.getNotifications()+"]";
	}
	
//	public static void main(String[] args) {
//		PersonDAO pDAO = new PersonDAO();
//		try{
//			ArrayList<User> users = Database.getInstance().getAllUsers();
//			ArrayList<Visitor> visitors = Database.getInstance().getAllVisitors();
//			
//			for (User user : users) {
//				System.out.println(user);
//				System.out.println("\n");
//			}
//			for (Visitor visitor : visitors) {
//				System.out.println(visitor);
//				System.out.println("\n");
//			}
//			pDAO.saveUser("tester", "tester", "tester", 1, 1, 1, Groups.User);
//			
//			ArrayList<User> users2 = Database.getInstance().getAllUsers();
//			for (User user : users2) {
//				System.out.println(user);
//				System.out.println("\n");
//			}
//		}
//		catch(InvalidPersonGroupException ipg) {
//			System.out.println(ipg);
//			}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//	}	
}
