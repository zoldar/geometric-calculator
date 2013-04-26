package net.zoldar.geocalc;

import net.zoldar.geocalc.utils.QuitSignal;

public class ReplCommandHandler {
    private static final String HELLO_MESSAGE = "Welcome to Area Calculator. Enter command.";
    
    public static String handle(String command) {
	if (command == "hello") {
	    return HELLO_MESSAGE;
	} else if (command == "exit") {
	    throw new QuitSignal();
	}
	
	return null;
    }
}
