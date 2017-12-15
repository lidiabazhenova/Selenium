package com.lidiabazhenova;

import com.lidiabazhenova.page.LoginPage;
import com.lidiabazhenova.page.MainPage;
import com.lidiabazhenova.page.SignUpPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\projects\\Selenium\\PageObjectSeleniumTest\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://github.com");
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }


    @Test
    public void signInTest() {
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void regisrFailTest() {
        SignUpPage signUpPage = mainPage.registration("useruser", "useruser@mail.ru", "000000");
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", error);
    }

    @Test
    public void signUpEmptyUserNameTest() {
        SignUpPage signUpPage = mainPage.registration("", "useruser@mail.ru", "000000");
        String error = signUpPage.getUserNameErrorText();
        Assert.assertEquals("Login can't be blank", error);
    }

    @Test
    public void signUpInvalidEmailTest() {
        SignUpPage signUpPage = mainPage.registration("3333llll", "userusermail.ru", "000000");
        String error = signUpPage.getUserEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }

    @After
    public void tearDown() {
        driver.close();
    }


}
