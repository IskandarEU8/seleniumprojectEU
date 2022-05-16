package com.cydeo.homeTasks.day02tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindWoodenSpoon_Etsy {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://etsy.com");


        System.out.println("\n\ntest started\n\n");

//        WebElement searchBox = driver.findElement(By.tagName("input"));
//        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]"));
        searchBox.sendKeys("Wooden Spoon");

//        WebElement sumbitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement sumbitBtn = driver.findElement(By.xpath("//button[@data-id= 'gnav-search-submit-button']"));
        sumbitBtn.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Wooden spoon | Etsy";


        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification passed");
        }else{
            System.err.println("Title verification failed");
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("actualTitle   = " + actualTitle);
        }


        System.out.println("Test finished");
//        Thread.sleep(3000);
//        driver.quit();


    }
}
