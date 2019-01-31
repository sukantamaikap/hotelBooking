package org.test.org.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.org.utils.ConfigUtil;

import java.io.IOException;

/**
 * Driver for Firefox.
 */
public class FirefoxDriver implements Driver {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public FirefoxDriver() throws IOException {
        System.setProperty(WEBDRIVER_GECKO_DRIVER, ConfigUtil.getGeckoDriver());
        this.webDriver = new org.openqa.selenium.firefox.FirefoxDriver();
        this.webDriverWait = new WebDriverWait(this.webDriver, WEB_DRIVER_WAIT);
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return this.webDriverWait;
    }

    public void quitDriver() {
        this.webDriver.quit();
    }
}
