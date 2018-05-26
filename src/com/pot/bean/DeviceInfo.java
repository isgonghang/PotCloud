package com.pot.bean;

import java.util.Arrays;

public class DeviceInfo {
    private String DeviceId;
    //设备状态
    private static final int Status_working = 0;//工作中
    private static final int Status_disconnect = 1;//未连接
    private static final int Status_connect = 2;//已连接
    private static final int Status_wraning = 3;//设备异常
    private static final int Status_waiting = 4;//待机中
    private String deviceName;
    private String deviceState;
    private String deviceMac;
    private int[] Location;//设备定位
	public String getDeviceId() {
		return DeviceId;
	}
	public void setDeviceId(String deviceId) {
		DeviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceState() {
		return deviceState;
	}
	public void setDeviceState(String deviceState) {
		this.deviceState = deviceState;
	}
	public String getDeviceMac() {
		return deviceMac;
	}
	public void setDeviceMac(String deviceMac) {
		this.deviceMac = deviceMac;
	}
	public int[] getLocation() {
		return Location;
	}
	public void setLocation(int[] location) {
		Location = location;
	}
	public static int getStatusWorking() {
		return Status_working;
	}
	public static int getStatusDisconnect() {
		return Status_disconnect;
	}
	public static int getStatusConnect() {
		return Status_connect;
	}
	public static int getStatusWraning() {
		return Status_wraning;
	}
	public static int getStatusWaiting() {
		return Status_waiting;
	}
	@Override
	public String toString() {
		return "DeviceInfo [DeviceId=" + DeviceId + ", deviceName=" + deviceName + ", deviceState=" + deviceState
				+ ", deviceMac=" + deviceMac + ", Location=" + Arrays.toString(Location) + "]";
	}
	public DeviceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeviceInfo(String deviceId, String deviceName, String deviceState, String deviceMac, int[] location) {
		super();
		DeviceId = deviceId;
		this.deviceName = deviceName;
		this.deviceState = deviceState;
		this.deviceMac = deviceMac;
		Location = location;
	}
	
}
