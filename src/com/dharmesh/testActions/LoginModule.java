package com.dharmesh.testActions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.dharmesh.testBase.TestBase;

public class LoginModule extends TestBase{
	
	public void loginToApplication() throws Exception{
		WebElement signIn = getWebElement("web.login.signinLink");
		Reporter.log("Clicking on sign in tab");
		signIn.click();
		Assert.assertEquals(driver.getTitle(),"Login - My Store");

		WebElement userName = getWebElement("web.login.username");
		Reporter.log("entering userName to the userName textbox");
		if(userName.isEnabled())
		userName.sendKeys(Repository.getProperty("userName"));

		WebElement password = getWebElement("web.login.password");
		Reporter.log("entering password to the password textbox");
		if(password.isEnabled())
		password.sendKeys(Repository.getProperty("password"));

		WebElement loginButton = getWebElement("web.login.loginButton");
		Reporter.log("clicking on login button");
		if(loginButton.isDisplayed())
			loginButton.click();

		Assert.assertEquals(getWebElement("web.loginUser.name").getText(),"John Doe");
	}
	public void logoutFromApp() throws Exception {
		WebElement signOut = getWebElement("web.logout.signOut");
		Reporter.log("Clicking on sign out tab");
		signOut.click();

		WebElement signIn = getWebElement("web.login.signinLink");
		Assert.assertTrue(signIn.isDisplayed());

	}
	public void loginToApplication(String userNameParam, String passwordParam) throws Exception{
		WebElement signIn = getWebElement("web.login.signinLink");
		Reporter.log("Clicking on sign in tab");
		signIn.click();
		Assert.assertEquals(driver.getTitle(),"Login - My Store");


		WebElement userName = getWebElement("web.login.username");
		Reporter.log("entering userName to the userName textbox");
		userName.sendKeys(userNameParam);

		WebElement password = getWebElement("web.login.password");
		Reporter.log("entering password to the password textbox");
		password.sendKeys(passwordParam);
		Reporter.log("clicking on login button");

		getWebElement("web.login.loginButton").click();
		Assert.assertEquals(getWebElement("web.loginUser.name").getText(),"John Doe");

	}

}
