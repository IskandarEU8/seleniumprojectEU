package com.cydeo.tasks.day05;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class T4_SimpleDropdown_And_StateSelection {

    @Test
    public void simple_dropdown(){

        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        Driver.getDriver().get("https://practice.cydeo.com/dropdown ");

        //3. Verify “Simple dropdown” default selected value is correct

        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='dropdown']")));
        System.out.println("select.getFirstSelectedOption() = " + select.getFirstSelectedOption());

        //Expected: “Please select an option”
        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State


//        Driver.quitDriver(3.5);

    }

}
/*
TC#4: Verifying “Simple dropdown” and “State selection” dropdown
default values
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Verify “Simple dropdown” default selected value is correct
Expected: “Please select an option”
4. Verify “State selection” default selected value is correct
Expected: “Select a State
 */