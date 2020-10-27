package org.iit.mmp.patientmodule.pages;
import java.util.HashMap;

import org.iit.mmp.base.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
*PageObjectClass : HomePage.java
*/

public class HomePage {
	private WebDriver driver;
 
	By tableRowXpath =By.xpath(TestBaseClass.prop.getProperty("tableRowXpath")) ;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	public boolean validateAppointmentDetails(HashMap<String,String> hMap)
	{
		boolean result =false;
		String rowText = driver.findElement(tableRowXpath ).getText();
		String appointDetails[]  = rowText.split(" ");
		if	((appointDetails[0].trim().equals(hMap.get("appointmentDate").trim()))
		&&  (appointDetails[1].trim().equals(hMap.get("time").trim()))
		&&  (appointDetails[2].trim().equals(hMap.get("sym").trim()))
		&&  (appointDetails[3].trim().equals(hMap.get("doctorName").trim())))
		{
			result = true;
		}
		return result;
	}

}
