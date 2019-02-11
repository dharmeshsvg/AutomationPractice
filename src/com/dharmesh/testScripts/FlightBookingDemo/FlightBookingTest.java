package com.dharmesh.testScripts.FlightBookingDemo;

import com.dharmesh.testBase.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightBookingTest extends TestBase {
    @BeforeClass
    public void setUp() throws IOException {
        init();
    }

    @Test
    public void BookFlight() throws Exception {
        WebElement flightTab = getWebElement("web.home.flightTabLink");
        flightTab.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement searchFlightFrom = getWebElement("web.home.enterCityFromTextbox");
        searchFlightFrom.click();
        WebElement enterFlightFrom = getWebElement("web.home.enterCityFromTextboxEnterCity");
        enterFlightFrom.sendKeys("RSA");
        WebElement selectFlightFrom = getWebElement("web.home.enterCityFromDropdown");
        selectFlightFrom.click();

        WebElement searchFlightTo = getWebElement("web.home.enterCityToTextbox");
        searchFlightTo.click();
        WebElement enterFlightTo = getWebElement("web.home.enterCityToTextboxEnterCity");
        enterFlightTo.sendKeys("GLT");
        WebElement selectFlightTo = getWebElement("web.home.enterCityToDropdown");
        selectFlightTo.click();

        WebElement DepartureFind = getWebElement("web.home.enableDateTexbox");
        DepartureFind.click();

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 2);
        String dateAfterTwoDays = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(dateAfterTwoDays);

        WebElement dateWidget = getWebElement("web.home.datePickerElement");
        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

        for (WebElement cell : columns) {
            //Select 13th Date
            if (cell.getText().equals(dateAfterTwoDays)) {
                System.out.println(cell.getText());
                cell.click();
                break;
            }
        }

        getWebElement("web.home.totalPassengers").click();
//        WebElement totalPassengersModule=getWebElement("web.home.totalPassengersModuleSelect");
        Select adults= new Select(getWebElement("web.home.totalpassAdult"));
        adults.selectByVisibleText("2");
        Select child= new Select(getWebElement("web.home.totalpassChild"));
        child.selectByVisibleText("3");
        Select infant= new Select(getWebElement("web.home.totalpassInfant"));
        infant.selectByVisibleText("1");
        getWebElement("web.home.totalpassSubmit").click();
        getWebElement("web.home.search").submit();
        Assert.assertEquals(driver.getTitle(),"Flights List");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement bookButton = getWebElement("web.flightlist.bookbutton");
        System.out.println("DS Understand:--->"+"arguments[0].scrollIntoView();");
        js.executeScript("arguments[0].scrollIntoView();", bookButton);
        bookButton.click();

        getWebElement("web.personalDetails.firstname").sendKeys("ds");
        getWebElement("web.personalDetails.lastname").sendKeys("svg");
        getWebElement("web.personalDetails.email").sendKeys("avc@test.com");
        getWebElement("web.personalDetails.confirmemail").sendKeys("avc@test.com");
        getWebElement("web.personalDetails.mobille").sendKeys("7894561230");
        getWebElement("web.personalDetails.Address").sendKeys("abc");
        getWebElement("web.personalDetails.CountryTextboxLink").click();
        getWebElement("web.personalDetails.Country").sendKeys("India");
        getWebElement("web.personalDetails.select").click();

        getWebElement("web.personalDetails.name").sendKeys("test");
        getWebElement("web.personalDetails.age").sendKeys("30");
        getWebElement("web.personalDetails.passportno").sendKeys("123456");
        getWebElement("web.personalDetails.confirmBooking").click();

        getWebElement("web.payment.paynowButton").click();

        Select payMethod = new Select(getWebElement("web.payment.method"));
        payMethod.selectByVisibleText("Credit Card");

    }
}