package com.syxt.vo;

public class Device {

	private String clientIP;
	private String devName;
	private int is_onLine;
	private String stateChange_date;
	
	public String getClientIP() {
		return clientIP;
	}
	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public int getIs_onLine() {
		return is_onLine;
	}
	public void setIs_onLine(int is_onLine) {
		this.is_onLine = is_onLine;
	}
	public String getStateChange_date() {
		return stateChange_date;
	}
	public void setStateChange_date(String stateChange_date) {
		this.stateChange_date = stateChange_date;
	}
}
