package com.sap.creditcard.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Credit card DTO
 * 
 * @author Vani Nayak
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties 
public class CreditCardDto {
	
	private long id;
	private long cardNumber;
	private String cardHolderName;
	private int limit;
	private double balance;

}
