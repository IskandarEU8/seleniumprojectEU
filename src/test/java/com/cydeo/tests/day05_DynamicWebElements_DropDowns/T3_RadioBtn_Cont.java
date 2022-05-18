package com.cydeo.tests.day05_DynamicWebElements_DropDowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T3_RadioBtn_Cont {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://practice.cydeo.com/radio_buttons");

        List<WebElement> colorRadioButtons = driver.findElements(By.xpath("//input[@name = 'color']"));

        for (WebElement each : colorRadioButtons) {
            String eachId = each.getAttribute("id");
            System.out.print(eachId + ".isSelected() = ");
            System.out.println(each.isSelected());

            Thread.sleep(150);

            if (eachId.equals("red")){
                each.click();
            }

            Thread.sleep(150);

            if (eachId.equals("yellow")){
                each.click();
            }

            Thread.sleep(150);
            if (eachId.equals("black")){
                each.click();
            }



        }

        System.out.println("\n\n\n");
        // Locate name = 'sports' radio buttons and store them in a list of Web Element
        List<WebElement> sportRadioButtons = driver.findElements(By.cssSelector("input[name = 'sport']"));

        Thread.sleep(250);
        for (WebElement each : sportRadioButtons) {
            String eachId = each.getAttribute("id");
            System.out.print(eachId + ".isSelected = ");
            System.out.println(each.isSelected());

            if (eachId.equals("hockey")){
                each.click();
                System.out.println("hockey is selected = " + each.isSelected());
                break;
            }
        }

        Thread.sleep(1000);
        driver.quit();


    }
}
