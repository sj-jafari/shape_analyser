package com.shapes.domain;

import java.util.ArrayList;
import java.util.List;

import com.shapes.exceptions.InvalidShapeException;
import com.shapes.exceptions.InvalidSideLengthException;
import com.shapes.exceptions.InvalidSideNumberException;

/**
 * <h1>A general class for representing a polygon.</h1>
 * <p>
 * The {@link Polygon} class can represent a polygons given a list of {@link Side}.
 * This gives us the flexibility to create any type of polygon.
 * </p>
 * 
 * @author Jalal
 * @since 20190117
 * @version 1.0
 */
public class Polygon implements Shape {
	private List<Side> sides;

	/**
	 * Constructs a {@link Polygon} by providing a desired number of sides.
	 * For ease of use, the sides are accepted as {@link Integer}.
	 * We have defined another Constructor which accepts {@link Side}, too.
	 * 
	 * @param givenSides
	 * @throws InvalidSideLengthException
	 * @throws InvalidShapeException 
	 */
	public Polygon(Integer... givenSides) throws InvalidSideLengthException, InvalidShapeException {
		if (givenSides.length <= 2)
			throw new InvalidShapeException();
		ArrayList<Side> temporarySidesList = new ArrayList<Side>();
		for (Integer sideLength : givenSides) {
			if (sideLength <= 0)
				throw new InvalidSideLengthException();
			temporarySidesList.add(new Side(sideLength));
		}

		// if everything was fine, then assign the list to the object variable.
		this.sides = temporarySidesList;
	}
	
	/**
	 * Constructs a {@link Polygon} by providing a desired number of sides.
	 * The sides are accepted as {@link Side}.
	 * We have defined another Constructor which accepts {@link Integer}, too.
	 * 
	 * @param givenSides
	 * @throws InvalidSideLengthException
	 * @throws InvalidShapeException 
	 */
	public Polygon(Side... givenSides) throws InvalidShapeException {
		if (givenSides.length <= 2)
			throw new InvalidShapeException();
		ArrayList<Side> temporarySidesList = new ArrayList<Side>();
		for (Side side : givenSides) {
			temporarySidesList.add(side);
		}

		// if everything was fine, then assign the list to the object variable.
		this.sides = temporarySidesList;
	}

	/**
	 * 
	 * @return a list of {@link Side}
	 */
	public List<Side> getSides() {
		return sides;
	}

	/**
	 * Sets the sides, given a list of {@link Side} as input.
	 * 
	 * @param sides
	 * @throws InvalidSideLengthException
	 */
	public void setSides(List<Side> sides) throws InvalidSideLengthException {
		for (Side side : sides) {
			if (side.getLength() <= 0)
				throw new InvalidSideLengthException();
		}
		this.sides = sides;
	}

	/**
	 * Edits a side by providing it's number (index) and a new length.
	 * Indices start from 1.
	 * 
	 * @param sideNumber
	 * @param newSide
	 * @throws InvalidSideNumberException
	 */
	public void editSide(Integer sideNumber, Side newSide)
			throws InvalidSideNumberException {
		sideNumber -= 1; // the indexes in list start from 0. Better to make this logic invisible for outsiders.

		try {
			this.sides.set(sideNumber, newSide);
		}catch (IndexOutOfBoundsException e) {
			throw new InvalidSideNumberException(sideNumber);
		}

	}
	
	/**
	 * Returns a side given its number (index)
	 * Indices start from 1.
	 * @param sideNumber
	 * @return Side
	 * @throws InvalidSideNumberException
	 */
	public Side getSide(Integer sideNumber)
			throws InvalidSideNumberException {
		sideNumber -= 1; // the indexes in list start from 0. Better to make this logic invisible for outsiders.

		try {
			return sides.get(sideNumber);
		}catch (IndexOutOfBoundsException e) {
			throw new InvalidSideNumberException(sideNumber);
		}
	}

	/**
	 * @return a String definition for this shape.
	 */
	public String getDefinition() {
		return "This is a polygon with " + sides.size() + " sides.";
	}

}
