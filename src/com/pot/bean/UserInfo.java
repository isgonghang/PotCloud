package com.pot.bean;

public class UserInfo {
    private String UserName;//用户名
    private String UserPassword;//用户密码
    private String UserEmailAddress;//用户电子邮件
    private String UserPhoenNumber;//用户手机号
    private String DeviceId;//设备序列号
    private String LoginState;//登录状态
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public String getUserEmailAddress() {
		return UserEmailAddress;
	}
	public void setUserEmailAddress(String userEmailAddress) {
		UserEmailAddress = userEmailAddress;
	}
	public String getUserPhoenNumber() {
		return UserPhoenNumber;
	}
	public void setUserPhoenNumber(String userPhoenNumber) {
		UserPhoenNumber = userPhoenNumber;
	}
	public String getDeviceId() {
		return DeviceId;
	}
	public void setDeviceId(String deviceId) {
		DeviceId = deviceId;
	}
	public String getLoginState() {
		return LoginState;
	}
	public void setLoginState(String loginState) {
		LoginState = loginState;
	}
	@Override
	public String toString() {
		return "UserInfo [UserName=" + UserName + ", UserPassword=" + UserPassword + ", UserEmailAddress="
				+ UserEmailAddress + ", UserPhoenNumber=" + UserPhoenNumber + ", DeviceId=" + DeviceId + ", LoginState="
				+ LoginState + "]";
	}
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfo(String userName, String userPassword, String userEmailAddress, String userPhoenNumber,
			String deviceId, String loginState) {
		super();
		UserName = userName;
		UserPassword = userPassword;
		UserEmailAddress = userEmailAddress;
		UserPhoenNumber = userPhoenNumber;
		DeviceId = deviceId;
		LoginState = loginState;
	}
}
