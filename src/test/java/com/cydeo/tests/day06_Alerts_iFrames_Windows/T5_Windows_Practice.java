package com.cydeo.tests.day06_Alerts_iFrames_Windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_Windows_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://practice.cydeo.com/windows");


    }


    @Test
    public void multiple_window_test(){
        String mainHandle = driver.getWindowHandle();

        System.out.println("mainHandle = " + mainHandle);


        //4.Assert Title is 'Windows'
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        System.out.println("Title before click  = " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Title didn't match with expected title");

        //5. Click to: 'Click Here' link

//        WebElement clickHereElement = driver.findElement(By.xpath("//a[.='Click Here']"));
        WebElement clickHereElement = driver.findElement(By.linkText("Click Here"));
        clickHereElement.click();

        System.out.println("Title before click  = " + actualTitle);

//        driver.switchTo().window();


        //6. Switch to new Window
        //7. Assert: Title is 'New Windows'



    }


}
