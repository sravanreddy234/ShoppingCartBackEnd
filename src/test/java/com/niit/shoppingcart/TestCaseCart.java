package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.BillingAddressDAO;
import com.niit.shoppingcart.dao.CardDetailDAO;
import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.ShippingAddressDAO;
import com.niit.shoppingcart.model.BillingAddress;
import com.niit.shoppingcart.model.CardDetail;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.ShippingAddress;


public class TestCaseCart {
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	Cart cart;
	
	@Autowired
	ShippingAddress shippingAddress;
	
	@Autowired
	ShippingAddressDAO shippingAddressDAO;
	
	@Autowired
	BillingAddressDAO billingAddressDAO;
	
	@Autowired
	BillingAddress billingAddress;
	
	@Autowired
	CardDetail cardDetail;
	
	@Autowired
	CardDetailDAO cardDetailDAO;
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		/*cartDAO = (CartDAO)context.getBean("cartDAO");
		cart = (Cart)context.getBean("cart");*/
		/*shippingAddressDAO=(ShippingAddressDAO)context.getBean("shippingAddressDAO");
		shippingAddress=(ShippingAddress)context.getBean("shippingAddress");*/
		/*billingAddressDAO=(	BillingAddressDAO)context.getBean("billingAddressDAO");
		billingAddress=(BillingAddress)context.getBean("billingAddress");*/
		cardDetail=(CardDetail) context.getBean("cardDetail");
		cardDetailDAO=(CardDetailDAO) context.getBean("cardDetailDAO");
		
	}

	/*@Test
	public void cartTestCase(){
		//cart.setCart_id("agsgg");
		cart.setProductID("88888");
		cart.setProductName("lenovo");
		cart.setProductPrice(22200);
		cart.setQuantity(0);
		cart.setUserID("576");
		cart.setTotal(133);		
		assertEquals(cartDAO.save(cart), true);
	}*/
	
	/*@Test
	public void cartTestCase(){
		
		cart.setCart_id("c00111");
		cart.setProductID("6767");
		cart.setProductName("lenovo");
		cart.setProductPrice(10000);
		cart.setQuantity(2);
		
	}*/
	
	
	
	/*@Test
	public void shippingTestCase(){
		
		shippingAddress.setApartmentNumber("5-1-24");
		shippingAddress.setCity("Hyd");
		shippingAddress.setCountry("india");
		shippingAddress.setState("TS");
		shippingAddress.setStreetName("Ashok Nagar");
		shippingAddress.setZipCode("507117");
		shippingAddress.setUserId("576");*/
	
/*shippingAddress.setS_line1("e");
shippingAddress.setS_line2("e");
shippingAddress.setS_city("e");
shippingAddress.setS_country("e");
shippingAddress.setS_state("e");
shippingAddress.setS_zipCode("123456");
shippingAddress.setUser_id();*/
		//assertEquals(shippingAddressDAO.saveOrUpdate(shippingAddress), true);
	

	
	/*@Test
	public void billingTestCase(){
	
billingAddress.setApartmentNumber("55");
billingAddress.setStreetName("shd");
billingAddress.setCity("ds");
billingAddress.setState("dsfds");
billingAddress.setCountry("dsfds");
billingAddress.setZipCode("fdsfsd");
billingAddress.setUserId("576");
		assertEquals(billingAddressDAO.saveOrUpdate(billingAddress), true);
	}*/
	
	@Test
	public void cardTestCase(){
cardDetail.setCardNumber("45556656565656");
cardDetail.setUserId("576");
cardDetail.setCvNumber("321");
cardDetail.setExpiryMonth("5566");
cardDetail.setExpiryYear("566");
cardDetail.setNameOnCard("sravan");
cardDetail.setTotalCost(000);


		assertEquals(cardDetailDAO.saveOrUpdate(cardDetail), true);
	
	}

}