package com.jang.fiy.logic;

import java.util.List;

import com.jang.fiy.model.User;

public interface UserService {
	List<User> getAll();

	User findUser(String m_email, String m_password);

	User findUser(String m_email);
	
	User getUserPass(String m_email, String m_name);
	
	User getUser(String m_email);
	
	void pupdate(int m_no);
	
	void insertUser(User user);
	
	void delete(User deleteUser);
	
	void updateUser(User user);
	
	int checkemail(String m_email);

}
