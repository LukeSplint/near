package com.splintart.nearsight.web.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.splintart.nearsight.NearSightException;
import com.splintart.nearsight.data.dto.Message;
import com.splintart.nearsight.service.MessageService;
import com.splintart.nearsight.service.UtilService;
import com.splintart.nearsight.web.rest.util.ErrorCode;

import static com.splintart.nearsight.web.rest.util.ControllerUtil.PRODUCES_JSON_UTF_8;
import static com.splintart.nearsight.web.rest.util.ControllerUtil.PRODUCES_TEXT_UTF_8;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author SplintArt 11 lut 2017
 *
 * 
 *         All rights reserved. Contact: lukedrzyzga@gmail.com
 */

@RestController
public class MessageController {

	@Autowired
	MessageService messageService;

	@Autowired
	UtilService utilService;

	// Logger instance
	private static final Logger logger = Logger.getLogger(MessageController.class);

	@ExceptionHandler({ NearSightException.class, Exception.class })
	public @ResponseBody HttpResponse<?> handleNearSightException(HttpServletRequest request, Exception ex) {
		return new HttpResponse<>(ex);
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = PRODUCES_TEXT_UTF_8)
	public String test() {

		return "OK";
		// return near.getMessagesAsJSON();
	}

	@RequestMapping(value = "/testResponse", method = RequestMethod.GET, produces = PRODUCES_JSON_UTF_8)
	public ResponseEntity<Message> testResponse() {

		Message message = new Message();
		message.setUser("Lukasz");
		message.setContent("tresc wiadomosci");
		return new ResponseEntity<>(message, HttpStatus.OK);
		// return near.getMessagesAsJSON();
	}

	// GET methods
	/**
	 * 
	 * @return all of messages
	 */
	@RequestMapping(value = "/messages", method = RequestMethod.GET, produces = PRODUCES_JSON_UTF_8)
	public HttpResponse<List<Message>> getAllMessages() {

		try {
			return new HttpResponse<List<Message>>(messageService.getAll());
		} catch (NearSightException e) {
			return new HttpResponse<>(e);
		}

		// return utilService.ObjectToJson(messageService.getAllMessages());
		// return near.getMessagesAsJSON();
	}

	@RequestMapping(value = "users/{username}/messages", method = RequestMethod.GET, produces = PRODUCES_TEXT_UTF_8)
	public String getUserMessages(@PathVariable("username") String username) {

		return "Tutaj bedzie zwracana lista wiadomosci uzytkownika: " + username;
	}

	// POST methods
	@RequestMapping(value = "/messages", method = RequestMethod.POST, produces = PRODUCES_JSON_UTF_8)
	public HttpResponse<?> addMessage(@RequestBody Message message) {

		if (message == null) {
			return new HttpResponse<>(ErrorCode.BAD_REQUEST);
		}
		
		try {
			messageService.add(message);
			return new HttpResponse<>(HttpStatus.OK);
		} catch (NearSightException e) {
			return new HttpResponse<>(e);
		}
		// return utilService.ObjectToJson(messageService.getAllMessages());

		// return near.getMessagesAsJSON();
	}

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String getMessage(@RequestParam(value = "request") String request,
			@RequestParam(value = "version", required = false, defaultValue = "1") int version) {

		if (logger.isDebugEnabled()) {
			logger.debug("Start getSomething");
			logger.debug("data: '" + request + "'");
		}

		String response = null;

		try {
			switch (version) {
			case 1:
				if (logger.isDebugEnabled())
					logger.debug("in version 1");
				// TODO: add your business logic here
				response = "Response from Spring RESTful Webservice : " + request;

				break;
			default:
				throw new Exception("Unsupported version: " + version);
			}
		} catch (Exception e) {
			response = e.getMessage().toString();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("result: '" + response + "'");
			logger.debug("End getSomething");
		}
		return response;
	}

	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public String postSomething(@RequestParam(value = "request") String request,
			@RequestParam(value = "version", required = false, defaultValue = "1") int version) {

		if (logger.isDebugEnabled()) {
			logger.debug("Start postSomething");
			logger.debug("data: '" + request + "'");
		}

		String response = null;

		try {
			switch (version) {
			case 1:
				if (logger.isDebugEnabled())
					logger.debug("in version 1");
				// TODO: add your business logic here
				response = "Response from Spring RESTful Webservice : " + request;

				break;
			default:
				throw new Exception("Unsupported version: " + version);
			}
		} catch (Exception e) {
			response = e.getMessage().toString();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("result: '" + response + "'");
			logger.debug("End postSomething");
		}
		return response;
	}
/*
	@RequestMapping(value = "/<add method name here>", method = RequestMethod.PUT)
	public String putSomething(@RequestBody String request,
			@RequestParam(value = "version", required = false, defaultValue = "1") int version) {

		if (logger.isDebugEnabled()) {
			logger.debug("Start putSomething");
			logger.debug("data: '" + request + "'");
		}

		String response = null;

		try {
			switch (version) {
			case 1:
				if (logger.isDebugEnabled())
					logger.debug("in version 1"); // TODO: add your business
													// logic here
				response = "Response from Spring RESTful Webservice : " + request;

				break;
			default:
				throw new Exception("Unsupported version: " + version);
			}
		} catch (Exception e) {
			response = e.getMessage().toString();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("result: '" + response + "'");
			logger.debug("End putSomething");
		}
		return response;
	}

	@RequestMapping(value = "/<add method name here>", method = RequestMethod.DELETE)
	public void deleteSomething(@RequestBody String request,
			@RequestParam(value = "version", required = false, defaultValue = "1") int version) {

		if (logger.isDebugEnabled()) {
			logger.debug("Start putSomething");
			logger.debug("data: '" + request + "'");
		}

		String response = null;

		try {
			switch (version) {
			case 1:
				if (logger.isDebugEnabled())
					logger.debug("in version 1"); // TODO: add your business
													// logic here

				break;
			default:
				throw new Exception("Unsupported version: " + version);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		if (logger.isDebugEnabled()) {
			logger.debug("result: '" + response + "'");
			logger.debug("End putSomething");
		}
	}
*/
}
