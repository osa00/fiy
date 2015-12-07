package com.jang.fiy.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.jang.fiy.model.DETAL_QUEST;
import com.jang.fiy.model.Quest;
import com.jang.fiy.model.User;

public class DquestDaoImpl implements DquestDao {
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate2;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcTemplate2 = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<DETAL_QUEST> getAll() {
		// TODO Auto-generated method stub
		String SQL = "SELECT * FROM FIY_DETAL_QUEST order by Q_NO asc";
		RowMapper mapper = new BeanPropertyRowMapper<DETAL_QUEST>(DETAL_QUEST.class);
		List<DETAL_QUEST> cList = (List) this.jdbcTemplate.query(SQL, mapper);
		return cList;
	}

	@Override
	public DETAL_QUEST findinfo(int m_no) {
		// TODO Auto-generated method stub
		String SQL = "SELECT q_no, m_no, dq_answer_date form FIY_DETAL_QUEST WHERE m_no = ?";
		RowMapper<DETAL_QUEST> mapper = new BeanPropertyRowMapper<DETAL_QUEST>(DETAL_QUEST.class);
		return jdbcTemplate.queryForObject(SQL, mapper, m_no);
	}
	
	@Override
	public void dqinsert(DETAL_QUEST detal_quest) {
		// TODO Auto-generated method stub
		String SQL_INS = "INSERT INTO FIY_DETAL_QUEST(q_no, m_no, dq_answer_date)"
				+ "VALUES(:q_no, :m_no, sysdate)";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(detal_quest);
		jdbcTemplate2.update(SQL_INS, parameterSource);
	}
}