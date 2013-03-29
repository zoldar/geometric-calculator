package net.zoldar.geocalc.calculator.calculations.area;

import net.zoldar.geocalc.calculator.CalculationResult;
import net.zoldar.geocalc.calculator.calculations.Calculation;
import net.zoldar.geocalc.calculator.shapes.Shape;
import net.zoldar.geocalc.calculator.shapes.Square;

public class SquareAreaCalculation implements AreaCalculationType, Calculation<Square> {
    @Override
    public CalculationResult computeFor(Square shape) {
	double area = shape.getSegment() * shape.getSegment();
	return new CalculationResult(area);
    }
    
    @Override
    public boolean isApplicableTo(Shape shape) {
	return shape instanceof Square;
    }
}
