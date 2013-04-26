package net.zoldar.geocalc.client.commands;

import net.zoldar.geocalc.client.Command;
import net.zoldar.geocalc.client.CommandResult;
import net.zoldar.geocalc.client.CommandType;

@CommandType(name="hello")
public class HelloCommand implements Command<String> {
    @Override
    public CommandResult<String> run() {
	return new HelloCommandResult(this, "Hello!");
    }

}
