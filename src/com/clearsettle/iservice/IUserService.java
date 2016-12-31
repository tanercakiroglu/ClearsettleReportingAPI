package com.clearsettle.iservice;

import com.clearsettle.domain.Report;
import com.clearsettle.domain.Transaction;
import com.clearsettle.domain.User;
import com.clearsettle.response.domain.CheckCredentialResponse;
import com.clearsettle.response.domain.ClientResponse;
import com.clearsettle.response.domain.MerchantResponse;
import com.clearsettle.response.domain.ReportResponse;

public interface IUserService {

	public CheckCredentialResponse checkCredential(User credential);
	public ReportResponse report(Report report);
	public ClientResponse client(Transaction transaction);
	public MerchantResponse merchant(Transaction transaction);
}
