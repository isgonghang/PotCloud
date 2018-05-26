package com.pot.bean;

public class HeatingArgs {

	private long time;
    private int pre;
    private int temp;
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public int getPre() {
		return pre;
	}
	public void setPre(int pre) {
		this.pre = pre;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	@Override
	public String toString() {
		return "HeatingArgs [time=" + time + ", pre=" + pre + ", temp=" + temp + "]";
	}
	public HeatingArgs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HeatingArgs(long time, int pre, int temp) {
		super();
		this.time = time;
		this.pre = pre;
		this.temp = temp;
	}
}
