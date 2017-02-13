/**
 * 
 */
package com.splintart.nearsight.web.rest;

import java.util.Date;

/**
 * @author SplintArt
 * 11 lut 2017
 *
 *
 * All rights reserved.
 * Contact: lukedrzyzga@gmail.com
 */

public class Response <T> {
	
	private String message;
	private String realizationDate;
	private T content;
	
	public Response(T content) {
		this.content = content;
		this.realizationDate = new Date().toString();
	}
	
	public Response(String message) {
		this.message = message;
		this.realizationDate = new Date().toString();
	}
	
	public Response(T content, String message) {
		this.content = content;
		this.message = message;
		this.realizationDate = new Date().toString();
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRealizationDate() {
		return realizationDate;
	}
	public void setRealizationDate(Date realizationDate) {
		this.realizationDate = realizationDate.toString();;
	}
	public T getContent() {
		return content;
	}
	public void setContent(T content) {
		this.content = content;
	}

	
}
