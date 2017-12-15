package com.lidiabazhenova.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[text()='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[text()='Sign up']")
    private WebElement signUpButton;

    @FindBy(xpath = "//input[@id='user[login]']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@id=\"user[email]\" ]")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id='user[password]']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//button[text()='Sign up for GitHub']")
    private WebElement signUpFormButton;

    public LoginPage clickSignIn() {
        signInButton.click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton() {
        signUpButton.click();
        return new SignUpPage(driver);

    }

    public SignUpPage clickSignUpFormButton() {
        signUpFormButton.click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName(String userName) {
        userNameField.sendKeys(userName);
        return this;
    }

    public MainPage typePassword(String password) {
        userPasswordField.sendKeys(password);
        return this;
    }

    public MainPage typeEmail(String email) {
        userEmailField.sendKeys(email);
        return this;
    }

    public SignUpPage registration(String username, String email, String password) {
        typeUserName(username);
        typeEmail(email);
        typePassword(password);
        clickSignUpFormButton();

        return new SignUpPage(driver);
    }
}
