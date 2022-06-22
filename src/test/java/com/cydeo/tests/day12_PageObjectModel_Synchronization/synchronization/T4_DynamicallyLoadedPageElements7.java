package com.cydeo.tests.day12_PageObjectModel_Synchronization.synchronization;

import com.cydeo.utilities.Driver;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public void dynamically_loaded_page_elemets7_test() throws InterruptedException {
//        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");
        Thread.sleep(10);
        WebElement doneTextElement = Driver.getDriver().findElement(By.xpath("//div[@id='alert']"));
        String expectedDoneText = "Done!";
        String actualDoneText = doneTextElement.getText();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

//        Assert.assertEquals(actualDoneText, expectedDoneText);

        WebElement spoungeBobImage = Driver.getDriver().findElement(By.xpath("//img[@src='/img/a-few-moments.jpg']"));
        wait.until(ExpectedConditions.visibilityOf(spoungeBobImage));
        Assert.assertTrue(spoungeBobImage.isDisplayed());



    }

    @Test
    public void  custom_test(){
        WebElement img = Driver.getDriver().findElement(By.tagName("img"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(img));
        Assert.assertTrue(img.isDisplayed());
    }




}
