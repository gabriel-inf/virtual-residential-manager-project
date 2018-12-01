package com.vrm.data;

import java.util.ArrayList;

import com.vrm.model.Condominium;
import com.vrm.model.AlarmSystem;
import com.vrm.model.Elevator;
import com.vrm.model.Gate;
import com.vrm.model.Person;
import com.vrm.model.SchedulePattern;
import com.vrm.model.User;

public class CondominiumDAO {
	
	public  Integer getBuildNumOfFloors() throws Exception {
		return Database.getInstance().getCondominiumInfo().getBuildNumOfFloors();
	}
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
	public ArrayList<SchedulePattern> getCondominiumSchedulePatterns() throws Exception{
		return Database.getInstance().getCondominiumSchedulePatterns();
	}
	public SchedulePattern getSchedulePattern(User user, int originFloor, int destinationFloor, int hour) throws Exception {
		ArrayList<SchedulePattern> condominiumSchedulePatterns = Database.getInstance().getCondominiumSchedulePatterns();
		SchedulePattern scheduleP = new SchedulePattern(originFloor, destinationFloor, hour, user);
		for (SchedulePattern schedulePattern : condominiumSchedulePatterns) {
			if(schedulePattern.equals(scheduleP))
				return schedulePattern;
		}
		return null;
	}
	public ArrayList<SchedulePattern> getSchedulePatternsByHour(int hour) throws Exception{
		ArrayList<SchedulePattern> condominiumSchedulePatterns = Database.getInstance().getCondominiumSchedulePatterns();
		ArrayList<SchedulePattern> returnSchedules = new ArrayList<SchedulePattern>();
		
		for (SchedulePattern schedulePattern : condominiumSchedulePatterns) {
			if(schedulePattern.getHour() == hour)
				returnSchedules.add(schedulePattern);
		}
		return returnSchedules;
	}
	public void saveSchedulePattern(SchedulePattern schedulePattern) throws Exception {
		Database.getInstance().save(schedulePattern);
	}
}
