package com.cydeo.tests.day12_PageObjectModel_Synchronization.synchronization;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleLogo {
    @Test
    public void googleLogoTest(){
        Driver.getDriver().get("https://google.com");

        WebElement googleLogo = Driver.getDriver().findElement(By.tagName("img"));
        Assert.assertTrue(googleLogo.isDisplayed());
    }
}
