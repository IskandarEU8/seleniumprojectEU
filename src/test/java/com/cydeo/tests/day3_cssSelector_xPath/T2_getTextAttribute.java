package com.cydeo.tests.day3_cssSelector_xPath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getTextAttribute {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com");

//        WebElement rememberMeLabel = driver.findElement(By.id("USER_REMEMBER"));
        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));

        String actualRememberMeLabel = rememberMeLabel.getText();
        String expectedRememberMeLabel = "Remember me on this computer";

        if (actualRememberMeLabel.equals(expectedRememberMeLabel)){
            System.out.println("\nLabel verification passed\n");
        }else {
            System.err.println("\n---------------------------------\n Label verification failed");
        }

        rememberMeLabel.click();

        Thread.sleep(2500);

        driver.quit();


    }
}
