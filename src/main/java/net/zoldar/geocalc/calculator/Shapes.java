package net.zoldar.geocalc.calculator;

import java.lang.reflect.InvocationTargetException;

import org.reflections.Reflections;

import net.zoldar.geocalc.calculator.shapes.CalculatorShape;
import net.zoldar.geocalc.calculator.shapes.Shape;
import net.zoldar.geocalc.utils.MisconfiguredShapeError;

public class Shapes<T extends Shape> {
    private static final Reflections REFLECTIONS = new Reflections("net.zoldar.geocalc.calculator.shapes");
    
    private final Class<T> shapeClass;
    
    private Shapes(Class<T> shapeType) {
	this.shapeClass = shapeType;
    }
    
    public Shape withArguments(Object ... args) {
	try {
	    return (Shape) shapeClass.getConstructors()[0].newInstance(args);
	} catch (IllegalArgumentException e) {
	    throw new IllegalArgumentException("Arguments passed do not conform shape's constructor.", e);
	} catch (SecurityException e) {
	    throw new MisconfiguredShapeError(e);
	} catch (InstantiationException e) {
	    throw new MisconfiguredShapeError(e);
	} catch (IllegalAccessException e) {
	    throw new MisconfiguredShapeError(e);
	} catch (InvocationTargetException e) {
	    throw new IllegalArgumentException("Arguments passed do not conform shape's contract.", e);
	}
    }
    
    @SuppressWarnings("unchecked")
    public static <Q extends Shape> Shapes<Q> forName(String name) {
	if (name == null) {
	    throw new NullPointerException("No shape name given!");
	}
	
	for (Class<?> shapeType : REFLECTIONS.getTypesAnnotatedWith(CalculatorShape.class)) {
	    CalculatorShape shapeAnn = shapeType.getAnnotation(CalculatorShape.class);
	    if (shapeAnn != null && name.equals(shapeAnn.name())) {
		return new Shapes<Q>((Class<Q>) shapeType);
	    }
	}
	throw new IllegalArgumentException("No shape with given name exists.");
    }
}
