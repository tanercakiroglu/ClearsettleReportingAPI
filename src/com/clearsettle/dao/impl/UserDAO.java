package com.clearsettle.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

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

@Service("ml")
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
		
		System.out.println(report.getFromDate());
		System.out.println(report.getToDate());
		
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
		 cal.setTimeInMillis(0);
		 cal.set(2015, 10, 9, 12, 9, 10);
		 Date created = cal.getTime(); 
		 
		 custInfo.setCreated_at(created);
		 custInfo.setUpdated_at(created);
		 custInfo.setDeleted_at(null);
		 custInfo.setNumber("401288XXXXXX188");
		 custInfo.setExpiryMonth("6");
		 custInfo.setExpiryYear("2017");
		 custInfo.setStartMonth(null);
		 custInfo.setStartYear(null);
		 custInfo.setIssueNumber(null);
		 custInfo.setEmail("michael@gmail.com");
		 custInfo.setBirthday("1986-03-20 12:09:1");
		 custInfo.setGender(null);
		 custInfo.setBillingTitle("");
		 custInfo.setBillingFirstName("Michael");
		 custInfo.setBillingLastName ("KaracustInfo");
		 custInfo.setBillingCompany (null);
		 custInfo.setBillingAddress1 ("test address");
		 custInfo.setBillingAddress2 (null);
		 custInfo.setBillingCity ("Antalya");
		 custInfo.setBillingPostcode ("07070");
		 custInfo.setBillingState (null);
		 custInfo.setBillingCountry ("TR");
		 custInfo.setBillingPhone (null);
		 custInfo.setBillingFax (null);
		 custInfo.setShippingTitle (null);
		 custInfo.setShippingFirstName ("Michael");
		 custInfo.setShippingLastName ("Kara");
		 custInfo.setShippingCompany (null);
		 custInfo.setShippingAddress1 ("test address");
		 custInfo.setShippingAddress2 (null);
		 custInfo.setShippingCity ("Antalya");
		 custInfo.setShippingPostcode ("07070");
		 custInfo.setShippingState (null);
		 custInfo.setShippingCountry ("TR");
		 custInfo.setShippingPhone (null);
		 custInfo.setShippingFax (null);
		 
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
