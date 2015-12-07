package com.jang.fiy.model;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;

//@NotEmpty
public class User {

	private int m_no;
	private String m_email;
	private String m_password;
	private String m_password2;
	private String m_name;
	private String m_point;
	private String m_nic;
	private Timestamp m_regidate;
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getM_password2() {
		return m_password2;
	}
	public void setM_password2(String m_password2) {
		this.m_password2 = m_password2;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_point() {
		return m_point;
	}
	public void setM_point(String m_point) {
		this.m_point = m_point;
	}
	public String getM_nic() {
		return m_nic;
	}
	public void setM_nic(String m_nic) {
		this.m_nic = m_nic;
	}
	public Timestamp getM_regidate() {
		return m_regidate;
	}
	public void setM_regidate(Timestamp m_regidate) {
		this.m_regidate = m_regidate;
	}
	
	
	
}
