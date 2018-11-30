package com.vrm.data;

import java.util.ArrayList;

import com.vrm.model.AlarmSystem;
import com.vrm.model.Elevator;
import com.vrm.model.Gate;
import com.vrm.model.Person;

public class CondominiumDAO {
	
	public AlarmSystem getCondominiumAlarmSystem() throws Exception{
		return Database.getInstance().getCondominiumAlarmSystem();
	}
	public ArrayList<Person> getCondominiumRegisteredEntrances() throws Exception{
		return Database.getInstance().getRegisteredEntrances();
	}
	public void registerPersonEntrance(Person person) throws Exception {
		Database.getInstance().log(person.getName() + " has entered");
		Database.getInstance().save(person);
	}
	public ArrayList<Elevator> getCondominiumElevators() throws Exception{
		return Database.getInstance().getCondominiumElevators();
	}
	public Gate getCondominiumGate() throws Exception {
		return Database.getInstance().getCondominiumGate();
	}
}
