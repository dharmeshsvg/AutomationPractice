package com.dharmesh.testScripts.TestSuitWithXlsData;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dharmesh.testActions.LoginModule;
import com.dharmesh.testBase.TestBase;

public class TestLoginWithParameterization extends TestBase{
	
	/**
	 * @param Excel name
	 * @param sheet Name
	 * @return
	 * @throws IOException
	 */
	// I have made method(getDate) in test base class by calling all methods from XLS_Reader class for ease to use.
	@DataProvider
	public  Object[][] Data() throws IOException {
		return getData("Login.xlsx","Login");
	}

	@BeforeClass
	public void initBrowser() throws IOException {
		init();
	}

	/**
	 * This test will execute two times. since I have kept data to 2 rows. for first data test will skip since I have made run mode is "N" . for second set it will run
	 * @param TestName
	 * @param userName
	 * @param password
	 * @param runMode
	 * @throws Exception 
	 */
	@Test(dataProvider = "Data")
	public void loginWithParameterization(String TestName, String userName, String password,String runMode) throws Exception {
		
		if(runMode.equals("N")) {
			throw new SkipException("Skipped Test case is");
		}
		
		LoginModule login = new LoginModule();
		login.loginToApplication(userName, password);
		driverwait(2);
		driver.findElement(By.xpath("//a[@class='logout']")).click();
		driverwait(1);
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();

	}
}
