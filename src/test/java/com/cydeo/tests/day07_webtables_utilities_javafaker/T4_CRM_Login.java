package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_CRM_Login {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // 1. Create new test and make setups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }


    @Test
    public void crm_login_test(){

        // 1. go to: https://login1.nextbasecrm.com
        driver.get("https://login1.nextbasecrm.com");
/*
        // 2. Enter valid userName
        WebElement userName = driver.findElement(By.xpath("//*[@name = 'USER_LOGIN']"));
        // helpdesk1@cybertekschool.com     UserUser
        // helpdesk2@cybertekschool.com     UserUser
        userName.sendKeys("helpdesk1@cybertekschool.com");

        WebElement userPassword = driver.findElement(By.xpath("//*[@name = 'USER_PASSWORD']"));
        userPassword.sendKeys("UserUser");


        BrowserUtils.sleep(1.5);
        WebElement loginButton = driver.findElement(By.xpath("//input[@class= 'login-btn']"));
        loginButton.click();

 */
        CRM_Utilities.crm_login(driver);

        BrowserUtils.verifyTitle(driver,"Portal");

    }


    @Test
    public void crm_login_test2(){

        driver.get("https://login1.nextbasecrm.com");
/*
        // 2. Enter valid userName
        WebElement userName = driver.findElement(By.xpath("//*[@name = 'USER_LOGIN']"));
        // helpdesk1@cybertekschool.com     UserUser
        // helpdesk2@cybertekschool.com     UserUser
        userName.sendKeys("helpdesk2@cybertekschool.com");

        WebElement userPassword = driver.findElement(By.xpath("//*[@name = 'USER_PASSWORD']"));
        userPassword.sendKeys("UserUser");

        BrowserUtils.sleep(1.5);
        WebElement loginButton = driver.findElement(By.xpath("//input[@class= 'login-btn']"));
        loginButton.click();

 */
        CRM_Utilities.crm_login(driver, "helpdesk2@cybertekschool.com","UserUser");
        BrowserUtils.verifyTitle(driver,"Portal");

    }




    @AfterMethod

    public void teardown() throws InterruptedException {
        BrowserUtils.sleep(3.4);
        driver.quit();
    }


}
//3.55.51