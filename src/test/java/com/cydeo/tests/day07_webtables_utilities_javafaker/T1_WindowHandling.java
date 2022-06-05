package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T1_WindowHandling {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // 1. Create new test and make setups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test (priority = 1)
    public void windows_handling() {
        // 2. Go to https://www.amazon.com
        driver.navigate().to("https://www.amazon.ca");

        // 3. Copy past the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.ca','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");


//        4. Create a logic to switch to the tab where Etsy.com is open

        Set<String> allWindowsHandlers = driver.getWindowHandles();

        for (String eachWindowsHandler : allWindowsHandlers) {
            driver.switchTo().window(eachWindowsHandler);
            System.out.println("Current URL: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains("etsy")){
                break;
            }
        }
//    5. Assert: Title contains 'Etsy'

        String expectedTitle = "Etsy";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle), "actual title is different than expected title");


    }


    @Test (priority = 2)
    public void windowSwitch(){
        driver.navigate().to("https://kun.uz");

        ((JavascriptExecutor) driver).executeScript("window.open('https://vb.kg','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://kaktus.media','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://daryo.uz/','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.ixbt.com/','_blank');");

        BrowserUtils.sleep(4);

        BrowserUtils.switchWindowAndVerify(driver, "kaktus","Кактус" );

        BrowserUtils.verifyTitle(driver, "Кактус – новости Кыргызстана и Бишкека");
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


}

/*

1. Create new test and make setups
2. Go to https://www.amazon.com
3. Copy past the lines from below into your class
    ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
    ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
    ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");
4. Create a logic to switch to the tab where Etsy.com is open
5. Assert: Title contains 'Etsy'


 */