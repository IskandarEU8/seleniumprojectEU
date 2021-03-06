package com.cydeo.tests.day12_PageObjectModel_Synchronization.synchronization;

import com.cydeo.pages.DynamicLoad1Page;
import com.cydeo.pages.DynamicLoad7Page;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.locks.Condition;

public class WebDriveWaitPractices {

    @Test
    public void dynamic_load_7_test() {
        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");

        //2. Wait until title is “Dynamic title”

        //creating the wait object to be able to create certain condition to wait
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        //use the "wait" object to create our expected condition
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        //Create object of DynamicLoad7Page to reach and assert web elements
        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();

        //3. Assert: Message “Done” is displayed.
        Assert.assertTrue(dynamicLoad7Page.doneMessage.isDisplayed());

        //4. Assert: Image is displayed
        Assert.assertTrue(dynamicLoad7Page.spongeBobImage.isDisplayed());

    }

    @Test
    public void dynamic_load_1_test(){

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

        DynamicLoad1Page dynamicLoad1Page = new DynamicLoad1Page();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        dynamicLoad1Page.startBtn.click();

        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.loadingBar));

        Assert.assertTrue(dynamicLoad1Page.inputUsername.isDisplayed());

        dynamicLoad1Page.inputUsername.sendKeys("tomsmith");

        dynamicLoad1Page.inputPassword.sendKeys("somethingwrong");

        dynamicLoad1Page.submitButton.click();

        Assert.assertTrue(dynamicLoad1Page.errorMessage.isDisplayed());



    }
}
