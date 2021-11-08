package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {

	void registerdata(User u);

	List<User> fetchdata(String username, String passord);

	User editdata(int userid);

	List<User> updatedata(User u);

	void deletedata(int userid);

	void harddeletedata(int userid);

	List<User> getDob();

	List<User> getJoiningDate();

}
