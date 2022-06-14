package com.cydeo.tasks.day05;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementReferenceException_Handling {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2500);
        driver.quit();
    }


    @Test
    public void staleElementReferenceExceptionHandling(){

//        1. Open Chrome browser
//        2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.navigate().to("https://practice.cydeo.com/add_remove_elements/");
        BrowserUtils.sleep(1.2);

//        3. Click to “Add Element” button
        WebElement addElementButton = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElementButton.click();

//        4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
        Assert.assertTrue(deleteButton.isDisplayed());

//        5. Click to “Delete” button.
        deleteButton.click();

//        6. Verify “Delete” button is NOT displayed after clicking.
        try{
            System.out.println("Delete button is displayed. " + deleteButton.isDisplayed());
        }catch (StaleElementReferenceException e){
            System.out.println("Delete button is completely deleted");
        }

    }





}
/*
XPATH PRACTICES
DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #1: StaleElementReferenceException handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/add_remove_elements/
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */