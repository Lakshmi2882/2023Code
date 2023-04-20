package com.qa.DriverFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
public WebDriver driver;
public Properties prop;
public static String highlight;
public WebDriver Init_driver(Properties prop)
{  String browsername=prop.getProperty("Browser");
	System.out.println("browser name is: "+browsername);
	if(browsername.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
		else if(browsername.equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
		else
		{
			System.out.println("enter correct browser: "+ browsername);
	}
	highlight=prop.getProperty("highlight");
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get(prop.getProperty("Url"));
	return driver;
}
public Properties init_prop()
{
	prop=new Properties();
	try {
		FileInputStream ip=new FileInputStream("C:\\Users\\eddan\\eclipse-workspace\\OpenCartAutomation1\\src\\test\\resourced\\Configfile");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return prop;
}
}
