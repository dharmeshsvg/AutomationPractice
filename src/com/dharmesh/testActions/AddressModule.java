package com.dharmesh.testActions;

import com.dharmesh.testBase.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class AddressModule extends TestBase {
    public void addAddress() throws Exception{

        WebElement addressTab = getWebElement("web.address.addressLink");
        Reporter.log("Clicking on Address tab");
        addressTab.click();

        WebElement addNewAddressButton = getWebElement("web.address.addNewAddressButton");
        Reporter.log("Clicking on Add a New Address Button");
        addNewAddressButton.click();

        WebElement firstName = getWebElement("web.address.firstName");
        firstName.clear();
        Reporter.log("entering firstName to the FirstName textbox");
        firstName.sendKeys("Dharmesh");

        WebElement lastName = getWebElement("web.address.lastName");
        lastName.clear();
        Reporter.log("entering lastName to the LastName textbox");
        lastName.sendKeys("Suvagiya");

        WebElement company = getWebElement("web.address.company");
        Reporter.log("entering companyName to the company textbox");
        company.sendKeys("Altimetrik");

        WebElement address1 = getWebElement("web.address.address1");
        Reporter.log("entering address to the address1 textbox");
        address1.sendKeys("Dobariya Wadi");

        WebElement address2 = getWebElement("web.address.address2");
        Reporter.log("entering address to the address2 textbox");
        address2.sendKeys("AmarNagar Road");

        WebElement city = getWebElement("web.address.city");
        Reporter.log("entering city to the City textbox");
        city.sendKeys("Jetpur");

        WebElement state = getWebElement("web.address.state");
        Reporter.log("Selecting state from drop down ");
        seleteDropDownValue(state,"Alaska");

        WebElement zip = getWebElement("web.address.zip");
        Reporter.log("entering postal code to the postal textbox");
        zip.sendKeys("12345");

        WebElement country = getWebElement("web.address.country");
        Reporter.log("Selecting country from drop down ");
        seleteDropDownValue(country,"United States");

        WebElement homePhone = getWebElement("web.address.homePhone");
        Reporter.log("entering homePhone info to the HomePhone textbox");
        homePhone.sendKeys("1234567890");

        WebElement mobilePhone = getWebElement("web.address.mobilePhone");
        Reporter.log("entering mobilePhone info to the MobilePhone textbox");
        mobilePhone.sendKeys("1234567890");

        WebElement addInfo = getWebElement("web.address.additionalInfo");
        Reporter.log("entering additional info to the AdditionalInfo textbox");
        addInfo.sendKeys("test");

        WebElement addTitle = getWebElement("web.address.addressTitle");
        addTitle.clear();
        Reporter.log("entering title address info to the title textbox");
        addTitle.sendKeys("Dharmesh Home Address");

        WebElement submit = getWebElement("web.address.saveButton");
        Reporter.log("Submitting address info");
        submit.click();

        WebElement addressTitleAfterAdd = getWebElement("web.address.addressTitleAfterAdd");

        if(addressTitleAfterAdd.isDisplayed()) {
            Reporter.log("Address Saved successfully");
        }
        else
        {
           Reporter.log("Address doesn't Saved successfully");
           Assert.assertTrue(addressTitleAfterAdd.isDisplayed());
        }
    }
    public void deleteAddress() throws Exception{
        WebElement deleteAddr = getWebElement("web.address.deleteButton");
        Reporter.log("Clicking on delete button");
        deleteAddr.click();

        Alert alert = driver.switchTo().alert();
        Reporter.log("accepting alert successfully");
        alert.accept();

        Reporter.log("address deleted successfully");

        if(driver.getPageSource().contains("Dharmesh Home Address")) {
            Assert.assertFalse(true);
            Reporter.log("address deleted successfully");
        }
        else {
            Reporter.log("address deleted successfully");
        }

    }
}
