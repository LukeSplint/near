/**
 * 
 */
package com.splintart.nearsight.service;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

/**
 * @author SplintArt
 * 10 lut 2017
 *
 * 
 * All rights reserved.
 * Contact: lukedrzyzga@gmail.com
 */

@Service
public class UtilService {

	public <T> String ObjectToJson(T object) {
		
		return ObjectToJson(object, null);
	}
	
	public <T> String ObjectToJson(T object, String defaultValue) {
		
		ObjectMapper mapper = new ObjectMapper();		
		String jsonString = defaultValue;
		
		try {
			jsonString = mapper.writeValueAsString(object);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return defaultValue;
		}
		
		return jsonString;
	}

}
