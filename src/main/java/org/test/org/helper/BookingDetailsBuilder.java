package org.test.org.helper;

import java.security.SecureRandom;

public class BookingDetailsBuilder {

    public BookingDetailsBuilder() {

    }

    public final BookingDetails buildBookingDetails(final String firstName,
                                                    final String lastName,
                                                    final int price,
                                                    final boolean depost,
                                                    final String checkin,
                                                    final String checkout) {
        final BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setFirstName(firstName);
        bookingDetails.setLastName(lastName);
        bookingDetails.setPrice(price);
        bookingDetails.setDeposit(depost);
        bookingDetails.setCheckinDate(checkin);
        bookingDetails.setCheckoutDate(checkout);
        return bookingDetails;
    }

    public final BookingDetails buildBookingDetails(final int price,
                                                    final boolean depost,
                                                    final String checkin,
                                                    final String checkout) {
        SecureRandom random = new SecureRandom();
        final String firstName = "RandomFirstName_" + random.nextInt(1000000);
        final String lastName = "RandomLastName_" + random.nextInt(1000000);
        return this.buildBookingDetails(firstName, lastName, price, depost, checkin, checkout);
    }

}
