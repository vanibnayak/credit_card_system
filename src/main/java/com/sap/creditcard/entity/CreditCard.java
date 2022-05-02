package com.sap.creditcard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * 
 * @author Vani Nayak
 *
 */

@Entity
@Table(name="credit_card")
@Data
public class CreditCard {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	 @Column(unique=true)
	 private long cardNumber;
	 
	 private String cardHolderName;
	 
	 private int cardlimit;
	 
}
