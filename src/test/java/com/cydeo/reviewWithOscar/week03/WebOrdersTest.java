package com.cydeo.reviewWithOscar.week03;


import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebOrdersTest {

    WebDriver driver;


    @BeforeMethod
    public void loginToViewOrders() {
        System.out.println("login steps for app");


        driver = WebDriverFactory.getDriver("chrome"); // instantiate or initiate or create
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void closeBrowser() {
        System.out.println("closing the browser for the following test cases");
    }

    @Test
    public void checkBoxTest() {
        System.out.println("Implementing step 3 and 4 of Test Case 1");
    }

    @Test
    public void deletePersonTest() {
        System.out.println("Implementing step 3 and 4 of Test Case 2");
    }


}
