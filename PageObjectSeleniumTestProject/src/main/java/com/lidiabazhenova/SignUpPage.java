package com.lidiabazhenova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//div[contains(@class, \"setup-header\")]/h1");
    private By userNameField = By.xpath("//input[@id='user_login']");
    private By userEmailField = By.xpath("//input[@id='user_email']");
    private By userPasswordField = By.xpath("//input[@id='user_password']");
    private By signUpButton = By.xpath("//button[@id=\"signup_button\"]");
    private By mainError = By.xpath("//form[@id='signup-form']/div[contains(@class, 'flash flash-error')]");
    private By userNameError = By.xpath("//input[@id=\"user_login\"]/ancestor::dd/following-sibling::dd");
    private By userEmailError = By.xpath("//input[@id='user_email']/ancestor::dd/following-sibling::dd");
    private By userPasswordError = By.xpath("//input[@id='user_password']/ancestor::dd/following-sibling::dd");

    public SignUpPage typeUserName(String userName) {
        driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(userPasswordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        driver.findElement(userEmailField).sendKeys(email);
        return this;
    }

    public SignUpPage registerWithInvalidCreds(String userName, String eMail, String password) {
        this.typePassword(userName);
        this.typeEmail(eMail);
        this.typeEmail(password);
        driver.findElement(signUpButton);
        return new SignUpPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getMainErrorText() {
        return driver.findElement(mainError).getText();
    }

    public String getUserNameErrorText() {
        return driver.findElement(userNameError).getText();
    }

    public String getUserEmailErrorText() {
        return driver.findElement(userEmailError).getText();
    }

    public String getUserPasswordErrorText() {
        return driver.findElement(userPasswordError).getText();
    }



}

