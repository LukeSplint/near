/**
 * 
 */
package com.splintart.nearsight;

import org.springframework.http.HttpStatus;

/**
 * @author SplintArt 11 lut 2017
 *
 *
 *         All rights reserved. Contact: lukedrzyzga@gmail.com
 */

public class NearSightException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9189156373062333337L;

	private HttpStatus httpStatus;

	public NearSightException(String message) {
		super(message);
	}
	
	public NearSightException(Throwable cause) {
		super(cause);
	}
	
	public NearSightException(String message, Throwable cause) {
		super(message, cause);
	}


	public NearSightException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public NearSightException(HttpStatus httpStatus, Throwable cause) {
		super(cause);
		this.httpStatus = httpStatus;
	}

	public NearSightException(HttpStatus httpStatus, String message, Throwable cause) {
		super(message, cause);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
