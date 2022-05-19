package com.cydeo.tests.day05_DynamicWebElements_DropDowns.testNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @BeforeClass
    public void setUpMethod(){
        System.out.println("\n---> BeforeMethod is running");
    }

    @AfterClass
    public void tearDownMethod(){
        System.out.println("---> AfterMethod is running");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 is running");
        // ASSERT EQUALS: compare 2 of the same things

        String actual = "apple";
        String expected = "apple";

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test2(){
        System.out.println("Test 2 is running");
        String actual = "apple";
        String expected = "apple";

        Assert.assertEquals(actual,expected);
    }

}
