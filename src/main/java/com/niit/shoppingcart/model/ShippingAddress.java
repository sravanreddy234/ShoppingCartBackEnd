package com.niit.shoppingcart.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;


@Entity
@Component
public class ShippingAddress implements Serializable{


    private static final long serialVersionUID = 1L;
    
    public ShippingAddress(){
		this.shippingAddressId="SHPNGADRS"+UUID.randomUUID().toString().substring(24).toUpperCase();
	}


    @Id
    //@GeneratedValue
    private String shippingAddressId;
    private String streetName;
    private String apartmentNumber;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    /*@OneToOne
    private UserDetails userDetails;*/
    
    public String userId;

    

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(String shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    

   /* public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}*/

	@Override
    public String toString() {
        return "ShippingAddress{" +
                "streetName='" + streetName + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
} // The End of Class;
