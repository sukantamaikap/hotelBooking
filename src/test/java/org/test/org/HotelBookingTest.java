package org.test.org;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.test.org.helper.BookingDetails;
import org.test.org.helper.BookingDetailsBuilder;
import org.test.org.pages.BookingPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.SecureRandom;

public class HotelBookingTest extends BaseUITest {
    private static final Logger LOG = LoggerFactory.getLogger(HotelBookingTest.class);

    private BookingPage bookingPage;

    @BeforeClass
    public void preparePage() {
        this.bookingPage = this.bookingPageFactory.getBookingPage();
    }

    @Test
    public void addBooking() throws InterruptedException {
        LOG.info("CREATE BOOKING DETAILS");
        final int price = 200;
        final boolean deposit = new SecureRandom().nextBoolean();
        final String checkin = "2019-02-02";
        final String checkout = "2019-02-12";
        final BookingDetailsBuilder builder = new BookingDetailsBuilder();
        final BookingDetails bookingDetails = builder.buildBookingDetails(price, deposit, checkin, checkout);

        LOG.info("ENTER BOOKING DETAILS IN UI");
        this.bookingPage.enterDetails(bookingDetails);

        LOG.info("SAVE BOOKING");
        this.bookingPage.saveRecord();

        LOG.info("VALIDATE BOOKING PERSISTED");
        this.bookingPage.assertRecordPersisted(bookingDetails);
    }

    @Test
    public void deleteBooking() throws InterruptedException {
        LOG.info("CREATE BOOKING DETAILS");
        final int price = 900;
        final boolean deposit = new SecureRandom().nextBoolean();
        final String checkin = "2019-02-06";
        final String checkout = "2019-02-22";
        final BookingDetailsBuilder builder = new BookingDetailsBuilder();
        final BookingDetails bookingDetails = builder.buildBookingDetails(price, deposit, checkin, checkout);

        LOG.info("ENTER BOOKING DETAILS IN UI");
        this.bookingPage.enterDetails(bookingDetails);

        LOG.info("SAVE BOOKING");
        this.bookingPage.saveRecord();

        LOG.info("DELETE BOOKING");
        this.bookingPage.deleteRecord(bookingDetails);

        LOG.info("VALIDATE BOOKING NOT DELETED");
        this.bookingPage.assertRecordNotPersisted(bookingDetails);

    }
}
