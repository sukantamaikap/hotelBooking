package org.test.org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.test.org.drivers.Driver;
import org.test.org.helper.BookingDetails;
import org.testng.Assert;

public class BookingPage extends AbstractPage {
    private static final Logger LOG = LoggerFactory.getLogger(BookingPage.class);

    private static final String FIRSTNAME = "//input[@id='firstname']";
    private static final String LASTNAME = "//input[@id='lastname']";
    private static final String TOTALPRICE = "//input[@id='totalprice']";
    private static final String DEPOSIT = "//select[@id='depositpaid']";
    private static final String CHECKIN = "//input[@id='checkin']";
    private static final String CHECKOUT = "//input[@id='checkout']";
    private static final String SAVE = "//input[@value=' Save ']";
    private static final String SEARCH_TEXT = "//p[text()='%s']";
    private static final String PARENT = "//p[text()='%s']//parent";
    private static final String DELETE = "//input[@value='Delete']";

    public BookingPage(Driver browserDriver) {
        super(browserDriver);
    }

    public void enterDetails(final BookingDetails bookingDetails) {
        this.enterFirstName(bookingDetails.getFirstName());
        this.enterLastName(bookingDetails.getLastName());
        this.enterTotalPrice(bookingDetails.getPrice());
        this.selectDeposit(bookingDetails.isDeposit());
        this.enterCheckin(bookingDetails.getCheckinDate());
        this.enterChekout(bookingDetails.getCheckoutDate());
    }

    private void enterChekout(final String checkoutDate) {
        LOG.info("enter checkout date");
        this.getElementUtil().findElement(By.xpath(CHECKOUT)).sendKeys(checkoutDate);
        this.getElementUtil().findElement(By.xpath(CHECKOUT)).sendKeys(Keys.ESCAPE);

    }

    public void enterCheckin(final String checkinDate) {
        LOG.info("enter checkin date");
        this.getElementUtil().findElement(By.xpath(CHECKIN)).sendKeys(checkinDate);
    }

    public void selectDeposit(final boolean deposit) {
        LOG.info("enter deposit");
        final Select depositValue = new Select(this.getElementUtil().findElement(By.xpath(DEPOSIT)));
        depositValue.selectByVisibleText(String.valueOf(deposit));
    }

    public void enterTotalPrice(final int price) {
        LOG.info("enter price");
        this.getElementUtil().findElement(By.xpath(TOTALPRICE)).sendKeys(String.valueOf(price));
    }

    public void enterLastName(String lastName) {
        LOG.info("enter last name");
        this.getElementUtil().findElement(By.xpath(LASTNAME)).sendKeys(lastName);
    }

    public void enterFirstName(final String firstName) {
        LOG.info("enter first name");
        this.getElementUtil().findElement(By.xpath(FIRSTNAME)).sendKeys(firstName);
    }

    public void saveRecord() throws InterruptedException {
        LOG.info("save the record");
        this.getElementUtil().findElement(By.xpath(SAVE)).click();
        Thread.sleep(3000);
    }

    public void assertRecordPersisted(final BookingDetails bookingDetails) {
        Assert.assertTrue(this.isRecordPresent(bookingDetails), "Record could not be located!!");
    }

    private boolean isRecordPresent(final BookingDetails bookingDetails) {
        final String searchText = String.format(SEARCH_TEXT, bookingDetails.getFirstName());
        try {
            return this.getElementUtil().findElements(By.xpath(searchText)).size() > 0;
        } catch (final TimeoutException ex) {
            return Boolean.FALSE;
        }
    }

    public void deleteRecord(final BookingDetails bookingDetails) throws InterruptedException {
        final String searchText = String.format(SEARCH_TEXT, bookingDetails.getFirstName());
        this.getElementUtil().findElement(By.xpath(searchText)).findElement(By.xpath(DELETE)).click();
        Thread.sleep(3000);
    }

    public void assertRecordNotPersisted(final BookingDetails bookingDetails) {
        Assert.assertFalse(this.isRecordPresent(bookingDetails), "Record should not have been present!!");
    }
}
