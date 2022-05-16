package com.cydeo.homeTasks.day02tasks;

import com.cydeo.utilities.Print;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchForAppleInGoogle {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://google.com");
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("apple" + Keys.ENTER);

        Print.printStarted();

        String expectedTitle = "apple";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            Print.printPassed("Title");
        }else {
            Print.printFailed("Title");
        }


        /*
        WebElement submitBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        String txt = submitBtn.getAttribute("aria-label");
        System.out.println(txt+"\n\n");
        submitBtn.click();

         */

        Print.printFinished();

        Thread.sleep(3000);
        driver.close();


    }
}
