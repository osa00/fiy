package com.jang.fiy.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.jang.fiy.model.User;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate2;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcTemplate2 = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<User> getAll() {
		String SQL = "SELECT * FROM FIY_MEMBER order by M_NO asc";

		RowMapper mapper = new BeanPropertyRowMapper<User>(User.class);

		List<User> cList = (List) this.jdbcTemplate.query(SQL, mapper);
		// TODO Auto-generated method stub
		return cList;
	}

	@Override
	public User findUser(String m_email, String m_password) {
		// TODO Auto-generated method stub
		String GETUSER_IDPASS = "SELECT * FROM FIY_MEMBER WHERE m_email = ? AND m_password = ?";
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return jdbcTemplate.queryForObject(GETUSER_IDPASS, mapper, m_email,
				m_password);
	}

	@Override
	public User findUser(String m_email) {
		// TODO Auto-generated method stub
		String GETUSER_ID = "SELECT * FROM FIY_MEMBER WHERE m_email = ?";
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return jdbcTemplate.queryForObject(GETUSER_ID, mapper, m_email);
	}

	@Override
	public void pupdate(int m_no){
		String PUPDATE_SQL = "UPDATE FIY_MEMBER SET m_point = m_point + 1 where m_no = 101";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(m_no);
		System.out.println("PUPDATE_SQL = " + PUPDATE_SQL);
		this.jdbcTemplate2.update(PUPDATE_SQL, parameterSource);
	}
	
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		String SQL_INS = "INSERT INTO FIY_MEMBER (m_no, m_email, m_password, m_name, m_nic, m_regidate)"
				+ " VALUES(fiy_member_seq.nextval, :m_email, :m_password, :m_name, :m_nic, sysdate)";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
		jdbcTemplate2.update(SQL_INS, parameterSource);
	}
	
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

		String SQL_UP = "UPDATE FIY_MEMBER SET m_password = :m_password, m_nic = :m_nic"
				+ " WHERE m_email = :m_email";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				user);
		this.jdbcTemplate2.update(SQL_UP, parameterSource);

	}

	@Override
	public int checkemail(String m_email) {
		// TODO Auto-generated method stub
		String checkID = "select count(*) from FIY_MEMBER where m_email=?";
		int count = this.jdbcTemplate.queryForObject(checkID, new Object[] {m_email}, Integer.class );
		return count;
	}
	
	@Override
	public User findPass(String m_email, String m_name) {
		// TODO Auto-generated method stub
		String GETPASS = "select m_password, m_name, m_email from FIY_MEMBER where m_email=? and m_name=?";
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return jdbcTemplate.queryForObject(GETPASS, mapper, m_email, m_name);
	}
	
	@Override
	public void delete(User deleteUser){
		// TODO Auto-generated method stub\
		String DELET_SQL = ("delete from FIY_MEMBER where m_email = :m_email");
		//jdbcTemplate2�뒗 荑쇰━瑜� 媛앹껜�뿉 �떞�븘 �떎�뻾�빐�빞 �맂�떎.
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(deleteUser);
		jdbcTemplate2.update (DELET_SQL,parameterSource);
		//jdbcTemplate2濡� �뾽�뜲�씠�듃瑜� �븳�떎.(DELET_SQL�룎�젮 �굹�삩 寃곌낵媛믪쓣 parameterSource�뿉 �떞�븘 deleteUser濡� �꽆寃⑥��떎)
	}
}
