package com.lidiabazhenova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainClass {

    private static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\projects\\Selenium\\tutby\\drivers\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        //driver.get("https://www.tut.by/");
//        driver.findElement(By.xpath("//div[@id=\"authorize\"]//a")).click();
//        driver.findElement(By.xpath("//input[@name=\"login\"]")).sendKeys("testselenium");
//        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("testselenium");
//        driver.findElement(By.xpath("//form[@class=\"auth-form\"]//input[@type=\"submit\"]")).submit();
//        WebElement pageAutorizaded = driver.findElement(By.xpath("//div[@id='authorize']//span[text()='test selenium']"));
//
//        pageAutorizaded.click();
//        driver.findElement(By.xpath("//div[@id=\"authorize\"]//a[text()=\"Почта\"]")).click();
//

        //​testselenium@tut​.by
        driver.get("https://mail.yandex.by/#inbox");
        driver.findElement(By.xpath("//span[text()=\"Войти в Яндекс.Почту\"]")).click();
        driver.findElement(By.xpath("(//span[@class=\"passport-Input-Label\"])[1]")).sendKeys("testselenium@tut\u200B.by");

        WebElement password = driver.findElement(By.xpath("(//span[@class=\"passport-Input-Label\"])[2]"));
        password.click();
        password.sendKeys("testselenium");
        driver.findElement(By.xpath("//button//*[text()=\"Войти\"]")).click();

        List<WebElement> unreadMails = driver.findElements(By.xpath("//span[@title=\"Отметить как прочитанное\"]"));
        System.out.println("size" + unreadMails.size());
        for (WebElement unreadMail : unreadMails) {
            driver.findElement(By.xpath("//span[@ class=\"_nb-checkbox-flag _nb-checkbox-normal-flag\"]")).click();
        }
        driver.findElement(By.xpath("//div[@title=\"Удалить (Delete)\"]")).click();

    }


}

