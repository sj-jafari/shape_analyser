package com.shapes.test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.shapes.controller.DetectTriangleTypeAction;
import com.shapes.domain.ShapeTypes;
import com.shapes.exceptions.InvalidShapeException;
import com.shapes.exceptions.InvalidSideLengthException;
import com.shapes.exceptions.ShapeIsNotSupportedException;

public class ControllersTest {
	
	private DetectTriangleTypeAction detectTriangleTypeAction;
	private String result;
	
	@Before
	public void before() {
		detectTriangleTypeAction = new DetectTriangleTypeAction(1, 1, 1);
		result = "";
	}
	// ------------------ Triangle analysis tests ----------------------------------
	@Test
	public void testSuccessfulDetectTriangleTypeAction() throws InvalidSideLengthException, InvalidShapeException, ShapeIsNotSupportedException {
		//Equilateral_Triangle
		detectTriangleTypeAction.setSide1(10);
		detectTriangleTypeAction.setSide2(10);
		detectTriangleTypeAction.setSide3(10);
		result = detectTriangleTypeAction.execute();
		assertEquals(result, ShapeTypes.Equilateral_Triangle.getDescription());
		
		//Isosceles_Triangle
		detectTriangleTypeAction.setSide1(3);
		detectTriangleTypeAction.setSide2(2);
		detectTriangleTypeAction.setSide3(3);
		result = detectTriangleTypeAction.execute();
		assertEquals(result, ShapeTypes.Isosceles_Triangle.getDescription());
		
		//Scalene_Triangle
		detectTriangleTypeAction.setSide1(4);
		detectTriangleTypeAction.setSide2(5);
		detectTriangleTypeAction.setSide3(6);
		result = detectTriangleTypeAction.execute();
		assertEquals(result, ShapeTypes.Scalene_Triangle.getDescription());
	}
	
	@Test(expected=InvalidSideLengthException.class)
	public void testUnsuccessfulDetectTriangleTypeActionInvalidSideLength() throws InvalidSideLengthException, InvalidShapeException, ShapeIsNotSupportedException {
		//
		detectTriangleTypeAction.setSide1(-1);
		detectTriangleTypeAction.setSide2(0);
		detectTriangleTypeAction.setSide3(10);
		result = detectTriangleTypeAction.execute();
	}
	
	// ------------------ /Triangle analysis tests ----------------------------------
	
}
