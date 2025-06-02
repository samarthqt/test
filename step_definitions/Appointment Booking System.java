package com.cucumber.steps;

import com.page_objects.AppointmentBookingPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppointmentBookingSteps extends AppointmentBookingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a patient is registered in the system")
    public void aPatientIsRegisteredInTheSystem() {
        verifyPatientRegistration();
    }

    @Given("the patient has access to the appointment booking portal")
    public void thePatientHasAccessToTheAppointmentBookingPortal() {
        verifyPortalAccess();
    }

    @When("the patient logs in to the appointment booking system using valid credentials")
    public void thePatientLogsInToTheAppointmentBookingSystemUsingValidCredentials() {
        String username = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        loginToSystem(username, password);
    }

    @Then("the patient dashboard is displayed with available functionalities")
    public void thePatientDashboardIsDisplayedWithAvailableFunctionalities() {
        verifyDashboardDisplay();
    }

    @When("the patient navigates to the 'Book Appointment' section")
    public void thePatientNavigatesToTheBookAppointmentSection() {
        navigateToBookAppointmentSection();
    }

    @Then("available time slots are displayed")
    public void availableTimeSlotsAreDisplayed() {
        verifyTimeSlotsDisplay();
    }

    @Then("the available time slots include '10:00 AM', '11:00 AM', '2:00 PM'")
    public void theAvailableTimeSlotsIncludeSpecificTimes() {
        verifySpecificTimeSlots();
    }

    @When("the patient selects the desired time slot '10:00 AM' from the available options")
    public void thePatientSelectsTheDesiredTimeSlot() {
        selectTimeSlot("10:00 AM");
    }

    @Then("the selected time slot is highlighted")
    public void theSelectedTimeSlotIsHighlighted() {
        verifyTimeSlotHighlight("10:00 AM");
    }

    @When("the patient clicks on the 'Book Appointment' button")
    public void thePatientClicksOnTheBookAppointmentButton() {
        clickBookAppointmentButton();
    }

    @Then("a confirmation dialog is displayed")
    public void aConfirmationDialogIsDisplayed() {
        verifyConfirmationDialog();
    }

    @When("the patient confirms the appointment booking")
    public void thePatientConfirmsTheAppointmentBooking() {
        confirmAppointmentBooking();
    }

    @Then("the appointment booking is confirmed")
    public void theAppointmentBookingIsConfirmed() {
        verifyAppointmentConfirmation();
    }

    @Then("a confirmation message is displayed")
    public void aConfirmationMessageIsDisplayed() {
        verifyConfirmationMessage();
    }

    @Then("the appointment details are correctly displayed in the patient dashboard")
    public void theAppointmentDetailsAreCorrectlyDisplayedInThePatientDashboard() {
        verifyAppointmentDetailsInDashboard();
    }

    @Then("no error messages are displayed during the booking process")
    public void noErrorMessagesAreDisplayedDuringTheBookingProcess() {
        verifyNoErrorMessages();
    }

    @Then("the system logs the appointment booking activity for audit purposes")
    public void theSystemLogsTheAppointmentBookingActivityForAuditPurposes() {
        verifyAuditLogging();
    }

    @Then("the selected time slot '10:00 AM' is no longer available for booking")
    public void theSelectedTimeSlotIsNoLongerAvailableForBooking() {
        verifyTimeSlotAvailability("10:00 AM", false);
    }

    @When("the patient attempts to book another appointment at the same time slot '10:00 AM'")
    public void thePatientAttemptsToBookAnotherAppointmentAtTheSameTimeSlot() {
        attemptDoubleBooking("10:00 AM");
    }

    @Then("the system prevents double booking")
    public void theSystemPreventsDoubleBooking() {
        verifyDoubleBookingPrevention();
    }

    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        verifyErrorMessageDisplay();
    }

    @Then("the patient receives an email confirmation with appointment details")
    public void thePatientReceivesAnEmailConfirmationWithAppointmentDetails() {
        verifyEmailConfirmation();
    }

    @Then("the patient receives an SMS confirmation with appointment details")
    public void thePatientReceivesAnSMSConfirmationWithAppointmentDetails() {
        verifySMSConfirmation();
    }

    @Then("the appointment status is updated to 'Booked' in the clinic management system")
    public void theAppointmentStatusIsUpdatedToBookedInTheClinicManagementSystem() {
        verifyAppointmentStatusUpdate();
    }

    @When("the patient decides to reschedule or cancel the appointment")
    public void thePatientDecidesToRescheduleOrCancelTheAppointment() {
        rescheduleOrCancelAppointment();
    }

    @Then("the patient is able to reschedule or cancel the appointment successfully")
    public void thePatientIsAbleToRescheduleOrCancelTheAppointmentSuccessfully() {
        verifyRescheduleOrCancelSuccess();
    }

    @Then("the system updates the available slots after cancellation")
    public void theSystemUpdatesTheAvailableSlotsAfterCancellation() {
        verifySlotUpdateAfterCancellation();
    }

    @Then("the canceled time slot is made available for booking again")
    public void theCanceledTimeSlotIsMadeAvailableForBookingAgain() {
        verifySlotAvailability("10:00 AM", true);
    }
}