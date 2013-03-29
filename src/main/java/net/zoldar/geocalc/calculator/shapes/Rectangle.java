package net.zoldar.geocalc.calculator.shapes;

import java.util.Collections;

import com.google.common.collect.Lists;

@CalculatorShape(name="rectangle")
public class Rectangle extends Polygon {
    public Rectangle(double segmentA, double segmentB) {
	super(Lists.newArrayList(segmentA, segmentB, segmentA, segmentB),
		Collections.nCopies(4, FULL_ANGLE / 4));
    }
    
    public double getSegmentA() {
	return getSegments().get(0);
    }
    
    public double getSegmentB() {
	return getSegments().get(1);
    }
}
