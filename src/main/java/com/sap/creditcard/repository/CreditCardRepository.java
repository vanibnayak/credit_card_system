package com.sap.creditcard.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sap.creditcard.entity.CreditCard;
/**
 * 
 * @author Vani Nayak
 *
 */

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long>{

	public Optional<CreditCard> findByCardNumber(Long cardNumber);
	
}
