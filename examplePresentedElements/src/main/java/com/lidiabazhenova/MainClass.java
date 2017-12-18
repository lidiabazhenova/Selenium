package com.lidiabazhenova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\\\projects\\\\Selenium\\\\examplePresentedElements\\\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://github.com/");

        if (driver.findElements(By.xpath("//a[text()='Log in']")).size() > 0)
            System.out.println("Such element is presented");
        else System.out.println("Cannot find such element");

    }

}
