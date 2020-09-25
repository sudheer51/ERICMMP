package org.iit.mmp.patientmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ScheduleAppointmentPage {
	private WebDriver driver;
	private By datePickerID = By.id("datepicker");
	
	private By timeID = By.id("time");
	private By continueButton= By.id("ChangeHeatName");
	private By symID = By.id("sym");
	public ScheduleAppointmentPage(WebDriver driver) {
		 
		 this.driver = driver;
	}

	public HashMap<String, String> scheduleAppointment(String doctorName,String appointmentDate)
	{
	 
		HashMap<String,String> hMap = new HashMap<String,String>();
		hMap.put("doctorName", doctorName);
		hMap.put("appointmentDate", appointmentDate);
		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
		driver.findElement(By.xpath("//h4[text()='"+doctorName+"']/ancestor::ul/following-sibling::button")).click();
		driver.switchTo().frame("myframe");
		driver.findElement(datePickerID).sendKeys(appointmentDate);
		Select time = new Select(driver.findElement(timeID));
		time.selectByValue("11Am");
		hMap.put("time", "11Am");
		driver.findElement(continueButton).click();
		driver.findElement(symID).sendKeys("Fever and Cold");
		hMap.put("sym", "Fever and Cold");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		return hMap;
	}

}
