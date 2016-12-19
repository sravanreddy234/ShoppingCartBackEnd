package com.niit.shoppingcart;

import static org.junit.Assert.*;





import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.OrderDetailDAO;
import com.niit.shoppingcart.model.OrderDetail;

public class TestCaseOrder {

	@Autowired
	OrderDetailDAO orderDetailDAO;
	@Autowired
	OrderDetail orderDetail;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		orderDetailDAO = (OrderDetailDAO)context.getBean("orderDetailDAO");
		orderDetail = (OrderDetail)context.getBean("orderDetail");
	}
	
	/*@Test
	public void orderDetailListTestCase()
	{
		List<OrderDetail> list = orderDetailDAO.list();
		int rowCount = list.size();
		assertEquals("OrderDetail List Test Case", rowCount,2);
	}*/
	
	@Test
	public void orderDetailAddTestCase()
	{
		orderDetail.setBillingAddressId("gjh");
		orderDetail.setUserId("576");
		orderDetail.setGrandTotal(5646);
		orderDetail.setShippingAddressId("5454");
		
		//boolean flag = orderDetailDAO.saveOrUpdate(orderDetail);
		assertEquals(orderDetailDAO.saveOrUpdate(orderDetail), true);
	}
}