package com.shapes.exceptions;

public class InvalidShapeException extends Exception {
	private static String msg = "The given shape is not valid!";

	public InvalidShapeException() {
		super(msg);
	}

}
