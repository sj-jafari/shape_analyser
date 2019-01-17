package com.shapes.utility;

import com.shapes.domain.Shape;
import com.shapes.domain.ShapeTypes;
import com.shapes.domain.Triangle;
import com.shapes.exceptions.ShapeIsNotSupportedException;

/**
 * <h1>A utility class for analyzing different types of shapes..</h1>
 * <p>
 * The {@link ShapeProcessor} class generally does the processing routines against given shapes, 
 * Like detecting the type, and so on.
 * </p>
 * 
 * @author Jalal
 * @since 20190117
 * @version 1.0
 */
public class ShapeProcessor {

	/**
	 * this method first detects the general class type of shape and then 
	 * calls the respective methods in order to determine further information regarding that shape.
	 * @param shape
	 * @return Shape Type
	 * @throws ShapeIsNotSupportedException 
	 */
	public static ShapeTypes detectShapeType(Shape shape) throws ShapeIsNotSupportedException {
		ShapeTypes result = null;

		if (shape instanceof Triangle) {
			Triangle triangle = (Triangle) shape;
			result = detectTriangleType(triangle);
		}
		//other types of shapes can be processed here
		else {
			throw new ShapeIsNotSupportedException();
		}
		return result;
	}

	/**
	 * Processes a triangle's characteristics and returns it's type.
	 * @param triangle
	 * @return the type of triangle
	 */
	private static ShapeTypes detectTriangleType(Triangle triangle) {
		/*
		 * Note: 
		 * We theoretically know an equilateral triangle is an isosceles one too.
		 * Likewise, a square is also a rectangle, circle is also an ellipse.
		 * However, in the current design we are mapping a shape to a single shape type.
		 * Here, we can simply expand our design with the least effect by returning 
		 * a list of types for a given Shape. 
		 */
		if(
			(triangle.getSide1().getLength() == triangle.getSide2() .getLength())
			&& 
			(triangle.getSide2().getLength() == triangle.getSide3().getLength())
		)
		{
			return ShapeTypes.Equilateral_Triangle;
		}else if(
			(triangle.getSide1().getLength() == triangle.getSide2().getLength())
			||
			(triangle.getSide1().getLength() == triangle.getSide3().getLength())
			||
			(triangle.getSide2().getLength() == triangle.getSide3().getLength())
		)
		{
			return ShapeTypes.Isosceles_Triangle;
		}else {
			return ShapeTypes.Scalene_Triangle;
		}
	}
	
	//other logics regarding shape analysis can be defined as separated methods here.
	
}
