package net.zoldar.geocalc.utils;

public class MisconfiguredShapeError extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public MisconfiguredShapeError(Throwable e) {
	super("Shape class found but seems to be misconfigured.", e);
    }
}
