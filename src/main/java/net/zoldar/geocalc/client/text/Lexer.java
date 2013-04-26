package net.zoldar.geocalc.client.text;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Lexer {
    private static final String BOUNDARY = "\\s+";
    
    private static final Map<Pattern, TokenParser> matchers = Maps.newLinkedHashMap();
    {
	matchers.put(Pattern.compile("^[0-9](.[0-9]{1,})?$"), 
		    new TokenParser() { 
	    		public Object apply(String token) { return Double.parseDouble(token); } });
    }
    
    public static List<TokenValue> parse(String input) {
	List<TokenValue> tokens = Lists.newArrayList();
	for (String token : input.split(BOUNDARY)) {
	    Object parsedToken = parseToken(token);
	    tokens.add(new TokenValue(token, parsedToken));
	}
	return tokens;
    }
    
    public static Object parseToken(String token) {
	for (Entry<Pattern, TokenParser> matcher : matchers.entrySet()) {
	    if (matcher.getKey().matcher(token).matches()) {
		return matcher.getValue().apply(token);
	    }
	}
	return token;
    }
    
    private interface TokenParser {
	Object apply(String token);
    }
}
