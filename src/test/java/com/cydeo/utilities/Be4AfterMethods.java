package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Be4AfterMethods {

    public static void setUp(WebDriver driver, String url){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    public static void tearDown(WebDriver driver, double seconds){
        BrowserUtils.sleep(seconds);
        driver.quit();
    }
}
