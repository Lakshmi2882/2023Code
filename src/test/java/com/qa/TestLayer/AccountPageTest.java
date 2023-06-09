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
	 
	 @BeforeClass
   public void AccountSetUp()
   {  account=login.DoLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	   
   }
	@Test(priority=1)
	public void  verifyAccountPageTitle()
	{
		String accTitle=account.AccountTitle();
		Assert.assertEquals(accTitle,Constants.Account_Title);
	}
	@Test(priority=2)
	public void verifyAccountsectionList()
	{
	List<String> ACSL=	account.AccountsectionList();
	assertEquals(ACSL, Constants.AccountList());
	}
	@Test(priority=3)
	public void verifyAccountsearchbar()
	{
		Assert.assertTrue(account.AccountsearchtextbarExist());
	}
	@Test(priority=4)
	public void verifyAccountsearchIconExist()
	{
		Assert.assertTrue(account.AccountsearchtextbarExist());
	}
	@Test(priority=5)
	public void verifyAccountRighthandsideList()
	{
	List<String> ARHL=account.AccountRighthandsidelist();
	Assert.assertEquals(ARHL,Constants.RHListValues());
	}
	@Test(priority=6)
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
	@Test(priority=7,dataProvider="productData")
	public void searchTest(String productName)
	{
	searchresult=	account.doSearchProduct(productName);
	Assert.assertTrue(searchresult.ProductSearchCount()>0);
	}
	@DataProvider
	public Object[][] productMainData()
	{
		return new Object[][]
				{
			{"iMac", "iMac"},
			{"Apple", "Apple Cinema 30\""},
			{"MacBook","MacBook"},
				};
				
				
				
	}
	@Test(priority=8, dataProvider="productMainData")
	public void productresult(String Mainproductname, String productname)
	{
		 searchresult=account.doSearchProduct(productname);
		product= searchresult.selectMainProduct(Mainproductname);
		Assert.assertEquals(product.getProductHeader(),Mainproductname);
	}
	}

