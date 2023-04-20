package com.qa.LoginPage;

import org.openqa.selenium.WebDriver;

import com.qa.UtilPackage.ElementUtil;

public class ProductPage {
private WebDriver driver;
private ElementUtil util;
public ProductPage(WebDriver driver)
{
	this.driver=driver;
	util=new ElementUtil(driver);
}

}
