package org.test.org.pages;

import org.test.org.drivers.Driver;

public class BookingPageFactory {
    private Driver browserDriver;

    public BookingPageFactory(final Driver browserDriver) {
        this.browserDriver = browserDriver;
    }

    public BookingPage getBookingPage() {
        return new BookingPage(this.browserDriver);
    }
}
