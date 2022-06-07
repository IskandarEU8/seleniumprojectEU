package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    /*
    This method will login with helpdesk1@cybertekschool.com user when it is called
     */

    public static void crm_login(WebDriver driver){

        // 2. Enter valid userName
        WebElement inputUserName = driver.findElement(By.xpath("//*[@name = 'USER_LOGIN']"));
        // helpdesk1@cybertekschool.com     UserUser
        // helpdesk2@cybertekschool.com     UserUser
        inputUserName.sendKeys("helpdesk1@cybertekschool.com");

        WebElement userPassword = driver.findElement(By.xpath("//*[@name = 'USER_PASSWORD']"));
        userPassword.sendKeys("UserUser");

        BrowserUtils.sleep(1.5);
        WebElement loginButton = driver.findElement(By.xpath("//input[@class= 'login-btn']"));
        loginButton.click();

    }

    public static void crm_login(WebDriver driver, String userName, String password){

        // 2. Enter valid userName
        WebElement inputUserName = driver.findElement(By.xpath("//*[@name = 'USER_LOGIN']"));
        // helpdesk1@cybertekschool.com     UserUser
        // helpdesk2@cybertekschool.com     UserUser
        inputUserName.sendKeys(userName);

        WebElement userPassword = driver.findElement(By.xpath("//*[@name = 'USER_PASSWORD']"));
        userPassword.sendKeys(password);

        BrowserUtils.sleep(1.5);
        WebElement loginButton = driver.findElement(By.xpath("//input[@class= 'login-btn']"));
        loginButton.click();

    }


}
