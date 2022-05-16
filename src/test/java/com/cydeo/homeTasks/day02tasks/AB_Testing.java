package com.cydeo.homeTasks.day02tasks;

import com.cydeo.utilities.Print;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AB_Testing {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Print.printStarted();

        driver.get("https://practice.cydeo.com");

        WebElement abTesting = driver.findElement(By.xpath("//a[@href='/abtest']"));
        abTesting.click();

        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            Print.printPassed("Title");
        }else{
            Print.printFailed("Title");
        }
        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);

        String expectedTitle2 = "Practice";
        String actualTitle2 = driver.getTitle();

        if (actualTitle2.equals(expectedTitle2)){
            Print.printPassed("Title2");
        }else{
            Print.printFailed("Title2");
        }

        Print.printFinished();

        Thread.sleep(1000);
        driver.quit();
    }
}
