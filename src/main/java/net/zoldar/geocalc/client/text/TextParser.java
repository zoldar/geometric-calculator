package net.zoldar.geocalc.client.text;

import java.util.List;

import com.google.common.collect.Lists;

import net.zoldar.geocalc.client.Command;
import net.zoldar.geocalc.client.Commands;

public class TextParser {
    public static Command<Object> parse(String input) {
	List<TokenValue> tokens = Lexer.parse(input);
	TokenValue commandToken = tokens.get(0);
	
	if (commandToken.getValue() instanceof String) {
	    String commandName = (String) commandToken.getValue();
	    List<TokenValue> argumentTokens = Lists.newArrayList(tokens.subList(1, tokens.size()-1));
	    Object[] arguments = extractArgumentsFrom(argumentTokens);
	    return Commands.withName(commandName).withArgumentsAsArray(arguments);
	}
	
	throw new IllegalArgumentException("Command must be a string.");
    }
    
    public static Object[] extractArgumentsFrom(List<TokenValue> tokens) {
	List<Object> arguments = Lists.newArrayList();
	for (TokenValue token : tokens) {
	    arguments.add(token.getValue());
	}
	return arguments.toArray();
    }
}
