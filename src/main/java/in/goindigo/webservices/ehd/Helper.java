package in.goindigo.webservices.ehd;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Headers;
import org.apache.camel.language.XPath;
import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Helper {
	
	private static final Logger log = LoggerFactory.getLogger("AppLog");
	
	public Logger getLogger(String name) {

		return log;

	}
	
	
	/**
	 * 
	 */
	public Helper() 
	{
		MDC.put("bundle.name", "AppLog");
	}
	
	
}
