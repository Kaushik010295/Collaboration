package com.kaushik.dao;

import java.util.List;

import com.kaushik.model.User;

public interface UserDAO {
	public List<User> list();
	public User get(int id);
	public void saveOrUpdate(User user);
	public void delete (int d);
	public User getusername(String name);
	public boolean isvaliduser(String user, String pass,boolean isAdmin);

}
