package com.cydeo.tests.day03_cssSelector_xPath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_locators_getText {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Test started");

        driver.get("https://login1.nextbasecrm.com/");
        WebElement userName = driver.findElement(By.className("login-inp"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("admin");

        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.className("errortext"));

        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = errorMessage.getText();

        Thread.sleep(1500);

        if (actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Negative test passed");
        }else{
            System.err.println("Negative test failed: " + errorMessage);
        }




        Thread.sleep(10000);
        driver.quit();
        System.out.println("Test finished");


    }
}
