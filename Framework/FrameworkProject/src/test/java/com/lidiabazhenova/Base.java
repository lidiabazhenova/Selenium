package com.lidiabazhenova;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    Properties properties;

    public WebDriver initializeDriver() throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream("C:\\projects\\Selenium\\Framework\\FrameworkProject\\src\\test\\resources\\data.properties");
        properties.load(fis);
        String browserName = properties.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.out.println(browserName);
            System.setProperty("webdriver.chrome.driver", "C:\\projects\\Selenium\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("IE")) {//IE code
        } else if (browserName.equals("firefox")) {
            //ff code
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    public void getScreenshot(String result) {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
        String filename = format.format(dateNow) + result + ".png";

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File("C:\\projects\\screenshots\\" + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
