/*package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component
public class Product {
	@Id
	private String id;
	private String name;
	private String description;
	private String price;
	
	@Transient
	private MultipartFile image;
	
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
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
*/
package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "product")
@Component
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	
	private String productId;
	@NotBlank(message="Give Product a name")
	private String productName;
	@NotBlank(message="Give product a description")
	private String description;
	
	@NotBlank(message="Select a category")
	private String categoryId;
	
	@NotBlank(message="Select a supplier")
	private String supplierId;
	/*@Column(name = "out_off_stock")
	private boolean isOutOffStock;*/
	
	

	@Min(value=0,message="Cannot give a quantity less than zero")
	private int quantity;
	
	@Min(value=500,message="Price cannot be less than 500")
	private int price;
	
	@Transient
	private MultipartFile imageUrl;
	
	@ManyToOne
	@JoinColumn(name="categoryId",nullable= false,updatable= false, insertable= false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="supplierId",nullable= false,updatable= false, insertable= false)
	private Supplier supplier;
	/*@OneToMany
	@JoinColumn(name="cartId",nullable= false,updatable= false, insertable= false)
	private Cart cart;*/
	
	/*@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItemList;

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}*/

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	/*public boolean getIsOutOffStock() {
		return isOutOffStock;
	}

	public void setIsOutOffStock(boolean isOutOffStock) {
		this.isOutOffStock = isOutOffStock;
	}
*/
	
	public MultipartFile getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(MultipartFile imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	/*@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", isOutOffStock=" + isOutOffStock
				+ ", imageUrl=" + imageUrl + ", quantity=" + quantity + ", price=" + price + "]";
	}
*/
	
	/*public Product() {
		
		this.productId="PRD"+UUID.randomUUID().toString().substring(24).toUpperCase();
		
	}
	*/
	

}
