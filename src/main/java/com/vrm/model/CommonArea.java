package com.vrm.model;

import java.util.ArrayList;

import com.vrm.CommonAreaTypes;

public class CommonArea extends CondominumDependency{
	private Enum<CommonAreaTypes> type;
	private ArrayList<Configuration> configurations;
	
	public CommonArea(Enum<CommonAreaTypes> type) {
		this.type=type;
		this.configurations = new ArrayList<Configuration>();
	}
	
	public Enum<CommonAreaTypes> getType() {
		return type;
	}

	public void setType(Enum<CommonAreaTypes> type) {
		this.type = type;
	}

	public ArrayList<Configuration> getConfigurations() {
		return configurations;
	}

	public void setConfigurations(ArrayList<Configuration> configurations) {
		this.configurations = configurations;
	}
}
