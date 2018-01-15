package com.lidiabazhenova;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBaseTest {

    WebDriver driver = null;

    @BeforeSuite
    public void login() throws IOException
    {
        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream("C:\\projects\\Selenium\\Framework\\DataDrivenParametrization\\src\\test\\java\\com\\lidiabazhenova\\current.properties");

        prop.load(fis);

        //System.out.println(prop.getProperty("username"));

        if (prop.getProperty("browser").equals("firefox"))

        {

            driver = new FirefoxDriver();

        } else if (prop.getProperty("browser").equals("chrome"))

        {

            driver = new ChromeDriver();

        } else

        {

            driver = new InternetExplorerDriver();

        }

        driver.get(prop.getProperty("url"));



    }

    @Test
    public void test() {
        System.out.println("test");

    }
}
