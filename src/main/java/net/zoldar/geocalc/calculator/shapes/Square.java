package net.zoldar.geocalc.calculator.shapes;

@CalculatorShape(name="square")
public class Square extends RegularPolygon {
    public Square(double segment) {
	super(4, segment);
    }
    
    public double getSegment() {
	return getSegments().get(0);
    }
}
