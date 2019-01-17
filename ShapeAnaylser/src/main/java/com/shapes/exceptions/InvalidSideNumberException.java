package com.shapes.exceptions;

public class InvalidSideNumberException extends Exception {
	private static String msg = "The side does not exist in the shape!";

	public InvalidSideNumberException() {
		super(msg);
	}

	public InvalidSideNumberException(Integer sideNumber) {
		super(msg + "(Side Number=" + sideNumber +")");
	}
}
