package com.qa.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.UtilPackage.ElementUtil;

public class LoginPage {
private WebDriver driver;
private ElementUtil util;
 public LoginPage(WebDriver driver)
 {
	 this.driver=driver;
	 util=new ElementUtil(driver);
 }
 //By locators
 By Username= By.id("input-email");
 By Password=By.id("input-password");
 By ForgotPasswordLink=By.linkText("Forgotten Password");
 By RegisterLink=By.linkText("Register");
 By loginbutton=By.xpath("//input[@type='submit']");
 
 
 public String LoginTitle()
 {
String loginpageTitle=	driver.getTitle();
return loginpageTitle;
 }
 public String getLoginpageURL()
 {
	return  driver.getCurrentUrl();
 }
 public boolean ForgotLinkExists()
 {
	return driver.findElement(ForgotPasswordLink).isDisplayed();
 }
 public boolean RegisterlinkExists()
 {
	 return driver.findElement(RegisterLink).isDisplayed();
 }
 public AccountPage DoLogin(String un, String pwd)
 { 
	 System.out.println("Enter username and password: "+ un +":"+pwd);
	 util.doSendKeys(Username,un);
	 util.doSendKeys(Password, pwd);
	 util.doClick(loginbutton);
	return new AccountPage(driver);//This is page chaining
 }
}
