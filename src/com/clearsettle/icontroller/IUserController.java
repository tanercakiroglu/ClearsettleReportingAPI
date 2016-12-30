package com.clearsettle.icontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clearsettle.domain.User;
import com.clearsettle.exception.BussinesException;
import com.clearsettle.response.domain.CheckCredentialResponse;

public interface IUserController {
	
	@RequestMapping(value="/api/v3/merchant/user/login",method = RequestMethod.POST)
	public @ResponseBody CheckCredentialResponse checkCredentail(User credential) throws BussinesException;
}
