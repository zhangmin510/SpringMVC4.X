package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.User;


public interface UserService {

	public int insertUser(User user);
	
	public User getUserById(int id);
	
	public List<User> getAllUser();
}
