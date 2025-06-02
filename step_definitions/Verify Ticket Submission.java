package com.cucumber.steps;

import com.page_objects.TicketSubmissionPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TicketSubmissionSteps extends TicketSubmissionPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the support section of the application")
    public void theUserNavigatesToTheSupportSectionOfTheApplication() {
        navigateToSupportSection();
    }

    @Then("the support section is displayed with ticket submission option")
    public void theSupportSectionIsDisplayedWithTicketSubmissionOption() {
        verifySupportSectionDisplayed();
    }

    @Given("the user is in the support section")
    public void theUserIsInTheSupportSection() {
        verifySupportSectionDisplayed();
    }

    @When("the user selects the 'Submit a Ticket' option")
    public void theUserSelectsTheSubmitATicketOption() {
        selectSubmitTicketOption();
    }

    @Then("the ticket submission form is displayed with required fields")
    public void theTicketSubmissionFormIsDisplayedWithRequiredFields() {
        verifyTicketFormDisplayed();
    }

    @Given("the ticket submission form is displayed")
    public void theTicketSubmissionFormIsDisplayed() {
        verifyTicketFormDisplayed();
    }

    @When("the user fills in the required details in the form")
    public void theUserFillsInTheRequiredDetailsInTheForm() {
        fillTicketFormDetails();
    }

    @Then("the form accepts input and displays entered details")
    public void theFormAcceptsInputAndDisplaysEnteredDetails() {
        verifyFormDetailsDisplayed();
    }

    @Given("the user has filled in the ticket submission form")
    public void theUserHasFilledInTheTicketSubmissionForm() {
        fillTicketFormDetails();
    }

    @When("the user attaches relevant documents to the ticket submission")
    public void theUserAttachesRelevantDocumentsToTheTicketSubmission() {
        attachDocumentsToTicket();
    }

    @Then("the documents are attached successfully without errors")
    public void theDocumentsAreAttachedSuccessfullyWithoutErrors() {
        verifyDocumentsAttached();
    }

    @Given("the user has completed the ticket submission form")
    public void theUserHasCompletedTheTicketSubmissionForm() {
        fillTicketFormDetails();
    }

    @When("the user submits the ticket")
    public void theUserSubmitsTheTicket() {
        submitTicket();
    }

    @Then("the ticket is submitted successfully and confirmation message is displayed")
    public void theTicketIsSubmittedSuccessfullyAndConfirmationMessageIsDisplayed() {
        verifyTicketSubmissionConfirmation();
    }

    @Given("the ticket is submitted successfully")
    public void theTicketIsSubmittedSuccessfully() {
        submitTicket();
    }

    @When("the user checks their email")
    public void theUserChecksTheirEmail() {
        checkEmailForConfirmation();
    }

    @Then("a confirmation email is received with ticket details")
    public void aConfirmationEmailIsReceivedWithTicketDetails() {
        verifyConfirmationEmailReceived();
    }

    @Given("the user is submitting a ticket")
    public void theUserIsSubmittingATicket() {
        fillTicketFormDetails();
    }

    @When("the user completes the submission process")
    public void theUserCompletesTheSubmissionProcess() {
        submitTicket();
    }

    @Then("no error messages are displayed")
    public void noErrorMessagesAreDisplayed() {
        verifyNoErrorMessages();
    }

    @Given("the user is filling in the ticket submission form")
    public void theUserIsFillingInTheTicketSubmissionForm() {
        fillTicketFormDetails();
    }

    @When("the user attempts to submit the form with incomplete details")
    public void theUserAttemptsToSubmitTheFormWithIncompleteDetails() {
        attemptSubmitIncompleteForm();
    }

    @Then("the system prompts for missing required fields")
    public void theSystemPromptsForMissingRequiredFields() {
        verifyMissingFieldsPrompt();
    }

    @Given("the user is accessing the application on a mobile device")
    public void theUserIsAccessingTheApplicationOnAMobileDevice() {
        accessApplicationOnMobile();
    }

    @When("the user navigates to the support section and selects 'Submit a Ticket'")
    public void theUserNavigatesToTheSupportSectionAndSelectsSubmitATicket() {
        navigateToSupportSection();
        selectSubmitTicketOption();
    }

    @Then("the ticket submission form is accessible and functional on mobile devices")
    public void theTicketSubmissionFormIsAccessibleAndFunctionalOnMobileDevices() {
        verifyMobileFormFunctionality();
    }

    @Given("the user has submitted a ticket")
    public void theUserHasSubmittedATicket() {
        submitTicket();
    }

    @When("the system processes the ticket")
    public void theSystemProcessesTheTicket() {
        processTicketInSystem();
    }

    @Then("the submitted tickets are recorded in CRM systems for future reference")
    public void theSubmittedTicketsAreRecordedInCRMSystemsForFutureReference() {
        verifyTicketRecordedInCRM();
    }

    @Given("the user is accessing the application on different browsers")
    public void theUserIsAccessingTheApplicationOnDifferentBrowsers() {
        accessApplicationOnDifferentBrowsers();
    }

    @When("the user navigates to the ticket submission form")
    public void theUserNavigatesToTheTicketSubmissionForm() {
        navigateToSupportSection();
        selectSubmitTicketOption();
    }

    @Then("the ticket system functions correctly across different browsers")
    public void theTicketSystemFunctionsCorrectlyAcrossDifferentBrowsers() {
        verifyBrowserCompatibility();
    }

    @Given("the user submits a ticket")
    public void theUserSubmitsATicket() {
        submitTicket();
    }

    @When("the system processes the ticket")
    public void theSystemProcessesTheTicket() {
        processTicketInSystem();
    }

    @Then("the ticket system processes submissions within expected time frame")
    public void theTicketSystemProcessesSubmissionsWithinExpectedTimeFrame() {
        verifyResponseTime();
    }

    @Given("the system is experiencing peak times")
    public void theSystemIsExperiencingPeakTimes() {
        simulatePeakTimes();
    }

    @When("the user submits a ticket")
    public void theUserSubmitsATicketDuringPeakTimes() {
        submitTicket();
    }

    @Then("the system handles ticket submissions without performance degradation")
    public void theSystemHandlesTicketSubmissionsWithoutPerformanceDegradation() {
        verifyPerformanceDuringPeakTimes();
    }

    @Given("the user has submitted a ticket")
    public void theUserHasSubmittedATicket() {
        submitTicket();
    }

    @When("the user accesses the ticket status section")
    public void theUserAccessesTheTicketStatusSection() {
        accessTicketStatusSection();
    }

    @Then("users can access and view the status of their submitted tickets")
    public void usersCanAccessAndViewTheStatusOfTheirSubmittedTickets() {
        verifyTicketStatusView();
    }

    @Given("the user is submitting multiple tickets")
    public void theUserIsSubmittingMultipleTickets() {
        fillMultipleTicketForms();
    }

    @When("the user submits the tickets simultaneously")
    public void theUserSubmitsTheTicketsSimultaneously() {
        submitMultipleTickets();
    }

    @Then("the system processes multiple ticket submissions without errors")
    public void theSystemProcessesMultipleTicketSubmissionsWithoutErrors() {
        verifyMultipleSubmissionProcessing();
    }
}