package net.zoldar.geocalc.calculator.shapes;

import java.util.List;

import net.zoldar.geocalc.utils.Contracts;

@CalculatorShape(name="polygon")
public class Polygon implements Shape {
    protected static final double FULL_ANGLE = Math.PI * 2;
    
    private final List<Double> segments;
    private final List<Double> angles;
    
    public Polygon(List<Double> segments, List<Double> angles) {
	if (!Contracts.allDoublesPositive(segments) || !Contracts.allDoublesPositive(angles)) {
	    throw new IllegalArgumentException("All numeric values passed must be positive.");
	}
	
	if (segments.size() < 3) {
	    throw new IllegalArgumentException("Number of segments must be 3 or higher.");
	}
	
	if (angles.size() != segments.size()) {
	    throw new IllegalArgumentException("Number of angles given must be the same as number of segments");
	}
	
	this.segments = segments;
	this.angles = angles;
    }
    
    public List<Double> getSegments() {
	return segments;
    }
    
    public List<Double> getAngles() {
	return angles;
    }
}
