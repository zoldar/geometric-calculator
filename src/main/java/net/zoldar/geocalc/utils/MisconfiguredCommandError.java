package net.zoldar.geocalc.utils;

public class MisconfiguredCommandError extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public MisconfiguredCommandError(Throwable e) {
	super("Shape class found but seems to be misconfigured.", e);
    }
}
