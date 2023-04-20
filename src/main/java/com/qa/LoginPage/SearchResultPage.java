package com.qa.LoginPage;

import org.openqa.selenium.WebDriver;

import com.qa.UtilPackage.ElementUtil;

public class SearchResultPage {
	private WebDriver driver;
	private ElementUtil util;
	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
	util=	new ElementUtil(driver);
	}
	@Test
	public void searchProductResult(String product)

}
