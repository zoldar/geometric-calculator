package net.zoldar.geocalc.calculator;

import static org.junit.Assert.*;
import net.zoldar.geocalc.calculator.calculations.area.SquareAreaCalculation;
import net.zoldar.geocalc.calculator.shapes.Shape;
import net.zoldar.geocalc.calculator.shapes.Square;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CalculatorShould {
    @Test
    public void correctlyExecuteValidCalculations() {
	// Most basic usage without helpers
	Square square = new Square(3);
	SquareAreaCalculation areaCalculation = new SquareAreaCalculation();
	areaCalculation.computeFor(square);
	
	// Using all available helpers
	
	Shape circle = Shapes.forName("circle").withArguments(4);
	assertEquals(
		Calculations.withType(CalculationTypes.withName("area")).computeFor(circle).getValue(),
		Math.PI * 4 * 4, 0.0001);
	
	Shape rectangle = Shapes.forName("rectangle").withArguments(3, 4);
	assertEquals(
		Calculations.withType(CalculationTypes.withName("circumference")).computeFor(rectangle).getValue(),
		14, 0.0001);
    }
}
