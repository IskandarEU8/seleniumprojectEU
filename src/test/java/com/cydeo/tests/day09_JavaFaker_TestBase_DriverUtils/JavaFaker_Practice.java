package com.cydeo.tests.day09_JavaFaker_TestBase_DriverUtils;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

public class JavaFaker_Practice {

    @Test
    public void test1(){

        //Creating Faker object to reach methods
        Faker faker = new Faker(new Locale("de"));

        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Iskandar"));
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Iskandar"));
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Iskandar"));
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Iskandar"));
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Iskandar"));

        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.ancient().hero() = " + faker.ancient().hero());
        System.out.println("faker.crypto().md5() = " + faker.crypto().md5());

        System.out.println("faker.numerify(\"###-####-#####\") = " + faker.numerify("1-312-###-##-##"));
        System.out.println("faker.letterify(\"???-????\") = " + faker.letterify("???-????"));
        System.out.println("faker.bothify(\"##?#-##?#-#??#\") = " + faker.bothify("##?#-##?#-#??#"));
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());


    }

}
