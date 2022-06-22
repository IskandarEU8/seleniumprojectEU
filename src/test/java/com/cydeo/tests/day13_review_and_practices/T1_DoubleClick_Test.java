package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T1_DoubleClick_Test {


    @AfterMethod
    public void tearDown(){
        Driver.quitDriver(1.4);
    }

    @Test
    public void t1_double_click_test(){

        //1. Goto: https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2

        Driver.getDriver().navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //2. Switch to iframe.

        //3. Double-click on the text “Double-click me to change my text color.”

        //4. Assert:Text’s “style” attribute value contains “red”.



    }


}
//52.00.00