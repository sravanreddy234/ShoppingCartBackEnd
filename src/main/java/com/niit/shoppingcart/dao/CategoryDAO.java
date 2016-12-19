package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

public interface CategoryDAO {
	public boolean save(Category category);

	public boolean update(Category category);

	public boolean delete(Category category);

	public Category get(String id);

	public List<Category> list();
	
	public List<Category> listCategory();
	
    List<Product> selectedCategoryProductList(String id);
	
	List<Product> selectAllCategoryProducts(String categoryId);
	
	int getProductCountByCategory(String id);
	
	public Category getByName(String name);
}
