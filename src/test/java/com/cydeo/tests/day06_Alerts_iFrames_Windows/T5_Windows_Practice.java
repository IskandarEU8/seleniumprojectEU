package com.cydeo.tests.day06_Alerts_iFrames_Windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
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

        Set<String> allWindowHandles = driver.getWindowHandles();
        // Windows handle 1 = main window
        // Windows handle 2 = second window

        System.out.println("allWindowHandles = " + allWindowHandles);

//        for ( String each : driver.getWindowHandles()) {
        for ( String each : allWindowHandles) {
                driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());
        }

//        driver.switchTo().window();


        //6. Switch to new Window
        //7. Assert: Title is 'New Window'
        String expectedTitleAfterClick = "New Window";
        actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitleAfterClick,  "actual title didn't match expected title");

        System.out.println("Title after click  = " + actualTitle);

        driver.switchTo().window(mainHandle);

    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }

}
