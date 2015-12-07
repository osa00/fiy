package com.jang.fiy.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.jang.fiy.model.Quest;
import com.jang.fiy.model.User;
import com.jang.fiy.model.Coupon;

public class CouponDaoImpl implements CouponDao {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate2;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcTemplate2 = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Coupon> getAll() {
		String SQL = "SELECT * FROM FIY_COUPON order by Q_NO asc";

		RowMapper mapper = new BeanPropertyRowMapper<Coupon>(Coupon.class);

		List<Coupon> cList = (List) this.jdbcTemplate.query(SQL, mapper);
		// TODO Auto-generated method stub
		return cList;
	}

	@Override
	public Coupon findCoupon(int c_no) {
		// TODO Auto-generated method stub
		String GETCOUPON_NO = "SELECT * FROM FIY_COUPON WHERE c_no = ?";
		RowMapper<Coupon> mapper = new BeanPropertyRowMapper<Coupon>(Coupon.class);
		return jdbcTemplate.queryForObject(GETCOUPON_NO, mapper, c_no);
	}

}
