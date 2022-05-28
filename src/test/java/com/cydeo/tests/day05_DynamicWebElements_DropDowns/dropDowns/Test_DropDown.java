package com.cydeo.tests.day05_DynamicWebElements_DropDowns.dropDowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class Test_DropDown {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void simpleDropdownTest() throws InterruptedException {
        driver.get("https://practice.cydeo.com/dropdown");

        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id = 'dropdown']")));
        WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();

        String actualSimpleDropdownText = currentlySelectedOption.getText();
        String expectedSimpleDropdownText = "Please select an option";

        Assert.assertEquals(actualSimpleDropdownText, expectedSimpleDropdownText);

        System.out.println("\n\n================================");
        System.out.println("Dropdown default text: " + actualSimpleDropdownText);


        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id = 'state']")));
        WebElement currentlySelectedState = stateDropdown.getFirstSelectedOption();
        String actualStateText = currentlySelectedState.getText();
//        String actualStateText2 = stateDropdown.getFirstSelectedOption().getText();
        String expectedStateText = "Select a State";

        Assert.assertEquals(actualStateText, expectedStateText);

        String defaultStateText = currentlySelectedState.getText();
        System.out.println("\n\n================================");
        System.out.println(defaultStateText);

        Thread.sleep(1000);
        simpleDropdown.selectByValue("1");

        Thread.sleep(1000);
        simpleDropdown.selectByIndex(2);

        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("California");

        Thread.sleep(1000);

        Select programmingLanguage = new Select(driver.findElement(By.xpath("//select[@name = 'Languages']")));
        programmingLanguage.selectByIndex(0);

        String actualPrLgTxt = programmingLanguage.getFirstSelectedOption().getText();
        System.out.println(actualPrLgTxt);


        Thread.sleep(1300);
        driver.close();
    }
}
