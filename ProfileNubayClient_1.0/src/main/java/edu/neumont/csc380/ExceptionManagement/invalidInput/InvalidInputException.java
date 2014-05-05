package edu.neumont.csc380.ExceptionManagement.invalidInput;


//exception representing an invalid input
public class InvalidInputException extends Exception {
	public InvalidInputException(String message) {
		super(message);
	}
}
