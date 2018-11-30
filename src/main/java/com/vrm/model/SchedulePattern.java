package com.vrm.model;

import com.vrm.systemexceptions.UnableToVinculateException;

public class SchedulePattern {
	private int originFloor;
	private int destinationFloor;
	private int hour;
	private User patternHolder;
	
	public SchedulePattern(int originFloor, int destinationFloor, int hour, User patternHolder) throws UnableToVinculateException {
		if(patternHolder != null) {
			this.originFloor=originFloor;
			this.destinationFloor=destinationFloor;
			this.hour=hour;	
			this.patternHolder=patternHolder;
		}
		else
			throw new UnableToVinculateException();
	}
	public int getOriginFloor() {
		return originFloor;
	}
	public int getDestinationFloor() {
		return destinationFloor;
	}
	public int getHour() {
		return hour;
	}
	public User getPatternHolder() {
		return patternHolder;
	}
	public boolean equals(SchedulePattern schedulePattern) {
		if(this.destinationFloor == schedulePattern.getDestinationFloor() && this.originFloor == schedulePattern.getOriginFloor()
				&& this.hour == schedulePattern.getHour() && this.patternHolder == schedulePattern.getPatternHolder())
			return true;
		else
			return false;
	}
}
