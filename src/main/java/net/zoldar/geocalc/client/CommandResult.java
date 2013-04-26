package net.zoldar.geocalc.client;

public interface CommandResult<T> {
    public Command<T> getCommand();
    public T getResult();
}
