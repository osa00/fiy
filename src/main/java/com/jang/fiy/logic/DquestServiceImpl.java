package com.jang.fiy.logic;

import java.util.List;

import com.jang.fiy.dao.DquestDao;
import com.jang.fiy.model.DETAL_QUEST;

public class DquestServiceImpl implements DquestService {
	
	private DquestDao dquestDao;
	
	public void setDquestDao(DquestDao dquestDaoImpl) {
		this.dquestDao = dquestDaoImpl;
	}

	@Override
	public List<DETAL_QUEST> getAll() {
		// TODO Auto-generated method stub
		return this.dquestDao.getAll();
	}

	@Override
	public DETAL_QUEST findinfo(int m_no) {
		// TODO Auto-generated method stub
		return this.dquestDao.findinfo(m_no);
	}

	@Override
	public void dqinsert(DETAL_QUEST detal_quest) {
		// TODO Auto-generated method stub
		this.dquestDao.dqinsert(detal_quest);

	}

}
