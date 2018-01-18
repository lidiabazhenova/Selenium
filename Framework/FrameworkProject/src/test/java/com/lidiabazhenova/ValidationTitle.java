package com.lidiabazhenova;

import com.lidiabazhenova.pageObjects.LandingPage;
import com.lidiabazhenova.pageObjects.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

import static org.testng.Assert.*;

public class ValidationTitle extends Base {

    private static Logger logger = LogManager.getLogger(ValidationTitle.class.getName());

    @BeforeTest
    public void setUp() throws Exception {
        driver = initializeDriver();
        logger.info("driver is initialised");
        driver.get(properties.getProperty("url"));
        logger.info("navigated to Home page");
    }

    @Test
    public void validateTitleTest() throws IOException {
        LandingPage landingPage = new LandingPage(driver);
        assertEquals(landingPage.getTitle().getText(), "FEATURED COURSES");
        logger.info("successfuly validated text");
    }


    @AfterTest
    public void tearDown() throws Exception {
        driver.close();
        driver = null;
    }
}

