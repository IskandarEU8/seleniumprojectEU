package com.cydeo.tests.day05_DynamicWebElements_DropDowns;

import com.cydeo.utilities.Print;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T2_RadioButton {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://practice.cydeo.com/radio_buttons");


        WebElement hockeyRadioBtn = driver.findElement(By.xpath("//input[@id = 'hockey']"));
        hockeyRadioBtn.click();
        if (hockeyRadioBtn.isSelected()) {
            Print.printPassed("\n\n\nHockeyRadioBtn");
            System.out.println("hockeyRadioBtn.isSelected() = " + hockeyRadioBtn.isSelected());
        } else {
            Print.printFailed("HockeyRadioBtn");
        }

        Thread.sleep(1000);
        driver.close();
    }
}
