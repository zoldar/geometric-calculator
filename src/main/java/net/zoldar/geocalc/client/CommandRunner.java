package net.zoldar.geocalc.client;

import java.util.List;

public class CommandRunner {
    private final List<CommandMiddleware> middlewares;
    
    public CommandRunner(List<CommandMiddleware> middlewares) {
	this.middlewares = middlewares;
    }

    public <Q extends Object> CommandResult<Q> execute(Command<Q> command) {
	command = runMiddlewareBefore(command);
	CommandResult<Q> result = null;
	if (command != null) {
	    result = command.run();
	    return runMiddlewareAfter(result);
	}
	return null;
    }
    
    private <Q extends Object> Command<Q> runMiddlewareBefore(Command<Q> command) {
	for (CommandMiddleware middleware : middlewares) {
	    command = middleware.doBefore(command);
	    if (command == null) {
		return null;
	    }
	}
	return command;
    }
    
    private <Q extends Object> CommandResult<Q> runMiddlewareAfter(CommandResult<Q> commandResult) {
	for (CommandMiddleware middleware : middlewares) {
	    commandResult = middleware.doAfter(commandResult);
	    if (commandResult == null) {
		return null;
	    }
	}
	return commandResult;

    }
}
