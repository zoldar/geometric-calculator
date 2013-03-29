package net.zoldar.geocalc.calculator;

import static org.junit.Assert.*;

import net.zoldar.geocalc.calculator.calculations.area.AreaCalculationType;
import net.zoldar.geocalc.calculator.calculations.circumference.CircumferenceCalculationType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CalculationTypesShould {
    @Test
    public void givenProperNameReturnValidCalculationType() {
	assertSame(CalculationTypes.withName("area"), AreaCalculationType.class);
	assertSame(CalculationTypes.withName("circumference"), CircumferenceCalculationType.class);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void throwWhenGivenInvalidCalculationName() {
	CalculationTypes.withName("somenonexistentname");
    }
}
