package net.zoldar.geocalc.client;

public interface CommandMiddleware {
    <Q> Command<Q> doBefore(Command<Q> command);
    <Q> CommandResult<Q> doAfter(CommandResult<Q> commnadResult);
}
