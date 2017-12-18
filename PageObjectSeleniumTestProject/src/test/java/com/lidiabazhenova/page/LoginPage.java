package com.lidiabazhenova.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private  WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='login_field']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[contains(@class, 'auth-form-header')]/h1")
    private WebElement heading;

    @FindBy(xpath = "//div[@id='js-pjax-container']//h2")
    private WebElement headingForStartGit;

    @FindBy(xpath = "//div[@id='js-flash-container']//div[@class='container']")
    private WebElement error;

    @FindBy(xpath = "//a[text()='Create an account']")
    private WebElement createAccountLink;

    public LoginPage typeUserName(String userName) {
        loginField.sendKeys(userName);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public void login(String userName, String password) {
        typeUserName(userName);
        typePassword(password);
        signInButton.click();
    }

    public String getHeadingText() {
        return heading.getText();
    }

    public String getHeadingForStartGit() {
        return headingForStartGit.getText();
    }

    public String getErrorText() {
        return error.getText();
    }

    public SignUpPage createAccount() {
        createAccountLink.click();
        return new SignUpPage(driver);
    }
}
