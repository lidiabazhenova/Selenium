package com.lidiabazhenova;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(17, TimeUnit.SECONDS);

        driver.get("https://www.tez-tour.com/");

        driver.findElement(By.xpath(".//*[@id='fancybox-close']")).click();
        Thread.sleep(1000);
        WebElement dateSelection = driver.findElement(By.xpath(".//*[@id='dateRange-from']"));
        dateSelection.click();
        wait = (new WebDriverWait(driver, 20));
        ////*[@id="ui-datepicker-div"]/div[1]/table/tbody/tr[4]/td[7]/a
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[7]/a")));
        WebElement d = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[7]/a"));
        d.click();
//        WebDriver driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(17, TimeUnit.SECONDS);
//
////Is displayed is used when particular object is in code base but it is in visible mode or not

//        driver.get("http://www.makemytrip.com/");
//
//
////        wait = (new WebDriverWait(driver, 20));
////        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[7]/a")));
//        System.out.println(driver.findElement(By.xpath(".//*[@id='hp-widget__depart']")).isDisplayed());
//
////driver.findElement(By.xpath(".//*[@id='multi_city_button']/span")).click();
//
////driver.findElement(By.xpath(".//*[@id='multi_city_button']/span")).isEnabled();
//
//        driver.findElement(By.xpath(".//*[@id='hp-widget__depart']")).click();
//Thread.sleep(10000);
//       // System.out.println(driver.findElement(By.xpath(".//*[@id='dp1513328330722']/div/div[1]/table/tbody/tr[4]/td[7]/a")));
//


    }
}
