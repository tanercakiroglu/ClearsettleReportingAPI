package com.clearsettle.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.clearsettle.domain.CustomerInfo;
import com.clearsettle.domain.Merchant;
import com.clearsettle.domain.Report;
import com.clearsettle.domain.Role;
import com.clearsettle.domain.Transaction;
import com.clearsettle.domain.User;
import com.clearsettle.idao.IUserDAO;
import com.clearsettle.response.domain.ClientResponse;
import com.clearsettle.response.domain.MerchantResponse;
import com.clearsettle.response.domain.ReportResponse;


public class UserDAO implements IUserDAO {

	//FOR DBConnections
	
	@Override
	public boolean checkCredential(User credential) {
		User userFromDB = new User();

		userFromDB.setFirstName("kb");
		userFromDB.setLastName("gc");
		userFromDB.setUsername("kb");
		userFromDB.setPassword("123*-+");
		userFromDB.setEmail("merchant@test.com");

		Role r = new Role();
		r.setName("ROLE_USER");
		List<Role> roles = new ArrayList<Role>();
		roles.add(r);
		userFromDB.setAuthorities(roles);

		if (userFromDB.getEmail().equals(credential.getEmail())
				&& userFromDB.getPassword().equals(credential.getPassword()))
			return true;
		else {
			return false;
		}
	}

	@Override
	public ReportResponse report(Report report) {
			
		ReportResponse response = new ReportResponse();
		response.setCount(283);
		response.setTotal(28300);
		response.setCurrency("USD");
		
		return response;
	}

	@Override
	public ClientResponse client(Transaction transaction) {
		 ClientResponse response = new ClientResponse();
		 CustomerInfo custInfo = new CustomerInfo();
		 Calendar cal = Calendar.getInstance();
		 cal.set(2015, 9, 9, 12, 9, 10);
		 Date created = cal.getTime(); 
		 SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		 cal.set(1986, 2, 20, 12, 9, 10);
		 Date birthDay =cal.getTime();
	      
		 custInfo.setId(1);
		 custInfo.setCreated_at(dt.format(created));
		 custInfo.setUpdated_at(dt.format(created));
		 custInfo.setDeleted_at(null);
		 custInfo.setNumber("401288XXXXXX188");
		 custInfo.setExpiryMonth("6");
		 custInfo.setExpiryYear("2017");
		 custInfo.setEmail("michael@gmail.com");
		 custInfo.setBirthday(dt.format(birthDay));
		 custInfo.setBillingTitle("");
		 custInfo.setBillingFirstName("Michael");
		 custInfo.setBillingLastName ("KaracustInfo");
		 custInfo.setBillingAddress1 ("test address");
		 custInfo.setBillingCity ("Antalya");
		 custInfo.setBillingPostcode ("07070");
		 custInfo.setBillingCountry ("TR");
		 custInfo.setShippingFirstName ("Michael");
		 custInfo.setShippingLastName ("Kara");
		 custInfo.setShippingAddress1 ("test address");
		 custInfo.setShippingCity ("Antalya");
		 custInfo.setShippingPostcode ("07070");
		 custInfo.setShippingCountry ("TR");
		 
		 response.setCustomerInfo(custInfo);
		 
		return response;
	}

	@Override
	public MerchantResponse merchant(Transaction transaction) {
		
		MerchantResponse response = new MerchantResponse();
		Merchant  merchant = new  Merchant();
		
		merchant.setApiKey("1234");
		merchant.setId(1);
		merchant.setName("Dev-Merchan");
		merchant.setdStatus("All");
		merchant.setMcc("6012");
		merchant.setIpnUrl(null);
		merchant.setType("ECOM");
		merchant.setDescriptor("descriptor");
		merchant.setSecretKey("1234");
		merchant.setComType("API");
		response.setMerchant(merchant);
		return response;
	}

}
