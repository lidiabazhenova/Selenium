package com.lidiabazhenova;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainClass {
    private static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\projects\\Selenium\\PageObjectSeleniumTest\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://github.com/");

        //MainPage mainPage = new MainPage(driver);

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);

        mainPage.registration("testusername00999", "ggg@mail.ru", "123");


    }
}
