package com.lidiabazhenova;

import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signInButton = By.xpath("//a[text()='Sign in']");
    private By signUpButton = By.xpath("//a[text()='Sign up']");
    private By userNameField = By.xpath("//input[@id='user[login]']");
    private By userEmailField = By.xpath("//input[@id=\"user[email]\" ]");
    private By userPasswordField = By.xpath("//input[@id='user[password]']");
    private By signUpFormButton = By.xpath("//button[text()='Sign up for GitHub']");

    public LoginPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);

    }

    public SignUpPage clickSignUpFormButton() {
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName(String userName) {
        driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public MainPage typePassword(String password) {
        driver.findElement(userPasswordField).sendKeys(password);
        return this;
    }

    public MainPage typeEmail(String email) {
        driver.findElement(userEmailField).sendKeys(email);
        return this;
    }

    public SignUpPage registration(String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);


    }
}
