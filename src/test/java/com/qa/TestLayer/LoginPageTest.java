package com.qa.TestLayer;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.UtilPackage.Constants;



public class LoginPageTest extends BaseTest{
	@Test(priority=1)
	public void verifyLoginPageTitle()
	{
	String actTitle=	login.LoginTitle();
	System.out.println("actual page title is: "+actTitle);
	Assert.assertEquals(actTitle, Constants.LOGIN_TITLE);
	}
	@Test(priority=2)
	public void verifyLoginPageURL()
	{
	String actURL=	login.getLoginpageURL();
	System.out.println("actual current url is :"+actURL);
	Assert.assertTrue(actURL.contains(Constants.Login_URL));
	
	}
	@Test(priority=3)
	public void verifyForgotLink()
	{
		Assert.assertTrue(login.ForgotLinkExists());
	}
	@Test(priority=4)
	public void verifyRegisterLink()
	{
		Assert.assertTrue(login.RegisterlinkExists());
	}
@Test(priority=5)
public void verifydoLogin() {
	login.DoLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	
}
}
