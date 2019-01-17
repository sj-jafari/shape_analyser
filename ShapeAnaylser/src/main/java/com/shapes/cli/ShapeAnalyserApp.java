package com.shapes.cli;

import java.util.Scanner;

import com.shapes.controller.DetectTriangleTypeAction;
import com.shapes.exceptions.InvalidShapeException;
import com.shapes.exceptions.InvalidSideLengthException;
import com.shapes.exceptions.ShapeIsNotSupportedException;

/**
 * <h1>A console application for Shape Analysis</h1>
 * <p>
 * It gives choices to the user for selecting a desired shape and gets the
 * corresponding parameters via command line. 
 * </br>
 * Good old CLI application :-) 
 * This can be easily replaced by any other type of GUI.
 * </p>
 * 
 * @author Jalal
 * @since 20190117
 * @version 1.0
 */
public class ShapeAnalyserApp {
	private static Scanner in = new Scanner(System.in);;

	/**
	 * The main execution method. It simply keeps looping until users chooses to
	 * exit.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		while (true) {
			try {
				showMenu();
				Integer choice = readChoice();
				String result = processChoice(choice);
				System.out.println();
				System.out.println(result);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	/**
	 * Prints the menu
	 */
	private static void showMenu() {
		System.out.println("____________________________________________________");
		System.out.println("Welcome to ShapeAnalyser! Please select a shape :");
		System.out.println("1. Triangle");
		System.out.println("2. Polygon");
		System.out.println("0. exit");

	}

	/**
	 * Gets the input choice
	 * 
	 * @return the choice
	 */
	private static Integer readChoice() {
		String strChoice = in.next();
		Integer choice = Integer.valueOf(strChoice);
		return choice;
	}

	/**
	 * Accepts the choice as input and calls the corresponding function.
	 * 
	 * @param choice
	 * @return
	 * @throws InvalidSideLengthException
	 * @throws InvalidShapeException
	 * @throws ShapeIsNotSupportedException 
	 */
	private static String processChoice(Integer choice) throws InvalidSideLengthException, InvalidShapeException, ShapeIsNotSupportedException {
		String result = null;
		switch (choice) {
		case 1:
			result = processTriangle();
			break;
		case 2:
			result = getComingSoonMessage();
			break;
		case 0:
			exit();
			break;
		default:
			result = getInvalidChoiceMessage();
			break;
		}

		return result;

	}

	/**
	 * Asks for the required parameters of a triangle from the user 
	 * and calls {@link DetectTriangleTypeAction} with those params.  
	 * @return Triangle Type.
	 * @throws InvalidSideLengthException
	 * @throws InvalidShapeException
	 * @throws ShapeIsNotSupportedException 
	 */
	private static String processTriangle() throws InvalidSideLengthException, InvalidShapeException, ShapeIsNotSupportedException {
		System.out.println("Please enter side 1");
		Integer side1 = in.nextInt();
		System.out.println("Please enter side 2");
		Integer side2 = in.nextInt();
		System.out.println("Please enter side 3");
		Integer side3 = in.nextInt();

		DetectTriangleTypeAction action = new DetectTriangleTypeAction(side1, side2, side3);

		String result = action.execute();
		return result;
	}

	/**
	 * Exists the program and returns to OS.
	 */
	private static void exit() {
		System.out.println("Bye!");
		in.close();
		System.exit(0);
	}

	/**
	 * 
	 * @return related message
	 */
	private static String getInvalidChoiceMessage() {
		return "Invalid Choice!";
	}

	/**
	 * 
	 * @return related message
	 */
	private static String getComingSoonMessage() {
		return "Coming soon! feature is not implemented int this version!";
	}

}
