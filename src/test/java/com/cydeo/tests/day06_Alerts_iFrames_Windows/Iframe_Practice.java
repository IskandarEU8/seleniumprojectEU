package com.cydeo.tests.day06_Alerts_iFrames_Windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Iframe_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setupConnection(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://practice.cydeo.com/iframe");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1400);
        driver.close();
    }

    @Test
    public void iframe_test(){

// We need to switch driver's focus to iframe:
        driver.switchTo().frame("mce_0_ifr");

// locate the p tag
        WebElement yourContentGoesHere = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(yourContentGoesHere.isDisplayed());
    }

}
