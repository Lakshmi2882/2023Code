package com.qa.LoginPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.UtilPackage.ElementUtil;

public class AccountPage {
	private WebDriver driver;
	private ElementUtil util;
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		util=new ElementUtil(driver);
		
	}
By header=	By.xpath("//div[@id='logo']");
By sectionList=By.cssSelector("div #content h2");
By Barlist= By.xpath("//div[@class='container']//nav//ul");
By searchtextbar= By.name("search");
By searchIcon=By.xpath("//span//button[@type='button']");
By RighthandSidelist=By.xpath("//div[@class='list-group']//a");
public String AccountTitle()
{
	return util.doGetTitle();
}

public List<String> AccountsectionList()
{
	List<WebElement> seclist= util.getElements(sectionList);
	ArrayList<String> sl= new ArrayList<String>();
	for(WebElement e:seclist)
	{ String text= e.getText();
	sl.add(text);
		
	}
	return sl;
}
public List<String> getAccountPageBarList()
{
	List<WebElement> AccountBarlist=util.getElements(Barlist);
	ArrayList<String> Bl=new ArrayList<String>();
	for(WebElement e:AccountBarlist)
	{
		String text=e.getText();
		Bl.add(text);
	}
	return Bl;
}
public boolean AccountsearchtextbarExist()
{
	return util.doIsDisplayed(searchtextbar);
}
public boolean AccountsearchiconExist()
{
	return util.doIsDisplayed(searchIcon);
}
public List<String> AccountRighthandsidelist()
{
List<WebElement> RHL=	util.getElements(RighthandSidelist);
ArrayList<String>RHList=new ArrayList<String>();
for(WebElement e:RHL)
{
	String text=e.getText();
	RHList.add(text);
}
return RHList;
}
public SearchResultPage doSearchProduct(String ProductName)
{
	System.out.println("Product is:"+ ProductName);
	util.doSendKeys(searchtextbar, ProductName);
	util.doClick(searchIcon);
	//return ProductPage(driver);
	return new SearchResultPage(driver);
}


}
