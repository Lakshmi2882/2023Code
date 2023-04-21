package com.qa.TestLayer;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.DriverFactory.DriverFactory;
import com.qa.LoginPage.AccountPage;
import com.qa.LoginPage.LoginPage;
import com.qa.LoginPage.ProductPage;
import com.qa.LoginPage.SearchResultPage;

public class BaseTest {
	DriverFactory df;
	Properties prop;
	WebDriver driver;
	LoginPage login;
	AccountPage account;
	SearchResultPage searchresult;
	ProductPage product;
@BeforeTest
public void SetUp()
{	
	df=new DriverFactory();
	prop= df.init_prop();
	driver=df.Init_driver(prop);
	login=new LoginPage(driver);
	
	
	
	
	
}
@AfterTest
public void tearDown()
{
	//driver.quit();
	
}
}
