package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Cart;

@Repository("cartDAO")
@EnableTransactionManagement
public class CartDAOImpl implements CartDAO {
	
@Autowired
private SessionFactory sessionFactory;

	@Transactional
	public List<Cart> list() {
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

	@Transactional
	public boolean save(Cart cart) {
try {
	sessionFactory.getCurrentSession().save(cart);
	return true;
} catch (HibernateException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	return false;
}
	}

	@Transactional
	public boolean delete(Cart cart) {
		
		//cart.setUserID(id);
		System.out.println(cart.getCart_id());
		System.out.println("in method");
		try {
			sessionFactory.getCurrentSession().delete(cart);
			return true;
			
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	@Transactional
	public String update(Cart cart) {
		
		//cart.setUserID(id);
		try {
			sessionFactory.getCurrentSession().update(cart);
		} catch (HibernateException e) {
			e.printStackTrace();
			return e.getMessage();

		}
		return null;
	} 
	
	@Transactional
	public Cart getProduct(String pro_id) {
		String hql = "from Cart where id ="+"'"+pro_id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	@Transactional
	public List<Cart> getByUser(String id, String status) {
		String hql="from Cart  where userID='"+id+"' and status='"+status+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();

		if (list != null && !list.isEmpty()) {
			return list;
		}

		return null;
	}
	
	@Transactional
	public Cart getCart(String cart_id) {
		String hql = "from Cart where id=" + "'" + cart_id + "' ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}
}