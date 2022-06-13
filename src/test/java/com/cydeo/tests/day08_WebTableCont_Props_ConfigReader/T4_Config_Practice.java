package com.cydeo.tests.day08_WebTableCont_Props_ConfigReader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_Config_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        //We are getting the browserType dynamically from our configuration.properties file
        String browserType = ConfigurationReader.getProperty("browser");
        String urlPage = ConfigurationReader.getProperty("env");
        System.out.println(browserType);

        // 1. Create new test and make setups
//        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(urlPage);

    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }



    @Test
    public void googleSearchTest(){

        String searchKeyword = ConfigurationReader.getProperty("searchValue");
        WebElement googleSearchBox = driver.findElement(By.xpath("//input[@name = 'q']"));
        googleSearchBox.sendKeys(searchKeyword + Keys.ENTER);

        BrowserUtils.sleep(1.2);
        String expectedTitle = "apple - Google'da Ara";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle, "Titles didn't match.");

    }



}
