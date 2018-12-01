package com.vrm.data;

import java.util.ArrayList;

import com.vrm.enums.Groups;
import com.vrm.model.AlarmSystem;
import com.vrm.model.Camera;
import com.vrm.model.Elevator;
import com.vrm.model.Gate;
import com.vrm.model.Person;
import com.vrm.model.SchedulePattern;
import com.vrm.model.User;
import com.vrm.model.Visitor;
import com.vrm.model.Condominium;

public class Database { // Class implemented using the Singleton design pattern.
	private static Database instance = null;
	private static ArrayList<User> systemUsers;
	private static ArrayList<Visitor> systemVisitors;
	private static ArrayList<Person> registeredEntrances;
	private static ArrayList<Camera> systemCameras;
	private static ArrayList<Elevator> systemElevators;
	private static Condominium condominiumInfo;
	private static ArrayList<SchedulePattern> condominiumSchedulePatterns;
	private static AlarmSystem alarmSystem;
	private static Gate condominiumGate;
	private static String systemFlowString;


	private Database() throws Exception { 	// The Person constructor throws an exception if the group
											// used to create the object is not valid. The Visitor constructor also
											// throws exception.
											//	Add permissions to the People.
		systemUsers = new ArrayList<User>();
		systemVisitors = new ArrayList<Visitor>();
		systemCameras = new ArrayList<Camera>();
		systemElevators = new ArrayList<Elevator>();
		alarmSystem = new AlarmSystem();
		registeredEntrances = new ArrayList<Person>();

		condominiumInfo = new Condominium(10);

		condominiumSchedulePatterns = new ArrayList<SchedulePattern>();
		
		systemFlowString = "Started case:#";

		systemUsers.add(new User(0, "Maria", "Maria", "123", 20, 2, 2, Groups.Administrator));
		systemUsers.add(new User(1, "Joao", "Joao", "123", 10, 1, 1, Groups.User));
		systemUsers.add(new User(2, "Jose", "Jose", "123", 21, 2, 2, Groups.User));

		systemVisitors.add(new Visitor(3, "Pedro", Groups.Visitor, systemUsers.get(1)));
		systemVisitors.add(new Visitor(4, "Jack", Groups.Maintenance, systemUsers.get(0)));

		systemCameras.add(new Camera(0));
		systemCameras.add(new Camera(1));
		systemCameras.add(new Camera(2));
		systemCameras.add(new Camera(3));
		systemCameras.add(new Camera(4));
		systemCameras.add(new Camera(5));
		systemCameras.add(new Camera(6));
		systemCameras.add(new Camera(7));
		systemCameras.add(new Camera(8));

		systemElevators.add(new Elevator(1, systemCameras.get(0)));
		systemElevators.add(new Elevator(1, systemCameras.get(1)));

		condominiumGate = new Gate(systemCameras.get(2));
		systemUsers.get(0).addPermission(1);
		systemUsers.get(0).addPermission(2);
	}

	public static Database getInstance() throws Exception {
		if (instance == null)
			instance = new Database();
		return instance;
	}

	public Condominium getCondominiumInfo() {
		return condominiumInfo;
	}

	public Gate getCondominiumGate() {
		return condominiumGate;
	}

	public ArrayList<User> getAllUsers() {
		return systemUsers;
	}

	public ArrayList<Visitor> getAllVisitors() {
		return systemVisitors;
	}

	public ArrayList<Camera> getAllCameras() {
		return systemCameras;
	}

	public ArrayList<Elevator> getCondominiumElevators() {
		return systemElevators;
	}

	public ArrayList<Person> getRegisteredEntrances() {
		return registeredEntrances;
	}

	public AlarmSystem getCondominiumAlarmSystem() {
		return alarmSystem;
	}

	public ArrayList<SchedulePattern> getCondominiumSchedulePatterns() {
		return condominiumSchedulePatterns;
	}

	public void save(User user) {
		systemUsers.add(user);
	}

	public void save(Visitor visitor) {
		systemVisitors.add(visitor);
	}

	public void save(Person person) {
		registeredEntrances.add(person);
	}

	public void save(SchedulePattern schedulePattern) {
		condominiumSchedulePatterns.add(schedulePattern);
	}
	public String getLogs(){
		return systemFlowString;
	}

	public void log(String action){
		systemFlowString=systemFlowString+"#"+action;
	} 
	public void cleanLog(){
		systemFlowString = "";
	}
}
