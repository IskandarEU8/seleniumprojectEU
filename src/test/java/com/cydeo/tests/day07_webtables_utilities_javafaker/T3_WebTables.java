package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T3_WebTables {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // 1. Create new test and make setups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void windows_handling() throws InterruptedException {
        driver.get("https://practice.cydeo.com/tables");

        WebElement tableOne = driver.findElement(By.xpath("//table[@id='table1']"));
/* We can locate Jason, go to parent row, and come back in the same row to get "Due" cell:
        //table[@id='table1']//tbody//td[.='Jason']/../td[4]


We can locate the same 'Due' cell by using following-sibling:
        //table[@id='table1']//tbody//td[.='Jason']/following-sibling::td[2]
 */




    }





    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
