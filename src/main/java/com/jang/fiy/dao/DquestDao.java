package com.jang.fiy.dao;

import java.util.List;

import com.jang.fiy.model.DETAL_QUEST;
import com.jang.fiy.model.Quest;
import com.jang.fiy.model.User;

public interface DquestDao {
	
	//리스트로 전체 불러오기
	List<DETAL_QUEST> getAll();
	
	//모델 DETAL_QUEST 참고하여 m_no로  정보 불러오기.
	DETAL_QUEST findinfo (int m_no);
	
	void dqinsert (DETAL_QUEST detal_quest);

}
