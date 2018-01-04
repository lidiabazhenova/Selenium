package com.lidiabazhenova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TableExercises {

    public static void main(String[] args) {

        //lectutes 96-99

        System.setProperty("webdriver.gecko.driver", "c:/projects/selenium/drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.cricbuzz.com/live-cricket-scorecard/18970/pak-vs-sl-2nd-t20i-pakistan-v-sri-lanka-in-uae-2017");

        WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
        int rowCount = table.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms")).size();
        int itemsInColoumnThreeCount = table.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms div:nth-child(3)")).size();

        for (int i = 0; i < itemsInColoumnThreeCount-2; i++) {
            System.out.println(table.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms div:nth-child(3)")).get(i).getText());
        }

        System.out.println(table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div[1]")).getText());
        System.out.println(table.findElement(By.xpath("//div[text()='Total']/following-sibling::div[1]")).getText());

    }
}
