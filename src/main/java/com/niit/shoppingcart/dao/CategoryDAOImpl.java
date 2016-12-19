/*package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;

@Repository("categoryDAO")
@EnableTransactionManagement
public class CategoryDAOImpl implements CategoryDAO {
	
	
	
			
			
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public boolean save(Category category) {
		
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean delete(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public Category get(String id) {
		String  hql = " from Category where id ="+"'"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> list = query.list();
		if(list == null || list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	@Transactional
	public List<Category> list() {
		String hql = "from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
	@Transactional
	public Category getByName(String name){
		String hql= " from Category where name ="+"'"+name+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> list = (List<Category>) query.list();
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		else
		{
			return null;
		}
	}
	

}
*/




package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

@Repository(value="categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Category category) {
		
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean delete(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/*@Transactional
	public void delete(String categoryId) {
		Category categoryToDelete = new Category();
		categoryToDelete.setCategoryId(categoryId);
		sessionFactory.getCurrentSession().delete(categoryToDelete);

	}*/

	@Transactional
	public Category get(String categoryId) {

		// sessionFactory.getCurrentSession().get(Category.class,id);
		String hql = "from Category where categoryId=" + "'" + categoryId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> listCategory = query.getResultList();
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}

		return null;

	}

	@Transactional
	public List<Category> listCategory() {
		@SuppressWarnings("unchecked")
		List<Category> listCategory = sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCategory;
	}
	
	@Transactional
	public List<Product> selectedCategoryProductList(String categoryId)
	{
		String hql="from Product where categoryId=" + "'" + categoryId + "'"+"and isOutOffStock=" + "'" + false + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> listSelectedProducts = query.getResultList();
		return listSelectedProducts; 
		
	
	}
	
	@Transactional
	public int getProductCountByCategory(String id)
	{
		String hql="from Product where categoryId=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> listSelectedProducts = query.getResultList();
		return listSelectedProducts.size(); 
		
	
	}

	@Transactional
	public List<Product> selectAllCategoryProducts(String categoryId) {

		String hql="from Product where categoryId=" + "'" + categoryId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> listSelectedProducts = query.getResultList();
		return listSelectedProducts; 
		
	}

	

	@Transactional
	public List<Category> list() {
		String hql = "from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public Category getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}