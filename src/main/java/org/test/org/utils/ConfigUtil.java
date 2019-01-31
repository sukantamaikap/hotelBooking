package org.test.org.utils;


import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Util for running Booking Selenium automation.
 */
public final class ConfigUtil {
    private static final String CONFIG_FILE_PATH = "/src/main/resources/config.properties";

    private ConfigUtil() {

    }

    private static Properties readProperties() throws IOException {
        final String basePath = new File(".").getCanonicalPath();
        final Properties properties = new Properties();
        InputStream fileInput = null;
        try {
            final File file = new File(basePath + CONFIG_FILE_PATH);
            fileInput = new FileInputStream(file);
            properties.load(fileInput);

        } finally {
            if (fileInput != null) {
                fileInput.close();
            }
        }
        return properties;
    }

    public static String getBaseUrl() throws IOException {
        if (readProperties() == null) {
            return null;
        }

        return readProperties().getProperty("baseUrl");
    }

    /**
     * Read browser from the properties file
     * @return browser
     * @throws IOException
     */
    public static String getBrowser() throws IOException {
        if (readProperties() == null) {
            Assert.fail("config file not found !!!");
            return null;
        }

        return readProperties().getProperty("browser");
    }

    /**
     * Read gecko driver path from properties file.
     * @return : gecko driver path
     * @throws IOException
     */
    public static String getGeckoDriver() throws IOException {
        return readProperties().getProperty("gecko_driver");
    }

    /**
     * Read chrome driver path from properties.
     * @return
     * @throws IOException
     */
    public static String getChromeDriver() throws IOException {
        return readProperties().getProperty("chrome_driver");
    }
}
