package com.cydeo.tests.day06_Alerts_iFrames_Windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownTest2 {
    WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void dateSelect() throws InterruptedException {
        Thread.sleep(1200);
        driver.navigate().to("https://practice.cydeo.com/dropdown");
        Select yearSelect = new Select(driver.findElement(By.xpath("//select[@id = 'year']")));
        yearSelect.selectByVisibleText("1923");

        Select monthSelect = new Select(driver.findElement(By.xpath("//select[@id = 'month']")));
        monthSelect.selectByValue("11");

        Select daySelect = new Select(driver.findElement(By.xpath("//select[@id = 'day']")));
        daySelect.selectByIndex(0);
        Thread.sleep(1200);


        // creating expected values
        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        //gettinig actual values
        String actualYear = yearSelect.getFirstSelectedOption().getText();
        String actualMonth = monthSelect.getFirstSelectedOption().getText();
        String actualDay = daySelect.getFirstSelectedOption().getText();

        //create assertions
        Assert.assertEquals(actualYear, expectedYear);
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualDay, expectedDay);
    }





    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1200);
        driver.close();
    }
}
