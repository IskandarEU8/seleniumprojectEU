package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {
    public static void main(String[] args) throws InterruptedException {

        String expectedTitle = "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";
        String actualTitle;
        System.out.println("Test started");
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();


        driver.get("https://yahoo.com");
        driver.manage().window().maximize();


        actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Verification successful");
            System.out.println("Actual   output: " + actualTitle);
            System.out.println("Expected output: " + expectedTitle);
        }else{
            System.out.println("Verification unsuccessful");
            System.out.println("Actual   output: " + actualTitle);
            System.err.println("Expected output: " + expectedTitle);
        }
        Thread.sleep(1500);
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();

        System.out.println("test finished");


    }


}
