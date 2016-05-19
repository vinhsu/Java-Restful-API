package com.control2me.japi;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.control2me.japi.services.v1.User;

public class BusinessManager {
	private static BusinessManager INSTANCE = new BusinessManager();
	private static final Logger log = Logger.getLogger(BusinessManager.class.getName());
	
	private BusinessManager() {}
	
	public static BusinessManager getInstance(){
		return INSTANCE;
	}
	
	public User findUser(String userId) throws Exception {
		log.info("BusinessManager::findUser started");
		
		User user = new User();
		user.setId("54321");
		user.setName("vincent");
		return user;
	}

	public List<User> findUsers() throws Exception {
		List<User> users = new ArrayList<User>();
		User user1 = new User();
		user1.setId("54321");
		user1.setName("vincent");
		users.add(user1);
		
		User user2 = new User();
		user2.setId("78965");
		user2.setName("brandon");
		users.add(user2);
		return users;
	}

	public User addUser(User user) {
		//user.setId("112233");
		//return user;
		User newUser =  DataManager.getInstance().insertUser(user);
		return newUser;
	}

	public User updateUserAttribute(String userId, String attribute, String name) {
		User user = new User();
		user.setId(userId);
		if (attribute.equals("name"))
			user.setName(name);
		return user;
	}

	public void deleteUser(String userId) {
		return;
	}
}
