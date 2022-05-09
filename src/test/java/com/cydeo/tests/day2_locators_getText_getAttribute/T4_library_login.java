package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_library_login {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://library2.cybertekschool.com/login.html");

        WebElement userNameInput = driver.findElement(By.className("form-control"));
        WebElement userPasswordInput = driver.findElement(By.id("inputPassword"));

        userNameInput.sendKeys("incorrect@email.com");
        userPasswordInput.sendKeys("incorrect password");

        WebElement signInButton = driver.findElement(By.tagName("button"));
        signInButton.click();
        Thread.sleep(2500);
        String classAtri = driver.findElement(By.tagName("button")).getAttribute("class");
        System.out.println(classAtri);


        driver.quit();


    }
}
//31700