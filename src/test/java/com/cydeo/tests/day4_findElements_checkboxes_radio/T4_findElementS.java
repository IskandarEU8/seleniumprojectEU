package com.cydeo.tests.day4_findElements_checkboxes_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_findElementS {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // we provide extra time for our driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // go to : https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        // locate all the links in the page
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        // print the numbers of the links on the page
        System.out.println("allLinks.size() = " + allLinks.size());

        for (WebElement each : allLinks) {
            System.out.println("Text link: " + each.getText() + " attribute of the link is: " + each.getAttribute("href"));
        }

        Thread.sleep(1500);
        driver.close();

    }
}
