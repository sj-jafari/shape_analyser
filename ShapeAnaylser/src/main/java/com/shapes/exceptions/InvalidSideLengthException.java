package com.shapes.exceptions;

public class InvalidSideLengthException extends Exception {
	private static String msg = "The given side length is not valid! Please provide a number greater than zero.";

	public InvalidSideLengthException() {
		super(msg);
	}

	public InvalidSideLengthException(Integer sideLength) {
		super(msg + "(Side Length=" + sideLength + ")");
	}

}
