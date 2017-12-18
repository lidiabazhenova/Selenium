package com.lidiabazhenova.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//"//div[contains(@class, \"setup-header\")]/h1"
    @FindBy(xpath = "//div[contains(@class, 'setup-header')]/h1")
    private WebElement heading;

    @FindBy(xpath = "//input[@id='user_login']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@id='user_email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='user_password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//button[@id='signup_button']")
    private WebElement signUpButton;

    @FindBy(xpath = "//form[@id='signup-form']/div[contains(@class, 'flash flash-error')]")
    private WebElement mainError;

    @FindBy(xpath = "//input[@id='user_login']/ancestor::dd/following-sibling::dd")
    private WebElement userNameError;

    @FindBy(xpath = "//input[@id='user_email']/ancestor::dd/following-sibling::dd")
    private WebElement userEmailError;

    @FindBy(xpath = "//input[@id='user_password']/ancestor::dd/following-sibling::dd")
    private WebElement userPasswordError;

    public SignUpPage typeUserName(String userName) {
        userNameField.sendKeys(userName);
        return this;
    }

    public SignUpPage typePassword(String password) {
        userPasswordField.sendKeys(password);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        userEmailField.sendKeys(email);
        return this;
    }

    public void register(String userName, String eMail, String password) {
        typeUserName(userName);
        typeEmail(eMail);
        typePassword(password);
        signUpButton.click();
    }

    public String getHeadingText() {
        return heading.getText();
    }

    public String getMainErrorText() {
        return mainError.getText();
    }

    public String getUserNameErrorText() {
        return userNameError.getText();
    }

    public String getUserEmailErrorText() {
        return userEmailError.getText();
    }

    public String getUserPasswordErrorText() {
        return userPasswordError.getText();
    }

}

