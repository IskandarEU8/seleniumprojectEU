package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitPractices {

    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver(1.5);
    }

    @Test
    public void remove_button_test(){

        DynamicControlsPage dcp = new DynamicControlsPage();
        // 3.Click to "Remove" button
        dcp.removeButton.click();
        // 4.Wait until "loading bar" disappears
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(dcp.loadingBar));

        // 5. Verify:
        // a. Checkbox is not displayed
        Assert.assertFalse(dcp.checkbox.isDisplayed());
        // b. "It's gone!" message is displayed.
        Assert.assertTrue(dcp.message.isDisplayed());



//13121
    }

}
