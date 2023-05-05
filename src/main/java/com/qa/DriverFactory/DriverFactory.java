package com.qa.DriverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.UtilPackage.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
public WebDriver driver;
public Properties prop;
public OptionsManager option;
public static String highlight;
public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver> ();

public WebDriver Init_driver(Properties prop)
{  String browsername=prop.getProperty("Browser");
	System.out.println("browser name is: "+browsername);
	highlight=prop.getProperty("highlight");
	option= new OptionsManager(prop);
	if(browsername.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
	//	driver=new ChromeDriver();
		if(Boolean.parseBoolean(prop.getProperty("remote")))
		{
			init_removeDriver("chrome");
		}
		else
		{
		tlDriver.set(new ChromeDriver(option.getChromeOptions()));
		}
	}
	
		else if(browsername.equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				//driver=new FirefoxDriver();
				if(Boolean.parseBoolean(prop.getProperty("remote")))
				{
					init_removeDriver("firefox");
				}
				else
				{
					tlDriver.set(new FirefoxDriver(option.getFirefoxOptions()));
				}
				
			}
		else
		{
			System.out.println("enter correct browser: "+ browsername);
	}
	
	getDriver().manage().deleteAllCookies();
	getDriver().manage().window().maximize();
	getDriver().get(prop.getProperty("Url"));
	return getDriver();
}
private void init_removeDriver(String browser) {
System.out.println("Running test on remote grid server:" +browser);
if(browser.equalsIgnoreCase("chrome"))
{
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(ChromeOptions.CAPABILITY, option.getChromeOptions());
	try {
		tlDriver.set( new RemoteWebDriver(new URL(prop.getProperty("huburl")),option.getChromeOptions()));
	} catch (MalformedURLException e) {
		
		e.printStackTrace();
	}
}
	else
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, option.getFirefoxOptions());
		try {
			tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")),option.getFirefoxOptions()));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	

//This is for get driver
public static WebDriver getDriver()
{
	return tlDriver.get();
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
public String getScreenshot()
{
	File srcFile=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
String path=	System.getProperty("user.dir")+"/screenshot"+System.currentTimeMillis()+".png";
File destination=new File(path);
try {
	FileUtils.copyDirectory(srcFile, destination);
} catch (IOException e) {
	
	e.printStackTrace();
}
return path;

}
}
