package com.clearsettle.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clearsettle.domain.User;
import com.clearsettle.idao.IUserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(  locations = { "classpath*:/WEB-INF/rest-servlet.xml"} )
public class Tests {
	
	
	
	  @Autowired
	  private IUserDAO userDAO;
	  
	  @Test
	  public void savePersonTest(){
		  User credential = new User();
		  credential.setPassword("123*-+");
		  credential.setEmail("merchant@test.com");
		  boolean returnVal=userDAO.checkCredential(credential);
		  assertEquals(returnVal,true );
	  }

}
