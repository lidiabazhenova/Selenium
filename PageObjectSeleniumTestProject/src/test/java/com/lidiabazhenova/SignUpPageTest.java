package com.lidiabazhenova;

import com.lidiabazhenova.page.SignUpPage;
import org.junit.*;
import org.openqa.selenium.By;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class SignUpPageTest extends AbstractSeleniumTest {

    private SignUpPage signUpPage;

    @Before
    public void setUp() {
        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpWithShortPassTest() {
        SignUpPage newSignUpPage = signUpPage.typePassword("q");
        String error = newSignUpPage.getUserPasswordErrorText();
        assertEquals("Password is too short (minimum is 7 characters) and needs at least one number", error);
    }

    @Test
    public void signUpWithReservedUserNameTest() {
        SignUpPage newSignUpPage = signUpPage.typeUserName("username");
        String error = newSignUpPage.getUserNameErrorText();
        assertEquals("Username name 'username' is a reserved word", error);
    }

    @Test
    public void signUpWithExistedUserNameTest() {
        SignUpPage newSignUpPage = signUpPage.typeUserName("user");
        String error = newSignUpPage.getUserNameErrorText();
        assertEquals("Username is already taken", error);
    }


    @Test
    public void signUpWithInvalidFieldsTest() {
        signUpPage.register("23", "23", "23");
        String error = signUpPage.getMainErrorText();
        String errorName = signUpPage.getUserNameErrorText();
        String errorEmail = signUpPage.getUserEmailErrorText();
        String errorPassword = signUpPage.getUserPasswordErrorText();
        assertEquals("There were problems creating your account.", error);
        assertEquals("Login is already taken", errorName);
        assertEquals("Email is invalid or already taken", errorEmail);
        assertEquals("Password is too short (minimum is 7 characters), needs at least one lowercase letter, and can't be your username", errorPassword);
    }

    @Test
    public void signUpWithValidFieldsTest() {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hhmmss");
        String username = "user" + format.format(dateNow);
        String email = "testselenium" + format.format(dateNow) + "@tut.by";
        String password = "password" + format.format(dateNow) + "@tut.by";
        signUpPage.register(username, email, password);
        assertTrue(driver.findElement(By.xpath(".//*[@id='js-pjax-container']//strong[text()='Step 2:']")).isDisplayed());
    }

    @Test
    public void headingTest() {
        String heading = signUpPage.getHeadingText();
        assertEquals("Join GitHub", heading);
    }

}
