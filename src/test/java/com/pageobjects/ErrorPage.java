package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ErrorPage extends WebReusableComponents {

    protected By providerSelectionErrorMessage = By.id("providerSelectionErrorMessage");
    protected By timeSlotSelectionErrorMessage = By.id("timeSlotSelectionErrorMessage");
    protected By invalidDoctorErrorMessage = By.id("invalidDoctorErrorMessage");
    protected By bookingValidationErrorMessage = By.id("bookingValidationErrorMessage");
    protected By pastDateErrorMessage = By.id("pastDateErrorMessage");
    protected By pastDateSlotSelectionPreventionMessage = By.id("pastDateSlotSelectionPreventionMessage");
    protected By confirmBookingButtonDisabledMessage = By.id("confirmBookingButtonDisabledMessage");
    protected By tooltipExplanationMessage = By.id("tooltipExplanationMessage");

    public ErrorPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyProviderSelectionErrorMessage() {
        waitUntilElementVisible(providerSelectionErrorMessage, 3);
        String actualMessage = getTextFromElement(providerSelectionErrorMessage);
        Assert.assertEquals(actualMessage, "Please select a provider.", "Provider selection error message does not match.");
    }

    public void verifyTimeSlotSelectionErrorMessage() {
        waitUntilElementVisible(timeSlotSelectionErrorMessage, 3);
        String actualMessage = getTextFromElement(timeSlotSelectionErrorMessage);
        Assert.assertEquals(actualMessage, "Please select a time slot.", "Time slot selection error message does not match.");
    }

    public void verifyInvalidDoctorErrorMessage() {
        waitUntilElementVisible(invalidDoctorErrorMessage, 3);
        String actualMessage = getTextFromElement(invalidDoctorErrorMessage);
        Assert.assertEquals(actualMessage, "Doctor not found or invalid.", "Invalid doctor error message does not match.");
    }

    public void verifyBookingValidationErrorMessage() {
        waitUntilElementVisible(bookingValidationErrorMessage, 3);
        String actualMessage = getTextFromElement(bookingValidationErrorMessage);
        Assert.assertEquals(actualMessage, "Booking validation error.", "Booking validation error message does not match.");
    }

    public void verifyPastDateErrorMessage() {
        waitUntilElementVisible(pastDateErrorMessage, 3);
        String actualMessage = getTextFromElement(pastDateErrorMessage);
        Assert.assertEquals(actualMessage, "Date is in the past.", "Past date error message does not match.");
    }

    public void verifyPastDateSlotSelectionPrevention() {
        waitUntilElementVisible(pastDateSlotSelectionPreventionMessage, 3);
        String actualMessage = getTextFromElement(pastDateSlotSelectionPreventionMessage);
        Assert.assertEquals(actualMessage, "Cannot select past date slot.", "Past date slot selection prevention message does not match.");
    }

    public void verifyPastDateBookingWarning() {
        waitUntilElementVisible(pastDateErrorMessage, 3);
        String actualMessage = getTextFromElement(pastDateErrorMessage);
        Assert.assertEquals(actualMessage, "Past dates cannot be booked.", "Past date booking warning message does not match.");
    }

    public void verifyConfirmBookingButtonDisabled() {
        waitUntilElementVisible(confirmBookingButtonDisabledMessage, 3);
        String actualMessage = getTextFromElement(confirmBookingButtonDisabledMessage);
        Assert.assertEquals(actualMessage, "Confirm Booking button disabled.", "Confirm Booking button disabled message does not match.");
    }

    public void verifyTooltipExplanation() {
        waitUntilElementVisible(tooltipExplanationMessage, 3);
        String actualMessage = getTextFromElement(tooltipExplanationMessage);
        Assert.assertEquals(actualMessage, "Past dates cannot be booked.", "Tooltip explanation message does not match.");
    }
}