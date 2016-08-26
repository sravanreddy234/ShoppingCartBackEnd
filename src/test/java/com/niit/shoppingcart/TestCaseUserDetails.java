package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;

public class TestCaseUserDetails {
	
	@Autowired
	UserDetailsDAO userDetailsDAO;
	@Autowired
	UserDetails userDetails;
	
	AnnotationConfigApplicationContext context;
	@Before
	public void init(){
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDetailsDAO=(UserDetailsDAO)context.getBean("UserDetailsDAO");
		userDetails=(UserDetails)context.getBean("UserDetails");
		
		}
	@Test
	public void UserDetailsAddTestCase(){
		userDetails.setId("USD_001");
		userDetails.setName("Sravan");
		userDetails.setPassword("sravan");
		userDetails.setContact("9948419310");
		userDetails.setAddress("Hyderabad");
		userDetails.setMail("sravanreddy234@gmail.com");
		assertEquals(userDetailsDAO.save(userDetails), true);
	}
	@Test
	public void UserDetailsListTestCase(){
		List<UserDetails> list=userDetailsDAO.list();
		int rowCount=list.size();
		assertEquals("UserDetails List Test Case", rowCount, 2);
	}
}
