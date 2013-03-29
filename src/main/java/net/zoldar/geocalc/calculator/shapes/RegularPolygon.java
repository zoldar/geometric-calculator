package net.zoldar.geocalc.calculator.shapes;

import java.util.Collections;
import java.util.List;

@CalculatorShape(name="regular_polygon")
public class RegularPolygon extends Polygon {
    public RegularPolygon(int sides, double segment) {
	super(makeSegments(sides, segment), makeAngles(sides, segment));
    }
    
    private static List<Double> makeSegments(int sides, double segment) {
	return Collections.nCopies(sides, segment);
    }
    
    private static List<Double> makeAngles(int sides, double segment) {
	return Collections.nCopies(sides, FULL_ANGLE / sides);
    }
}
