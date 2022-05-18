package com.cydeo.tests.day4_findElements_checkboxes_radio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class T6_StaleElementReferenceException {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://practice.cydeo.com/abtest");

        WebElement cydeoLink = driver.findElement(By.xpath("//a[text() = 'CYDEO']"));

        System.out.println("\n\ncydeoLink = " + cydeoLink.isDisplayed() + "\n\n");

        driver.navigate().refresh();

        cydeoLink = driver.findElement(By.xpath("//a[text() = 'CYDEO']"));

        System.out.println("cydeoLink = " + cydeoLink.isDisplayed());

        Thread.sleep(2000);
        driver.close();

    }
}
