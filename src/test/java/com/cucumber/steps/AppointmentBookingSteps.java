package com.cucumber.steps;
import com.pageobjects.HealthcareProviderPage;
import com.pageobjects.TimeSlotPage;
import com.pageobjects.BookingConfirmationPage;
import com.pageobjects.ErrorPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppointmentBookingSteps extends HealthcareProviderPage {

    @Given("the patient is logged into the telemedicine system")
    public void thePatientIsLoggedIntoTheTelemedicineSystem() {
        loginToTelemedicineSystem();
    }

    @When("the patient navigates to the {string} page")
    public void thePatientNavigatesToThePage(String pageName) {
        navigateToPage(pageName);
    }

    @When("the patient chooses a healthcare provider from the list")
    public void thePatientChoosesAHealthcareProviderFromTheList() {
        selectHealthcareProvider();
    }

    @Then("the system displays available time slots for the selected provider")
    public void theSystemDisplaysAvailableTimeSlotsForTheSelectedProvider() {
        TimeSlotPage timeSlotPage = new TimeSlotPage();
        timeSlotPage.verifyAvailableTimeSlots();
    }

    @Given("the patient has selected a healthcare provider")
    public void thePatientHasSelectedAHealthcareProvider() {
        selectHealthcareProvider();
    }

    @When("the patient views the list of available time slots")
    public void thePatientViewsTheListOfAvailableTimeSlots() {
        TimeSlotPage timeSlotPage = new TimeSlotPage();
        timeSlotPage.viewAvailableTimeSlots();
    }

    @When("the patient selects a preferred time slot")
    public void thePatientSelectsAPreferredTimeSlot() {
        TimeSlotPage timeSlotPage = new TimeSlotPage();
        timeSlotPage.selectPreferredTimeSlot();
    }

    @Then("the system prompts the patient to confirm the booking")
    public void theSystemPromptsThePatientToConfirmTheBooking() {
        BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
        bookingConfirmationPage.promptBookingConfirmation();
    }

    @Given("the patient has selected a time slot for a telemedicine consultation")
    public void thePatientHasSelectedATimeSlotForATelemedicineConsultation() {
        TimeSlotPage timeSlotPage = new TimeSlotPage();
        timeSlotPage.selectPreferredTimeSlot();
    }

    @When("the patient confirms the booking")
    public void thePatientConfirmsTheBooking() {
        BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
        bookingConfirmationPage.confirmBooking();
    }

    @Then("the system displays a booking confirmation message")
    public void theSystemDisplaysABookingConfirmationMessage() {
        BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
        bookingConfirmationPage.verifyBookingConfirmationMessage();
    }

    @Then("the system sends a confirmation email to the patient")
    public void theSystemSendsAConfirmationEmailToThePatient() {
        BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
        bookingConfirmationPage.sendConfirmationEmail();
    }

    @Given("the patient is on the {string} page")
    public void thePatientIsOnThePage(String pageName) {
        navigateToPage(pageName);
    }

    @When("the patient tries to proceed without selecting a provider")
    public void thePatientTriesToProceedWithoutSelectingAProvider() {
        attemptProceedWithoutProviderSelection();
    }

    @Then("the system displays an error message prompting the selection of a provider")
    public void theSystemDisplaysAnErrorMessagePromptingTheSelectionOfAProvider() {
        ErrorPage errorPage = new ErrorPage();
        errorPage.verifyProviderSelectionErrorMessage();
    }

    @When("the patient tries to confirm the booking without selecting a time slot")
    public void thePatientTriesToConfirmTheBookingWithoutSelectingATimeSlot() {
        attemptBookingWithoutTimeSlotSelection();
    }

    @Then("the system displays an error message prompting the selection of a time slot")
    public void theSystemDisplaysAnErrorMessagePromptingTheSelectionOfATimeSlot() {
        ErrorPage errorPage = new ErrorPage();
        errorPage.verifyTimeSlotSelectionErrorMessage();
    }

    @Then("the system displays a list of available healthcare providers")
    public void theSystemDisplaysAListOfAvailableHealthcareProviders() {
        verifyAvailableHealthcareProviders();
    }

    @Then("the system displays only the time slots that are not already booked")
    public void theSystemDisplaysOnlyTheTimeSlotsThatAreNotAlreadyBooked() {
        TimeSlotPage timeSlotPage = new TimeSlotPage();
        timeSlotPage.verifyUnbookedTimeSlots();
    }

    @Given("the user is logged into the healthcare portal")
    public void theUserIsLoggedIntoTheHealthcarePortal() {
        loginToHealthcarePortal();
    }

    @When("the user navigates to the 'Appointments' section and clicks on 'Book Appointment'")
    public void theUserNavigatesToTheAppointmentsSectionAndClicksOnBookAppointment() {
        navigateToAppointmentsSection();
    }

    @When("enters {string} in the doctor selection field")
    public void entersInTheDoctorSelectionField(String doctorName) {
        enterDoctorName(doctorName);
    }

    @Then("an error message is displayed indicating that the doctor is not found or invalid")
    public void anErrorMessageIsDisplayedIndicatingThatTheDoctorIsNotFoundOrInvalid() {
        ErrorPage errorPage = new ErrorPage();
        errorPage.verifyInvalidDoctorErrorMessage();
    }

    @Then("the system prevents proceeding with the booking and displays a validation error message")
    public void theSystemPreventsProceedingWithTheBookingAndDisplaysAValidationErrorMessage() {
        ErrorPage errorPage = new ErrorPage();
        errorPage.verifyBookingValidationErrorMessage();
    }

    @When("selects {string} from the calendar")
    public void selectsFromTheCalendar(String date) {
        selectDateFromCalendar(date);
    }

    @Then("the system prevents proceeding with the booking")
    public void theSystemPreventsProceedingWithTheBooking() {
        ErrorPage errorPage = new ErrorPage();
        errorPage.verifyPastDateBookingPrevention();
    }

    @Then("displays a validation error message indicating the date is in the past")
    public void displaysAValidationErrorMessageIndicatingTheDateIsInThePast() {
        ErrorPage errorPage = new ErrorPage();
        errorPage.verifyPastDateErrorMessage();
    }

    @Given("the patient is logged into the telemedicine platform with ID {string}")
    public void thePatientIsLoggedIntoTheTelemedicinePlatformWithID(String patientID) {
        loginToTelemedicinePlatform(patientID);
    }

    @When("the patient navigates to the 'Consultations' section on the dashboard")
    public void thePatientNavigatesToTheConsultationsSectionOnTheDashboard() {
        navigateToConsultationsSection();
    }

    @When("selects 'Schedule a Consultation' and chooses 'Audio' as the type")
    public void selectsScheduleAConsultationAndChoosesAudioAsTheType() {
        scheduleAudioConsultation();
    }

    @When("searches for doctor using Doctor ID {string}")
    public void searchesForDoctorUsingDoctorID(String doctorID) {
        searchDoctorByID(doctorID);
    }

    @When("attempts to select a slot at {string} on {string}")
    public void attemptsToSelectASlotAtOn(String time, String date) {
        attemptSlotSelection(time, date);
    }

    @Then("the system does not allow selection of a past date slot")
    public void theSystemDoesNotAllowSelectionOfAPastDateSlot() {
        ErrorPage errorPage = new ErrorPage();
        errorPage.verifyPastDateSlotSelectionPrevention();
    }

    @Then("an error message or warning is displayed indicating that past dates cannot be booked")
    public void anErrorMessageOrWarningIsDisplayedIndicatingThatPastDatesCannotBeBooked() {
        ErrorPage errorPage = new ErrorPage();
        errorPage.verifyPastDateBookingWarning();
    }

    @Then("the 'Confirm Booking' button is disabled for the past date")
    public void theConfirmBookingButtonIsDisabledForThePastDate() {
        ErrorPage errorPage = new ErrorPage();
        errorPage.verifyConfirmBookingButtonDisabled();
    }

    @Then("a tooltip or message may appear explaining the reason")
    public void aTooltipOrMessageMayAppearExplainingTheReason() {
        ErrorPage errorPage = new ErrorPage();
        errorPage.verifyTooltipExplanation();
    }

    @When("the patient logs out from the platform")
    public void thePatientLogsOutFromThePlatform() {
        logoutFromPlatform();
    }

    @Then("the patient is successfully logged out of the telemedicine platform")
    public void thePatientIsSuccessfullyLoggedOutOfTheTelemedicinePlatform() {
        verifySuccessfulLogout();
    }

    @Then("the login screen is displayed")
    public void theLoginScreenIsDisplayed() {
        verifyLoginScreenDisplayed();
    }
}