package com.cydeo.tests.day12_PageObjectModel_Synchronization.synchronization;

import com.cydeo.utilities.Driver;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T4_DynamicallyLoadedPageElements7 {

    @BeforeMethod
    public void connect() {
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");
    }

    @AfterMethod
    public void teardown() {
        Driver.quitDriver(2.3);
    }

    @Test
    public void dynamically_loaded_page_elemets7_test() {
        WebElement doneTextElement = Driver.getDriver().findElement(By.xpath("//div[@id='alert']"));
        String expectedDoneText = "Done!";
        String actualDoneText = doneTextElement.getText();

//        Assert.assertEquals(actualDoneText, expectedDoneText);

        WebElement spoungeBobImage = Driver.getDriver().findElement(By.xpath("//img[@src='/img/a-few-moments.jpg']"));



    }





}
