package com.tieto.test;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.tieto.base.WebDriverWrapper;
import com.tieto.pages.DashboardPage;
import com.tieto.pages.LoginPage;
import com.tieto.pages.PatientFinderPage;

public class AddPatientTest extends WebDriverWrapper {
		
	@Test
	public void createPatientTest() throws InterruptedException
	{
		LoginPage login =new LoginPage(driver);	
		login.enterUsername("admin");
		login.enterPassword("pass");
		login.selectLanguageByText("English (Indian)");
		login.clickOnLogin();
		
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.mouseHoverOnPatientClient();
		dashboardPage.clickOnPatients();
		
		PatientFinderPage patientFinder=new PatientFinderPage(driver);
		patientFinder.switchToFrameWithFin();
		
		Thread.sleep(5000);
		driver.findElement(By.id("create_patient_btn1")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("pat");
		Thread.sleep(5000);
		driver.findElement(By.id("form_fname")).sendKeys("gugan");
		driver.findElement(By.id("form_lname")).sendKeys("gugan");
		driver.findElement(By.id("DOB")).sendKeys("2020-07-02");
		//fill the patient 
		// verify 
	}

}
