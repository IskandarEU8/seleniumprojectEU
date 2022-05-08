package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CydeoVerification {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Test started");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://practice.cydeo.com");
        driver.manage().window().maximize();

        String expectedUrlFragment = "cydeo";
        String expectedTitle = "Practice";

        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();

        boolean testPassed = false;


        // check if url contains "cydeo" and title is: "Practice"
        if (actualUrl.contains(expectedUrlFragment) && actualTitle.equals(expectedTitle)){
            testPassed = true;
            System.out.println(actualUrl + " : " + expectedUrlFragment);
            System.out.println("actual title: "+actualTitle + " | expected title: " + expectedTitle);
        } else{
            System.err.println("actual title: "+actualTitle + " | expected title: " + expectedTitle);
            System.err.println(actualUrl + " : " + expectedUrlFragment);
        }

        Thread.sleep(3500);
        driver.quit();

        System.out.println("Test finished successfully: "+testPassed );
    }
}
