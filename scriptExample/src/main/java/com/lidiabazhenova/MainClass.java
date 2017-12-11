package com.lidiabazhenova;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) {
        //       System.setProperty("webdriver.gecko.driver", "C:\\projects\\Selenium\\dificultActions\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\\\projects\\\\Selenium\\\\ScriptExample\\\\drivers\\chromedriver.exe");

//        WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.manage().window().maximize();

//        driver.get("http://en.wikipedia.org");
//
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("window.scrollBy(0, 1000)", "");
//        jse.executeScript("window.scrollBy(0, -1000)", "");
// jse.executeScript("alert('HELLO WORLD')");

        driver.get("http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html");
        String mainWindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='jdk-8u151-windows-x64.exe']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("(//a[text()='Oracle Binary Code License Agreement for Java SE'])[1]")).click();

        //switch to last window with for:

        for (String window : driver.getWindowHandles()
                ) {
            driver.switchTo().window(window);
        }

        driver.findElement(By.xpath("//a[@href='/technetwork/java/index.html']")).click();

        driver.switchTo().window(mainWindow);

        driver.get("http://google.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("confirm('Are you sure?');");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().dismiss();

    }

}
