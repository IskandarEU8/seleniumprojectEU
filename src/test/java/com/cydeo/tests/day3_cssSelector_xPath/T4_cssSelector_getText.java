package com.cydeo.tests.day3_cssSelector_xPath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[value='Reset password']"));
        String actualResetPasswordButtonText = resetPasswordButton.getText();
        String expectedResetPasswordButtonText = "Reset password";

        if (expectedResetPasswordButtonText.equals(actualResetPasswordButtonText)){
            System.out.println("Reset Password Button verification passed");
        }else{
            System.out.println("Reset Password Button verification failed");
        }

        Thread.sleep(2500);

        driver.quit();

    }
}
