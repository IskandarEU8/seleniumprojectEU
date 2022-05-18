package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
/*
        WebDriver driver = new FirefoxDriver();
//        driver1.get("https://www.facebook.com");
//        driver1.get("https://www.apple.com");
//        Thread.sleep(1500);
//        driver1.get("https://www.tesla.com/");
//        Thread.sleep(2500);
//        driver1.navigate().back();
//
//        Thread.sleep(2500);
//        driver1.navigate().forward();
//        Thread.sleep(2500);
//        driver1.navigate().to("https://google.com");
        driver.navigate().to("https://kaktus.media");
        String currentTitle = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();

        System.out.println(currentTitle + " : " + currentUrl);
        System.out.println("driver.getTitle() = " + driver.getTitle());

 */

        WebDriver driver1 = new ChromeDriver();

        driver1.navigate().to("https://myip.com");
        String currentTitle = driver1.getTitle();
        String currentUrl = driver1.getCurrentUrl();

        System.out.println(currentTitle + " : " + currentUrl);
        Thread.sleep(2500);
        driver1.navigate().to("https://whoer.net");


        currentTitle = driver1.getTitle();
        currentUrl = driver1.getCurrentUrl();
        System.out.println(currentTitle + " : " + currentUrl);

        Thread.sleep(2500);
        driver1.navigate().to("https://www.samsung.com/us/mobile/");
        currentTitle = driver1.getTitle();
        currentUrl = driver1.getCurrentUrl();
        System.out.println(currentTitle + " : " + currentUrl);

        Test test = new Test();
        test.automate("https://abc.com");
        driver1.quit();



//      driver1.navigate().refresh();

/*
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");

        WebDriver driver2 = new EdgeDriver();
        driver.get("https://www.facebook.com");

                VIDEO 3:27:00
 */
//VIDEO 3:53:00
    }

    public void automate(String url){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);
        String currentTitle = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentTitle + " : " + currentUrl);
//        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        driver.close();
    }

}
