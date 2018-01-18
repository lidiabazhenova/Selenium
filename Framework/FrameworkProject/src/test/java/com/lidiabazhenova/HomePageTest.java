package com.lidiabazhenova;

import com.lidiabazhenova.pageObjects.LandingPage;
import com.lidiabazhenova.pageObjects.LoginPage;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class HomePageTest extends Base {

    private static org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(HomePageTest.class.getName());

    @BeforeTest
    public void setUp() throws Exception {
        driver = initializeDriver();
        logger.info("driver is initialised");
    }

    @BeforeMethod
    public void getUrl() {
        driver.get(properties.getProperty("url"));
        logger.info("navigated to Home page");
    }

    @Test(dataProvider = "getData")
    public void signInHomePageTest(String eMail, String password, String text) throws IOException {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.getLogin().click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmail().sendKeys(eMail);
        loginPage.getPassword().sendKeys(password);
        System.out.println(text);
        loginPage.getLogin().click();
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[2][3];
        data[0][0] = "auttest@tut.by";
        data[0][1] = "auttest";
        data[0][2] = "non restricted user";
        data[1][0] = "lkl@klk.com";
        data[1][1] = "123123";
        data[1][2] = "restricted user";
        return data;
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.close();
    }
}

