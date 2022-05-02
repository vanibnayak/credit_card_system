package com.sap.creditcard.service;

import java.util.List;

import com.sap.creditcard.entity.CreditCard;

/**
 * Credit cad service interface with 2 methods to Add and get all credit cards
 * 
 * @author Vani Nayak
 *
 */

public interface ICreditCardService {

	public long create(CreditCard creditCard);
	public List<CreditCard> findAll();
	
}
