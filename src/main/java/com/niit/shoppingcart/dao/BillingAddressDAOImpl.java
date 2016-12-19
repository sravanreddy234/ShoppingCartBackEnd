package com.niit.shoppingcart.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.BillingAddressDAO;
import com.niit.shoppingcart.model.BillingAddress;

@Repository("billingAddressDAO")
public class BillingAddressDAOImpl implements BillingAddressDAO {

	@Autowired
	SessionFactory sessionFactory;

	public BillingAddressDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(BillingAddress billingAddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(billingAddress);
		return true;

	}

	@Transactional
	public void deleteBillingAddress(String billingAddressId) {
		BillingAddress billingAddressToDelete = new BillingAddress();
		billingAddressToDelete.setBillingAddressId(billingAddressId);
		sessionFactory.getCurrentSession().delete(billingAddressToDelete);
		
		

	}

	@Transactional
	public BillingAddress getBillingAddress(String billingAddressId) {
		return sessionFactory.getCurrentSession().get(BillingAddress.class, billingAddressId);
	}

}
