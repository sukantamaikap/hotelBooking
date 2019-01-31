package org.test.org.pages;

import org.test.org.drivers.Driver;
import org.test.org.utils.PageElementUtil;

/**
 * Base class for all page objects.
 */
public class AbstractPage {
    private Driver browserDriver;
    private PageElementUtil elementUtil;

    public AbstractPage(final Driver browserDriver) {
        this.browserDriver = browserDriver;
        this.elementUtil = new PageElementUtil(this.browserDriver);
    }

    public PageElementUtil getElementUtil() {
        return this.elementUtil;
    }
}
