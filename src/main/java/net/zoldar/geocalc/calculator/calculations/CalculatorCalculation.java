package net.zoldar.geocalc.calculator.calculations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME)
public @interface CalculatorCalculation {
    String name();
}
