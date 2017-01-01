package com.clearsettle.iservice;

import com.clearsettle.domain.Report;
import com.clearsettle.domain.Transaction;
import com.clearsettle.domain.User;
import com.clearsettle.response.domain.CheckCredentialResponse;
import com.clearsettle.response.domain.ClientResponse;
import com.clearsettle.response.domain.MerchantResponse;
import com.clearsettle.response.domain.ReportResponse;

/**
 * 
 * @author taner cakiroglu
 *
 */

public interface IUserService {

	/**
	 * @comment implements bussines logic
	 * @param credential
	 * @return
	 */
	public CheckCredentialResponse checkCredential(User credential);

	/**
	 * @comment implements bussines logic
	 * @param report
	 * @return
	 */
	public ReportResponse report(Report report);

	/**
	 * @comment implements bussines logic 
	 * @param transaction
	 * @return
	 */
	public ClientResponse client(Transaction transaction);

	/**
	 * @comment implements bussines logic 
	 * @param transaction
	 * @return
	 */
	public MerchantResponse merchant(Transaction transaction);
}
