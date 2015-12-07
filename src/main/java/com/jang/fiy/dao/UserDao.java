package com.jang.fiy.dao;

import java.util.List;

import com.jang.fiy.model.User;

public interface UserDao {

	List<User> getAll();
	
	User findUser(String m_email, String m_password);

	User findUser(String m_email);

//	User findId(String name, String email);// �������� �ȵ�
//
	User findPass(String m_email, String m_name);

	void pupdate(int m_no);
	
	void update(User user);

	void insert(User user);

	void delete(User deleteUser);


	int checkemail(String m_email);

	

}
