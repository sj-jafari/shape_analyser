package com.shapes.domain;

import com.shapes.exceptions.InvalidShapeException;
import com.shapes.exceptions.InvalidSideLengthException;
import com.shapes.exceptions.InvalidSideNumberException;

/**
 * <h1>This class simply represents a triangle.</h1>
 * <p>
 * When creating a {@link Triangle}, it receives the three sides as input,
 * checks for validity via it's parent class, {@link Polygon}, and if everything
 * is fine, constructs a triangle. The sides are treated as separated fields for
 * clarity and simplicity.
 * </p>
 * 
 * @author Jalal
 * @since 20190117
 * @version 1.0
 */
public class Triangle extends Polygon {

	/**
	 * Given three sides as {@link Integer}, constructs a triangle instance.
	 * 
	 * @param side1
	 * @param side2
	 * @param side3
	 * @throws InvalidSideLengthException
	 * @throws InvalidShapeException 
	 */
	public Triangle(Integer side1, Integer side2, Integer side3) throws InvalidSideLengthException, InvalidShapeException {
		super(side1, side2, side3);
	}
	
	/**
	 * Given three {@link Side} as input, constructs a triangle instance.
	 * 
	 * @param side1
	 * @param side2
	 * @param side3
	 * @throws InvalidShapeException
	 */
	public Triangle(Side side1, Side side2, Side side3) throws InvalidShapeException {
		super(side1, side2, side3);
	}

	/**
	 * @return side1 of triangle.
	 */
	public Side getSide1() {
		return super.getSides().get(0);
	}

	/**
	 * Edits the length of side 3
	 * 
	 * @param side1
	 * @throws InvalidSideNumberException
	 */
	public void setSide1(Side side1) throws InvalidSideNumberException {
		//TODO: we could handle InvalidSideNumberException here, since we are sure it does not happen in this controlled method.
		//		Also, callers do not need to be aware of this exception here.
		super.editSide(1, side1);
	}

	/**
	 * @return side2 of triangle.
	 */
	public Side getSide2() {
		return super.getSides().get(1);
	}

	/**
	 * Edits the length of side 2
	 * 
	 * @param side2
	 * @throws InvalidSideNumberException
	 */
	public void setSide2(Side side2) throws InvalidSideNumberException {
		super.editSide(2, side2);
	}

	/**
	 * @return side3 of triangle.
	 */
	public Side getSide3() {
		return super.getSides().get(2);
	}

	/**
	 * Edits the length of side 3
	 * 
	 * @param side1
	 * @throws InvalidSideNumberException
	 */
	public void setSide3(Side side3) throws InvalidSideNumberException {
		super.editSide(3, side3);
	}
	

	/**
	 * @return a String definition for this shape.
	 */
	public String getDefinition() {
		return "This is a triangle with these sides: " 
				+ this.getSide1().getLength() + ", "
				+ this.getSide2().getLength() + ", "
				+ this.getSide3().getLength();
	}

}
