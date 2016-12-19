package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ShippingAddressDAO;
import com.niit.shoppingcart.model.ShippingAddress;

public class TestCaseShpng {
	
	@Autowired
	ShippingAddress shippingAddress;
	
	@Autowired
	ShippingAddressDAO shippingAddressDAO;

AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		shippingAddressDAO = (ShippingAddressDAO)context.getBean("shippingAddressDAO");
		shippingAddress = (ShippingAddress)context.getBean("shippingAddress");
	}
	
	/*@Test
	public void shippingAddressListTestCase()
	{
		List<ShippingAddress> list = shippingAddressDAO.list();
		int rowCount = list.size();
		assertEquals("ShippingAddress List Test Case", rowCount,4);
	}*/
	
	@Test
	public void shippingAddressAddTestCase()
	{
		shippingAddress.setApartmentNumber("5-1-24");
		shippingAddress.setCity("Hyd");
		shippingAddress.setCountry("india");
		shippingAddress.setState("TS");
		shippingAddress.setStreetName("Ashok Nagar");
		shippingAddress.setZipCode("507117");
		shippingAddress.setUserId("555");
		
		assertEquals(shippingAddressDAO.saveOrUpdate(shippingAddress), true);
	}
}
