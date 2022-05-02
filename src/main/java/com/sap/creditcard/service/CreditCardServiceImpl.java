package com.sap.creditcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.creditcard.entity.CreditCard;
import com.sap.creditcard.exception.CreditCardAlreadyExistException;
import com.sap.creditcard.repository.CreditCardRepository;

import lombok.extern.log4j.Log4j2;

/**
 * CreditCardServiceImpl service with two methods
 * 1. Save credit card details  
 * 2. Fetch all credit cards in the system
 * 
 * 
 * @author Vani Nayak
 *
 */
@Log4j2
@Service
public class CreditCardServiceImpl implements ICreditCardService {
	
	@Autowired
	CreditCardRepository cardRepository;

	/**
	 * Create method to save credit card details to credit card table using credit card repository
	 * @param creditCard { cardHolderName,CardNumber, limit}
	 * Checks if card already exist in table if present throws exception
	 * if is not present calls saves card to table
	 * @return credit card id
	 * @exception CreditCardAlreadyExistException
	 */
	public long create(CreditCard creditCard) throws CreditCardAlreadyExistException {
		
		log.info("Check if card number already present");
		if(cardRepository.findByCardNumber(creditCard.getCardNumber()).isPresent()) {
			log.error("Card number already exist");
			throw new CreditCardAlreadyExistException("Credit card details already exist");
		}
		CreditCard savedCard=cardRepository.save(creditCard);
		log.info("Card details saved");
		return savedCard.getId();
	}
	
	/**
	 * 
	 * Methods gets all the credit cards stored in the database
	 * @return List<CreditCard>
	 * 
	 * 
	 */
	public List<CreditCard> findAll(){
		log.info("Find all credit cards");
		return cardRepository.findAll();
		
	}

}
