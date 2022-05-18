package com.cydeo.tests.day4_findElements_checkboxes_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class T6_StaleElementReferenceException {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://practice.cydeo.com/abtest");

        WebElement cydeoLink = driver.findElement(By.xpath("//a[@text() = 'CYDE']"));

        driver.navigate().refresh();

        System.out.println("cydeoLink = " + cydeoLink.isDisplayed());


    }
}
