package net.zoldar.geocalc.client.commands;

import net.zoldar.geocalc.client.Command;
import net.zoldar.geocalc.client.CommandResult;
import net.zoldar.geocalc.client.CommandType;
import net.zoldar.geocalc.utils.QuitSignal;

@CommandType(name="exit")
public class ExitCommand implements Command<Object> {
    @Override
    public CommandResult<Object> run() {
	throw new QuitSignal();
    }
}
