package com.control2me.japi;

import org.apache.log4j.Logger;

import com.control2me.japi.services.v1.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class DataManager {
	private static final Logger log = Logger.getLogger(DataManager.class.getName());
	
	private static DB japiDB;
	private static DBCollection userCollection;
	
	private static DataManager INSTANCE;
	
	public static DataManager getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new DataManager();
		}

		return INSTANCE;
	}
	
	private DataManager() {
		try {
			MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017));
			japiDB = mongoClient.getDB("japi");
			userCollection = japiDB.getCollection("users");
			
		} catch (Exception e) {
			log.error("db connection error e=", e);
		}
		
	}
	
	// Insert User into database
	public User insertUser(User user) {
		BasicDBObject doc = new BasicDBObject();
		doc.put("name", user.getName());
		
		userCollection.insert(doc);
		user.setId(doc.get("_id").toString());
		return user;
	}
}
