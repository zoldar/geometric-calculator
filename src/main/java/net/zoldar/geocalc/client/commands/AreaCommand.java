package net.zoldar.geocalc.client.commands;

import java.util.List;

import net.zoldar.geocalc.calculator.CalculationTypes;
import net.zoldar.geocalc.calculator.Calculations;
import net.zoldar.geocalc.calculator.Shapes;
import net.zoldar.geocalc.calculator.shapes.Shape;
import net.zoldar.geocalc.client.Command;
import net.zoldar.geocalc.client.CommandResult;
import net.zoldar.geocalc.client.CommandType;

@CommandType(name="area")
public class AreaCommand implements Command<Double> {
    private static final String COMMAND = "area";
    
    private final String shapeName;
    private final List<Double> shapeParams;
    
    public AreaCommand(String shapeName, List<Double> shapeParams) {
	this.shapeName = shapeName;
	this.shapeParams = shapeParams;
    }

    @Override
    public CommandResult<Double> run() {
	Shape shape = Shapes.forName(shapeName).withArgumentsAsArray(shapeParams.toArray());
	double result = Calculations.withType(CalculationTypes.withName(COMMAND)).computeFor(shape).getValue();
	return new AreaCommandResult(this, result);
    }

    public String getShapeName() {
	return shapeName;
    }
    
    public List<Double> getShapeParams() {
	return shapeParams;
    }
}
