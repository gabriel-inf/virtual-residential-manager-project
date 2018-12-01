package com.vrm.model;

import com.vrm.data.Database;

public class AlarmSystem {
	private boolean active;
	
	public AlarmSystem() {
		this.active = false;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void activateAlarms() throws Exception {
		Database.getInstance().log("Alarm activated!");
		this.active = true;
	}
	public void deactivateAlarms() throws Exception {
		Database.getInstance().log("Alarm deactivated!");
		this.active = false;
	}
}
