/**
 * 
 */
package com.splintart.nearsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splintart.nearsight.NearSightException;
import com.splintart.nearsight.data.dao.MessageDAO;
import com.splintart.nearsight.data.dto.Message;


/**
 * @author SplintArt
 * 10 lut 2017
 *
 * 
 * All rights reserved.
 * Contact: lukedrzyzga@gmail.com
 */

@Service
public class MessageService {
	
	@Autowired
	MessageDAO messageDAO; 
	
	public List<Message> getAll() throws NearSightException
	{
		List<Message> messageList = messageDAO.getAll();

		return messageList;
	}

	public void add(Message message) throws NearSightException {
		messageDAO.add(message);
	}
	
	//TODO own List interface or class extends List, ktory mialby dodatkowo medote AsJsonString
}
