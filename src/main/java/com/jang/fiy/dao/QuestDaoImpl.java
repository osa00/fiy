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

public class QuestDaoImpl implements QuestDao {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate2;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcTemplate2 = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Quest> getAll() {
		String SQL = "SELECT * FROM FIY_QUEST order by Q_NO asc";

		RowMapper mapper = new BeanPropertyRowMapper<Quest>(Quest.class);

		List<Quest> cList = (List) this.jdbcTemplate.query(SQL, mapper);
		// TODO Auto-generated method stub
		return cList;
	}

	@Override
	public Quest questGet(int q_no) {
		// TODO Auto-generated method stub
		String SQL = "SELECT q_no, q_name, q_answer, q_hint1, q_hint2, q_hint3 FROM FIY_QUEST WHERE q_no = ?";
		RowMapper<Quest> mapper = new BeanPropertyRowMapper<Quest>(Quest.class);
		System.out.println("DAOIMPL안뇽 = " + q_no);
		return jdbcTemplate.queryForObject(SQL, mapper, q_no);
		

	}
	
	

}
