package com.shapes.controller;

import com.shapes.domain.Triangle;
import com.shapes.exceptions.InvalidShapeException;
import com.shapes.exceptions.InvalidSideLengthException;
import com.shapes.exceptions.ShapeIsNotSupportedException;
import com.shapes.utility.ShapeProcessor;

/**
 * <h1>A controller class for detecting triangle type</h1>
 * <p>
 * It simply receives three sides, constructs a {@link Triangle} and processes it using {@link ShapeProcessor}. 
 * </p>
 * 
 * @author Jalal
 * @since 20190117
 * @version 1.0
 */
public class DetectTriangleTypeAction {
	private Integer side1;
	private Integer side2;
	private Integer side3;
	
	/**
	 * Execution method for this action 
	 * @return the string description the shape.
	 * @throws InvalidSideLengthException
	 * @throws InvalidShapeException 
	 * @throws ShapeIsNotSupportedException 
	 */
	public String execute() throws InvalidSideLengthException, InvalidShapeException, ShapeIsNotSupportedException {
		Triangle triangle = new Triangle(side1, side2, side3);		
		String result = ShapeProcessor.detectShapeType(triangle).getDescription();
		return result;
	}
	
	/**
	 * Constructs this action.
	 * @param side1
	 * @param side2
	 * @param side3
	 */
	public DetectTriangleTypeAction(Integer side1, Integer side2, Integer side3) {
		super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	//getters and setters
	public Integer getSide1() {
		return side1;
	}
	public void setSide1(Integer side1) {
		this.side1 = side1;
	}
	public Integer getSide2() {
		return side2;
	}
	public void setSide2(Integer side2) {
		this.side2 = side2;
	}
	public Integer getSide3() {
		return side3;
	}
	public void setSide3(Integer side3) {
		this.side3 = side3;
	}
	
	
}
