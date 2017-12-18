package com.lidiabazhenova;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    private static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\projects\\Selenium\\tutby\\drivers\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get("https://www.google.com/imghp?hl=ru");

        driver.findElement(By.xpath("//a[@aria-label=\"Поиск по картинке\"]//span[@id=\"qbi\"]")).click();
        driver.findElement(By.xpath("//a[text()='Загрузить файл']")).click();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\projects\\Selenium\\testselenium1\\screenshots\\02_25_26.png");

    }

}
