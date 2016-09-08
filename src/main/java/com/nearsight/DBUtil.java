package com.nearsight;

import java.net.UnknownHostException;

import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class DBUtil {
	
	private static MongoClient mongoClient;
	private static DB nearDatabase;
	private static MongoDbFactory mongoDBFactory;
	
	private static final String connectionUrl = "ds060968.mlab.com";
	private static final int connectionPort = 60968;
	
	private static final String mongoUser = "nearApp";
	private static final String mongoPassword = "pass1234";
	
	private static final String nearDatabaseName = "near";
	
	public static MongoClient getMongoClient() throws UnknownHostException
	{
		if (DBUtil.mongoClient == null)
		{
			DBUtil.mongoClient = new MongoClient(connectionUrl, connectionPort);
		}
	
		return DBUtil.mongoClient;	
	}
	
	public static DB getNearDatabase() throws UnknownHostException
	{
		boolean authenticationResult;
		
		if (DBUtil.nearDatabase == null)
		{
			DBUtil.nearDatabase = DBUtil.getMongoClient().getDB(nearDatabaseName);
			
			authenticationResult = DBUtil.nearDatabase.authenticate(mongoUser, mongoPassword.toCharArray());
			
			if (authenticationResult == false)
			{
				return null;
			}
		}
		
		return DBUtil.nearDatabase;
	}
	
	public static MongoDbFactory getMongoDBFactory()
	{
		if (DBUtil.mongoDBFactory == null)
		{
			DBUtil.mongoDBFactory = new SimpleMongoDbFactory(mongoClient, nearDatabaseName, new UserCredentials(mongoUser, mongoPassword));
			//DBUtil.mongoDBFactory = new SimpleMongoDbFactory(mongoClient, nearDatabaseName);
		}
		
		return DBUtil.mongoDBFactory;
	}

}
