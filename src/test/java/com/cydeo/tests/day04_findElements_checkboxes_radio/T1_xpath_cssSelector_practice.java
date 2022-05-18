package com.cydeo.tests.day04_findElements_checkboxes_radio;

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

        WebElement homeBtn = driver.findElement(By.cssSelector("a[class = 'nav-link']"));       // cssSelector
        WebElement homeBtn2 = driver.findElement(By.xpath("//a[@class = 'nav-link']")); //xPath - relative
//        WebElement homeBtn3 = driver.findElement(By.className("nav-link")); // className
//        WebElement homeBtn3 = driver.findElement(By.cssSelector("a.nav-link")); // cssSelector syntax = 2
//        WebElement homeBtn3 = driver.findElement(By.cssSelector("a[href = '/'")); // cssSelector syntax = 2
        WebElement homeBtn3 = driver.findElement(By.cssSelector("[href = '/'")); // cssSelector syntax = 2
//        WebElement homeBtn3 = driver.findElement(By.tagName("a"));  //tagName
//        WebElement homeBtn3 = driver.findElement(By.partialLinkText("ome"));  // partialLinkText
//        WebElement homeBtn3 = driver.findElement(By.linkText("Home"));          // linkText
//        WebElement homeBtn3 = driver.findElement(By.xpath("/html/body/nav/ul/li/a"));          // xpath - absolute
//        WebElement homeBtn3 = driver.findElement(By.xpath("/html/body//a"));          // xpath - absolute + relative

        System.out.println("home button is displayed "+homeBtn.isDisplayed());

        String expHomeBtnTxt = "Home";
        String actualHomeBtnTxt = homeBtn.getText();
        String actualHomeBtnTxt2 = homeBtn.getText();
        String actualHomeBtnTxt3 = homeBtn.getText();

        if (actualHomeBtnTxt.equals(expHomeBtnTxt)){
            Print.printPassed("Home button");
        }else{
            Print.printFailed("Home button");
        }

        if (actualHomeBtnTxt2.equals(expHomeBtnTxt)){
            Print.printPassed("Home button2");
        }else{
            Print.printFailed("Home button2");
        }

        if (actualHomeBtnTxt3.equals(expHomeBtnTxt)){
            Print.printPassed("Home button3");
        }else{
            Print.printFailed("Home button3");
        }


        String expHeadTxt = "Forgot Password";
//        String actHeadTxt = driver.findElement(By.tagName("h2")).getText();                       // tagName
//        String actHeadTxt = driver.findElement(By.cssSelector("div.example > h2")).getText();     // cssSelector
//        String actHeadTxt = driver.findElement(By.xpath("//h2")).getText();                       //xpath
//        String actHeadTxt = driver.findElement(By.xpath("//h2[text() = 'Forgot Password']")).getText(); //xpath
        WebElement HeadTxt = driver.findElement(By.xpath("//h2[. = 'Forgot Password']")); //xpath
        String actHeadTxt = driver.findElement(By.xpath("//h2[. = 'Forgot Password']")).getText(); //xpath

        System.out.println("Header Text is displayed " + HeadTxt.isDisplayed());

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
// <input type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required="">

//        WebElement emailInput = driver.findElement(By.xpath("//input[@name = 'email']"));

//        WebElement emailInput = driver.findElement(By.xpath("//input[@type = 'text']"));


        WebElement emailInput = driver.findElement(By.xpath("//input[contains (@pattern, 'a-z')]"));
        emailInput.sendKeys("admin@cydeo.com");

        Thread.sleep(1000);

//        WebElement retrieveBtn = driver.findElement(By.xpath("//button[@id = 'form_submit']"));
        WebElement retrieveBtn = driver.findElement(By.xpath("//button[@type = 'submit']"));
        retrieveBtn.click();

//        System.out.println("Header text is displayed " + actHeadTxt.);

        Thread.sleep(1000);
        driver.navigate().back();



        WebElement footerNote = driver.findElement(By.xpath("//div[@style = 'text-align: center;']"));
        System.out.println("footerNote = " + footerNote.isDisplayed());
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

        Thread.sleep(1000);
        driver.close();



    }
}

// VIDEO 2.03.05