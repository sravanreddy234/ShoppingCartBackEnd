package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.OrderedItems;

public interface OrderedItemsDAO {

	boolean saveOrUpdate(OrderedItems orderedItems );
	
	void delete(String orderedItemId);
	
	List<OrderedItems> listOrderedItems();
}
