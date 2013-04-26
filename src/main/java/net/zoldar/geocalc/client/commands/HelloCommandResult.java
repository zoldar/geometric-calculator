package net.zoldar.geocalc.client.commands;

import net.zoldar.geocalc.client.Command;
import net.zoldar.geocalc.client.CommandResult;

public class HelloCommandResult implements CommandResult<String> {
    private final HelloCommand command;
    private final String result;
    
    public HelloCommandResult(HelloCommand command, String result) {
	this.command = command;
	this.result = result;
    }
    
    @Override
    public Command<String> getCommand() {
	return command;
    }

    @Override
    public String getResult() {
	return result;
    }

}
