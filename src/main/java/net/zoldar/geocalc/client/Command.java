package net.zoldar.geocalc.client;

public interface Command<T> {
    public CommandResult<T> run();
}
