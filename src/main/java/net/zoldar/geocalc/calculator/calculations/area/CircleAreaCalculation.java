package net.zoldar.geocalc.calculator.calculations.area;

import net.zoldar.geocalc.calculator.CalculationResult;
import net.zoldar.geocalc.calculator.calculations.Calculation;
import net.zoldar.geocalc.calculator.shapes.Circle;
import net.zoldar.geocalc.calculator.shapes.Shape;

public class CircleAreaCalculation implements AreaCalculationType, Calculation<Circle> {
    @Override
    public CalculationResult computeFor(Circle shape) {
	double area = Math.PI * shape.getRadius() * shape.getRadius();
	return new CalculationResult(area);
    }

    @Override
    public boolean isApplicableTo(Shape shape) {
	return shape instanceof Circle;
    }
}
