package com.splintart.nearsight.data.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.splintart.nearsight.NearSightException;
import com.splintart.nearsight.data.DBUtil;


/**
 * 
 * @author SplintArt
 * 10 lut 2017
 *
 * 
 * All rights reserved.
 * Contact: lukedrzyzga@gmail.com
 */
public abstract class AbstractDAO {
	
	protected String COLLECTION_NAME = "LOOOL";
/*	private DB nearDatabase; */
	
	private DBCollection collection;
	
/*	public MessageDAO(DB nearDatabase)
	{
		this.nearDatabase = nearDatabase;
	}*/
	
	public String getCollectionName() {
		return COLLECTION_NAME;
	}
	
	public DBCollection getCollection() throws NearSightException
	{
		if (collection == null)
		{
			collection = DBUtil.getCollection(getCollectionName());
		}
		
		return collection;
	}
	
	
	public <T> List<T> getAll(Class <T> clazz) throws NearSightException
	{
		List<T> objectList = new ArrayList<T>();
		MongoTemplate mongoTemplate;

		mongoTemplate = new MongoTemplate(DBUtil.getMongoDBFactory());
		
		
		DBCursor cursor = getCollection().find();
		
		while (cursor.hasNext())
		{
			DBObject dbObject = cursor.next();
			
			T object = mongoTemplate.getConverter().read(clazz, dbObject);
			
			objectList.add(object);
		}
		
		
		return objectList;
	}
	
	
	

}
