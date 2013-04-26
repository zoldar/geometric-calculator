package net.zoldar.geocalc.logger;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LoggerEntryShould {
    @Test
    public void afterInstantiationContainValidTimestampAndProvidedMessage() {
	String message = "A test message.";
	DateTime now = DateTime.now();
	LoggerEntry entry = new LoggerEntry(message);
	assertEquals(entry.getMessage(), message);
	assertTrue(Math.abs(entry.getCreated().getMillis() - now.getMillis()) < 1000);
    }
}
