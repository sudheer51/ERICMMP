package org.iit.mmp.patientmodule.tests;

import java.util.HashMap;

import org.iit.mmp.base.HelperClass;
import org.iit.mmp.base.TestBaseClass;
import org.iit.mmp.patientmodule.pages.HomePage;
import org.iit.mmp.patientmodule.pages.LoginPage;
import org.iit.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScheduleAppointmentTests extends TestBaseClass{
	
  
	@Test
	public void validateAppointmentDetails()
	{
		 
		HelperClass helperObj = new HelperClass(driver);
		helperObj.invokeWebApplication("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		LoginPage lPage = new LoginPage(driver);
		lPage.login("ria1","Ria12345");
		helperObj.navigateToAModule("Schedule Appointment");
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		HashMap<String,String> hMap =sPage.scheduleAppointment("Dr.Charlie","15/10/2020");
		HomePage hPage = new HomePage(driver);
		boolean result = hPage.validateAppointmentDetails(hMap);
		Assert.assertTrue(result);
	}
	
	@Test
	public void m1()
	{
		
	}
	  
	 
}
