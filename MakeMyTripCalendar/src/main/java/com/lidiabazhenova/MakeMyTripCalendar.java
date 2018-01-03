package com.lidiabazhenova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTripCalendar {

    static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub

        WebDriver obj = new ChromeDriver();
        obj.get("https://www.makemytrip.com/flights/");

        obj.manage().window().maximize();
        Thread.sleep(3000L);
        obj.findElement(By.xpath(".//*[@id='hp-widget__depart']")).click();


        //Selecting ur desierd month


        while(!obj.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).getText().contains("MARCH"))
        {
            wait = (new WebDriverWait(obj, 20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']/span[@class='ui-icon ui-icon-circle-triangle-e']")));
            obj.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']/span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            wait = (new WebDriverWait(obj, 10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")));
        }

        int count1=obj.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).size();
        System.out.println(count1);

        for (int i=0;i<count1;i++)
        {
            String s1=obj.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).getText();
            System.out.println(s1);

            if (s1.equalsIgnoreCase("11"))
            {
                obj.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).click();
                break;
            }

        }

//RETURN DATE DATE

        obj.findElement(By.xpath("//input[@id='hp-widget__return']")).click();

        Thread.sleep(3000);
        System.out.println(obj.findElement(By.xpath("(//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month'])[3]")).getText());

        while(!obj.findElement(By.xpath("(//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month'])[3]")).getText().contains("JULY"))
        {
            obj.findElement(By.xpath("(//a[@class='ui-datepicker-next ui-corner-all']/span[@class='ui-icon ui-icon-circle-triangle-e'])[2]")).click();
        }


        int count2=obj.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).size();
        System.out.println(count2);


        for (int i=0;i<count2;i++)
        {
            String s2=obj.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).getText();
            System.out.println(s2);

            if (s2.equalsIgnoreCase("15"))
            {
                obj.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).click();
                break;
            }

        }

    }

}
