package com.lidiabazhenova;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class MainClass {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\projects\\Selenium\\exampleKeysImitation\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        WebElement searchInput = driver.findElement(By.xpath("//input[@id='searchInput']"));

        String select = Keys.chord(Keys.CONTROL, "a");
        String cut = Keys.chord(Keys.CONTROL, "x");
        String copy = Keys.chord(Keys.CONTROL, "c");
        String paste = Keys.chord(Keys.CONTROL, "v");


        searchInput.sendKeys(Keys.chord(Keys.SHIFT, "new year"));
        //searchInput.sendKeys(Keys.ENTER);
        searchInput.sendKeys(select);
        searchInput.sendKeys(cut);
        searchInput.sendKeys(paste);
        searchInput.sendKeys(select);
        searchInput.sendKeys(Keys.DELETE);
        searchInput.sendKeys(Keys.chord(Keys.SHIFT, "test"));
        searchInput.sendKeys(select);
        searchInput.sendKeys(copy);
        searchInput.sendKeys(paste);
        searchInput.sendKeys(Keys.ENTER);


        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
        String filename = format.format(dateNow)+ ".png";

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File("C:\\projects\\Selenium\\screenshots\\" + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();


    }

}
