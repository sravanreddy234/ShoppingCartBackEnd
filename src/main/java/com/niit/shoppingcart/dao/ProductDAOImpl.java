/*package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

@Repository("productDAO")
@EnableTransactionManagement
public class ProductDAOImpl implements ProductDAO {
	

		private static final Logger log=LoggerFactory.getLogger("ProductDAO.class");
	
	
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public boolean save(Product product) {
		
		try {
			log.debug("starting of the save method");
			sessionFactory.getCurrentSession().save(product);
			log.debug("end of the save method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			log.error("exception occured in save:"+e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean update(Product product) {
		try {
			log.debug("starting of the update method");
			sessionFactory.getCurrentSession().update(product);
			log.debug("end of the update method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			log.error("exception");
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean delete(Product product) {
		try {
			log.debug("starting of the delete method");
			sessionFactory.getCurrentSession().delete(product);
			log.debug("end of the delete method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public Product get(String id) {
		log.debug("starting of the get method");
		log.info("trying to get product based on id:"+id);
		String hql=" from Product where id =" + " ' " + id + " ' ";
		log.info("the hsql query is :"+ hql);
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list = query.list();
		if(list == null||list.isEmpty())
		{
			log.info("no products are avaliable with this id:"+id);
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	@Transactional
	public List<Product> list() {
		log.debug("starting of the List method");
		String hql = "from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("end of the list method");
		List<Product> list =query.list();
		if(list==null || list.isEmpty()){
			log.info("no products are avaliable");
		}
		return list;
	}
	}*/



package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Product product) {
		
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
		@Transactional
		public boolean update(Product product) {
			
			try {
				sessionFactory.getCurrentSession().update(product);
				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		@Transactional
		public boolean delete(Product product) {
			
			try {
				sessionFactory.getCurrentSession().delete(product);
				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

	@Transactional
	public Product get(String productId) {

		return sessionFactory.getCurrentSession().get(Product.class, productId);
		// String hql = "from Product where productId=" + "'" + id + "'";
		// Query query = sessionFactory.getCurrentSession().createQuery(hql);
		// List<Product> listProducts = query.getResultList();
		// return listProducts.get(0);
	}

	@Transactional
	public List<Product> listProduct() {
		List<Product> listProducts = sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listProducts;
	}

	@Transactional
	public List<Product> listProductByStock() {
		String hql = "from Product where isOutOffStock=" + "'" + false + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> listOfProductsByStock = query.getResultList();
		return listOfProductsByStock;
	}

	@Transactional
	public List<Product> similarProducts(String productId) {
		Product product = get(productId);

		String hql = "from Product where productId!=" + "'" + productId + "'" + "and" + " categoryId=" + "'"
				+ product.getCategory() + "'" + "and supplierId!=" + "'" + product.getSupplier() + "'"
				+ "and isOutOffStock=" + "'" + false + "'";
		//instead of getCategory() need to assign getCategoryId()
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> similarProductList = query.getResultList();
		return similarProductList;

	}

	@Transactional
	public List<Product> searchProduct(String keyword) {
		String hql = "from Product p where lower(p.productName) like lower('%" + keyword + "%') and isOutOffStock="
				+ "'" + false + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> listOfSearchedProducts = query.getResultList();
		return listOfSearchedProducts;
	}

	@Transactional
	public List<Product> searchProductAdmin(String keyword) {
		String hql = "from Product p where lower(p.productName) like lower('%" + keyword + "%')";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> listOfSearchedProducts = query.getResultList();
		return listOfSearchedProducts;
	}

	@Transactional
	public List<Product> list() {
		String hql = "from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
	@Transactional
	public List<Category> list1() {
		String hql = "from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return null;
	}

	public Product getProductById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
