package com.lidiabazhenova.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath("//input[@id=\"login_field\"]");
    private By passwordField = By.xpath("//input[@id=\"password\"]");
    private By signInButton = By.xpath("//input[@type=\"submit\"]");
    private By heading = By.xpath("//div[contains(@class, 'auth-form-header')]/h1");
    private By error = By.xpath("//div[@id='js-flash-container']//div[@class='container']");
    private By createAccountLink = By.xpath("//a[text()='Create an account']");

    public LoginPage typeUserName(String userName) {
        driver.findElement(loginField).sendKeys(userName);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public void login(String userName, String password) {
        typeUserName(userName);
        typePassword(password);

        driver.findElement(signInButton).click();
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getErrorText() {
        return driver.findElement(error).getText();
    }

    public SignUpPage createAccount() {
        driver.findElement(createAccountLink).click();
        return new SignUpPage(driver);
    }
}
