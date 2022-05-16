package com.cydeo.homeTasks.day02tasks;

import com.cydeo.utilities.Print;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationForm {
    public static void main(String[] args) throws InterruptedException {

        Print.printStarted();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.navigate().to("https://practice.cydeo.com/registration_form");

        String expectedHeaderText = "Registration form";
        String actualHeaderText = driver.findElement(By.tagName("h2")).getText();

        if (actualHeaderText.equals(expectedHeaderText)){
            Print.printPassed("Header text");
        }else {
            Print.printFailed("Header text");
        }

        WebElement firstName = driver.findElement(By.xpath("//input[@name = 'firstname']"));

        String expectedPlaceHolderText = "first name";
        String actualPlaceHolderText = firstName.getAttribute("placeholder");

        if (actualPlaceHolderText.equals(expectedPlaceHolderText)){
            Print.printPassed("Placeholder text");
        }else {
            Print.printFailed("Placeholder text");
            System.out.println("actualPlaceHolderText = " + actualPlaceHolderText);
            System.out.println("expectedPlaceHolderText = " + expectedPlaceHolderText);
        }

//        WebElement submitBtn = driver.findElement(By.xpath("//button[@id = 'wooden_spoon']"));
//        submitBtn.click();
        Print.printFinished();

        Thread.sleep(2500);

        driver.quit();



    }
}
