package com.splintart.nearsight.data.dto;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * @author SplintArt
 * 10 lut 2017
 *
 * 
 * All rights reserved.
 * Contact: lukedrzyzga@gmail.com
 */
public class Message {
	
	private String user;
	private String content;
	private String type;
	private String latitude;
	private String longitude;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String toString()
	{
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonString = null;
		
		try {
			jsonString = mapper.writeValueAsString(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonString;
	}
	

}
