package com.jang.fiy.logic;

import java.util.List;

import com.jang.fiy.dao.QuestDao;
import com.jang.fiy.model.Quest;

public class QuestServiceImpl implements QuestService {
	
	private QuestDao questDao;
	
	public void setQuestDao(QuestDao questDaoImpl) {
		this.questDao = questDaoImpl;
	}

	@Override
	public List<Quest> getAll() {
		// TODO Auto-generated method stub
		return this.questDao.getAll();
	}

	@Override
	public Quest get(int q_no) {
		// TODO Auto-generated method stub
		System.out.println("Service안뇽 = " + q_no);
		return this.questDao.questGet(q_no);
	}
	
	

}
