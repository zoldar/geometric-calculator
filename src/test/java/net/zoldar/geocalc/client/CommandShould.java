package net.zoldar.geocalc.client;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.google.common.collect.Lists;

@RunWith(JUnit4.class)
public class CommandShould {
    @Test
    public void conformWithSomeApiExperiments() {
	/*
	CommandResult<Double> r1 = Commands.withName("area").forArgumentsAsArray(new Object[]{"circle", 4}).run();
	double value1 = r1.getValue();
	*/
	/*
	CommandResult<String> r2 = Commands.withName("showall").forArguments("dotted").run();
	String value2 = r2.getValue();
	
	CommandResult<Double> r3 = Commands.withName("circumference").forArguments("rectangle", 3, 4).run();
	double value3 = r3.getValue();
	*/
	//CommandResult<?> r1 = Commands.prepare(AreaCommand.class).withArguments("rectangle", 3, 4).run();
	
	List<CommandMiddleware> middlewares = Lists.newArrayList((CommandMiddleware) new AreaLoggerCommandMiddleware());
	CommandRunner runner = new CommandRunner(middlewares);
	 
	//CommandResult<String> result = runner.execute(Commands.withName("area").forArgumentsAsArray(new Object[]{"circle", 4}));
	CommandResult<Object> commandResult = runner.execute(
		Commands.withName("area").withArguments("rectangle", 3, 4));
	assertEquals((Double) commandResult.getResult(), Math.PI * 9.0, 0.0001);
	
	//Evaluator evaluator = new Evaluator();
	
	//CommandResult<String> result = runner.execute(evaluator.parse("area 3 2"));
	
    }
}
