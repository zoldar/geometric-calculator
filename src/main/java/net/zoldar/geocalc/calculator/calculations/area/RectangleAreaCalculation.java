package net.zoldar.geocalc.calculator.calculations.area;

import net.zoldar.geocalc.calculator.CalculationResult;
import net.zoldar.geocalc.calculator.calculations.Calculation;
import net.zoldar.geocalc.calculator.shapes.Rectangle;
import net.zoldar.geocalc.calculator.shapes.Shape;

public class RectangleAreaCalculation implements AreaCalculationType, Calculation<Rectangle> {
    @Override
    public CalculationResult computeFor(Rectangle shape) {
	double area = shape.getSegmentA() * shape.getSegmentB();
	return new CalculationResult(area);
    }

    @Override
    public boolean isApplicableTo(Shape shape) {
	return shape instanceof Rectangle;
    }
}
