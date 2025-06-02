import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AppointmentPage from "../pages/appointmentPage";

Given("a patient is registered in the system", () => {
 // Assume patient registration is handled outside of this test
});

Given("the patient has access to the appointment booking portal", () => {
 AppointmentPage.visitPortal();
});

When("the patient logs in to the appointment booking system using valid credentials", () => {
 AppointmentPage.login('validUsername', 'validPassword');
});

Then("the patient dashboard is displayed with available functionalities", () => {
 AppointmentPage.verifyDashboardDisplayed();
});

When("the patient navigates to the 'Book Appointment' section", () => {
 AppointmentPage.navigateToBookAppointment();
});

Then("available time slots are displayed", () => {
 AppointmentPage.verifyTimeSlotsDisplayed();
});

Then("the available time slots include '10:00 AM', '11:00 AM', '2:00 PM'", () => {
 AppointmentPage.verifySpecificTimeSlots(['10:00 AM', '11:00 AM', '2:00 PM']);
});

When("the patient selects the desired time slot '10:00 AM' from the available options", () => {
 AppointmentPage.selectTimeSlot('10:00 AM');
});

Then("the selected time slot is highlighted", () => {
 AppointmentPage.verifyTimeSlotHighlighted('10:00 AM');
});

When("the patient clicks on the 'Book Appointment' button", () => {
 AppointmentPage.clickBookAppointment();
});

Then("a confirmation dialog is displayed", () => {
 AppointmentPage.verifyConfirmationDialog();
});

When("the patient confirms the appointment booking", () => {
 AppointmentPage.confirmBooking();
});

Then("the appointment booking is confirmed", () => {
 AppointmentPage.verifyBookingConfirmed();
});

Then("a confirmation message is displayed", () => {
 AppointmentPage.verifyConfirmationMessage();
});

Then("the appointment details are correctly displayed in the patient dashboard", () => {
 AppointmentPage.verifyAppointmentDetails();
});

Then("no error messages are displayed during the booking process", () => {
 AppointmentPage.verifyNoErrorMessages();
});

Then("the system logs the appointment booking activity for audit purposes", () => {
 AppointmentPage.verifyBookingLogged();
});

Then("the selected time slot '10:00 AM' is no longer available for booking", () => {
 AppointmentPage.verifyTimeSlotUnavailable('10:00 AM');
});

When("the patient attempts to book another appointment at the same time slot '10:00 AM'", () => {
 AppointmentPage.attemptDoubleBooking('10:00 AM');
});

Then("the system prevents double booking", () => {
 AppointmentPage.verifyDoubleBookingPrevented();
});

Then("an error message is displayed", () => {
 AppointmentPage.verifyErrorMessageDisplayed();
});

Then("the patient receives an email confirmation with appointment details", () => {
 AppointmentPage.verifyEmailConfirmation();
});

Then("the patient receives an SMS confirmation with appointment details", () => {
 AppointmentPage.verifySmsConfirmation();
});

Then("the appointment status is updated to 'Booked' in the clinic management system", () => {
 AppointmentPage.verifyStatusUpdatedToBooked();
});

When("the patient decides to reschedule or cancel the appointment", () => {
 AppointmentPage.rescheduleOrCancelAppointment();
});

Then("the patient is able to reschedule or cancel the appointment successfully", () => {
 AppointmentPage.verifyRescheduleOrCancelSuccess();
});

Then("the system updates the available slots after cancellation", () => {
 AppointmentPage.verifySlotsUpdatedAfterCancellation();
});

Then("the canceled time slot is made available for booking again", () => {
 AppointmentPage.verifyCanceledSlotAvailableAgain();
});