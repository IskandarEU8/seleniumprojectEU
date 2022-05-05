package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
/*
        WebDriver driver = new FirefoxDriver();
//        driver1.get("https://www.facebook.com");
//        driver1.get("https://www.apple.com");
//        Thread.sleep(1500);
//        driver1.get("https://www.tesla.com/");
//        Thread.sleep(2500);
//        driver1.navigate().back();
//
//        Thread.sleep(2500);
//        driver1.navigate().forward();
//        Thread.sleep(2500);
//        driver1.navigate().to("https://google.com");
        driver.navigate().to("https://kaktus.media");
        String currentTitle = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();

        System.out.println(currentTitle + " : " + currentUrl);
        System.out.println("driver.getTitle() = " + driver.getTitle());

 */

        WebDriver driver1 = new ChromeDriver();

        driver1.navigate().to("https://apple.com");
        String cnnTitle = driver1.getTitle();
        String cnnUrl = driver1.getCurrentUrl();


        System.out.println(cnnTitle + " : " + cnnUrl);
        System.out.println(cnnTitle + " : " + cnnUrl);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("driver.getTitle() = " + driver1.getTitle());

        System.out.println("driver1.getCurrentUrl() = " + driver1.getCurrentUrl());

/*
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");

        WebDriver driver2 = new EdgeDriver();
        driver.get("https://www.facebook.com");

                VIDEO 3:27:00
 */

    }
}
