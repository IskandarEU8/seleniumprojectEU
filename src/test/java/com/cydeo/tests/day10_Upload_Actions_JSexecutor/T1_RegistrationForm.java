package com.cydeo.tests.day10_Upload_Actions_JSexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_RegistrationForm {

    @Test
    public void registration_form_test() {

        // 1. Open browser
        // 2. Go to url: https://practice.cydeo.com/registration_form
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("registration.form.url"));

        // Create JavaFaker object
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
//        String userName = faker.name().username();
//        System.out.println("userName = " + userName);
//
//        userName = userName.replace(".", "");
//        System.out.println("userName = " + userName);

        WebElement userNameInput = Driver.getDriver().findElement(By.xpath("//*[@placeholder='username']"));
//        userNameInput.sendKeys(userName);
        String userName = (faker.bothify("helpdesk###"));
        userNameInput.sendKeys(userName);


        // 6. Enter email address
        WebElement emailAddressInput = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        emailAddressInput.sendKeys(userName + "@email.com");
//        emailAddressInput.sendKeys(faker.internet().emailAddress());

        // 7. Enter phone password
        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        passwordInput.sendKeys(faker.internet().password());

        // 8. Enter phone number
        WebElement phoneNumberInput = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumberInput.sendKeys(faker.numerify("###-###-####"));

        // 9. Select a gender from radio buttons
        WebElement genderInput = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        genderInput.click();

        // 10. Enter date of birth
        WebElement birthdayInput = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        birthdayInput.sendKeys("01/01/2001");

        // 11. Select Department/Office
        WebElement departmentOfficeSelect = Driver.getDriver().findElement(By.xpath("//select[@name='department']"));

//        Select departmentDropdown = new Select(departmentOfficeSelect);
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        int randNum = faker.number().numberBetween(1,9);
        departmentDropdown.selectByIndex(randNum);
//        departmentDropdown.selectByIndex(faker.number().numberBetween(1,9));
//        departmentDropdown.selectByValue("DE");

        // 12. Select Job Title
        WebElement jobTitleSelect = Driver.getDriver().findElement(By.xpath("//select[@name='job_title']"));

        Select jobTitle = new Select(jobTitleSelect);
        jobTitle.selectByVisibleText("SDET");


        BrowserUtils.sleep(2.3);
        // 13. Select programming language from checkboxes
        WebElement programmingLanguageSelect = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        programmingLanguageSelect.click();


        // 14. Click to sign up button
        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        signUpButton.click();

        // 15. Verify success message "You've successfully completed registration." is displayed
        WebElement registrationConfirmationText = Driver.getDriver().findElement(By.xpath("//p"));

        String actualRegistrationConfirmationText = registrationConfirmationText.getText();
        String expectedRegistrationConfirmationText = "You've successfully completed registration!";


        Assert.assertEquals(actualRegistrationConfirmationText, expectedRegistrationConfirmationText, "Text didn't match.");


        Driver.quitDriver(2.5);

    }
}

//VIDEO 1.14.39