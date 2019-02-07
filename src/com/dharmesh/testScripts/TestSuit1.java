package com.dharmesh.testScripts;

import java.io.IOException;

import com.dharmesh.testActions.AddressModule;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dharmesh.testActions.LoginModule;
import com.dharmesh.testBase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(com.dharmesh.customeListner.Listner.class)
public class TestSuit1 extends TestBase {
	ExtentReports report;
	ExtentTest logger;
	@BeforeClass
	public void setUp() throws IOException {
		init();
		report = new ExtentReports(System.getProperty("user.dir")
				+ "\\src\\com\\dharmesh\\screenShot\\LoginTest.html");

	}
	@Test(priority = 1)
	public void testLogin() throws Exception {

		logger = report.startTest("verify web Login functionality");
		logger.log(LogStatus.INFO, "Browser is up and running");

		LoginModule login = new LoginModule();
		login.loginToApplication();
		logger.log(LogStatus.INFO, "Login Is successfull");

		report.endTest(logger);
	}
/*
	@Test(priority = 2)
	@Ignore
	public void testAddAddress() throws Exception {
		logger = report.startTest("verify add Address functionality");
		AddressModule address = new AddressModule();
		address.addAddress();
		logger.log(LogStatus.INFO, "Address Saved successfull");
		report.endTest(logger);
	}
	@Test(priority = 3)
	@Ignore
	public void testDeleteAddress() throws Exception {
		logger = report.startTest("verify delete Address functionality");
		AddressModule address = new AddressModule();
		address.deleteAddress();
		logger.log(LogStatus.INFO, "Address deleted successfull");
		report.endTest(logger);

	}
	@Test(priority = 4)
	@Ignore
	public void testLogout() throws Exception {
		logger = report.startTest("verify logout functionality");
		LoginModule login = new LoginModule();
		login.logoutFromApp();
		logger.log(LogStatus.INFO, "Logout successfull");
		report.endTest(logger);
	}
*/
	@AfterClass
	public void testDown() {
		closeBrowser();
		logger.log(LogStatus.INFO, "Browser Closed Successfull");
		report.flush();
	}
}
