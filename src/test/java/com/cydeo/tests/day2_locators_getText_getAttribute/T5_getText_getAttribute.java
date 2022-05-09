package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getText_getAttribute {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // go to Practice Cydeo Registration page
        driver.get("https://practice.cydeo.com/registration_form");

        System.out.println("---------------------------------------------");
        System.out.println("Test started");
        // verify header text is as expected:
        String expectedHeaderText = "Registration form";
        WebElement headerText = driver.findElement(By.tagName("h2"));
        String actualHeaderText = headerText.getText();


        if (expectedHeaderText.equals(actualHeaderText)){
            System.out.println("Header verification passed");
        }else{
            System.err.println("Header verification failed");
            System.out.println(expectedHeaderText);
            System.out.println(actualHeaderText);
        }


        System.out.println("============================================================");
        // Locate "first name" input box
        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        //expected placeholder attribute
        String expectedPlaceHolder = "first name";

        //actual placeholder attribute
        String actualPlaceHolder = firstNameInput.getAttribute("placeholder");

        // verify placeholder's attribute by comparing actual and expected values
        if (actualPlaceHolder.equals(expectedPlaceHolder)){
            System.out.println("Placeholder test verification passed");
        }else{
            System.err.println("Placeholder test verification failed");
        }

        System.out.println("Test finished");

        Thread.sleep(1000);
    }
}
