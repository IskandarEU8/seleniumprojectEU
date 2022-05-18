package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonLinks {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver =  WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//        driver.navigate().to("https://amazon.com");
//        driver.navigate().to("https://aliexpress.com");
        driver.navigate().to("https://kaktus.media");

        System.out.println("\n\n\n");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        System.out.println("Quantity of foun links: " + allLinks.size() + "\n\n\n");

        for (WebElement eachLink : allLinks) {
            System.out.println("Link text: '" + eachLink.getText() + "' link of the text '" + eachLink.getAttribute("href") + '\'');
        }

        Thread.sleep(1500);
        driver.quit();





    }
}
