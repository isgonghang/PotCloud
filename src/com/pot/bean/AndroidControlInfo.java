package com.pot.bean;

public class AndroidControlInfo {
	private int temperature;
	private int pressure;
	private long time;
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "AndroidControlInfo [temperature=" + temperature + ", pressure=" + pressure + ", time=" + time + "]";
	}
	public AndroidControlInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AndroidControlInfo(int temperature, int pressure, long time) {
		super();
		this.temperature = temperature;
		this.pressure = pressure;
		this.time = time;
	}
	
}
