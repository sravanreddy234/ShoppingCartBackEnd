package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Temp;

@Repository
public interface TempDAO {
	
	public boolean save(Temp temp);
	public boolean delete(Temp temp);
	public boolean update(Temp temp);
	public Temp get(String id);
	
	public List<Temp> list();

}
