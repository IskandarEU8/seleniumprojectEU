package com.cydeo.utilities;

public class Print {

    public static void printStarted(){
        System.out.println("\n\nTest started\n");
    }

    public static void printFinished(){
        System.out.println("\nTest finished\n\n");
    }
    public static void printPassed(String title){
        System.out.println(title + " verification passed");
    }

    public static void printFailed(String title){
        System.out.println(title + " verification failed");
    }



}
