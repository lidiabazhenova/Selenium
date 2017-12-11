package com.lidiabazhenova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\projects\\Selenium\\testselenium1\\drivers1\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.tut.by/");
        WebElement search = driver.findElement(By.id("search_from_str"));
        search.sendKeys("EPAM-systems");
        driver.findElement(By.name("search")).click();

        try {
            WebElement controlLink = driver.findElement(
                    By.xpath("(//li[@class='b-results__li'])[1]//*[contains(text(), 'EPAM')]"));
            System.out.println(controlLink.getText());
            if (controlLink.getText().contains("EPAM")) {
                System.out.println("True");
                driver.findElement(By.xpath("(//li[@class='b-results__li'])//a[contains(text(), 'www.epam.com')]")).click();
            } else throw new Exception("Not correct site");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            if (driver.findElement(By.cssSelector("title")).getText().contains("EPAM-systems")) {
                System.out.println("This is www.epam.com");
            } else throw new Exception("Not correct site");
        } catch (Exception e) {
            System.out.println("This isn't www.epam.com");
        }
    }
}
