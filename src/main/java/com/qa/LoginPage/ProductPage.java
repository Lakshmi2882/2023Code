package com.qa.LoginPage;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.UtilPackage.ElementUtil;

public class ProductPage {
private WebDriver driver;
private ElementUtil util;
private HashMap<String,String> productinfo;
public ProductPage(WebDriver driver)
{
	this.driver=driver;
	util=new ElementUtil(driver);
}
private By ProductHeader=By.cssSelector("div h1");
private By Imagecount=By.cssSelector("ul.thumbnails img");
private By productMetaData=By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
private By productpricelist=By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
private By Quantity=By.className("quantity");
public String getProductHeader()
{
	String text=util.getElement(ProductHeader).getText();
	System.out.println(text);
	return text;
}
public int ProductImageCount()
{
	int Images=util.getElements(Imagecount).size();
	System.out.println(Images);
	return Images;
}
public void productInfoMap()
{
 productinfo=new HashMap<String,String>();
 getProductHeader();
 getProductMetaData();
 getProductPriceData();
}
//Encapsulation
private void getProductMetaData()
{
	List<WebElement> productmetadatalist=util.getElements(productMetaData);
	for(WebElement e:productmetadatalist)
	{
	String text=	e.getText();
	String meta[]=text.split(":");
	String metakey=meta[0].trim();
	String metaValue=meta[1].trim();
	productinfo.put(metakey, metaValue);
	}
}
private void getProductPriceData()
{
	List<WebElement> productprice=util.getElements(productpricelist);
	//$602.00
	//Ex Tax: $500.00
	for(WebElement e:productprice)
	{   String text=e.getText();
		productinfo.put("price", text);
	}
}
}
