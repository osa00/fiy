package com.jang.fiy.logic;

import java.util.List;

import com.jang.fiy.dao.UserDao;
import com.jang.fiy.model.User;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDaoImpl) {
		this.userDao = userDaoImpl;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return this.userDao.getAll();
	}

	@Override
	public User findUser(String m_email, String m_password) {
		// TODO Auto-generated method stub
		return this.userDao.findUser(m_email, m_password);
	}

	@Override
	public User findUser(String m_email) {
		// TODO Auto-generated method stub
		return this.userDao.findUser(m_email);
	}
	
	@Override
	public User getUserPass(String m_email, String m_name) {
		// TODO Auto-generated method stub
		return this.userDao.findPass(m_email, m_name);
	}
	
	@Override
	public User getUser(String m_email) {
		// TODO Auto-generated method stub
		return this.userDao.findUser(m_email);
	}
	
	@Override
	public void pupdate(int m_no){
		// TODO Auto-generated method stub
		this.userDao.pupdate(m_no);
		System.out.println("서비스컨트롤러 = " + m_no);
	}


	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.insert(user);

	}
	
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.update(user);

	}

	@Override
	public int checkemail(String m_email) {
		// TODO Auto-generated method stub
		return userDao.checkemail(m_email);
	}
	
	@Override
	public void delete(User deleteUser){
		// TODO Auto-generated method stub
		userDao.delete(deleteUser);
	}
	
}
