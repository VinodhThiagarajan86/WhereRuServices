package com.hack.whereru.collections;

import org.springframework.data.annotation.Id;

public class CurrentLocation {

	@Id
	private String id;

	private double[] position;
	
	private String uID;
	
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String timeStamp;

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public CurrentLocation() {
	}

	public CurrentLocation(String uID , String userName , double x, double y ,String timeStamp) {
		this.id = id;
		this.uID = uID;
		this.userName = userName;
		this.position = new double[] { x, y };
		this.timeStamp = timeStamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double[] getPosition() {
		return position;
	}

	public void setPosition(double[] position) {
		this.position = position;
	}

	public String getuID() {
		return uID;
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

}
