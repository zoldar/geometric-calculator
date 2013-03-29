package net.zoldar.geocalc.calculator;

import static org.junit.Assert.*;
import net.zoldar.geocalc.calculator.calculations.area.AreaCalculationType;
import net.zoldar.geocalc.calculator.calculations.circumference.CircumferenceCalculationType;
import net.zoldar.geocalc.calculator.shapes.Circle;
import net.zoldar.geocalc.calculator.shapes.Rectangle;
import net.zoldar.geocalc.calculator.shapes.Shape;
import net.zoldar.geocalc.calculator.shapes.Square;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CalculationsIntegration {
    @Test
    public void givenAreaCalculationTypeAndShapeShouldReturnProperArea() {
	Shape square = new Square(3);
	CalculationResult calcS = Calculations.withType(AreaCalculationType.class).computeFor(square);
	assertEquals(calcS.getValue(), 9, 0.0001);
	
	Shape rectangle = new Rectangle(3, 4);
	CalculationResult calcR = Calculations.withType(AreaCalculationType.class).computeFor(rectangle);
	assertEquals(calcR.getValue(), 12, 0.0001);
	
	Shape circle = new Circle(3);
	CalculationResult calcC = Calculations.withType(AreaCalculationType.class).computeFor(circle);
	assertEquals(calcC.getValue(), Math.PI * 3 * 3, 0.0001);
    }
    
    @Test
    public void givenCircumferenceCalculationTypeAndPolygonReturnProperCircumference() {
	Shape square = new Square(3);
	CalculationResult calcS = Calculations.withType(CircumferenceCalculationType.class).computeFor(square);
	assertEquals(calcS.getValue(), 12, 0.0001);
	
	Shape rectangle = new Rectangle(3, 4);
	CalculationResult calcR = Calculations.withType(CircumferenceCalculationType.class).computeFor(rectangle);
	assertEquals(calcR.getValue(), 14, 0.0001);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void throwsOnNonExistingCalculationImplementationForShape() {
	Shape circle = new Circle(3);
	Calculations.withType(CircumferenceCalculationType.class).computeFor(circle);
    }
}
