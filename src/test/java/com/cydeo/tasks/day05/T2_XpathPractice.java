package com.cydeo.tasks.day05;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class T2_XpathPractice {

    @Test
    public void xpathPractice(){
//        TC #2: Radiobutton handling
//        1. Open Chrome browser
//        2. Go to https://practice.cydeo.com/radio_buttons
        Driver.getDriver().navigate().to("https://practice.cydeo.com/radio_buttons");

//        3. Click to “Hockey” radio button
        WebElement hockeyRadioBtn = Driver.getDriver().findElement(By.xpath("//input[@id='hockey']"));
        hockeyRadioBtn.click();

//        4. Verify “Hockey” radio button is selected after clicking.
        Assert.assertTrue(hockeyRadioBtn.isSelected());
//        USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS


        Driver.quitDriver(1.5);

    }

    @Test
    public void test2(){
        Driver.getDriver().navigate().to("https://practice.cydeo.com/radio_buttons");

        clickAndVerifyRadioButton(Driver.getDriver(), "color", "green");

    }

    @Test
    public void test3(){
        Driver.getDriver().navigate().to("https://practice.cydeo.com/radio_buttons");
        WebElement hockeyRadioBtn = Driver.getDriver().findElement(By.xpath("//input[@id='hockey']"));
        hockeyRadioBtn.click();
        BrowserUtils.sleep(1.3);
        clickAndVerifyRadioButton(Driver.getDriver(), "sport", "hockey");


    }

    public void clickAndVerifyRadioButton(WebDriver driver, String name, String id){
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='" +name +"']"));

        for (WebElement eachRadioButton : radioButtons) {
            String eachId = eachRadioButton.getAttribute("id");
            System.out.println(eachId  + ".isSelected() = ");
            System.out.println(eachRadioButton.isSelected());
        }

    }
}


/*
XPATH PRACTICES
DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #2: Radiobutton handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */