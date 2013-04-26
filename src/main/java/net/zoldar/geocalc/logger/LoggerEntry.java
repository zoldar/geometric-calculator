package net.zoldar.geocalc.logger;

import org.joda.time.DateTime;

public class LoggerEntry {
    private final DateTime created;
    private final String message;
    
    public LoggerEntry(String message) {
	this.message = message;
	this.created = DateTime.now();
    }

    public DateTime getCreated() {
	return created;
    }
    
    public String getMessage() {
	return message;
    }
}
