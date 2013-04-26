package net.zoldar.geocalc.utils;

public class Contracts {
    private Contracts() {
	
    }
    
    public static boolean allDoublesPositive(Iterable<Double> doubles) {
	for (Double d : doubles) {
	    if (d.compareTo(0.0) <= 0) {
		return false;
	    }
	}
	return true;
    }

    public static boolean doublePositive(double radius) {
	return Double.compare(radius, 0.0) > 0;
    }
}
