package net.zoldar.geocalc.calculator.calculations;

import net.zoldar.geocalc.calculator.CalculationResult;
import net.zoldar.geocalc.calculator.shapes.Shape;

public interface Calculation<T extends Shape> {
    CalculationResult computeFor(T shape);
    boolean isApplicableTo(Shape shape);
}
