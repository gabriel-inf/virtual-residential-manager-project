package com.vrm.service;
import java.util.ArrayList;

import com.vrm.data.CondominiumDAO;
import com.vrm.data.PersonDAO;
import com.vrm.model.Elevator;
import com.vrm.model.Person;
import com.vrm.model.SchedulePattern;
import com.vrm.model.User;

public class ElevatorService {
	
	public boolean callElevator(Person person, int destinationFloor, boolean identified) throws Exception {
		CondominiumDAO condominiumDAO = new CondominiumDAO();
		if(identified) {
			boolean isAllowed = person.checkPermissions(destinationFloor);
			if(isAllowed) {
				this.getClosestElevator(condominiumDAO.getCondominiumElevators(), 0).call(destinationFloor);  //  Call the elevator that is closest to the first floor.
				return true;
			}
			else
				return false;
		}
		else {
			this.getClosestElevator(condominiumDAO.getCondominiumElevators(), 0).call(destinationFloor);
			return true;
		}
	}
	
	public boolean userCallElevator(Person person, int originFloor, int destinationFloor, int hour) throws Exception {
		if(person.isUser() && person.getId() != null) {
			CondominiumDAO condominiumDAO = new CondominiumDAO();
			PersonDAO personDAO = new PersonDAO();
			User user = personDAO.getUserById(person.getId());
			
			boolean isAllowed = user.checkPermissions(destinationFloor);
			if(isAllowed) {
				this.getClosestElevator(condominiumDAO.getCondominiumElevators(), originFloor).call(destinationFloor);  //  Call the elevator that is closest to the first floor.
				if(condominiumDAO.getSchedulePattern(user, originFloor, destinationFloor, hour) == null) {
					int occurrences = user.numHistoryOccurrences(originFloor, destinationFloor, hour);
					if(occurrences < 7) {
						user.addCallToHistory(originFloor, destinationFloor, hour);
					}
					else{
						user.removeCallHistory(originFloor, destinationFloor, hour);
						condominiumDAO.saveSchedulePattern(new SchedulePattern(originFloor, destinationFloor, hour, user));					
					}
				}
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	
/*	public boolean patternCallElevator(int hour) throws Exception {
		CondominiumDAO condominiumDAO = new CondominiumDAO();
		ArrayList<SchedulePattern> schedulePatterns = new ArrayList<SchedulePattern>();
		schedulePatterns.addAll(condominiumDAO.getSchedulePatternsByHour(hour));
		
	}*/
	
	private Elevator getClosestElevator(ArrayList<Elevator> condominiumElevators, int floor) {
		if(condominiumElevators != null && floor >= 0) {
			Elevator closestElevator = condominiumElevators.get(0);
			int distanceToDestination = closestElevator.getActualFloor() - floor;
			for (Elevator elevator : condominiumElevators) {
				if((elevator.getActualFloor() - floor) < distanceToDestination ) {
					closestElevator = elevator;
					distanceToDestination = elevator.getActualFloor() - floor;
				}
			}
			return closestElevator;
		}
		else
			return null;
	}
	
}
