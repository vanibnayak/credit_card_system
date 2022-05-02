package com.sap.creditcard.controller;


import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sap.creditcard.controller.CreditCardController;
import com.sap.creditcard.dto.CreditCardDto;
import com.sap.creditcard.entity.CreditCard;
import com.sap.creditcard.service.ICreditCardService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CreditCardController.class)
public class CreditCardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private ICreditCardService service;
    
    @Test
    public void create_thenreturn_id() throws Exception{
    	
    	CreditCardDto cc=new CreditCardDto();
		cc.setCardHolderName("John");
		cc.setCardNumber(4417123456789113l);
		cc.setLimit(1000);
		 Mockito.when(service.create(Mockito.any(CreditCard.class))).thenReturn(1l);

	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/creditCard")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(mapper.writeValueAsString(cc).getBytes(StandardCharsets.UTF_8))
	                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
	                .andReturn();

	        Assertions.assertThat(result).isNotNull();
    } 
    
    @Test
    public void create_thenreturn_id_amex() throws Exception{
    	
    	CreditCardDto cc=new CreditCardDto();
		cc.setCardHolderName("John Toj");
		cc.setCardNumber(374245455400126l);
		cc.setLimit(1000);
		 Mockito.when(service.create(Mockito.any(CreditCard.class))).thenReturn(1l);

	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/creditCard")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(mapper.writeValueAsString(cc).getBytes(StandardCharsets.UTF_8))
	                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
	                .andReturn();

	        Assertions.assertThat(result).isNotNull();
    } 
    
    
    @Test
    public void create_thenreturn_id_discover() throws Exception{
    	
    	CreditCardDto cc=new CreditCardDto();
		cc.setCardHolderName("Moiee");
		cc.setCardNumber(60115564485789458l);
		cc.setLimit(1000);
		 Mockito.when(service.create(Mockito.any(CreditCard.class))).thenReturn(1l);

	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/creditCard")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(mapper.writeValueAsString(cc).getBytes(StandardCharsets.UTF_8))
	                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
	                .andReturn();

	        Assertions.assertThat(result).isNotNull();
    } 
    
    @Test
    public void create_thenreturn_id_jcb() throws Exception{
    	
    	CreditCardDto cc=new CreditCardDto();
		cc.setCardHolderName("Chriss");
		cc.setCardNumber(3530111333300000l);
		cc.setLimit(1000);
		 Mockito.when(service.create(Mockito.any(CreditCard.class))).thenReturn(1l);

	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/creditCard")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(mapper.writeValueAsString(cc).getBytes(StandardCharsets.UTF_8))
	                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
	                .andReturn();

	        Assertions.assertThat(result).isNotNull();
    } 
    
    @Test
    public void create_thenreturn_id_visa() throws Exception{
    	
    	CreditCardDto cc=new CreditCardDto();
		cc.setCardHolderName("Chriss");
		cc.setCardNumber(4917484589897107l);
		cc.setLimit(1000);
		 Mockito.when(service.create(Mockito.any(CreditCard.class))).thenReturn(1l);

	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/creditCard")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(mapper.writeValueAsString(cc).getBytes(StandardCharsets.UTF_8))
	                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
	                .andReturn();

	        Assertions.assertThat(result).isNotNull();
    } 
    
    @Test
    public void create_thenreturn_id_master() throws Exception{
    	
    	CreditCardDto cc=new CreditCardDto();
		cc.setCardHolderName("Chriss");
		cc.setCardNumber(2223000048410010l);
		cc.setLimit(1000);
		 Mockito.when(service.create(Mockito.any(CreditCard.class))).thenReturn(1l);

	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/creditCard")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(mapper.writeValueAsString(cc).getBytes(StandardCharsets.UTF_8))
	                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
	                .andReturn();

	        Assertions.assertThat(result).isNotNull();
    } 

    
    @Test
    public void create_empty_creditcard() throws Exception{
    	
    	CreditCardDto cc=new CreditCardDto();
		
		 Mockito.when(service.create(Mockito.any(CreditCard.class))).thenReturn(1l);

	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/creditCard")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(mapper.writeValueAsString(cc).getBytes(StandardCharsets.UTF_8))
	                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest())
	                .andReturn();

	        
    } 
    
    @Test
    public void create_empty_cardholdername() throws Exception{
    	
    	CreditCardDto cc=new CreditCardDto();
		cc.setCardHolderName("");
		cc.setCardNumber(4417123456789113l);
		cc.setLimit(1000);
		

	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/creditCard")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(mapper.writeValueAsString(cc).getBytes(StandardCharsets.UTF_8))
	                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest())
	                .andReturn();

	        
    } 
    
    @Test
    public void create_invalid_card_number() throws Exception{
    	
    	CreditCardDto cc=new CreditCardDto();
		cc.setCardHolderName("Bob");
		cc.setCardNumber(441712345891l);
		cc.setLimit(1000);
		

	        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/creditCard")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(mapper.writeValueAsString(cc).getBytes(StandardCharsets.UTF_8))
	                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest())
	                .andReturn();

	        
    } 
    
  
    @Test
    void geAll_creditcard_Test() throws Exception {
    	
    	CreditCard cc=new CreditCard();
    	cc.setId(1l);
    	cc.setCardHolderName("Bob");
    	cc.setCardNumber(1234l);
    	cc.setCardlimit(1000);
    	
    	List<CreditCard> ccList=new ArrayList<CreditCard>();
    	ccList.add(cc);
    	
    	Mockito.when(service.findAll()).thenReturn(ccList);
    	
    	CreditCardDto ccDto=new CreditCardDto();
    	ccDto.setId(1l);
    	ccDto.setCardHolderName("Bob");
    	ccDto.setCardNumber(1234l);
    	ccDto.setLimit(1000);
    	ccDto.setBalance(0);

    	List<CreditCardDto> ccDtoList=new ArrayList<CreditCardDto>();
    	ccDtoList.add(ccDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/creditCard")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assertions.assertThat(result).isNotNull();
        String creditJson = result.getResponse().getContentAsString();
        Assertions.assertThat(creditJson).isEqualToIgnoringCase(mapper.writeValueAsString(ccDtoList));
    }
    
}
