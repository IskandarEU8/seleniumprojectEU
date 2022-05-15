package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practice {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/forgot_password");

        WebElement footNote = driver.findElement(By.xpath("/html/body/div/div[3]"));
        WebElement footNote2 = driver.findElement(By.xpath("//div[@class='large-4 large-centered columns']"));
        WebElement footNote3 = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        String footNoteText = footNote.getText();
        String footNoteText2 = footNote.getText();
        String footNoteText3 = footNote.getText();

        System.out.println(footNoteText);
        System.out.println(footNoteText2);
        System.out.println(footNoteText3);
    }
}

// VIDEO 1.06.05