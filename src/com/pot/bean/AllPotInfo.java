package com.pot.bean;

public class AllPotInfo {
	private String record;
	private String other;
	private String defaults;
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getDefaults() {
		return defaults;
	}
	public void setDefaults(String defaults) {
		this.defaults = defaults;
	}
	public AllPotInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AllPotInfo(String record, String other, String defaults) {
		super();
		this.record = record;
		this.other = other;
		this.defaults = defaults;
	}
	
	
}
