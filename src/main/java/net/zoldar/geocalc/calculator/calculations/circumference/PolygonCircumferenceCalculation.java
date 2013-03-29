package net.zoldar.geocalc.calculator.calculations.circumference;

import net.zoldar.geocalc.calculator.CalculationResult;
import net.zoldar.geocalc.calculator.calculations.Calculation;
import net.zoldar.geocalc.calculator.shapes.Polygon;
import net.zoldar.geocalc.calculator.shapes.Shape;

public class PolygonCircumferenceCalculation implements CircumferenceCalculationType, Calculation<Polygon> {
    @Override
    public CalculationResult computeFor(Polygon shape) {
	double circumference = 0;
	for (double segment : shape.getSegments()) {
	    circumference += segment;
	}
	return new CalculationResult(circumference);
    }

    @Override
    public boolean isApplicableTo(Shape shape) {
	return shape instanceof Polygon;
    }
}
