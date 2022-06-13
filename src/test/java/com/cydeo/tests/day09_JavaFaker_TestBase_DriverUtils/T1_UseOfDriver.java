package com.cydeo.tests.day09_JavaFaker_TestBase_DriverUtils;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_UseOfDriver {
/*
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        //We are getting the browserType dynamically from our configuration.properties file
        String browserType = ConfigurationReader.getProperty("browser");

        System.out.println(browserType);

        // 1. Create new test and make setups
//        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        BrowserUtils.switchToEnglish(driver);

    }

 */

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.getDriver().quit();
    }



    @Test
    public void googleSearchTest(){

        //Driver.getDriver() ==> driver
        String urlPage = ConfigurationReader.getProperty("env");
        Driver.getDriver().get(urlPage);
        BrowserUtils.switchToEnglish(Driver.getDriver());
        String searchKeyword = ConfigurationReader.getProperty("searchValue");
        WebElement googleSearchBox = Driver.getDriver().findElement(By.xpath("//input[@name = 'q']"));
        googleSearchBox.sendKeys(searchKeyword + Keys.ENTER);

        BrowserUtils.sleep(1.2);
        String expectedTitle = ConfigurationReader.getProperty("searchValue")+" - Google Search";
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println(actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle, "Titles didn't match.");

    }
}
