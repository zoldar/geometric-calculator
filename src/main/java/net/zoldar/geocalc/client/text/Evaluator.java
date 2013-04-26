package net.zoldar.geocalc.client.text;

import net.zoldar.geocalc.client.CommandRunner;
import net.zoldar.geocalc.utils.QuitSignal;

public class Evaluator {
    private final CommandRunner runner;
    
    public Evaluator(CommandRunner runner) {
	this.runner = runner;
    }
    
    public String evaluate(String input) {
	try {
	    return runner.execute(TextParser.parse(input)).toString();
	} catch (QuitSignal e) {
	    throw e;
	} catch (Exception e) {
	    return "Error: "+e;
	}
    }
}
