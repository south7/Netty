package com.syxt.vo;

public class StructAlgResW {

	private String ip;
	private Integer dspstate;
	private Float alarm_probability; 
	private Integer top;
	private Integer left;
	private Integer bottom;
	private Integer right;
	private Integer alarm_type;//0故障 1火灾
	private Integer is_alarm;//0未报警 1报警
	private Integer ch_num;
	private String alarm_date;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getDspstate() {
		return dspstate;
	}
	public void setDspstate(Integer dspstate) {
		this.dspstate = dspstate;
	}
	public Float getAlarm_probability() {
		return alarm_probability;
	}
	public void setAlarm_probability(Float alarm_probability) {
		this.alarm_probability = alarm_probability;
	}
	public Integer getTop() {
		return top;
	}
	public void setTop(Integer top) {
		this.top = top;
	}
	public Integer getLeft() {
		return left;
	}
	public void setLeft(Integer left) {
		this.left = left;
	}
	public Integer getBottom() {
		return bottom;
	}
	public void setBottom(Integer bottom) {
		this.bottom = bottom;
	}
	public Integer getRight() {
		return right;
	}
	public void setRight(Integer right) {
		this.right = right;
	}
	public Integer getAlarm_type() {
		return alarm_type;
	}
	public void setAlarm_type(Integer alarm_type) {
		this.alarm_type = alarm_type;
	}
	public Integer getIs_alarm() {
		return is_alarm;
	}
	public void setIs_alarm(Integer is_alarm) {
		this.is_alarm = is_alarm;
	}
	public Integer getCh_num() {
		return ch_num;
	}
	public void setCh_num(Integer ch_num) {
		this.ch_num = ch_num;
	}
	public String getAlarm_date() {
		return alarm_date;
	}
	public void setAlarm_date(String alarm_date) {
		this.alarm_date = alarm_date;
	}
	
}
