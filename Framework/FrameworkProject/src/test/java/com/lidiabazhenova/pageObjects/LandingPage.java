package com.lidiabazhenova.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    By signIn = By.cssSelector("a[href*='sign_in']");
    By title = By.xpath("//*[contains(text(), 'Featured Courses')]");
    By navBar = By.xpath("//nav[@class='navbar-collapse collapse']");

    public WebElement getLogin() {
        return driver.findElement(signIn);
    }

    public WebElement getTitle() {
        return driver.findElement(title);
    }

    public WebElement getNavigationBar() {
        return driver.findElement(navBar);
    }

}


