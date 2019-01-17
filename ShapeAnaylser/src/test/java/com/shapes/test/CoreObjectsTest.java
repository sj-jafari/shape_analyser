package com.shapes.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.shapes.domain.Polygon;
import com.shapes.domain.Side;
import com.shapes.domain.Triangle;
import com.shapes.exceptions.InvalidShapeException;
import com.shapes.exceptions.InvalidSideLengthException;
import com.shapes.exceptions.InvalidSideNumberException;

public class CoreObjectsTest {

	// ------------------ Side Class tests -----------------------------------
	@Test
	public void testSideCreationSuccess() throws InvalidSideLengthException {
		// test successful Side creation, should not throw anything.

		Side side = new Side(10);
		assertNotEquals(null, side);
	}

	@Test(expected = InvalidSideLengthException.class)
	public void testSideCreationFailure() throws InvalidSideLengthException {
		// test unsuccessful side creation, the input is invalid.

		Side side = new Side(-7);
	}
	// ------------------ /Side Class tests -----------------------------------

	// ------------------ Triangle Class tests --------------------------------
	@Test
	public void testTriangleCreationSuccess() throws InvalidSideLengthException, InvalidShapeException {
		// test successful triangle creation, should not throw anything.

		// construct with integers
		Triangle triangle = new Triangle(10, 9, 8);

		assertNotEquals(null, triangle);
		
		// construct with Side
		triangle = null;
		triangle = new Triangle(new Side(10), new Side(9), new Side(8));
		assertNotEquals(null, triangle);
	}

	@Test(expected = InvalidSideLengthException.class)
	public void testTriangleCreationFailureSide1() throws InvalidSideLengthException, InvalidShapeException {
		// test unsuccessful triangle creation, the inputs are invalid.
		Triangle triangle = new Triangle(0, 10, 10);

	}

	@Test(expected = InvalidSideLengthException.class)
	public void testTriangleCreationFailureSide2() throws InvalidSideLengthException, InvalidShapeException {
		// test unsuccessful triangle creation, the inputs are invalid.
		Triangle triangle = new Triangle(3, -10, 10);

	}

	@Test(expected = InvalidSideLengthException.class)
	public void testTriangleCreationFailureSide3() throws InvalidSideLengthException, InvalidShapeException {
		// test unsuccessful triangle creation, the inputs are invalid.
		Triangle triangle = new Triangle(3, 10, -5);
	}

	@Test()
	public void testEditTriangleSidesSuccess()
			throws InvalidSideLengthException, InvalidSideNumberException, InvalidShapeException {
		// test successful edit sides of a triangle
		Triangle triangle = new Triangle(1, 1, 1);
		triangle.setSide1(new Side(5));
		triangle.setSide2(new Side(10));
		triangle.setSide3(new Side(15));

		assertEquals(triangle.getSide1().getLength(), new Integer(5));
		assertEquals(triangle.getSide2().getLength(), new Integer(10));
		assertEquals(triangle.getSide3().getLength(), new Integer(15));

	}

	@Test(expected = InvalidSideLengthException.class)
	public void testEditTriangleSide1Failure()
			throws InvalidSideLengthException, InvalidSideNumberException, InvalidShapeException {
		// test unsuccessful edit sides of a triangle
		Triangle triangle = new Triangle(1, 1, 1);
		triangle.setSide1(new Side(-10));

	}

	@Test(expected = InvalidSideLengthException.class)
	public void testEditTriangleSide2Failure()
			throws InvalidSideLengthException, InvalidSideNumberException, InvalidShapeException {
		// test unsuccessful edit sides of a triangle
		Triangle triangle = new Triangle(1, 1, 1);
		triangle.setSide2(new Side(-10));

	}

	@Test(expected = InvalidSideLengthException.class)
	public void testEditTriangleSide3Failure()
			throws InvalidSideLengthException, InvalidSideNumberException, InvalidShapeException {
		// test unsuccessful edit sides of a triangle
		Triangle triangle = new Triangle(1, 1, 1);
		triangle.setSide3(new Side(-10));

	}
	// ------------------ /Triangle Class tests --------------------------------

	// ------------------ Polygon Class tests ----------------------------------
	@Test
	public void testPolygonCreationSuccess() throws InvalidSideLengthException, InvalidShapeException {
		// test successful Polygon creation, should not throw anything.

		Polygon polygon = new Polygon(10, 5, 1, 7, 4);
		assertNotEquals(null, polygon);
		assertEquals(polygon.getSides().size(), 5);
	}

	@Test(expected = InvalidShapeException.class)
	public void testPolygonCreationFailureInvalidShape() throws InvalidSideLengthException, InvalidShapeException {
		// test unsuccessful Polygon creation, the inputs are invalid.
		Polygon polygon = new Polygon(10, 5);
	}

	@Test(expected = InvalidSideLengthException.class)
	public void testPolygonCreationFailureInvalidSide() throws InvalidSideLengthException, InvalidShapeException {
		// test unsuccessful Polygon creation, the inputs are invalid.
		Polygon polygon = new Polygon(10, 5, -10);
	}

	@Test
	public void testPolygonEditSuccess()
			throws InvalidSideLengthException, InvalidShapeException, InvalidSideNumberException {
		// test successful Polygon creation, should not throw anything.

		Polygon polygon = new Polygon(10, 5, 1, 7, 4);

		for (int i = 1; i <= 5; i++) {
			polygon.editSide(i, new Side(2));
		}

		for (int i = 1; i <= 5; i++) {
			assertEquals(polygon.getSide(i).getLength(), new Integer(2));
		}
	}
	
	@Test(expected=InvalidSideNumberException.class)
	public void testPolygonEditFailureInvalidSideNumber()
			throws InvalidSideLengthException, InvalidShapeException, InvalidSideNumberException {
		// test unsuccessful Polygon modification, invalid side number

		Polygon polygon = new Polygon(1, 2, 3, 4, 5);
		polygon.editSide(10, new Side(9));
	}
	
	@Test(expected=InvalidSideNumberException.class)
	public void testPolygonGetSideFailureInvalidSideNumber()
			throws InvalidSideLengthException, InvalidShapeException, InvalidSideNumberException {
		// test unsuccessful get polygon side, invalid side number

		Polygon polygon = new Polygon(1, 2, 3, 4, 5);
		polygon.getSide(0);
	}
	// ------------------ /Polygon Class tests ----------------------------------
}
