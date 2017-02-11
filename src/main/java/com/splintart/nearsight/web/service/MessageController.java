package com.splintart.nearsight.web.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.splintart.nearsight.service.MessageService;
import com.splintart.nearsight.service.UtilService;

@RestController
public class MessageController {

//	Near near = new Near();
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	UtilService utilService;

	// Logger instance
	private static final Logger logger = Logger.getLogger(MessageController.class);

	@RequestMapping(value = "/messages", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String getMessages() {
		
		return utilService.ObjectToJson(messageService.getAllMessages());
		//return near.getMessagesAsJSON();
	}
	

	@RequestMapping(value = "users/{username}/messages", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String getUserMessages(@PathVariable("username") String username) {

		return "Tutaj będzie zwracana lista wiadomości użytkownika: " + username;
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
	 * @RequestMapping(value = "/<add method name here>", method =
	 * RequestMethod.PUT) public String putSomething(@RequestBody String
	 * request,@RequestParam(value = "version", required = false, defaultValue =
	 * "1") int version) {
	 * 
	 * if (logger.isDebugEnabled()) { logger.debug("Start putSomething");
	 * logger.debug("data: '" + request + "'"); }
	 * 
	 * String response = null;
	 * 
	 * try { switch (version) { case 1: if (logger.isDebugEnabled())
	 * logger.debug("in version 1"); // TODO: add your business logic here
	 * response = "Response from Spring RESTful Webservice : "+ request;
	 * 
	 * break; default: throw new Exception("Unsupported version: " + version); }
	 * } catch (Exception e) { response = e.getMessage().toString(); }
	 * 
	 * if (logger.isDebugEnabled()) { logger.debug("result: '" + response +
	 * "'"); logger.debug("End putSomething"); } return response; }
	 * 
	 * @RequestMapping(value = "/<add method name here>", method =
	 * RequestMethod.DELETE) public void deleteSomething(@RequestBody String
	 * request,@RequestParam(value = "version", required = false, defaultValue =
	 * "1") int version) {
	 * 
	 * if (logger.isDebugEnabled()) { logger.debug("Start putSomething");
	 * logger.debug("data: '" + request + "'"); }
	 * 
	 * String response = null;
	 * 
	 * try { switch (version) { case 1: if (logger.isDebugEnabled())
	 * logger.debug("in version 1"); // TODO: add your business logic here
	 * 
	 * break; default: throw new Exception("Unsupported version: " + version); }
	 * } catch (Exception e) { logger.info(e.getMessage()); }
	 * 
	 * if (logger.isDebugEnabled()) { logger.debug("result: '" + response +
	 * "'"); logger.debug("End putSomething"); } }
	 */
}
