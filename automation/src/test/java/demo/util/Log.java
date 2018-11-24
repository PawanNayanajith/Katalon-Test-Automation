package demo.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

	private static Logger logger = LogManager.getLogger(Log.class);
	
    public static void startTestCase() {
        logger.log(Level.INFO, "********************************************");
        logger.log(Level.INFO, "************** START TEST CASE *************");
        logger.log(Level.INFO, "********************************************");
    }

    
    public static void endTestCase() {
        logger.log(Level.INFO, "********************************************");
        logger.log(Level.INFO, "************** END TEST CASE *************");
        logger.log(Level.INFO, "********************************************");
    }
	
	
}
