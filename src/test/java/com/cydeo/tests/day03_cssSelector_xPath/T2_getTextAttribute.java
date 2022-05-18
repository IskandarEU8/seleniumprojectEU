package com.cydeo.tests.day03_cssSelector_xPath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getTextAttribute {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
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

        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));

        String actualForgotPasswordLinkText = forgotPasswordLink.getText();
        String expectedForgotPasswordLinkText = "FORGOT YOUR PASSWORD?";

        if (actualForgotPasswordLinkText.equals(expectedForgotPasswordLinkText)){
            System.out.println("\nForgot Passsword Verification Passed");
        } else{
            System.err.println("\n\nForgot Password Verification Failed\n");
            System.out.println("actualForgotPasswordLink = " + actualForgotPasswordLinkText);
            System.out.println("expectedForgotPasswordLink = " + expectedForgotPasswordLinkText);;
        }

        String expectedInHrefAttrValue = "forgot_password=yes";
        String actualInHrefAttrValue = driver.findElement(By.className("login-link-forgot-pass")).getAttribute("href");

        if (actualInHrefAttrValue.contains(expectedInHrefAttrValue)){
            System.out.println("\nHREF Attribute value Verification Passed");
        }else{
            System.err.println("\n\nSystem.out.println(\"\\nHREF Attribute value Verification Failed\n");
        }




        Thread.sleep(2500);

        driver.quit();
/*
        label[class='login-item-checkbox-label']
 */

    }
}


// VIDEO 2-36-00