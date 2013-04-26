package net.zoldar.geocalc.logger;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ClearedLoggerShould {
    private static Logger logger = Logger.getInstance();
    
    @Before
    public void getClearedBeforeEveryTest() {
	logger.clear();
    }
    
    @AfterClass
    public static void getClearedAfterAllTestsAreDone() {
	logger.clear();
    }
    
    @Test
    public void afterLoggingContainOneLoggerEntryWithProperState() {
	String message = "A test logging.";
	DateTime now = DateTime.now();
	logger.log(message);
	assertEquals(logger.getLogSize(), 1);
	LoggerEntry entry = logger.getLog().get(0);
	assertEquals(entry.getMessage(), message);
	assertTrue(Math.abs(entry.getCreated().getMillis() - now.getMillis()) < 1000);
    }
    
    @Test
    public void afterAddingAnEntryAndClearingHaveCleanLog() {
	logger.log("Some text");
	logger.clear();
	assertEquals(logger.getLogSize(), 0);
    }
}
