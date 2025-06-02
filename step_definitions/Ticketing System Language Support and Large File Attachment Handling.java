package com.cucumber.steps;

import com.page_objects.TicketingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TicketingSteps extends TicketingPage {

    @Given("the user has access to the ticketing system")
    public void theUserHasAccessToTheTicketingSystem() {
        navigateToTicketingSystem();
    }

    @When("the user navigates to the ticket submission page")
    public void theUserNavigatesToTheTicketSubmissionPage() {
        navigateToTicketSubmissionPage();
    }

    @Then("the ticket submission page loads successfully")
    public void theTicketSubmissionPageLoadsSuccessfully() {
        verifyTicketSubmissionPageLoaded();
    }

    @Given("the ticket submission page is loaded")
    public void theTicketSubmissionPageIsLoaded() {
        verifyTicketSubmissionPageLoaded();
    }

    @When("the user selects the language preference as French")
    public void theUserSelectsTheLanguagePreferenceAsFrench() {
        selectLanguagePreference("French");
    }

    @Then("the system interface changes to French language")
    public void theSystemInterfaceChangesToFrenchLanguage() {
        verifyLanguageChanged("French");
    }

    @Given("the system interface is in French language")
    public void theSystemInterfaceIsInFrenchLanguage() {
        verifyLanguageChanged("French");
    }

    @When("the user enters ticket details in French")
    public void theUserEntersTicketDetailsInFrench() {
        enterTicketDetailsInFrench();
    }

    @Then("the ticket details are entered in French")
    public void theTicketDetailsAreEnteredInFrench() {
        verifyTicketDetailsEnteredInFrench();
    }

    @Given("the ticket details are entered in French")
    public void theTicketDetailsAreEnteredInFrench() {
        verifyTicketDetailsEnteredInFrench();
    }

    @When("the user attaches a large file of 50MB to the ticket submission")
    public void theUserAttachesALargeFileOf50MBToTheTicketSubmission() {
        attachLargeFile(50);
    }

    @Then("the system accepts the large file without error")
    public void theSystemAcceptsTheLargeFileWithoutError() {
        verifyLargeFileAccepted();
    }

    @Given("the large file is attached to the ticket")
    public void theLargeFileIsAttachedToTheTicket() {
        verifyLargeFileAttached();
    }

    @When("the user submits the ticket with the attached file")
    public void theUserSubmitsTheTicketWithTheAttachedFile() {
        submitTicketWithAttachment();
    }

    @Then("the ticket is submitted successfully with the large file attachment")
    public void theTicketIsSubmittedSuccessfullyWithTheLargeFileAttachment() {
        verifyTicketSubmittedWithAttachment();
    }

    @Given("the ticket is submitted successfully")
    public void theTicketIsSubmittedSuccessfully() {
        verifyTicketSubmitted();
    }

    @When("the system generates a confirmation message")
    public void theSystemGeneratesAConfirmationMessage() {
        generateConfirmationMessage();
    }

    @Then("the confirmation message is displayed in French")
    public void theConfirmationMessageIsDisplayedInFrench() {
        verifyConfirmationMessageInFrench();
    }

    @Given("the ticket is submitted")
    public void theTicketIsSubmitted() {
        verifyTicketSubmitted();
    }

    @When("the user checks the ticket status in the system")
    public void theUserChecksTheTicketStatusInTheSystem() {
        checkTicketStatus();
    }

    @Then("the ticket appears in the system with a status indicating successful submission")
    public void theTicketAppearsInTheSystemWithAStatusIndicatingSuccessfulSubmission() {
        verifyTicketStatus();
    }

    @Given("the ticket is submitted with an attachment")
    public void theTicketIsSubmittedWithAnAttachment() {
        verifyTicketSubmittedWithAttachment();
    }

    @When("the user attempts to retrieve the attached file")
    public void theUserAttemptsToRetrieveTheAttachedFile() {
        retrieveAttachedFile();
    }

    @Then("the attached file can be retrieved and viewed successfully")
    public void theAttachedFileCanBeRetrievedAndViewedSuccessfully() {
        verifyFileRetrievedSuccessfully();
    }

    @Given("the ticket is submitted")
    public void theTicketIsSubmitted() {
        verifyTicketSubmitted();
    }

    @When("the system logs the submission details")
    public void theSystemLogsTheSubmissionDetails() {
        logSubmissionDetails();
    }

    @Then("the system logs include the language preference and file attachment details")
    public void theSystemLogsIncludeTheLanguagePreferenceAndFileAttachmentDetails() {
        verifyLogsIncludeLanguageAndFileDetails();
    }

    @Given("the user has completed a ticket submission")
    public void theUserHasCompletedATicketSubmission() {
        verifyTicketSubmitted();
    }

    @When("the user attempts to submit another ticket in Spanish language")
    public void theUserAttemptsToSubmitAnotherTicketInSpanishLanguage() {
        selectLanguagePreference("Spanish");
    }

    @Then("the system interface changes to Spanish language successfully")
    public void theSystemInterfaceChangesToSpanishLanguageSuccessfully() {
        verifyLanguageChanged("Spanish");
    }

    @Given("the system interface is in Spanish language")
    public void theSystemInterfaceIsInSpanishLanguage() {
        verifyLanguageChanged("Spanish");
    }

    @When("the user attaches a different large file of 75MB to the ticket submission")
    public void theUserAttachesADifferentLargeFileOf75MBToTheTicketSubmission() {
        attachLargeFile(75);
    }

    @Then("the system accepts the 75MB file without error")
    public void theSystemAcceptsThe75MBFileWithoutError() {
        verifyLargeFileAccepted();
    }

    @Given("the new file is attached to the ticket")
    public void theNewFileIsAttachedToTheTicket() {
        verifyLargeFileAttached();
    }

    @When("the user submits the ticket with the new file attachment")
    public void theUserSubmitsTheTicketWithTheNewFileAttachment() {
        submitTicketWithAttachment();
    }

    @Then("the ticket is submitted successfully with the new file attachment")
    public void theTicketIsSubmittedSuccessfullyWithTheNewFileAttachment() {
        verifyTicketSubmittedWithAttachment();
    }

    @Given("the ticket is submitted in Spanish")
    public void theTicketIsSubmittedInSpanish() {
        verifyTicketSubmitted();
    }

    @When("the user retrieves the ticket")
    public void theUserRetrievesTheTicket() {
        retrieveTicket();
    }

    @Then("the system displays ticket details in the selected language during retrieval")
    public void theSystemDisplaysTicketDetailsInTheSelectedLanguageDuringRetrieval() {
        verifyTicketDetailsInSelectedLanguage();
    }

    @Given("large files are being attached to tickets")
    public void largeFilesAreBeingAttachedToTickets() {
        verifyLargeFileAttached();
    }

    @When("the user observes the system performance")
    public void theUserObservesTheSystemPerformance() {
        observeSystemPerformance();
    }

    @Then("the system handles large file attachments efficiently without performance degradation")
    public void theSystemHandlesLargeFileAttachmentsEfficientlyWithoutPerformanceDegradation() {
        verifyPerformanceEfficiency();
    }

    @Given("the user has submitted tickets in multiple languages")
    public void theUserHasSubmittedTicketsInMultipleLanguages() {
        verifyMultipleLanguageSubmissions();
    }

    @When("the user switches language preferences")
    public void theUserSwitchesLanguagePreferences() {
        switchLanguagePreferences();
    }

    @Then("language switching does not affect the integrity of the ticket data")
    public void languageSwitchingDoesNotAffectTheIntegrityOfTheTicketData() {
        verifyDataIntegrityAfterLanguageSwitch();
    }
}