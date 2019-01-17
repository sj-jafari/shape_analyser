package com.shapes.exceptions;

public class ShapeIsNotSupportedException extends Exception {
	private static String msg = "The given shape is supported for processing!";

	public ShapeIsNotSupportedException() {
		super(msg);
	}

}
