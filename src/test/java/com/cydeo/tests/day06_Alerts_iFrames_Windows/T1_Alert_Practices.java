package com.cydeo.tests.day06_Alerts_iFrames_Windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practices {

    WebDriver driver;


    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://practice.cydeo.com/javascript_alerts");

    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(1300);
        driver.quit();
    }



    @Test (priority = 1)
    public void alertPractice() throws InterruptedException {
        WebElement clickAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickAlert.click();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Thread.sleep(1200);
        String clickResult = result.getText();
        String expectedClickResult = "You successfully clicked an alert";

        Assert.assertEquals(clickResult, expectedClickResult);

        // Confirm
        Thread.sleep(1200);

        WebElement confirmAlert = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmAlert.click();
//        Alert alert = driver.switchTo().alert();
        alert.dismiss();

//        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));

        //You clicked: Ok
        String clickConfirm = result.getText();
        String expectedConfirmResult = "You clicked: Ok";

        Assert.assertEquals(clickConfirm, expectedConfirmResult);

        Thread.sleep(1200);

        String cancelConfirm = result.getText();
        String expectedCancelResult = "You clicked: Cancel";

        confirmAlert.click();
        alert.dismiss();

        Assert.assertEquals(cancelConfirm, expectedCancelResult);

        Thread.sleep(1200);
        WebElement promptAlert = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
//        promptAlert.click();

        String clickPrompt = result.getText();
        String expectedPromptResult = "You clicked: Ok";




    }



}
//VIDEO: 2.08.04