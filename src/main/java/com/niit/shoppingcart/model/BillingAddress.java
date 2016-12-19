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
public class BillingAddress implements Serializable{


    private static final long serialVersionUID = 1L;
    
    public BillingAddress(){
		this.billingAddressId="BLNGADRS"+UUID.randomUUID().toString().substring(24).toUpperCase();
	}


    @Id
    //@GeneratedValue
    private String billingAddressId;

    private String streetName;
    private String apartmentNumber;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    private String userId;

    

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(String billingAddressId) {
		this.billingAddressId = billingAddressId;
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

    


   

	@Override
    public String toString() {
        return "BillingAddress{" +
                "streetName='" + streetName + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

} // The End of Class;
