package com.lidiabazhenova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) {

        //       System.setProperty("webdriver.gecko.driver", "C:\\projects\\Selenium\\dificultActions\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\\\projects\\\\Selenium\\\\dificultActions\\\\drivers\\chromedriver.exe");

//        WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://www.ebay.com");

        driver.findElement(By.xpath("//*[@id=\"HomepageOverlay14374ModalClose\"]/img")).click();
        By.xpath("//tr[@role='list']//a[text()='Электроника']");

        WebElement link = driver.findElement(By.xpath("//tr[@role='list']//a[text()='Электроника']"));
        WebElement element = driver.findElement(By.xpath("//tr[@role='list']//a[text()='Электроника']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(link).build().perform();

//        actions.dragAndDrop(element, link).build().perform();
//
//        actions.clickAndHold(element).moveToElement(link).release().build().perform();
//
//        actions.doubleClick(element);
//        actions.contextClick(element);
//
//        Action action = actions.clickAndHold(element).moveToElement(link).release().build();
//        action.perform();

        //       driver.quit();
    }

}
