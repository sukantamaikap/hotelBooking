package org.test.org;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.test.org.drivers.DriverFactory;
import org.test.org.pages.BookingPageFactory;
import org.test.org.utils.ConfigUtil;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class BaseUITest {
    private static final Logger LOG = LoggerFactory.getLogger(BaseUITest.class);

    protected DriverFactory driverFactory;
    protected BookingPageFactory bookingPageFactory;

    /**
     * Start browser and prepare environment
     */
    @BeforeTest
    public void prepEnvironment() throws IOException {
        if (this.driverFactory != null) {
            LOG.info("WE NEED TO CLOSE ANY DORMANT BROWSER SESSION");
            this.driverFactory.getDriver().quitDriver();
            this.driverFactory = null;
        }

        LOG.info("START A NEW DRIVER SESSION");
        this.driverFactory = DriverFactory.getInstance();

        LOG.info("INIT PAGE");
        this.bookingPageFactory = new BookingPageFactory(this.driverFactory.getDriver());

        this.driverFactory.getDriver().getWebDriver().navigate().to(ConfigUtil.getBaseUrl());

        LOG.info("MAXIMIZE WINDOW");
        this.driverFactory.getDriver().getWebDriver().manage().window().maximize();
    }

    @AfterTest
    public void shutDown() throws Exception {
        this.driverFactory.getDriver().quitDriver();
    }
}
