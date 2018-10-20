package com.userfront.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userfront.dao.UserDao;
import com.userfront.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findByUsername(String username) {

		return userDao.findByUsername(username);
	}

	@Override
	public boolean findByExists(String username, String email) {
		if (checkUsernameExists(username) && checkEmailExists(email)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean checkUsernameExists(String username) {
		System.out.println("user name check" + userDao.findByUsername(username));
		if (null != userDao.findByUsername(username)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean checkEmailExists(String email) {
		System.out.println("email check");
		if (null != userDao.findByEmail(email)) {
			return true;
		}

		return false;
	}

	@Override
	public void save(User user) {
		userDao.save(user);

	}

	@Override
	public User findByEmail(String email) {

		return userDao.findByEmail(email);
	}

}
