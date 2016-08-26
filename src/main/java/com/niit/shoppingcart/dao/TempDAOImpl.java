package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Temp;

public class TempDAOImpl implements TempDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public boolean save(Temp temp) {
		
		sessionFactory.getCurrentSession().save(temp);
		
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Temp temp) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Temp temp) {
		// TODO Auto-generated method stub
		return false;
	}

	public Temp get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Temp> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
