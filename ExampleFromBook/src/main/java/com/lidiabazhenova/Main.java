package com.lidiabazhenova;

import com.google.common.base.Predicate;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Main {
    static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\projects\\Selenium\\testselenium1\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("http://svyatoslav.biz/testlab/wt");
        Collection<WebElement> forms = driver.findElements(By.tagName("form"));
        assertFalse("No forms found!", forms.isEmpty());
        Iterator<WebElement> i = forms.iterator();
        boolean form_found = false;
        WebElement form = null;
        while (i.hasNext()) {
            form = i.next();
            if ((form.findElement(By.name("name")).getAttribute("type").equalsIgnoreCase("text")) && (form.findElement(By.name("height")).getAttribute("type").equalsIgnoreCase("text")) &&
                    (form.findElement(By.name("weight")).getAttribute("type").equalsIgnoreCase("text")) && (form.findElement(By.xpath("//input[@type='submit']")).getAttribute("value").equalsIgnoreCase("Рассчитать")) && (form.findElements(By.name("gender")).size() == 2)) {
                form_found = true;
                break;
            }
        }
        assertTrue("No suitable forms found!", form_found);

        // 2 (action) В поле «Имя» ввести «username».
        form.findElement(By.name("name")).clear();
        form.findElement(By.name("name")).sendKeys("username");
        // 2 (check) Значение появляется в поле.
        assertEquals("Unable to fill 'Имя' filed", "username", form.findElement(By.name("name")).getAttribute("value"));
        // 3 (action) В поле «Рост» ввести «50».
        form.findElement(By.name("height")).clear();
        form.findElement(By.name("height")).sendKeys("50");
        // 3 (check) Значение появляется в поле.
        assertEquals("Unable to fill 'Рост' filed", "50", form.findElement(By.name("height")).getAttribute("value"));
        // 4 (action) В поле «Вес» ввести «3».
        form.findElement(By.name("weight")).clear();
        form.findElement(By.name("weight")).sendKeys("3");
        // 4 (check) Значение появляется в поле.
        assertEquals("Unable to fill 'Вес' filed", "3", form.findElement(By.name("weight")).getAttribute("value"));
        // 5 (action) В радиокнопке «Пол» выбрать пол «М».
        form.findElement(By.xpath("//input[@name='gender' and @value='m']")).click();
        // 5 (check) Вариант «М» выбран.
        assertTrue("Unable select 'М' gender", form.findElement(By.xpath("//input[@name='gender' and @value='m']")).isSelected());


        // 6 (action) Нажать «Рассчитать».
        form.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        // 6 (check) Форма исчезает, в центральной ячейке таблицы появляется надпись «Слишком мала масса тела».
        // Thread.sleep(3000);
        wait = (new WebDriverWait(driver, 20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@value='Рассчитать']")));
        forms = driver.findElements(By.tagName("form"));
        i = forms.iterator();
        form_found = false;
        while (i.hasNext()) {
            form = i.next();
            if ((form.findElement(By.name("name")).getAttribute("type").equalsIgnoreCase("text"))
                    && (form.findElement(By.name("height")).getAttribute("type").equalsIgnoreCase("text"))
                    && (form.findElement(By.name("weight")).getAttribute("type").equalsIgnoreCase("text"))
                    && (form.findElement(By.xpath("//input[@type=\"submit\"]")).getAttribute("value").equalsIgnoreCase("Рассчитать"))
                    && (form.findElements(By.name("gender")).size() == 2)) {
                form_found = true;
                break;
            }
        }

        Assert.assertFalse("Form is on the page!", form_found);
        final WebElement resultElement = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
        Assert.assertEquals("Слишком малая масса тела", resultElement.getText());
    }

}



