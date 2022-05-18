package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkedTextPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.cydeo.com");

        driver.manage().window().maximize();

        Thread.sleep(2500);
//        driver.findElement(By.linkText("A/B Testing")).click();
        WebElement abTestLink = driver.findElement(By.linkText("A/B Testing"));
        abTestLink.click();

        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();

        System.out.println(actualTitle);
        if (actualTitle.equals(expectedTitle)){
            System.out.println("First verification was successful");
        }else {
            System.err.println("First verification wasn't successful");
            System.err.println(actualTitle + " : " + expectedTitle);
        }
        Thread.sleep(2500);
        driver.navigate().back();

        String expectedTitle2 = "Practice";
        actualTitle = driver.getTitle();



        if (actualTitle.equals(expectedTitle2)){
            System.out.println("Second verification was successful");
        }else {
            System.err.println("Second verification wasn't successful");
        }
        String getText =  driver.findElement(By.linkText("A/B Testing")).getText();
        System.out.println(getText);
    }
}
//14915