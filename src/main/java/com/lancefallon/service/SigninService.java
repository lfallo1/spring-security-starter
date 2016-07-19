package com.lancefallon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lancefallon.dao.UserDao;
import com.lancefallon.model.User;

@Service
public class SigninService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncryptionService passwordEncryptionService;
	
	public void signup(User user) throws Exception{
		this.userDao.addUser(user);
	}
	
	public User signin(String username, String password) throws Exception{
		User user = this.userDao.findByUsername(username);
		if(!this.passwordEncryptionService.checkpw(password, user.getPassword())){
			throw new Exception();
		}
		return user;
	}
}
