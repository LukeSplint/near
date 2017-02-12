package com.splintart.nearsight.data.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.splintart.nearsight.NearSightException;
import com.splintart.nearsight.data.DBUtil;
import com.splintart.nearsight.data.dto.Message;

/**
 * 
 * @author SplintArt
 * 10 lut 2017
 *
 * 
 * All rights reserved.
 * Contact: lukedrzyzga@gmail.com
 */

@Component
public class MessageDAO extends AbstractDAO {
	
/*	private DB nearDatabase;
	
	private DBCollection collection;*/
	
/*	public MessageDAO(DB nearDatabase)
	{
		this.nearDatabase = nearDatabase;
	}*/
	
	public MessageDAO() {
		COLLECTION_NAME = "Message";
	}
	
	
	public List<Message> getAll() throws NearSightException
	{
		
		return getAll(Message.class);
		/*List<Message> messageList = new ArrayList<Message>();
		MongoTemplate mongoTemplate = new MongoTemplate(DBUtil.getMongoDBFactory());
		
		DBCursor cursor = getCollection().find();
		
		while (cursor.hasNext())
		{
			DBObject dbObject = cursor.next();
			
			Message message = mongoTemplate.getConverter().read(Message.class, dbObject);
			
			messageList.add(message);
		}
		
		Set<String> tables = null;
		try {
			tables = DBUtil.getNearDatabase().getCollectionNames();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(String coll : tables){
			System.out.println(coll);
			
			Message message = new Message();
			message.setContent(coll);
			messageList.add(message);
		}

		
		return messageList;*/
	}
	
	public void add(Message message) throws NearSightException {
		
		MongoTemplate mongoTemplate = new MongoTemplate(DBUtil.getMongoDBFactory());
		
		mongoTemplate.insert(message, COLLECTION_NAME);		
	}
	

}
