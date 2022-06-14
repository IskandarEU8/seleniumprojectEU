package com.cydeo.tests.day10_Upload_Actions_JSexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    @Test
    public void upload_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("upload_test_url"));
        String imgPath = "C:\\Users\\iCan\\Downloads\\Safe Uploads\\fast-food.png";

        WebElement fileUpload = Driver.getDriver().findElement(By.id("file-upload"));
        BrowserUtils.sleep(1);

        fileUpload.sendKeys(imgPath);

        WebElement uploadBtn = Driver.getDriver().findElement(By.id("file-submit"));
        uploadBtn.click();


        WebElement actualMessageElement = Driver.getDriver().findElement(By.tagName("h3"));

        String expectedMessage = "File Uploaded!";
        String actualMessage = Driver.getDriver().findElement(By.tagName("h3")).getText();

        Assert.assertEquals(actualMessage, expectedMessage);
        Assert.assertTrue(actualMessageElement.isDisplayed());


        Driver.quitDriver(2.5);
    }

}
//3.40.05