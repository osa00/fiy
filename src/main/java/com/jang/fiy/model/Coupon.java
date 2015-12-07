package com.jang.fiy.model;

import java.sql.Timestamp;

public class Coupon {
	
	private int c_no;
	private String c_name;
	private Timestamp c_startdate;
	private Timestamp c_enddate;
	private String c_dis;
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public Timestamp getC_startdate() {
		return c_startdate;
	}
	public void setC_startdate(Timestamp c_startdate) {
		this.c_startdate = c_startdate;
	}
	public Timestamp getC_enddate() {
		return c_enddate;
	}
	public void setC_enddate(Timestamp c_enddate) {
		this.c_enddate = c_enddate;
	}
	public String getC_dis() {
		return c_dis;
	}
	public void setC_dis(String c_dis) {
		this.c_dis = c_dis;
	}
	
	

}
