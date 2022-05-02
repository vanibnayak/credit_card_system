package com.sap.creditcard.repositoy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sap.creditcard.entity.CreditCard;
import com.sap.creditcard.repository.CreditCardRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CreditCardRepositoryTest {

	@Autowired
	private CreditCardRepository cardRepository;
	
	@Test
	public void saveCreditCardTest_correct() {
		CreditCard cc=new CreditCard();
		cc.setCardHolderName("Bob");
		cc.setCardNumber(123456789033l);
		cc.setCardlimit(1000);
		cardRepository.save(cc);
		assertThat(cardRepository.findById(1L)).isInstanceOf(Optional.class);
		
		
		
	}
	
	@Test
	public void findAllCreditCardTest_correct() {
		CreditCard cc=new CreditCard();
		cc.setCardHolderName("John");
		cc.setCardNumber(1267899073l);
		cc.setCardlimit(1000);
		cardRepository.save(cc);
		CreditCard cc1=new CreditCard();
		cc1.setCardHolderName("John");
		cc1.setCardNumber(1234568990l);
		cc1.setCardlimit(10000);
		cardRepository.save(cc1);
		 assertThat(cardRepository.findAll()).isInstanceOf(List.class);	
		
	}
	
	@Test
	public void saveCreditCardTest_exception() {
		Exception exception = assertThrows(DataIntegrityViolationException.class, () -> {
			CreditCard cc=new CreditCard();
			cc.setCardHolderName("John");
			cc.setCardNumber(12345673l);
			cc.setCardlimit(1000);
			cardRepository.save(cc);
			CreditCard cc1=new CreditCard();
			cc1.setCardHolderName("John");
			cc1.setCardNumber(12345673l);
			cc1.setCardlimit(100);
			cardRepository.save(cc1);
	    });

	    String expectedMessage = "could not execute statement";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
		
		
		
	}
	
	
}
