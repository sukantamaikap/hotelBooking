package org.test.org.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Browser driver interface.
 */
public interface Driver {
    int WEB_DRIVER_WAIT = 30;
    String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
    String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    WebDriver getWebDriver();
    WebDriverWait getWebDriverWait();
    void quitDriver();
}
