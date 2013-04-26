package net.zoldar.geocalc.logger;

import java.util.List;

import com.google.common.collect.Lists;

public class Logger {
    private static Logger instance;
    
    private List<LoggerEntry> buffer = Lists.newCopyOnWriteArrayList();
    
    private Logger() {
	
    }
    
    public static Logger getInstance() {
	if (instance == null) {
	    instance = new Logger();
	}
	return instance;
    }
    
    synchronized public void log(String message) {
	buffer.add(new LoggerEntry(message));
    }
    
    synchronized public void clear() {
	buffer.clear();
    }
    
    public List<LoggerEntry> getLog() {
	return Lists.newArrayList(buffer);
    }
    
    public int getLogSize() {
	return buffer.size();
    }
}
