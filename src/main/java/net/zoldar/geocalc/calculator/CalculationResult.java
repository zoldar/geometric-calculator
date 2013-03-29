package net.zoldar.geocalc.calculator;

import java.util.List;

import com.google.common.collect.Lists;

public class CalculationResult {
    private final List<Double> values;
    
    public CalculationResult(double value) {
	values = Lists.newArrayList(value);
    }
    
    public CalculationResult(List<Double> values) {
	if (values == null || values.size() < 1) {
	    throw new IllegalArgumentException("There must be at least one value defined.");
	}
	this.values = values;
    }
    
    public double getValue() {
	if (values.size() > 1) {
	    throw new UnsupportedOperationException("Multiple values in result.");
	}
	return values.get(0);
    }
    
    public List<Double> getValues() {
	return values;
    }
}
