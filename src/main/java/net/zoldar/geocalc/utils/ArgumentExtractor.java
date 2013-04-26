package net.zoldar.geocalc.utils;

import java.util.Map;

import com.google.common.collect.Maps;

public class ArgumentExtractor {
    public static Map<String, Double> getNumeric(Map<String, Object> arguments) {
	Map<String, Double> doubleArgs = Maps.newHashMap();
	for (String name : arguments.keySet()) {
	    if (isNumeric(arguments.get(name))) {
		doubleArgs.put(name, (Double) arguments.get(name));
	    }
	}
	return doubleArgs;
    }
    
    private static boolean isNumeric(Object value) {
	return value instanceof Double || value instanceof Integer;
    }
}
