package com.niit.shoppingcart.dao;

import com.niit.shoppingcart.model.BillingAddress;

public interface BillingAddressDAO {
	boolean saveOrUpdate(BillingAddress billingAddress);

	void deleteBillingAddress(String billingAddressId);

	BillingAddress getBillingAddress(String billingAddressId);
}
