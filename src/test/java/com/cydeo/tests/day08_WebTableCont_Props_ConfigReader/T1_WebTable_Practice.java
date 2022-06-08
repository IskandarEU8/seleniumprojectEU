package com.cydeo.tests.day08_WebTableCont_Props_ConfigReader;

/*
1. go to https://practice.cydeo.com/web-tables
2. Verify Bob's name is listed as expected
Expected: `Bob Martin`
3. Verify Bob Martin's order date is as expected
expected `12/31/2021`
 */

import com.cydeo.utilities.Be4AfterMethods;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setupConnection(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }



    @Test (priority = 1)
    public void bobsNameIsListed(){
        WebElement bobMartinsName = driver.findElement(By.xpath("//table[@id = 'ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
//        WebElement bobMartinsName = driver.findElement(By.xpath("//*[.='Bob Martin']"));
        String expectedBobName = "Bob Martin";
        String actualBobName = bobMartinsName.getText();

        Assert.assertEquals(actualBobName, expectedBobName,"Bob's actual and expected names do not match");

        bobMartinsName.isDisplayed();
        System.out.println(bobMartinsName.getText());
    }

    @Test (priority = 2)
    public void verifyOrderDate(){
        WebElement orderDate = driver.findElement(By.xpath("//table[@id = 'ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));
//        WebElement orderDate = driver.findElement(By.xpath("//*[.='12/31/2021']"));
        String actualOrderDate = orderDate.getText();
        String expectedOrderDate = "12/31/2021";

        System.out.println("actualOrderDate = " + actualOrderDate);

        Assert.assertEquals(actualOrderDate, expectedOrderDate, "Dates do not match");
    }



}
//30.30