package com.nearsight;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {

	Near near = new Near();

	// Logger instance
	private static final Logger logger = Logger.getLogger(SimpleRestController.class);

	@RequestMapping(value = "/messages", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String getMessages() {

		return near.getMessagesAsJSON();

		// return "Tutaj będzie zwracana lista wiadomości ;)";
	}
	

	@RequestMapping(value = "/messages", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String getMessage(@RequestParam(value = "user") String user) {

		return "Tutaj będzie zwracana lista wiadomości użytkownika: " + user;
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
