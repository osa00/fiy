package com.jang.fiy.model;

import java.sql.Timestamp;

public class DETAL_QUEST {
	
	private int m_no;
	private int q_no;
	private Timestamp dq_answer_date;
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public int getQ_no() {
		return q_no;
	}
	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}
	public Timestamp getDq_answer_date() {
		return dq_answer_date;
	}
	public void setDq_answer_date(Timestamp dq_answer_date) {
		this.dq_answer_date = dq_answer_date;
	}
	
	

}
