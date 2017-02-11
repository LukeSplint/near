package com.splintart.nearsight.data;

import java.net.UnknownHostException;

import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.MongoCredentialPropertyEditor;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.splintart.nearsight.NearSightException;

public class DBUtil {

	private static MongoClient mongoClient;
	private static DB nearDatabase;
	private static MongoDbFactory mongoDBFactory;

	private static final String connectionUrl = "ds060968.mlab.com";
	private static final int connectionPort = 60968;

	private static final String mongoUser = "nearApp";
	private static final String mongoPassword = "pass1234";

	private static final String nearDatabaseName = "near";

	public static MongoClient getMongoClient() throws UnknownHostException {
		if (DBUtil.mongoClient == null) {
			DBUtil.mongoClient = new MongoClient(connectionUrl, connectionPort);
		}

		return DBUtil.mongoClient;
	}

	public static DB getDatabase() throws UnknownHostException {
		boolean authenticationResult;

		if (DBUtil.nearDatabase == null) {
			DBUtil.nearDatabase = DBUtil.getMongoClient().getDB(nearDatabaseName);

			authenticationResult = DBUtil.nearDatabase.authenticate(mongoUser, mongoPassword.toCharArray());

			if (authenticationResult == false) {
				return null;
			}
		}

		return DBUtil.nearDatabase;
	}

	public static MongoDbFactory getMongoDBFactory() throws NearSightException {
		if (DBUtil.mongoDBFactory == null) {
			// MongoCredential mongoCredential =
			// MongoCredential.createCredential(mongoUser, nearDatabaseName,
			// mongoPassword.toCharArray());

			try {
				DBUtil.mongoDBFactory = new SimpleMongoDbFactory(DBUtil.getMongoClient(), nearDatabaseName);
			} catch (UnknownHostException e) {
				throw new NearSightException(e);
			}

			// DBUtil.mongoDBFactory = new SimpleMongoDbFactory(mongoClient,
			// nearDatabaseName);
		}

		return DBUtil.mongoDBFactory;
	}

	public static DBCollection getCollection(final String name) {

		DBCollection collection = null;

		try {
			collection = getDatabase().getCollection(name);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return collection;
	}

}
