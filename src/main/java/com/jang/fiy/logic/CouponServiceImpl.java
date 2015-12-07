package com.jang.fiy.logic;

import java.util.List;

import com.jang.fiy.dao.CouponDao;
import com.jang.fiy.dao.QuestDao;
import com.jang.fiy.dao.UserDao;
import com.jang.fiy.model.Coupon;
import com.jang.fiy.model.Quest;

public class CouponServiceImpl implements CouponService {
	
	private CouponDao couponDao;
	
	public void setCouponDao(CouponDao couponDaoImpl) {
		this.couponDao = couponDaoImpl;
	}

	@Override
	public List<Coupon> getAll() {
		// TODO Auto-generated method stub
		return this.couponDao.getAll();
	}

	@Override
	public Coupon findCoupon (int c_no) {
		// TODO Auto-generated method stub
		return this.couponDao.findCoupon(c_no);
	}

}
