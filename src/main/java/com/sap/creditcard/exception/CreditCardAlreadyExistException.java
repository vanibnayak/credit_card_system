package com.sap.creditcard.exception;

/**
 * 
 * @author Vani Nayak
 *
 */
public class CreditCardAlreadyExistException extends RuntimeException{
	private String message;
	
	public CreditCardAlreadyExistException(String message) {
		super(message);
		this.message=message;
	}
	
	public CreditCardAlreadyExistException() {
		
	}

}
