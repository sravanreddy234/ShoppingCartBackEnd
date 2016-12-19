/*package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Supplier {
	
	@Id
	private String id;
	private String name;
	private String address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
*/


package com.niit.shoppingcart.model;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "supplier")
@Component
public class Supplier implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="supplierId")
	private String supplierId;
	
	@OneToMany(mappedBy="supplier", fetch=FetchType.EAGER)
	private Set<Product> product;
	
	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	
	@NotBlank(message="Please give a supplier name")
	private String supplierName;
	
	@NotBlank(message="Enter a contact no")
	private String supplierContact;

	@NotBlank(message="Enter a email Id")
	private String supplierEmail;
	
	@NotBlank(message="Give supplier a address")
	private String supplierAddress;
	
	@Transient
	private MultipartFile supplierImage;

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierContact() {
		return supplierContact;
	}

	public void setSupplierContact(String supplierContact) {
		this.supplierContact = supplierContact;
	}

	public String getSupplierEmail() {
		return supplierEmail;
	}

	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public MultipartFile getSupplierImage() {
		return supplierImage;
	}

	public void setSupplierImage(MultipartFile supplierImage) {
		this.supplierImage = supplierImage;
	}

	/*@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierContact="
				+ supplierContact + ", supplierEmail=" + supplierEmail + ", supplierAddress=" + supplierAddress
				+ ", supplierImage=" + supplierImage + "]";
	}*/

	/*public Supplier()
	{
		this.supplierId="SUPP"+UUID.randomUUID().toString().substring(24).toUpperCase();
	}*/
	
}
