package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitPractices {

    DynamicControlsPage dcPage;

    @BeforeMethod
    public void setupMethod() {
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dcPage = new DynamicControlsPage();
    }

    @AfterMethod
    public void teardown() {
        Driver.quitDriver(1.5);
    }

    @Test
    public void remove_button_test() {

        // 3.Click to "Remove" button
        dcPage.removeButton.click();
        // 4.Wait until "loading bar" disappears
        BrowserUtils.waitForInvisibilityOf(dcPage.loadingBar);
        /*
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(dcPage.loadingBar));

         */

        // 5. Verify:
        // a. Checkbox is not displayed
        try {
            Assert.assertTrue(!dcPage.checkbox.isDisplayed());
            Assert.assertFalse(dcPage.checkbox.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
        // b. "It's gone!" message is displayed.
        Assert.assertTrue(dcPage.message.isDisplayed());
        Assert.assertTrue(dcPage.message.getText().equals("It's gone!"));

//13121
    }


    @Test
    public void enable_button_test(){

        //3- Click to “Enable” button
        dcPage.enableButton.click();


        //System.out.println("dynamicControlsPage.inputBox.isEnabled() = "
        //        + dynamicControlsPage.inputBox.isEnabled());



        //4- Wait until “loading bar disappears”
        //Calling our ExplicitWait utility method to wait loadingBar to disappear
        BrowserUtils.waitForInvisibilityOf(dcPage.loadingBar);


        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dcPage.inputBox.isEnabled());

        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dcPage.message.isDisplayed());

        String expectedMessage =dcPage.message.getText();
        //Check the String value is matching as expected: “It’s enabled!”
        Assert.assertEquals(dcPage.message.getText(),expectedMessage);
    }

}

//25552