package com.lidiabazhenova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//lectures 88-94 Webserver
public class Main {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        WebDriverWait wd = new WebDriverWait(driver, 7);

        driver.get("https://fantasycricket.dream11.com/IN/");

        driver.findElement(By.xpath("//*[@id='m_rtxtEmail1']")).sendKeys("aa");
        wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='m_frmRegister']/div[1]/ul/li[2]/p")));

        driver.findElement(By.xpath("//*[@id='m_frmRegister']/div[1]/ul/li[2]/p")).click();

        //Site has changed. There is no element with id='recaptcha-anchor

        int number = findFrameNumber(driver, By.xpath(".//*[@id='recaptcha-anchor']/div[5]"));

        driver.switchTo().frame(number);

        driver.findElement(By.xpath(".//*[@id='recaptcha-anchor']/div[5]")).click();
    }



        public static int findFrameNumber (WebDriver driver, By by)
        {

            int i;

            int framecount = driver.findElements(By.tagName("iframe")).size();

            for (i = 0; i < framecount; i++)

            {
                driver.switchTo().frame(i);

                int count = driver.findElements(by).size();

                if (count > 0) {

                    break;

                } else {
                    System.out.println("continue looping");
                }
            }

            driver.switchTo().defaultContent();

            return i;

        }

    }
