package com.jang.fiy.logic;

import java.util.List;

import com.jang.fiy.model.Quest;
import com.jang.fiy.model.User;
import com.jang.fiy.model.Coupon;

public interface CouponService {
	
	List<Coupon> getAll();
	
	Coupon findCoupon (int c_no);
}
