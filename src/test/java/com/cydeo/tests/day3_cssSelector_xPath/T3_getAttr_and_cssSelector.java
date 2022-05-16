package com.cydeo.tests.day3_cssSelector_xPath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttr_and_cssSelector {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com");
        WebElement loginButton = driver.findElement(By.className("login-btn"));
//        String actualButtonText = loginButton.getAttribute("value");

//        WebElement signInButton = driver.findElement(By.cssSelector("input[class='login-btn'"));
//        WebElement signInButton = driver.findElement(By.cssSelector("input[type='submit'"));

        WebElement signInButton = driver.findElement(By.cssSelector("input[value='Log In']"));
        String  actualButtonText = signInButton.getAttribute("value");

        String expectedButtonText = "Log In";

        if (expectedButtonText.equals(actualButtonText)){
            System.out.println("Log in button text verification passed");
        }else{
            System.out.println("Log in button text verification failed");
        }



        Thread.sleep(2500);

        driver.quit();

    }
}
