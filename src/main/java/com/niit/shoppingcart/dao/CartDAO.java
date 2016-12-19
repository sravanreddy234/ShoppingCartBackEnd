package com.niit.shoppingcart.dao;

import java.util.List;



import com.niit.shoppingcart.model.Cart;

public interface CartDAO {


	public List<Cart> list();
	public Cart getCart(String cart_id);
	public Cart getProduct(String pro_id);
	public boolean save(Cart cart);
	public String update(Cart cart);
	public boolean delete(Cart cart);
	public List<Cart> getByUser(String id, String status);
}