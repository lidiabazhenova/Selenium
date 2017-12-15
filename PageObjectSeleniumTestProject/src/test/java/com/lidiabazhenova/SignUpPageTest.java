package com.lidiabazhenova;

import com.lidiabazhenova.page.SignUpPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    private WebDriver driver;
    SignUpPage signUpPage;

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
    public void headingTest() {
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub", heading);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
