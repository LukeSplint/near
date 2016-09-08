package com.nearsight.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.nearsight.DBUtil;
import com.nearsight.dto.Message;

public class MessageDAO {
	
	private static final String messageCollectionName = "Message";
	private DB nearDatabase;
	
	private DBCollection collection;
	
	public MessageDAO(DB nearDatabase)
	{
		this.nearDatabase = nearDatabase;
	}
	
	public DBCollection getCollection()
	{
		if (collection == null)
		{
			collection = nearDatabase.getCollection(messageCollectionName);
		}
		
		return collection;
	}
	
	public List<Message> getMessages()
	{
		List<Message> messageList = new ArrayList<Message>();
		MongoTemplate mongoTemplate = new MongoTemplate(DBUtil.getMongoDBFactory());
		
		DBCursor cursor = getCollection().find();
		
		while (cursor.hasNext())
		{
			DBObject dbObject = cursor.next();
			
			Message message = mongoTemplate.getConverter().read(Message.class, dbObject);
			
			messageList.add(message);
		}
		
		/*Set<String> tables = null;
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
		}*/

		
		return messageList;
	}
	

}
