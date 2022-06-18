package com.cydeo.tests.day11_DriverClose_Acrions_JSExecutorPractice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Circle_Drag_And_Drop {

    @Test
    public void drag_and_drop_test(){
        Driver.getDriver().navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(Driver.getDriver());

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("window.scrollBy(0, 150)");

        WebElement cookieSettings = Driver.getDriver().findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookieSettings.click();

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        String actualStartText = bigCircle.getText();
        String expectedStartText = "Drag the small circle here.";

        Assert.assertEquals(actualStartText, expectedStartText);

        actions.clickAndHold(smallCircle)
                .pause(2000)
                .perform();

        BrowserUtils.sleep(1.7);
        String actualTextWhileHolding = bigCircle.getText();
        String expectedTextWhileHolding = "Drop here.";
        System.out.println("================================");
        System.out.println(actualTextWhileHolding);

//        Assert.assertEquals(actualTextWhileHolding, expectedTextWhileHolding);

        actions.clickAndHold(bigCircle).moveToElement(bigCircle).release().perform();

        System.out.println(bigCircle.getText());

        actions.dragAndDrop(smallCircle, bigCircle).perform();


        System.out.println(bigCircle.getText());

        String actualResult = bigCircle.getText();
        String expectedResult = "You did great!";

        Assert.assertEquals(actualResult, expectedResult);




        Driver.quitDriver(6);
    }

}
