package com.cydeo.tests.day08_WebTableCont_Props_ConfigReader;

import org.testng.annotations.Test;

public class LearningProperties {

    @Test
    public void java_properties_reading_test(){
        // key - value
        // os.name = Windows 10
        // user.name = iCan
        System.out.println("System.getProperties(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
    }

}
//VIDEO: 2:20:00