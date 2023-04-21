package com.qa.TestLayer;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.UtilPackage.Constants;

public class ProductPageTest extends BaseTest{
	 @BeforeClass
	   public void ProductInfoSetUp()
	   {  account=login.DoLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		   
	   }
	 @Test(priority=1)
	 public void verifyProductHeader()
	 {
		 searchresult=account.doSearchProduct("MacBook");
			product= searchresult.selectMainProduct("MacBook");
			Assert.assertEquals(product.getProductHeader(),"MacBook");
	 }
@Test(priority=2)
public void verifyProductImageCount()
{searchresult=account.doSearchProduct("MacBook");
product= searchresult.selectMainProduct("MacBook");
	
	Assert.assertEquals(searchresult.ProductSearchCount(), 5);
}
}
