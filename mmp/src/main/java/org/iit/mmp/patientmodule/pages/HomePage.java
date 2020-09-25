package org.iit.mmp.patientmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;
 
	By tableRowXpath =By.xpath("//table[@class='table']//tr[1]/td[1]") ;
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
