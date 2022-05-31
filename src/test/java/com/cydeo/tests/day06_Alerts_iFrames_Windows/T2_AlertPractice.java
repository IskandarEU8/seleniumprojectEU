package com.cydeo.tests.day06_Alerts_iFrames_Windows;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T2_AlertPractice {



    WebDriver driver;


    @BeforeMethod
    public void setupConnection(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://practice.cydeo.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDownConnection() throws InterruptedException {
        Thread.sleep(1200);
        driver.quit();
    }

    @Test (priority = 1)
    public void testClickAlert() throws InterruptedException {
        WebElement clickForAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickForAlert.click();
        Thread.sleep(1200);
        Alert alert  = driver.switchTo().alert();
        alert.accept();

        WebElement actualClickAlertTextElemet = driver.findElement(By.xpath("//p[@id = 'result']"));

        String expectedClickAlertText = "You successfully clicked an alert";
        String actualClickAlertText = actualClickAlertTextElemet.getText();

        Assert.assertTrue(actualClickAlertTextElemet.isDisplayed());
        Assert.assertEquals(expectedClickAlertText, actualClickAlertText);

        driver.quit();
    }

    @Test (priority = 2)
    public void testConfirmAlert() throws InterruptedException {
        WebElement clickConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickConfirm.click();
        Thread.sleep(1200);

        WebElement actualConfirmTextElement = driver.findElement(By.xpath("//p[@id = 'result']"));
        String actualConfirmText = actualConfirmTextElement.getText();
        String expectedConfirmText = "You clicked: Cancel";

        System.out.println("\n\n\n-------------------------------------------------\n\n");
        System.out.println("expectedConfirmText = " + expectedConfirmText);
        System.out.println("actualConfirmText = " + actualConfirmText);
        System.out.println("\n\n-------------------------------------------------\n\n\n");
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        Assert.assertTrue(actualConfirmTextElement.isDisplayed(), "Result text is NOT displayed");
        Assert.assertEquals(actualConfirmText, expectedConfirmText, "Actual result text is not as expected");
    }
}
