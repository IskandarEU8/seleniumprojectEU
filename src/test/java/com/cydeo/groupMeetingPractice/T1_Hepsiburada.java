package com.cydeo.groupMeetingPractice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T1_Hepsiburada {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://hepsiburada.com");

    }

    @Test
    public void test1() {
        WebElement searchInputBox = driver.findElement(By.xpath("//input[@class = 'desktopOldAutosuggestTheme-input']"));
        searchInputBox.sendKeys("apple", Keys.ENTER);

        BrowserUtils.sleep(1.2);

        String expectedTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle, "Titles didn't match");


        WebElement thirdElement = driver.findElement(By.xpath("//*[@id=\"i2\"]/div/a/div[2]/div[1]/div[2]/div[2]"));
//        WebElement thirdElement = driver.findElement(By.xpath("(//li[@class='productListContent-item'])[1]/following-sibling::li[2]"));
        thirdElement.click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        // Windows handle 1 = main window
        // Windows handle 2 = second window

        System.out.println("allWindowHandles = " + allWindowHandles);


        for (String each : allWindowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());
        }


        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "iPhone 11 128 GB Fiyatı, Taksit Se&#231;enekleri ile Satın Al\"";
        Assert.assertEquals(actualTitle, expectedTitle2);

    }

}
//3.43.39
