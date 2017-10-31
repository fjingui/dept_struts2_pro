package com.sqlconn.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class LoggerTest {

	public static void main(String[] args) {  
	    Logger logger = (Logger) LogManager.getLogger("mylog");  
	    logger.trace("trace level");  
	    logger.debug("debug level");  
	    logger.info("info level");  
	    logger.warn("warn level");  
	    logger.error("error level");  
	    logger.fatal("fatal level");  
	}  
}
