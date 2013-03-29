package net.zoldar.geocalc.calculator.shapes;

import net.zoldar.geocalc.utils.Contracts;

@CalculatorShape(name="circle")
public class Circle implements Shape {
    private final double radius;
    
    public Circle(double radius) {
	if (!Contracts.doublePositive(radius)) {
	    throw new IllegalArgumentException("Radius must be positive value.");
	}
	
	this.radius = radius;
    }
    
    public double getRadius() {
	return radius;
    }
}
