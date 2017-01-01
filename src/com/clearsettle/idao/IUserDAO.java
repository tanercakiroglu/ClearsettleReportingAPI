package com.clearsettle.idao;

import com.clearsettle.domain.Report;
import com.clearsettle.domain.Transaction;
import com.clearsettle.domain.User;
import com.clearsettle.response.domain.ClientResponse;
import com.clearsettle.response.domain.MerchantResponse;
import com.clearsettle.response.domain.ReportResponse;

public interface IUserDAO {

	/**
	 * @comment database query
	 * @param credential
	 * @return
	 */
	public boolean checkCredential(User credential);

	/**
	 * @comment database query
	 * @param report
	 * @return
	 */
	public ReportResponse report(Report report);

	/**
	 * @comment database query
	 * @param transaction
	 * @return
	 */
	public ClientResponse client(Transaction transaction);

	/**
	 * @comment database query
	 * @param transaction
	 * @return
	 */
	public MerchantResponse merchant(Transaction transaction);

}
