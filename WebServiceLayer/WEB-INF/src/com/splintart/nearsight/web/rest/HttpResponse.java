/**
 * 
 */
package com.splintart.nearsight.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.splintart.nearsight.web.rest.util.ErrorCode;

/**
 * @author SplintArt
 * 11 lut 2017
 *
 *
 * All rights reserved.
 * Contact: lukedrzyzga@gmail.com
 */

public class HttpResponse<T> extends ResponseEntity<Response<T>> {
	
	Response<T> response;
	
	public HttpResponse(Throwable e) {
		
		super(new Response<T>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	public HttpResponse(Throwable e, HttpStatus httpStatus) {
		super(new Response<T>(e.getMessage()), httpStatus);		
	}
	
	public HttpResponse(ErrorCode errorCode) {
		super(new Response<T>(errorCode.getMessage()), errorCode.getHttpStatus());		
	}
	
	public HttpResponse(String message) {
		super(new Response<T>(message), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public HttpResponse(T content) {
		super(new Response<T>(content), HttpStatus.OK);
	}
	
	public HttpResponse(T content, String message) {
		super(new Response<T>(content, message), HttpStatus.OK);
	}
	
	public HttpResponse(String message, HttpStatus httpStatus) {
		super(new Response<T>(message), httpStatus);
	}
	
	public HttpResponse(T content, HttpStatus httpStatus) {
		super(new Response<T>(content), httpStatus);
	}
	
	public HttpResponse(T content, String message, HttpStatus httpStatus) {
		super(new Response<T>(content, message), httpStatus);
	}

}
