package org.test.org.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.test.org.drivers.Driver;

public class BookingPage extends AbstractPage {
    private static final Logger LOG = LoggerFactory.getLogger(BookingPage.class);

    public BookingPage(Driver browserDriver) {
        super(browserDriver);
    }
}
