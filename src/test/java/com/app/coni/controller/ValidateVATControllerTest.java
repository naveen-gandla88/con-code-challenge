package com.app.coni.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.app.coni.Service.ValidateVATNumService;
import com.app.coni.model.Country;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
public class ValidateVATControllerTest {
	
	@InjectMocks
	ValidateVATController validateVATController;
	
	@Mock
	ValidateVATNumService validateVATNumService;
	
	@Test
	public void TestValidateVAT() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		Country con = new Country();
		con.setCountry("France(FR)");
		when(validateVATNumService.validateVATNumber("FR94328781786")).thenReturn(con);
		
		Country result = validateVATController.validateVAT("FR94328781786");
		
		assertThat(result.getCountry().equals(con.getCountry()));
		
	}
	
	

}
