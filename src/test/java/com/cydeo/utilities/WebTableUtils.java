package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTableUtils {
//    Method #1 info:
//            - Name: returnOrderDate()
//- Return type: String
//- Arg1: WebDriver driver
//- Arg2: String costumerName

    public static String returnOrderDate(WebDriver driver, String customerName) {

        WebElement returnOrderDate = driver.findElement(By.xpath("//td[.='"+ customerName +"']/following-sibling::td[3]"));
        return returnOrderDate.getText();
    }


//    Method #2 info:
//            - Name: orderVerify()
//- Return type: void
//- Arg1: WebDriver driver
//- Arg2: String costumerName
//- Arg3: String expectedOrderDate
//
//    This method should accept above-mentioned arguments and internally assert expectedOrderDate matching actualOrderDate.


public static void orderVerify(WebDriver driver, String customerName, String expectedOrderDate){

    WebElement orderDateElement = driver.findElement(By.xpath("//td[.='"+ customerName +"']/following-sibling::td[3]"));

    String actualOrderDate = orderDateElement.getText();

    Assert.assertEquals(actualOrderDate, expectedOrderDate, "Expected and actual order dates didn't match ");
}


}
/*
1. Create a new class called WebTables Utils.
2. Create two methods to verify order

Method #1 info:
- Name: returnOrderDate()
- Return type: String
- Arg1: WebDriver driver
- Arg2: String costumerName

This method should accept a costumerName and return the costumer order date as a String

Method #2 info:
- Name: orderVerify()
- Return type: void
- Arg1: WebDriver driver
- Arg2: String costumerName
- Arg3: String expectedOrderDate

This method should accept above-mentioned arguments and internally assert expectedOrderDate matching actualOrderDate.
 */