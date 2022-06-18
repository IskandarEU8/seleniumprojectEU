package com.cydeo.tests.day11_DriverClose_Acrions_JSexecutorPractice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T6_Etsy {

    @Test
    public void etsy_test(){
        Driver.getDriver().get("https://etsy.com");
        Actions actions = new Actions(Driver.getDriver());
        WebElement etsyH2 = Driver.getDriver().findElement(By.xpath("//h2[@class='wt-text-heading-02 wt-mb-xs-1 wt-text-center-xs']"));

        BrowserUtils.sleep(1.2);
        actions.moveToElement(etsyH2).perform();

        Driver.quitDriver(2.3);
    }
}
