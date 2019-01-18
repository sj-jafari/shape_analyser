package com.shapes.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.shapes.domain.Polygon;
import com.shapes.domain.ShapeTypes;
import com.shapes.domain.Triangle;
import com.shapes.exceptions.InvalidShapeException;
import com.shapes.exceptions.InvalidSideLengthException;
import com.shapes.exceptions.ShapeIsNotSupportedException;
import com.shapes.utility.ShapeProcessor;

public class ShapeAnalysisTest {
	
	// ------------------ Triangle analysis tests ----------------------------------
	@Test
	public void testEquilateralTriangle() throws InvalidSideLengthException, InvalidShapeException, ShapeIsNotSupportedException {
		//successful detection of an equilateral triangle
		Triangle triangle = new Triangle(10, 10, 10);
		assertEquals(ShapeTypes.Equilateral_Triangle, ShapeProcessor.detectShapeType(triangle));
		
		assertNotEquals(ShapeTypes.Isosceles_Triangle, ShapeProcessor.detectShapeType(triangle));
	}
	
	@Test
	public void testIsoscelesTriangle() throws InvalidSideLengthException, InvalidShapeException, ShapeIsNotSupportedException {
		//successful detection of an isosceles triangle
		Triangle triangle = new Triangle(3, 10, 3);
		assertEquals(ShapeTypes.Isosceles_Triangle, ShapeProcessor.detectShapeType(triangle));
	}
	
	@Test
	public void testScaleneTriangle() throws InvalidSideLengthException, InvalidShapeException, ShapeIsNotSupportedException {
		//successful detection of a scalene triangle
		Triangle triangle = new Triangle(2, 7, 10);
		assertEquals(ShapeTypes.Scalene_Triangle, ShapeProcessor.detectShapeType(triangle));
	}
	
	@Test(expected = InvalidShapeException.class)
	public void testDetectTriangleIsNull() throws InvalidSideLengthException, InvalidShapeException, ShapeIsNotSupportedException {
		//test null triangle
		Triangle triangle = null;
		assertEquals(ShapeTypes.Scalene_Triangle, ShapeProcessor.detectShapeType(triangle));
	}
	
	@Test(expected = InvalidSideLengthException.class)
	public void testDetectTriangleWithInvalidLength() throws InvalidSideLengthException, InvalidShapeException, ShapeIsNotSupportedException {
		//test triangle with invalid length
		Triangle triangle = new Triangle(-5, 0, 10);
		assertEquals(ShapeTypes.Scalene_Triangle, ShapeProcessor.detectShapeType(triangle));
	}
	
	// ------------------ /Triangle analysis tests ----------------------------------

	// ------------------ ShapeProcessor tests --------------------------------------
	//@Ignore
	@Test(expected=ShapeIsNotSupportedException.class)
	public void testNotSupportedShape() throws InvalidSideLengthException, InvalidShapeException, ShapeIsNotSupportedException {
		//test a shape which is not supported for processing
		Polygon polygon = new Polygon(10,7,5,3,2);
		ShapeProcessor.detectShapeType(polygon);
	}
	
	// ------------------ ShapeProcessor tests --------------------------------------
}
