package com.qa.TestLayer;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.LoginPage.AccountPage;
import com.qa.UtilPackage.Constants;

public class AccountPageTest extends BaseTest {
	 
	 @BeforeTest
   public void AccountSetUp()
   {  account=login.DoLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	   
   }
	@Test
	public void  verifyAccountPageTitle()
	{
		String accTitle=account.AccountTitle();
		Assert.assertEquals(accTitle,Constants.Account_Title);
	}
	@Test
	public void verifyAccountsectionList()
	{
	List<String> ACSL=	account.AccountsectionList();
	assertEquals(ACSL, Constants.AccountList());
	}
	@Test
	public void verifyAccountsearchbar()
	{
		Assert.assertTrue(account.AccountsearchtextbarExist());
	}
	@Test
	public void verifyAccountsearchIconExist()
	{
		Assert.assertTrue(account.AccountsearchtextbarExist());
	}
	@Test
	public void verifyAccountRighthandsideList()
	{
	List<String> ARHL=account.AccountRighthandsidelist();
	Assert.assertEquals(ARHL,Constants.RHListValues());
	}
	@Test
	public void verifyAccountBarList() {
		List<String> bar=account.getAccountPageBarList();
		Assert.assertEquals(bar, Constants.Barlist());
	}
	@DataProvider
	public Object[][] productData()
	{ // it will return two dimensional array which are rows and columns
		return new Object[][] {
			{"Mac Book"},
			{"Apple"},
			{"Samsung"},
		};
			
			
		}
	@Test(dataProvider="ProductData")
	public void searchTest(String productName)
	{
	searchresult=	account.doSearchProduct(productName);
	}
	}

