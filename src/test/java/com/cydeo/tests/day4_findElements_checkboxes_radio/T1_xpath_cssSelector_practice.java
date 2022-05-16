package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.utilities.Print;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/forgot_password");
/*
        WebElement actFootNote = driver.findElement(By.xpath("/html/body/div/div[3]"));
        WebElement actFootNote2 = driver.findElement(By.xpath("//div[@class='large-4 large-centered columns']"));
        WebElement actFootNote3 = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        String actFootNoteText = actFootNote.getText();
        String actFootNoteText2 = actFootNote.getText();
        String actFootNoteText3 = actFootNote.getText();

        System.out.println(actFootNoteText);
        System.out.println(actFootNoteText2);
        System.out.println(actFootNoteText3);

 */

        /*
        Locate:
            - "forgot password" header
            - "E-mail" text
            - "E-mail" input box
            - "Retrieve password" button
            - "Powered by Cydeo" text
            - Verify all web elements displayed
         */

        Print.printStarted();

        String expHeadTxt = "Forgot Password";
        String actHeadTxt = driver.findElement(By.tagName("h2")).getText();

        if (actHeadTxt.equals(expHeadTxt)){
            Print.printPassed("Header text");
        }else {
            Print.printFailed("Header text");
        }

        WebElement emailText = driver.findElement(By.xpath("//label[@for = 'email']"));

        String expEmailTxt = "E-mail";
        String actEmailTxt = emailText.getText();

        if (actEmailTxt.equals(expEmailTxt)){
            Print.printPassed("Email text");
        }else {
            Print.printFailed("Email text");
            System.out.println("actEmailTxt = " + actEmailTxt);
            System.out.println("expEmailTxt = " + expEmailTxt);
        }

        WebElement emailInput = driver.findElement(By.xpath("//input[@name = 'email']"));
        emailInput.sendKeys("admin@cydeo.com");

        WebElement retrieveBtn = driver.findElement(By.xpath("//button[@id = 'form_submit']"));
        retrieveBtn.click();

        driver.navigate().back();

        WebElement footerNote = driver.findElement(By.xpath("//div[@style = 'text-align: center;']"));
        String actFootNote = footerNote.getText();
        String expactFootNote = "Powered by CYDEO";

        if (actFootNote.equals(expactFootNote)){
            Print.printPassed("Footer note");
        }else {
            Print.printFailed("Footer note");
            System.out.println("expactFootNote = " + expactFootNote);
            System.out.println("actFootNote = " + actFootNote);
        }


        Print.printFinished();

        Thread.sleep(2500);
        driver.close();

    }
}

// VIDEO 1.18.05