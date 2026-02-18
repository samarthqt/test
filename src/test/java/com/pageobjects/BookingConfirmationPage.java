package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class BookingConfirmationPage extends WebReusableComponents {

    protected By bookingConfirmationMessage = By.id("bookingConfirmationMessage");
    protected By confirmBookingButton = By.id("confirmBookingButton");

    public BookingConfirmationPage() {
        PageFactory.initElements(driver, this);
    }

    public void promptBookingConfirmation() {
        waitUntilElementVisible(confirmBookingButton, 3);
    }

    public void confirmBooking() {
        waitUntilElementVisible(confirmBookingButton, 3);
        clickElement(confirmBookingButton);
    }

    public void verifyBookingConfirmationMessage() {
        waitUntilElementVisible(bookingConfirmationMessage, 3);
        String actualMessage = getTextFromElement(bookingConfirmationMessage);
        Assert.assertEquals(actualMessage, "Booking confirmed.", "Booking confirmation message does not match.");
    }

    public void sendConfirmationEmail() {
        // Implement email sending logic
    }
}