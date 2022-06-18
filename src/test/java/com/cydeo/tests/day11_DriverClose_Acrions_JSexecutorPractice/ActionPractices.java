package com.cydeo.tests.day11_DriverClose_Acrions_JSexecutorPractice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionPractices {

    // TC #4: Scroll practice
    // 1- Open a Chrome browser
    // 2- Go to: https://practice.cydeo.com/

    @Test
    public void task4_and_task5_test(){

        // TC #4: Scroll practice
        // 1- Open a Chrome browser
        // 2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com");


        //3- Scroll down to “Powered by CYDEO”

        //Create object of Actions and pass our "driver" instance
        Actions actions = new Actions(Driver.getDriver());

        //Locating cydeo link to be able to pass in the actions method
        //a[@href='https://cydeo.com/']
        WebElement cydeoLink =Driver.getDriver().findElement(By.linkText("CYDEO"));

//        BrowserUtils.sleep(2);
        actions.moveToElement(cydeoLink).perform();

//        actions.sendKeys(Keys.PAGE_UP).perform();

        Driver.quitDriver(2.2);

    }

    @Test
    public void etsy_test() {
        Driver.getDriver().get("https://etsy.com");
        Actions actions = new Actions(Driver.getDriver());
        WebElement etsyH2 = Driver.getDriver().findElement(By.xpath("//h2[@class='wt-text-heading-02 wt-mb-xs-1 wt-text-center-xs']"));

        BrowserUtils.sleep(1.2);
        actions.moveToElement(etsyH2).perform();

        Driver.quitDriver(2.3);
    }

}
