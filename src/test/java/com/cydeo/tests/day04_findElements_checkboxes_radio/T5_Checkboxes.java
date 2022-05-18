package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T5_Checkboxes {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id = 'box1']"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@id = 'box2']"));

        boolean b1 = checkbox1.isSelected();
        boolean b2 = checkbox2.isSelected();

        System.out.println("checkbox1 is selected = " + b1);
        System.out.println("checkbox2 is selected = " + b2);

        Thread.sleep(1500);

        checkbox1.click();

         b1 = checkbox1.isSelected();
         b2 = checkbox2.isSelected();

        System.out.println("checkbox1 is selected = " + b1);
        System.out.println("checkbox2 is selected = " + b2);

        Thread.sleep(1500);

        checkbox2.click();

        b1 = checkbox1.isSelected();
        b2 = checkbox2.isSelected();

        System.out.println("checkbox1 is selected = " + b1);
        System.out.println("checkbox2 is selected = " + b2);


        Thread.sleep(1500);
        driver.quit();

    }
}

//34200