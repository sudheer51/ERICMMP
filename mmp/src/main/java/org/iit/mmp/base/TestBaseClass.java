package org.iit.mmp.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {
	protected WebDriver driver;
	File f;
	FileInputStream fis;
	public static Properties prop ;
	
	@BeforeClass
	@Parameters({"browser"})
	public void createDriverInstance(String browser) throws IOException
	{
		if(browser.equals("CH"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();//Initialization
			loadProperties("Chrome.properties");
			 
		}
		else if(browser.equals("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();//Initialization
			loadProperties("IE.properties");
		}
	}
	public void loadProperties(String fileName) throws IOException
	{
		f  = new File(fileName);
		fis = new FileInputStream(f);
		prop = new Properties();
		prop.load(fis);
	}
}
