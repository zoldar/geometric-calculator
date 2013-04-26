package net.zoldar.geocalc.client.commands;

import net.zoldar.geocalc.client.Command;
import net.zoldar.geocalc.client.CommandResult;

public class AreaCommandResult implements CommandResult<Double> {
    private final AreaCommand command;
    private final double result;
    
    public AreaCommandResult(AreaCommand command, double result) {
	this.command = command;
	this.result = result;
    }
    
    @Override
    public Command<Double> getCommand() {
	return command;
    }

    @Override
    public Double getResult() {
	return result;
    }

}
