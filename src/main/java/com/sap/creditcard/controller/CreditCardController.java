package com.sap.creditcard.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sap.creditcard.dto.CreditCardDto;
import com.sap.creditcard.entity.CreditCard;
import com.sap.creditcard.exception.CreditCardAlreadyExistException;
import com.sap.creditcard.service.ICreditCardService;
import com.sap.creditcard.util.CardNumberValidator;

import lombok.extern.log4j.Log4j2;

/**
 * Credit card controller with 2 methods Post and Get
 * @author Vani Nayak
 *
 */
@RestController
@Log4j2
@RequestMapping("/creditCard")
public class CreditCardController {
	
	@Autowired
    private ICreditCardService service;

	/**
	 * Method to create credit card
	 * @param creditCard
	 * @return
	 * Return 200 Ok if creation successful
	 * On invalid input throws 400 BadRequest
	 * On credit card number already exist throws conflict status
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public long create(@RequestBody CreditCardDto creditCard) {
		try {
			if(creditCard==null) {
				log.error("Credit card details are null at create");
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide valid credit card details");
			}
			if(creditCard==null || Strings.isBlank(creditCard.getCardHolderName()) ) {
				log.error("Cardholder name is empty or null at create");
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide valid card holder name");
	
			}
			if(creditCard.getCardNumber()<=0 
					|| !CardNumberValidator.validateCardNumberWithLuhn(creditCard.getCardNumber())) {
				log.error("Invalid credit card number");
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide valid card number");
	
			}
			
			return service.create(translateToCreditCard(creditCard));
		}catch(CreditCardAlreadyExistException e) {
			log.error("Credit card number already exist");
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());

		}
		
	}
	
	/**
	 * Get method
	 * fetches all the credit cards available in the system
	 * @return
	 * throws exception with OK status if no credit cards found in system
	 */
    @GetMapping
    public List<CreditCardDto> findAll() {
    	
    	List<CreditCard> creditCardList=service.findAll();
    	
        if(creditCardList==null || creditCardList.size()==0) {
        	throw new ResponseStatusException(HttpStatus.OK, "No credit cards found");

        }
        return creditCardList.stream()
        .map(this::translateFromCreditCard)
        .collect(Collectors.toList());
    }
    
    /**
     * Private translator method 
     * from the credit card DTO to entity 
     * @param from
     * @return
     */
    
    private CreditCard translateToCreditCard(CreditCardDto from) {
	
		CreditCard to=new CreditCard();
		to.setCardNumber(from.getCardNumber());
		to.setCardHolderName(from.getCardHolderName());
		to.setCardlimit(from.getLimit());
		return to;
				
	}
	
    /**
     * Private translator method 
     * from the credit card Entity to DTO 
     * @param from
     * @return
     */
	private CreditCardDto translateFromCreditCard(CreditCard from) {
				
		CreditCardDto to=new CreditCardDto();
		to.setId(from.getId());
		to.setCardNumber(from.getCardNumber());
		to.setCardHolderName(from.getCardHolderName());
		to.setBalance(0);
		to.setLimit(from.getCardlimit());
		
		return to;
	}
   


}
