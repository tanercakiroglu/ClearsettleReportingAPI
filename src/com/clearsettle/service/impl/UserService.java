package com.clearsettle.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.clearsettle.domain.Report;
import com.clearsettle.domain.Transaction;
import com.clearsettle.domain.User;
import com.clearsettle.idao.IUserDAO;
import com.clearsettle.iservice.IUserService;
import com.clearsettle.response.domain.CheckCredentialResponse;
import com.clearsettle.response.domain.ClientResponse;
import com.clearsettle.response.domain.MerchantResponse;
import com.clearsettle.response.domain.ReportResponse;
import com.clearsettle.util.Constants;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;

	@Override
	public CheckCredentialResponse checkCredential(User credential) {
		CheckCredentialResponse response = null;
		
		if (userDAO.checkCredential(credential)) {
			StringBuilder strbuild = new StringBuilder();
			strbuild.append("Bearer ");
			strbuild.append(signAndSerializeJWT(createJWT(), Constants.SECRET_KEY));
			response = new CheckCredentialResponse(Constants.APPROVED,strbuild.toString());
		}
		return response;
	}

	@Override
	public ReportResponse report(Report report) {
		ReportResponse response =null;
		response=userDAO.report(report);
		response.setStatus(Constants.APPROVED);
		return response;
	}
	
	@Override
	public ClientResponse client(Transaction transaction) {
		ClientResponse response =null;
		response=userDAO.client(transaction);
		response.setStatus(Constants.APPROVED);
		return response;
	}
	

	@Override
	public MerchantResponse merchant(Transaction transaction) {
		MerchantResponse response =null;
		response=userDAO.merchant(transaction);
		response.setStatus(Constants.APPROVED);
		return response;
	}

	
	private JWTClaimsSet createJWT() {

		JWTClaimsSet claimsSet = new JWTClaimsSet();
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 10);
		Date tenFromNow = cal.getTime();
		claimsSet.setSubject("alice");
		claimsSet.setIssueTime(now);
		claimsSet.setIssuer("clearsettle.site.com");
		claimsSet.setExpirationTime(tenFromNow);
		claimsSet.setNotBeforeTime(now);
		return claimsSet;
	}

	private String signAndSerializeJWT(JWTClaimsSet claimsSet, String secret) {
		JWSSigner signer = new MACSigner(secret);
		SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
		try {
			signedJWT.sign(signer);
			return signedJWT.serialize();
		} catch (JOSEException e) {
			e.printStackTrace();
			return null;
		}
	}


	
	
}
