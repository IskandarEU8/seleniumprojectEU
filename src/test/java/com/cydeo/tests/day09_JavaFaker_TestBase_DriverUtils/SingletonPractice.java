package com.cydeo.tests.day09_JavaFaker_TestBase_DriverUtils;

import org.testng.annotations.Test;

public class SingletonPractice {

    @Test
    public void singleton_understand_test1(){

        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1);

        String str2 = Singleton.getWord();
        System.out.println("str1 = " + str2);

        String str3 = Singleton.getWord();
        System.out.println("str1 = " + str3);

    }

    @Test
    public void singleton_understand_test2(){

        String str4 = Singleton.getWord();
        System.out.println("str4 = " + str4);

        String str5 = Singleton.getWord();
        System.out.println("str5 = " + str5);

        String str6 = Singleton.getWord();
        System.out.println("str6 = " + str6);

    }


}
