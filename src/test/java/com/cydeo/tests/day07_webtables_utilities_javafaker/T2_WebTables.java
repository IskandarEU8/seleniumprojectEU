package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T2_WebTables {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // 1. Create new test and make setups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void windows_handling() throws InterruptedException {
        driver.get("https://practice.cydeo.com/dropdown");

        WebElement mayMonth = driver.findElement(By.xpath("(//option [@value = 4])[1]"));
        mayMonth.click();

        WebElement year1962 = driver.findElement(By.xpath("//*[@id='year']/option[61]"));
        year1962.click();
        Thread.sleep(1000);

//        WebElement marchMonth = driver.findElement(By.xpath("(//option[@value=2])[2]"));
        WebElement marchMonth = driver.findElement(By.xpath("//option[@value=4]/preceding-sibling::option[2]"));
        marchMonth.click();
        Thread.sleep(1000);

        WebElement dayEight = driver.findElement(By.xpath("//*[@id='day']/option[8]"));
        dayEight.click();

        Thread.sleep(1000);

        WebElement year1985 = driver.findElement(By.xpath("//*[@id='year']/option[38]"));
        year1985.click();
        Thread.sleep(1000);


        WebElement septemberMonth = driver.findElement(By.xpath("//option[@value=4]/following-sibling::option[4]"));
        septemberMonth.click();
        Thread.sleep(1000);

        WebElement dayTwentyFour = driver.findElement(By.xpath("//*[@id='day']/option[24]"));
        dayTwentyFour.click();
        Thread.sleep(1000);



    }



    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }






}
