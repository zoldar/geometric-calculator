package net.zoldar.geocalc.calculator;

import static org.junit.Assert.*;
import net.zoldar.geocalc.calculator.shapes.Circle;
import net.zoldar.geocalc.calculator.shapes.Rectangle;
import net.zoldar.geocalc.calculator.shapes.Shape;
import net.zoldar.geocalc.calculator.shapes.Square;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ShapesIntegration {
    @Test
    public void givenExistingShapeNameAndProperArgumentsReturnShapeInstance() {
	Shape circle = Shapes.forName("circle").withArguments(3);
	assertEquals(((Circle) circle).getRadius(), 3, 0.0001);
	
	Shape square = Shapes.forName("square").withArguments(3);
	assertEquals(((Square) square).getSegment(), 3, 0.0001);
	
	Shape rectangle = Shapes.forName("rectangle").withArguments(3, 4);
	assertEquals(((Rectangle) rectangle).getSegmentA(), 3, 0.0001);
	assertEquals(((Rectangle) rectangle).getSegmentB(), 4, 0.0001);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void throwsOnNonExistingShapeName() {
	Shapes.forName("somenonexistantshape");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void throwsOnWrongConstructorArguments() {
	Shapes.forName("square").withArguments(3, 4);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void throwsOnCounstructorArgumentsBreakingContract() {
	Shapes.forName("square").withArguments(-3);
    }
}
