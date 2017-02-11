/**
 * 
 */
package com.splintart.nearsight.web.rest.util;

import org.springframework.http.HttpStatus;

/**
 * @author SplintArt
 * 11 lut 2017
 *
 *
 * All rights reserved.
 * Contact: lukedrzyzga@gmail.com
 */

public class ErrorCode {
	
	private HttpStatus httpStatus = HttpStatus.ACCEPTED;
	private String message;
	
	public ErrorCode(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}
	
	
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}



	public String getMessage() {
		return message;
	}


	//400 - client errors
	public static final ErrorCode BAD_REQUEST = new ErrorCode(HttpStatus.BAD_REQUEST, "Bad request.");
	
	//500
	public static final ErrorCode INTERNAL_ERROR = new ErrorCode(HttpStatus.INTERNAL_SERVER_ERROR, "General error.");
	

}
