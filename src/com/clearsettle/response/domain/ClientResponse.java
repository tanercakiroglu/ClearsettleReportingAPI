package com.clearsettle.response.domain;

import com.clearsettle.domain.CustomerInfo;

public class ClientResponse extends BaseResponse {

	private CustomerInfo customerInfo;

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	
	
}
