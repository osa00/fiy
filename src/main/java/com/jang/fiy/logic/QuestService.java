package com.jang.fiy.logic;

import java.util.List;

import com.jang.fiy.model.Quest;
import com.jang.fiy.model.User;

public interface QuestService {
	
	List<Quest> getAll();
	
	Quest get(int q_no);
}
