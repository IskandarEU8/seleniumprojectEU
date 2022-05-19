package com.cydeo.tests.day05_DynamicWebElements_DropDowns.t1_t2_t3;

import com.cydeo.utilities.Print;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class T1_StaleElementRefEx {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/add_remove_elements/");


        Print.printStarted();

        Thread.sleep(1200);

//        WebElement addElementBtn = driver.findElement(By.xpath("//*[@id='content']/div/button")); // method # 1
//        WebElement addElementBtn = driver.findElement(By.xpath("//button[text() ='Add Element']")); ////a[text() = 'CYDEO']"
        WebElement addElementBtn = driver.findElement(By.xpath("//button[.='Add Element']")); ////a[text() = 'CYDEO']"
        addElementBtn.click();

        WebElement deleteBtn = driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("Delete button is  displayed: " + deleteBtn.isDisplayed());




        Thread.sleep(1200);
        deleteBtn.click();

        try {
            System.out.println("Delete button is displayed: " + deleteBtn.isDisplayed());
        } catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException is thrown");
            System.out.println("This means the web element is completely deleted from the page");
            System.out.println("DeleteButton.isDisplayed(): false");
        }



        Print.printFinished();

        Thread.sleep(1200);
        driver.quit();
    }
}
