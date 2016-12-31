package com.clearsettle.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clearsettle.aspect.exceptionhandler.HandleException;
import com.clearsettle.aspect.logger.Loggable;
import com.clearsettle.domain.Report;
import com.clearsettle.domain.Transaction;
import com.clearsettle.domain.User;
import com.clearsettle.exception.BussinesException;
import com.clearsettle.icontroller.IUserController;
import com.clearsettle.iservice.IUserService;
import com.clearsettle.util.Constants;
import com.clearsettle.util.Util;

@RestController
public class UserController implements IUserController {

	@Autowired
	private IUserService userService;

	@HandleException
	@Loggable
	@Override
	public String checkCredentail(@RequestBody User credential) throws BussinesException {
		if (credential == null || Util.isNullOREmpty(credential.getEmail())
				|| Util.isNullOREmpty(credential.getPassword()))
			throw new BussinesException(Constants.INVALID_PARAMETERS);

		return Util.constructJSON(Constants.APPROVED, true, userService.checkCredential(credential));
	}

	@HandleException
	@Loggable
	@Override
	public String report(@RequestBody Report report) throws BussinesException {
		if (report == null || report.getFromDate()==null 
				||report.getToDate()==null)
			throw new BussinesException(Constants.INVALID_PARAMETERS);
		
		return Util.constructJSON(Constants.APPROVED, true, userService.report(report));
	}

	@HandleException
	@Loggable
	@Override
	public String client(@RequestBody  Transaction transaction) throws BussinesException {
		if (transaction == null || Util.isNullOREmpty(transaction.getTransactionId()))
			throw new BussinesException(Constants.INVALID_PARAMETERS);
		
		return Util.constructJSON(Constants.APPROVED, true, userService.client(transaction));
	}

	@Override
	public String merchant(@RequestBody Transaction transaction) throws BussinesException {
		if (transaction == null || Util.isNullOREmpty(transaction.getTransactionId()))
			throw new BussinesException(Constants.INVALID_PARAMETERS);
		
		return Util.constructJSON(Constants.APPROVED, true, userService.merchant(transaction));
	}

}
