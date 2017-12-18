package com.lidiabazhenova;

import com.lidiabazhenova.page.LoginPage;
import com.lidiabazhenova.page.SignUpPage;
import org.junit.*;

public class LoginPageTest extends AbstractSeleniumTest {
    private LoginPage loginPage;

    @Before
    public void setUp() {
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyFieldsTest() {
        loginPage.login("", "");
        String error = loginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void loginWithInvalidFieldsTest() {
        loginPage.login("uyuy", "123123");
        String error = loginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void loginWithValidFieldsTest() {
        loginPage.login("mytestuserforgit", "mytestuserforgitpassword");
        Assert.assertEquals("Learn Git and GitHub without any code!", loginPage.getHeadingForStartGit());
    }

    @Test
    public void createAccTest() {
        SignUpPage signUpPage = loginPage.createAccount();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub", heading);
    }

}
