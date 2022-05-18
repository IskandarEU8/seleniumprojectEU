package com.cydeo.tests.day03_cssSelector_xPath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_xPath_getText {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        System.out.println("test started");

        WebElement authorization = driver.findElement(By.xpath("a[@href='https://login1.nextbasecrm.com/?login=yes']"));
        String authorizationText = authorization.getText();
        System.out.println(authorizationText);


        authorization.click();

        System.out.println(authorizationText);
        System.out.println("test finished");


    }
}
