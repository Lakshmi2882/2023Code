package com.qa.DriverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
		tlDriver.set(new ChromeDriver(option.getChromeOptions()));
	}
	
		else if(browsername.equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				//driver=new FirefoxDriver();
				tlDriver.set(new FirefoxDriver(option.getFirefoxOptions()));
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
