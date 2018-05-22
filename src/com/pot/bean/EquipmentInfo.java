package com.pot.bean;

public class EquipmentInfo {
	private String temperature; //温度
	private String time; //时间
	private String user; //用户
	private String location; //位置
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public EquipmentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EquipmentInfo(String temperature, String time, String user, String location) {
		super();
		this.temperature = temperature;
		this.time = time;
		this.user = user;
		this.location = location;
	}
	@Override
	public String toString() {
		return "EquipmentInfo [temperature=" + temperature + ", time=" + time + ", user=" + user + ", location="
				+ location + "]";
	}
	

}
