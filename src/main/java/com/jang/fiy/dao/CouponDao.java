package com.jang.fiy.dao;

import java.util.List;

import com.jang.fiy.model.User;
import com.jang.fiy.model.Quest;
import com.jang.fiy.model.Coupon;

public interface CouponDao {

	List<Coupon> getAll();
	
	Coupon findCoupon (int c_no);
	
//	void update(Quest quest);
//
//	void insert(Quest quest);
//
//	void delete(Quest deleteQuest);
}
