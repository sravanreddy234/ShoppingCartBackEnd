/*package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Category {
	
	
@OneToMany(mappedBy="category",fetch=FetchType.EAGER)
	public Set<Product> getProducts(){
		return  products;
	}
	public void SetProducts(Set<Product> products){
		this.products=products;
	}
	
	
	@Id
	private String id;
	private String name;
	@NotEmpty
	private String description;
	private Set<Product> products;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}

--------------------------------------------------------------

*/




package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "category")
@Component
public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	@Id 
	@Column(name="categoryId")
	private String categoryId;
	
	@OneToMany(mappedBy="category", fetch=FetchType.EAGER)
	private Set<Product> products;
	
	
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@NotBlank(message="Give category a name")
	private String categoryName;
	
	@NotBlank(message="Give a category description")
	private String categoryDescription;

	@Transient
	private MultipartFile categoryImage;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public MultipartFile getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(MultipartFile categoryImage) {
		this.categoryImage = categoryImage;
	}

	/*@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + ", categoryImage=" + categoryImage + "]";
	}*/

	/*public Category()
	{
		this.categoryId="CAT"+UUID.randomUUID().toString().substring(24).toUpperCase();
	}*/
}
