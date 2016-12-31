package com.clearsettle.idao;

import com.clearsettle.domain.Report;
import com.clearsettle.domain.Transaction;
import com.clearsettle.domain.User;
import com.clearsettle.response.domain.ClientResponse;
import com.clearsettle.response.domain.MerchantResponse;
import com.clearsettle.response.domain.ReportResponse;

public interface IUserDAO {

	public boolean checkCredential(User credential);
	public ReportResponse report(Report report);
	public ClientResponse client(Transaction transaction);
	public MerchantResponse merchant(Transaction transaction);
	
	
}
