/*package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Product;

@Repository
public interface ProductDAO {
	public boolean save(Product product);

	public boolean update(Product product);

	public boolean delete(Product product);

	public Product get(String id);

	public List<Product> list();
}
*/



package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

public interface ProductDAO {

	public boolean save(Product product);
	
	public boolean update(Product product);
	
	public boolean delete(Product product);
	
	Product get(String id);
	
	List<Product> list();
	
	List<Category> list1();
	
	List<Product> listProductByStock();
	
	List<Product> similarProducts(String productId);

	List<Product> searchProduct(String keyword);
	
	List<Product> searchProductAdmin(String keyword);
	
	List<Product> getProductList();

    Product getProductById (String id);

	

}
