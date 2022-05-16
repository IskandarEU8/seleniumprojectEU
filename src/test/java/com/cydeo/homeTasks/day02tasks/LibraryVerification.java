package com.cydeo.homeTasks.day02tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LibraryVerification {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://library2.cybertekschool.com/login.html");

        String userName = "incorrect@email.com";
        String passWord = "incorrect password";

        Thread.sleep(1000);

        WebElement inputEmail = driver.findElement(By.xpath("//input[@id = 'inputEmail']"));
        inputEmail.sendKeys(userName);

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id = 'inputPassword']"));
        inputPassword.sendKeys(passWord + Keys.ENTER);


        Thread.sleep(1500);
        driver.close();







    }


}
