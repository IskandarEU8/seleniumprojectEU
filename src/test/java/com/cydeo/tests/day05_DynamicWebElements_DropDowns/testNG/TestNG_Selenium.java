package com.cydeo.tests.day05_DynamicWebElements_DropDowns.testNG;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void tearDownMethod(){
        driver.quit();
    }


    @Test
    public void selenium_test() throws InterruptedException {

        driver.get("https://google.com");

        Assert.assertEquals(driver.getTitle(), "Google", "Title is not matching");

        Thread.sleep(1300);

        driver.quit();
    }
}
