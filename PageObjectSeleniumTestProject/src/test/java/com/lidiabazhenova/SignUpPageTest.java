package com.lidiabazhenova;

import com.lidiabazhenova.page.MainPage;
import com.lidiabazhenova.page.SignUpPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\projects\\Selenium\\PageObjectSeleniumTest\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpWithShortPassTest () {
        SignUpPage newSignUpPage = signUpPage.typePassword("q");
        String error = newSignUpPage.getUserPasswordErrorText();
        Assert.assertEquals("Password is too short (minimum is 7 characters) and needs at least one number", error);
    }

    @Test
    public void signUpWithReservedUserNameTest () {
        SignUpPage newSignUpPage = signUpPage.typeUserName("username");
        String error = newSignUpPage.getUserNameErrorText();
        Assert.assertEquals("Username name 'username' is a reserved word", error);
    }

    @Test
    public void signUpWithExistedUserNameTest () {
        SignUpPage newSignUpPage = signUpPage.typeUserName("user");
        String error = newSignUpPage.getUserNameErrorText();
        Assert.assertEquals("Username is already taken", error);
    }


    @Test
    public void signUpWithInvalidFieldsTest () {
        signUpPage.register("23", "23", "23" );
        String error = signUpPage.getMainErrorText();
        String errorName = signUpPage.getUserNameErrorText();
        String errorEmail = signUpPage.getUserEmailErrorText();
        String errorPassword = signUpPage.getUserPasswordErrorText();
        Assert.assertEquals("There were problems creating your account.", error);
        Assert.assertEquals("Login is already taken", errorName);
        Assert.assertEquals("Email is invalid or already taken", errorEmail);
        Assert.assertEquals("Password is too short (minimum is 7 characters), needs at least one lowercase letter, and can't be your username", errorPassword);
    }

    @Test
    public void signUpWithValidFieldsTest () {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hhmmss");
        String username = "user" + format.format(dateNow);
        String email = "testselenium" + format.format(dateNow) + "@tut.by";
        String password = "password" + format.format(dateNow) + "@tut.by";
        signUpPage.register(username, email, password );
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='js-pjax-container']//strong[text()='Step 2:']")).isDisplayed());
    }

    @Test
    public void headingTest() {
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub", heading);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
