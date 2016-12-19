package com.niit.shoppingcart.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CardDetailDAO;
import com.niit.shoppingcart.model.CardDetail;

@Repository("cardDetailDAO")
public class CardDetailDAOImpl implements CardDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CardDetailDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean saveOrUpdate(CardDetail cardDetail) {
		System.out.println(cardDetail);
	sessionFactory.getCurrentSession().saveOrUpdate(cardDetail);
	return true;

	}

}
