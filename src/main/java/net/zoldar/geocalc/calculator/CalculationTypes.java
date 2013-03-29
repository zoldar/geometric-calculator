package net.zoldar.geocalc.calculator;

import org.reflections.Reflections;

import net.zoldar.geocalc.calculator.calculations.CalculationType;
import net.zoldar.geocalc.calculator.calculations.CalculatorCalculation;

public class CalculationTypes {
    private static final Reflections REFLECTIONS = new Reflections("net.zoldar.geocalc.calculator.calculations");
    
    private CalculationTypes() {
	
    }
    
    @SuppressWarnings("unchecked")
    public static <Q extends CalculationType> Class<Q> withName(String name) {
	if (name == null) {
	    throw new NullPointerException("No shape name given!");
	}
	
	for (Class<?> calculationTypeClass : REFLECTIONS.getTypesAnnotatedWith(CalculatorCalculation.class)) {
	    CalculatorCalculation calcAnn = calculationTypeClass.getAnnotation(CalculatorCalculation.class);
	    if (calcAnn != null && name.equals(calcAnn.name())) {
		return (Class<Q>) calculationTypeClass;
	    }
	}
	throw new IllegalArgumentException("No calculation type with given name exists.");
    }
}
