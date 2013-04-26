package net.zoldar.geocalc.client;

import java.lang.reflect.InvocationTargetException;

import net.zoldar.geocalc.utils.MisconfiguredCommandError;

import org.reflections.Reflections;

public class Commands<T extends Command<Object>> {
    private static final Reflections REFLECTIONS = new Reflections("net.zoldar.geocalc.client.commands");
    
    private final Class<T> commandClass;
    
    private Commands(Class<T> commandType) {
	this.commandClass = commandType;
    }
    
    public Command<Object> withArguments(Object ... arguments) {
	return withArgumentsAsArray(arguments);
    }

    @SuppressWarnings("unchecked")
    public Command<Object> withArgumentsAsArray(Object[] arguments) {
	try {
	    return (Command<Object>) commandClass.getConstructors()[0].newInstance(arguments);
	} catch (IllegalArgumentException e) {
	    throw new IllegalArgumentException("Arguments passed do not conform command's constructor.", e);
	} catch (SecurityException e) {
	    throw new MisconfiguredCommandError(e);
	} catch (InstantiationException e) {
	    throw new MisconfiguredCommandError(e);
	} catch (IllegalAccessException e) {
	    throw new MisconfiguredCommandError(e);
	} catch (InvocationTargetException e) {
	    throw new IllegalArgumentException("Arguments passed do not conform command's contract.", e);
	}
    }
    
    @SuppressWarnings("unchecked")
    public static <Z extends Command<Object>> Commands<Z> withName(String commandName) {
	if (commandName == null) {
	    throw new NullPointerException("No command name given!");
	}
	
	for (Class<?> commandType : REFLECTIONS.getTypesAnnotatedWith(CommandType.class)) {
	    CommandType commandAnn = commandType.getAnnotation(CommandType.class);
	    if (commandAnn != null && commandName.equals(commandAnn.name())) {
		return new Commands<Z>((Class<Z>) commandType);
	    }
	}
	throw new IllegalArgumentException("No shape with given name exists.");
    }
}
