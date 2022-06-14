package com.cydeo.tests.day10_Upload_Actions_JSexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T4_JavascriptExecutor {

    @Test
    public void javascript_test1(){
        // Task: Scroll using JavascriptExecutor
        // 1. Open Chrome browser
        // 2. Navigate to: https:// practice.cydeo.com/infinite_scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        // 3. Use below JavaScript method and scroll
//        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.scroll(0, 750)");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


        // a. 750 pixels down 10 times
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");
        }


        // b. 750 pixels up 10 times
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-750)");
        }

        Driver.quitDriver(2);
    }
}
