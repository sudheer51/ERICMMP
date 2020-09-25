package org.iit.mmp.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {
	protected WebDriver driver;
	@BeforeClass
	public void createDriverInstance()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();//Initialization
	}

}
