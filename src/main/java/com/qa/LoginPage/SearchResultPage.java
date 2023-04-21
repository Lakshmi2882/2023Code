package com.qa.LoginPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.UtilPackage.ElementUtil;

public class SearchResultPage {
	private WebDriver driver;
	private ElementUtil util;
	private By Imagecount=By.cssSelector("div.caption a");
	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
	util=	new ElementUtil(driver);
	}
	public int ProductSearchCount()
	{ 
		int Productcount= util.waitForElementtobeVisible(Imagecount, 30).size();
		System.out.println(Productcount);
		return Productcount;
	}
	
public ProductPage selectMainProduct(String MainProductName)
{
	List<WebElement> products=util.getElements(Imagecount);
	for(WebElement e:products)
	{
	String text=	e.getText();
	if(text.equals(MainProductName))
	{
		e.click();
		break;
	}
	
	}
	return new ProductPage(driver);
}
}
