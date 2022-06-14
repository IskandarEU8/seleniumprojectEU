package com.cydeo.tests.day10_Upload_Actions_JSexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    @Test
    public void upload_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("upload_test_url"));

    }

}
