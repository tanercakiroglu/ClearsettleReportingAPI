package com.clearsettle.icontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clearsettle.domain.Report;
import com.clearsettle.domain.Transaction;
import com.clearsettle.domain.User;
import com.clearsettle.exception.BussinesException;

public interface IUserController {
	
	@RequestMapping(value="/v3/merchant/user/login",method = RequestMethod.POST)
	public @ResponseBody String checkCredentail(User credential) throws BussinesException;
	
	
	@RequestMapping(value="/v3/transactions/report",method = RequestMethod.POST)
	public @ResponseBody String report(Report credential) throws BussinesException;
	
	@RequestMapping(value="/v3/client",method = RequestMethod.POST)
	public @ResponseBody String client(Transaction transaction) throws BussinesException;
	
	@RequestMapping(value="/v3/merchant",method = RequestMethod.POST)
	public @ResponseBody String merchant(Transaction transaction) throws BussinesException;
}
