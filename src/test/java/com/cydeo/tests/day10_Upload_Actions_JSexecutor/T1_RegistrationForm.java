package com.cydeo.tests.day10_Upload_Actions_JSexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T1_RegistrationForm {

    @Test
    public void registration_form_test(){

        // 1. Open browser
        // 2. Go to url: https://practice.cydeo.com/registration_form
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("registration.form.url"));


        Faker faker = new Faker();
        // 3. Enter first name

        WebElement firstNameInput = Driver.getDriver().findElement(By.xpath("//input[@class='form-control']"));
//        WebElement firstNameInput = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstNameInput.sendKeys(faker.name().firstName());

        // 4. Enter last name
        WebElement lastNameInput = Driver.getDriver().findElement(By.xpath("(//div[@class='col-sm-5'])[2]/input[@class='form-control']"));
//        WebElement lastNameInput = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastNameInput.sendKeys(faker.name().lastName());

        // 5. Enter username
        String userName = faker.name().username().replaceAll(".", "");
        WebElement userNameInput = Driver.getDriver().findElement(By.xpath("//*[@placeholder='username']"));
        userNameInput.sendKeys(userName);

        // 6. Enter email address
        WebElement emailAddressInput = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        emailAddressInput.sendKeys(faker.internet().emailAddress());

        // 7. Enter phone password
        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        passwordInput.sendKeys(faker.internet().password());

        // 8. Enter phone number
        WebElement phoneNumberInput = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumberInput.sendKeys(faker.numerify("###-###-####"));

        // 9. Select a gender from radio buttons
        WebElement genderSelect = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        genderSelect.click();

        // 10. Enter date of birth
        WebElement birthdayInput = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        birthdayInput.sendKeys("01/01/2001");

        // 11. Select Department/Office
        WebElement departmentOfficeSelect = Driver.getDriver().findElement(By.xpath("//select/option[@value='Mayor's Office']"));
        departmentOfficeSelect.click();

        // 12. Select Job Title
        WebElement jobTitleSelect = Driver.getDriver().findElement(By.xpath("//select/option[@name='job_title]/option[@value='SDET']"));
        jobTitleSelect.click();

        // 13. Select programming language from checkboxes
        WebElement programmingLanguageSelect = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        programmingLanguageSelect.click();

        // 14. Click to sign up button
        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        signUpButton.click();

        // 15. Verify success message "You've successfully completed registration." is displayed


        Driver.quitDriver(4.5);

    }
}

//VIDEO 1.14.39