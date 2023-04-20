package com.qa.UtilPackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.DriverFactory.DriverFactory;

public class ElementUtil {
	private WebDriver driver;
	private JSUtil jsutil;
public ElementUtil(WebDriver driver)
{
	this.driver=driver;
	jsutil = new JSUtil(driver);
}
public By locators(String locatorType, String locatorValue)
{
	By locator=null;
	switch(locatorType)
	{
	case "id":
		locator= By.id(locatorValue);
		break;

	case "name":
		locator=By.name(locatorValue);
		break;
	case "className":
		locator=By.className(locatorValue);
		break;
	case "linkText":
		locator=By.linkText(locatorValue);
		break;
	case "partialLinkText" :
		locator=By.partialLinkText(locatorValue);
		break;
	case "xPath":
		locator=By.xpath(locatorValue);
		break;
	case "cssSelector":
		locator=By.cssSelector(locatorValue);
		break;
	case "TagName":
		locator=By.tagName(locatorValue);
		break;
	default:
		System.out.println("enter correct locator: "+ locator);
		break;
	
	}
	return locator;
}
public WebElement getElement(By locator)
{
	WebElement element= driver.findElement(locator);
	if(Boolean.parseBoolean(DriverFactory.highlight.trim()));
	{
	jsutil.flash(element);
	}
	return element;
	
}
public WebElement getElement(String locatorType,String locatorValue)
{
	return driver.findElement(locators(locatorType,locatorValue));
}
public List<WebElement> getElements(By locator)
{
	return driver.findElements(locator);
}
public void doSendKeys(By locator, String value)
{
	WebElement ele=getElement(locator);
	ele.clear();
	ele.sendKeys(value);
}
public void doClick(By locator)
{
	 getElement(locator).click();
}
public String doGetTitle()
{
	 return driver.getTitle();
}
public String doGetText(By locator)
{
	return getElement(locator).getText();
}
public String doGetAttribute(By locator,String attName)
{
	return getElement(locator).getAttribute(attName);
}
public boolean doIsDisplayed(By locator)
{
	return getElement(locator).isDisplayed();
}
public boolean doIsEnabled(By locator)
{
	return getElement(locator).isEnabled();
}
public void clickOnElement(By locator, String value)
{
	List<WebElement> eleList=getElements(locator);
	System.out.println(eleList.size());
	for(WebElement ele:eleList)
	{
		if(ele.getText().equals(value))
				{
			ele.click();
			break;
				}
	}
}
public List<String> getLinksTextList(By locator)
{
	List<String> eleTextList= new ArrayList<String>();
	List<WebElement> eleList=getElements(locator);
	System.out.println("elements are :" +eleList.size());
	for(WebElement e:eleList)
	{
	String text=e.getText();
	if(!text.isEmpty())
	{
		eleTextList.add(text);
	}
	}
	return eleTextList;
}
public boolean isElementExist(By locator)
{
	List<WebElement> lists=getElements(locator);
	if(lists.size()>0)
	{
		System.out.println("element is present");
		return true;
	}
	else
	{
		System.out.println("element is not present");
		return false;
	}
}
//Selectors for DropDown list
public void doSelectByVisibleText(By locator, String text)
{
	Select select= new Select(getElement(locator));
 	select.selectByVisibleText(text);
}
public void doSelectByValue(By locator, String text)
{
	Select select=new Select(getElement(locator));
	select.deselectByValue(text);
}
public void doSelectByIndex(By locator, int i)
{
	Select select=new Select(getElement(locator));
	select.selectByIndex(i);
}
public void getDropdownOptionsList(By locator)
{
	List<String> optionsList=new ArrayList<String>();
	Select select=new Select(getElement(locator));
	List<WebElement> options= select.getOptions();
	System.out.println(options.size());
	for(WebElement e:options)
	{
	String text=	e.getText();
	optionsList.add(text);
	}
}
public void selectDropDownValue(By locator, String value)
{
	Select select=new Select(getElement(locator));
	List<WebElement> options=select.getOptions();
	System.out.println(options.size());
	for(WebElement e:options)
	{
	String text=	e.getText();
	if(text.equals(value))
	{
		e.click();
		break;
	}
	}
}
public void clickDropDownValue(By locator, String value)
{
	List<WebElement> listofElements=getElements(locator);
	for(WebElement e: listofElements)
	{
	String text=	e.getText();
	if(text.equals(value))
	{
		e.click();
		break;
	}
	}
}
public void doActionSendKeys(By locator, String value)
{
	Actions act=new Actions(driver);
	act.sendKeys(getElement(locator), value).perform();
}
public void doActionsClick(By locator)
{
	Actions act=new Actions(driver);
	act.click(getElement(locator)).perform();
}
public Alert waitForAlert(int timeout)
{
	WebDriverWait wait=new WebDriverWait(driver, timeout);
	return wait.until(ExpectedConditions.alertIsPresent());
}
public String getAlertText(int timeout)
{
	String text=waitForAlert(timeout).getText();
	acceptAlert(timeout);
	return text;
}
public void acceptAlert(int timeOut)
{
	waitForAlert(timeOut).accept();;
}
public void DismissAlert(int timeout)
{
	waitForAlert(timeout).dismiss();;
}
public void sendKeysOnAlert(int timeout,String value)
{
	waitForAlert(timeout).sendKeys(value);
}
public String waitForTitleContains(String titleValue,int timeout)
{
	WebDriverWait wait=new WebDriverWait(driver,timeout);
	if(wait.until(ExpectedConditions.titleContains(titleValue)))
			{
		return driver.getTitle();
			}
	return null;
}

}
