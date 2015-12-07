package com.jang.fiy.dao;

import java.util.List;

import com.jang.fiy.model.User;
import com.jang.fiy.model.Quest;

public interface QuestDao {

	List<Quest> getAll();
	
	Quest questGet (int q_no);
	
//	void update(Quest quest);
//
//	void insert(Quest quest);
//
//	void delete(Quest deleteQuest);
}
