package com.vrm.service;
import java.util.ArrayList;

import com.vrm.data.CondominiumDAO;
import com.vrm.model.Elevator;
import com.vrm.model.Person;

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
