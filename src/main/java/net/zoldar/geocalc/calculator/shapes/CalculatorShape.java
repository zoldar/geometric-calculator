package net.zoldar.geocalc.calculator.shapes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME)
public @interface CalculatorShape {
    String name();
}
