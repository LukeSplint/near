package com.splintart.nearsight.web.service;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.mongodb.DB;

public class Near {
	
	/*public List<Message> getMessages()
	{
		DB nearDatabase;
		
		try {
			nearDatabase = getDBUtil().getNearDatabase();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		

		MessageDAO messageDAO = new MessageDAO(nearDatabase);
		
		List<Message> messageList = messageDAO.getMessages();

		return messageList;
	}
	
	public String getMessagesAsJSON()
	{
		ObjectMapper mapper = new ObjectMapper();
		
		List<Message> messageList;
		
		String jsonString = "MESSAGE LIST ERROR";
		
		messageList = getMessages();
		
		try {
			jsonString = mapper.writeValueAsString(messageList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonString;
		
		
	}
*/
}
