package com.cydeo.tests.day10_Upload_Actions_JSexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Actions_Hover {

    @Test
    public void hover_test(){

        // 1. Go to: https://practice.cydeo.com/hovers
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("hover_test_url"));

        Actions actions = new Actions(Driver.getDriver());

        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        // 2. Locate all the "user" texts under here:
        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));
//        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[text()='user1']"));

        WebElement viewProfile1 = Driver.getDriver().findElement(By.xpath("//a[@href='/users/1']"));
        WebElement viewProfile2 = Driver.getDriver().findElement(By.xpath("//a[@href='/users/2']"));
        WebElement viewProfile3 = Driver.getDriver().findElement(By.xpath("//a[@href='/users/3']"));


        // 3. Hover over to first image and ASSERT
        actions.moveToElement(img1).perform();
        BrowserUtils.sleep(1.4);
        // a. "name: user1" is displayed
        Assert.assertTrue(user1.isDisplayed());
        Assert.assertTrue(viewProfile1.isDisplayed());

        actions.moveToElement(img2).perform();
        BrowserUtils.sleep(1.3);
        // a. "name: user2" is displayed
        Assert.assertTrue(user2.isDisplayed());

        actions.moveToElement(img3).perform();
        BrowserUtils.sleep(1.2);
        // a. "name: user3" is displayed
        Assert.assertTrue(user3.isDisplayed());



        // a. "name: user1" is displayed
        // b. "view profile" is displayed





        Assert.assertTrue(viewProfile2.isDisplayed());
        Assert.assertTrue(viewProfile3.isDisplayed());



        Driver.quitDriver(2.5);
    }
}
