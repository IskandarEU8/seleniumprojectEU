package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.invisibilityOf(dcPage.loadingBar));

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

}
