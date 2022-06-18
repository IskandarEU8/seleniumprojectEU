package com.cydeo.tests.day11_DriverClose_Acrions_JSExecutorPractice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_Scroll_JSExecutor {

    //1- Open a Chrome browser
    //2- Go to: https://practice.cydeo.com/large
    @Test
    public void test7_scroll_test() {
        Driver.getDriver().get("https://practice.cydeo.com/large");

        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));

        //Down-casting our driver type to JavascriptExecutor,
        // so we are able to use the methods coming from that interface

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //3- Scroll down to “Cydeo” link
        js.executeScript("arguments[0].scrollIntoView(true)", cydeoLink, homeLink);
        BrowserUtils.sleep(1);


        //4- Scroll up to “Home” link
        js.executeScript("arguments[0].scrollIntoView(true)",  homeLink);
        //js.executeScript("arguments[1].scrollIntoView(true)", cydeoLink, homeLink);
        //objects
        //cydeoLink 0
        //homeLink 1
        //someOtherLink 2

        //JavaScript method to use : arguments[0].scrollIntoView(true)


        Driver.quitDriver(2);
    }
}