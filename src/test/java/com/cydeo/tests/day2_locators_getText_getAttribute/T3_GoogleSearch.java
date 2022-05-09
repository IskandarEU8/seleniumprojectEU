package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //maximize screen
        driver.manage().window().maximize();

        //go to Google.com
        driver.get("https://google.co.uk");

        // write "apple" in search box
        WebElement googleSearchBox = driver.findElement(By.name("q"));

        //type in the search box
        googleSearchBox.sendKeys("apple" + Keys.ENTER);

        String expectedInTitle = "apple";
        String actualTitle = driver.getTitle();

        if (actualTitle.startsWith(expectedInTitle)){
            System.out.println("Title verification passed");
        }else{
            System.err.println("Title verification failed");
        }

        WebElement partialLinkText = driver.findElement(By.partialLinkText("iPhone"));
        partialLinkText.click();

        Thread.sleep(2000);
        WebElement elementFoundById = driver.findElement(By.id("iphone-13-pro-ar-gallery"));
        elementFoundById.click();


        Thread.sleep(8000);

        driver.quit();


    }
}
