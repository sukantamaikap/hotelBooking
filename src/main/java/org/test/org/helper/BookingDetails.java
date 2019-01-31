package org.test.org.helper;

public class BookingDetails {
    private String firstName;
    private String lastName;
    private int price;
    private boolean deposit;
    // dates should be in YYYY-mm-dd format, as UI accepts date in the same format
    private String checkinDate;
    private String checkoutDate;

    public BookingDetails() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(final int price) {
        this.price = price;
    }

    public boolean isDeposit() {
        return deposit;
    }

    public void setDeposit(final boolean deposit) {
        this.deposit = deposit;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(final String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(final String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
}
