package com.cydeo.tests.day10_Upload_Actions_JSexecutor;

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
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//        js

        // a. 750 pixels down 10 times
        // b. 750 pixels up 10 times
    }
}
