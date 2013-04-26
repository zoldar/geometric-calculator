package net.zoldar.geocalc.client;

import net.zoldar.geocalc.client.commands.AreaCommand;
import net.zoldar.geocalc.client.commands.AreaCommandResult;
import net.zoldar.geocalc.logger.Logger;

public class AreaLoggerCommandMiddleware implements CommandMiddleware {
    @Override
    public <Q> Command<Q> doBefore(Command<Q> command) {
	return command;
    }

    @Override
    public <Q> CommandResult<Q> doAfter(CommandResult<Q> commandResult) {
	if (isAreaCommandResult(commandResult)) {
	    AreaCommand areaCommand = (AreaCommand) commandResult.getCommand();
	    Logger.getInstance().log(areaCommand.getShapeName()+" "+commandResult.getResult());
	}
	return commandResult;
    }

    private <Q> boolean isAreaCommandResult(CommandResult<Q> command) {
	return command instanceof AreaCommandResult;
    }
}
