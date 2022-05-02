package com.sap.creditcard.util;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

/**
 * CardNumberValidator class with method to validate number using Luhn algorithm  
 * 
 * @author Vani Nayak
 *
 */
@Log4j2
@Component
public class CardNumberValidator {

	/**
	 *  As per Luhn validation if sum of the digits in even place with sum of doubling digits
	 * at odd place starting from end of the number is divisible by 10 the number is a valid credit card number 
	 * 
	 * 
	 * @param cardNumber
	 * @return boolean value true if card number is valid else false
	 */
	public static boolean validateCardNumberWithLuhn(long cardNumber) {
		log.info("Validate card number using Luhn algorithm");
		int sum = 0;
		//indicator for odd even place
	    boolean isOddDigitPlace = false;
	    String cardNumberString=Long.toString(cardNumber);
	    for(int i=cardNumberString.length()-1;i>=0;i--)
	    {	 
	        int d =cardNumberString.charAt(i) - '0';
	     
	        //double the number before add
	        if (isOddDigitPlace == true)
	        	d = d * 2;
	        
	        //in case doubling results in 2 digits, add individual digits 
	        sum += d / 10;
	        sum += d % 10;	 
	        isOddDigitPlace = !isOddDigitPlace;
	        
	    }
	    return (sum % 10 == 0);
	}
	
}
