package com.lidiabazhenova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MainClass {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\projects\\Selenium\\DropDownCheckBoxesRadioButtonsAlerts\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://spicejet.com");

        Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_Adult']")));

        dropdown.selectByIndex(4);
        dropdown.selectByValue("8");
        dropdown.selectByVisibleText("3");

        System.out.println(driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_chk_IndArm']")).isSelected());

        driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_chk_IndArm']")).click();

        System.out.println(driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_chk_IndArm']")).isSelected());

        driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_chk_IndArm']")).click();

        System.out.println(driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_chk_IndArm']")).isSelected());

        driver.get("http://www.echoecho.com/htmlforms10.htm");

//driver.findElement(By.xpath("//input[@value='Milk']")).click();

        int count = driver.findElements(By.xpath("//input[@name='group1']")).size();

        for (int i = 0; i < count; i++)

        {

//driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();

            String text = driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");

            if (text.equals("Cheese"))

            {

                driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();

            }

        }

        driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");

        driver.findElement(By.xpath("html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/form/input")).click();

        System.out.println(driver.switchTo().alert().getText());

//driver.switchTo().alert().sendKeys("fesfe");

        driver.switchTo().alert().accept(); //Accept = ok done yes

//driver.switchTo().alert().dismiss();

    }

}
