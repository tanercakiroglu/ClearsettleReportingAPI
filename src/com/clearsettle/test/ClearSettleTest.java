package com.clearsettle.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clearsettle.domain.Report;
import com.clearsettle.domain.Transaction;
import com.clearsettle.domain.User;
import com.clearsettle.exception.BussinesException;
import com.clearsettle.icontroller.IUserController;
import com.clearsettle.idao.IUserDAO;
import com.clearsettle.iservice.IUserService;
import com.clearsettle.response.domain.CheckCredentialResponse;
import com.clearsettle.response.domain.MerchantResponse;
/**
 * 
 * @author taner cakiroglu
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
public class ClearSettleTest {

	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserController userController;

	@Test
	public void daoCheckCredentialTest() {
		User credential = new User();
		credential.setPassword("123*-+");
		credential.setEmail("merchant@test.com");
		boolean returnVal = userDAO.checkCredential(credential);
		assertEquals(returnVal, true);
	}
	
	@Test
	public void daoCheckCredentialTest1() {
		User credential = new User();
		credential.setPassword("123");
		credential.setEmail("merchant@test.com");
		boolean returnVal = userDAO.checkCredential(credential);
		assertEquals(returnVal, false);
	}

	@Test
	public void serviceCheckCredentialTest() {
		User credential = new User();
		credential.setPassword("123*-+");
		credential.setEmail("merchant@test.com");
		Object returnVal = userService.checkCredential(credential);
		assertTrue(returnVal instanceof CheckCredentialResponse);
	}
	
	@Test(expected=BussinesException.class)
	public void controllerCheckCredentialTest() throws BussinesException {
		User credential = new User();
		credential.setPassword(" ");
		credential.setEmail("merchant@test.com");
		Object returnVal = userController.checkCredentail(credential);
		assertTrue(returnVal instanceof String);
	}

	@Test(expected=BussinesException.class)
	public void controllerCheckCredentialTest1() throws BussinesException {
		User credential = new User();
		credential.setPassword("123*-+");
		credential.setEmail(null);
		Object returnVal = userController.checkCredentail(credential);
		assertTrue(returnVal instanceof String);
	}
	
	@Test
	public void daoMerchantTest() {
		Transaction transaction = new Transaction();
		transaction.setTransactionId("1343242321");
		Object returnVal = userDAO.merchant(transaction);
		assertTrue(returnVal instanceof MerchantResponse);
	}
	
	@Test(expected=BussinesException.class)
	public void controllerMerchantTest() throws BussinesException {
		Transaction transaction = new Transaction();
		transaction.setTransactionId("");
		Object returnVal = userController.merchant(transaction);
		assertTrue(returnVal instanceof MerchantResponse);
	}
	
	@Test(expected=BussinesException.class)
	public void controllerMerchantTest1() throws BussinesException {
		Transaction transaction = new Transaction();
		transaction.setTransactionId(null);
		Object returnVal = userController.merchant(transaction);
		assertTrue(returnVal instanceof MerchantResponse);
	}
	
	@Test(expected=BussinesException.class)
	public void controllerClientTest() throws BussinesException {
		Transaction transaction = new Transaction();
		transaction.setTransactionId("       ");
		Object returnVal = userController.client(transaction);
		assertTrue(returnVal instanceof MerchantResponse);
	}
	
	@Test(expected=BussinesException.class)
	public void controllerReportTest() throws BussinesException {
		Report report = new Report();
		report.setToDate(null);
		report.setFromDate(new Date());
		Object returnVal = userController.report(report);
		assertTrue(returnVal instanceof MerchantResponse);
	}
	
	@Test(expected=BussinesException.class)
	public void controllerReportTest1() throws BussinesException {
		Report report = new Report();
		report.setToDate(new Date());
		report.setFromDate(null);
		Object returnVal = userController.report(report);
		assertTrue(returnVal instanceof MerchantResponse);
	}
	
	@Test(expected=BussinesException.class)
	public void controllerReportTest2() throws BussinesException {
		Object returnVal = userController.report(null);
		assertTrue(returnVal instanceof MerchantResponse);
	}
}
