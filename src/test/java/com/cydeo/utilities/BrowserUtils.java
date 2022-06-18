package com.cydeo.utilities;

/*
In this class only general utility methods that are not related to some specific page
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    /*
    This method will accept int (in seconds) and execute Thread.sleep for given duration
     */

    public static void sleep(int seconds) {
        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {

        }
    }

    public static void sleep(double seconds) {
        seconds *= 1000;
        try {
            Thread.sleep((long) seconds);
        } catch (InterruptedException e) {

        }
    }


    /*
    This method accepts 3 arguments.
    Arg1: WebDriver
    Arg2: expectedInUrl: to verify if the URL contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
     */

    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle) {

        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String eachWindowsHandle : allWindowsHandles) {
            driver.switchTo().window(eachWindowsHandle);

            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Current Title: " + driver.getTitle());

            if (driver.getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }

        //Assert: Title contains ***
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle), "actual title doesn't contain \"" + expectedInTitle + "\"");


    }



    /*
    This method accepts a String "expectedTitle" and Asserts if it is true;
     */

    public static void verifyTitle(WebDriver driver, String expectedTitle) {

        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title verification FAILED");

    }

    public static void switchToEnglish(WebDriver driver) {
        WebElement english = driver.findElement(By.xpath("//a[.='English']"));
        english.click();
    }

}
