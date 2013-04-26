package net.zoldar.geocalc.client.text;

public class TokenValue {
    private final String stringValue;
    private final Object realValue;
    
    public TokenValue(String stringValue, Object realValue) {
	this.stringValue = stringValue;
	this.realValue = realValue;
    }
    
    public Object getValue() {
	return realValue;
    }
    
    @Override
    public String toString() {
	return "TokenValue<"+stringValue+">";
    }
}