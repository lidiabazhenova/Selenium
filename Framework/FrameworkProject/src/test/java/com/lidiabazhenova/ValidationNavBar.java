package com.lidiabazhenova;

import com.lidiabazhenova.pageObjects.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ValidationNavBar extends Base {

    private static Logger logger = LogManager.getLogger(ValidationNavBar.class.getName());

    @BeforeTest
    public void setUp() throws Exception {
        driver = initializeDriver();
        logger.info("driver is initialised");
        driver.get(properties.getProperty("url"));
        logger.info("navigated to Home page");
    }

    @Test
    public void validateNavBarTest() throws IOException {
        LandingPage landingPage = new LandingPage(driver);
        assertTrue(landingPage.getNavigationBar().isDisplayed());
        logger.info("successfuly validated text");
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.close();
        driver = null;
    }
}

