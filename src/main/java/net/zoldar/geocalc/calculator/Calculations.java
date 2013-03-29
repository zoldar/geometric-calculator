package net.zoldar.geocalc.calculator;

import java.util.List;
import java.util.ServiceLoader;

import com.google.common.collect.Lists;

import net.zoldar.geocalc.calculator.calculations.Calculation;
import net.zoldar.geocalc.calculator.calculations.CalculationType;
import net.zoldar.geocalc.calculator.shapes.Shape;

public class Calculations<T extends Shape> {
    private final List<Calculation<T>> typeHits;
    
    private Calculations(List<Calculation<T>> typeHits) {
	this.typeHits = typeHits;
    }
    
    @SuppressWarnings("unchecked")
    public CalculationResult computeFor(Shape shape) {
	for (Calculation<T> calculation : typeHits) {
	    if (calculation.isApplicableTo(shape)) {
		return calculation.computeFor((T) shape);
	    }
	}
	throw new IllegalArgumentException("No calculation found for given shape.");
    }
    
    public static <K extends Shape> Calculations<K> withType(Class<? extends CalculationType> clazz) {
	List<Calculation<K>> calculations = Lists.newArrayList();
	for (Calculation<K> calculation : ServiceLoader.load(Calculation.class)) {
	    if (clazz.isAssignableFrom(calculation.getClass())) {
		calculations.add(calculation);
	    }
	}
	
	if (calculations.size() == 0) {
	    throw new IllegalStateException("No calculations found for given calculation type.");
	}
	
	return new Calculations<K>(calculations);
    }
    

}
