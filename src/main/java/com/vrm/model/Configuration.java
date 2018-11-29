package com.vrm.model;

import java.util.ArrayList;

public class Configuration {
	private int startingHour;
	private int endingHour;
	private ArrayList<Integer> daysOfTheWeek;
	private Enum<Groups> group;
	private boolean active;
	
	public Configuration(int startingHour, int endingHour, ArrayList<Integer> days, Enum<Groups> group) {
		this.startingHour=startingHour;
		this.endingHour=endingHour;
		this.daysOfTheWeek = new ArrayList<Integer>();
		this.daysOfTheWeek.addAll(days);
		this.group=group;
	}

	public int getStartingHour() {
		return startingHour;
	}

	public void setStartingHour(int startingHour) {
		this.startingHour = startingHour;
	}

	public int getEndingHour() {
		return endingHour;
	}

	public void setEndingHour(int endingHour) {
		this.endingHour = endingHour;
	}

	public ArrayList<Integer> getDaysOfTheWeek() {
		return daysOfTheWeek;
	}

	public void setDaysOfTheWeek(ArrayList<Integer> daysOfTheWeek) {
		this.daysOfTheWeek = daysOfTheWeek;
	}

	public Enum<Groups> getGroup() {
		return group;
	}

	public void setGroup(Enum<Groups> group) {
		this.group = group;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
}
