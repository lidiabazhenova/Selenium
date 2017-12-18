package com.lidiabazhenova;

import com.lidiabazhenova.page.LoginPage;
import com.lidiabazhenova.page.MainPage;
import com.lidiabazhenova.page.SignUpPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainPageTest extends AbstractSeleniumTest {

    private MainPage mainPage;

    @Before
    public void setUp() {
        driver.get("http://github.com");
        mainPage = new MainPage(driver);
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

}
