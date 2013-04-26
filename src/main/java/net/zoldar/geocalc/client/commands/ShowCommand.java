package net.zoldar.geocalc.client.commands;

import net.zoldar.geocalc.client.Command;
import net.zoldar.geocalc.client.CommandResult;
import net.zoldar.geocalc.client.CommandType;

@CommandType(name="show")
public class ShowCommand implements Command<String> {
    @Override
    public CommandResult<String> run() {
	return null;
    }

}
