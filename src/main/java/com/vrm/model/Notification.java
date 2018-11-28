
package com.vrm.model;

public class Notification {
	private String description;
	private Object image;
	
	public Notification(String description, Object image) {
		this.description=description;
		this.image=image;
	}
	public String getDescription() {
		return this.description;
	}
	public Object getImage() {
		return this.image;
	}
}
