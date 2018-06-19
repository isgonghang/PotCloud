package com.pot.bean;

public class PotInfo {
	private String time;
	private String weight;
	private String pre;
	private String temp;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getPre() {
		return pre;
	}
	public void setPre(String pre) {
		this.pre = pre;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public PotInfo(String time, String weight, String pre, String temp) {
		super();
		this.time = time;
		this.weight = weight;
		this.pre = pre;
		this.temp = temp;
	}
	public PotInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
