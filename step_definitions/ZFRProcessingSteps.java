package com.cucumber.steps;

import com.pageobjects.ZFRProcessingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class ZFRProcessingSteps {

    private ZFRProcessingPage zfrProcessingPage = new ZFRProcessingPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the SAP S/4HANA system with authorized credentials")
    public void theUserIsLoggedIntoTheSAPSystemWithAuthorizedCredentials() {
        zfrProcessingPage.loginToSAPSystem("authorizedUser", "password123");
    }

    @Given("the user navigates to the periodic billing document processing transaction \\(VF31\\)")
    public void theUserNavigatesToThePeriodicBillingDocumentProcessingTransactionVF31() {
        zfrProcessingPage.navigateToVF31Transaction();
    }

    @When("the user enters the ZFR document number {string} in the appropriate field")
    public void theUserEntersTheZFRDocumentNumberInTheAppropriateField(String zfrDocumentNumber) {
        zfrProcessingPage.enterZFRDocumentNumber(zfrDocumentNumber);
    }

    @When("the user selects the ZFR document for processing")
    public void theUserSelectsTheZFRDocumentForProcessing() {
        zfrProcessingPage.selectZFRDocumentForProcessing();
    }

    @When("the user triggers the output processing for the ZFR document")
    public void theUserTriggersTheOutputProcessingForTheZFRDocument() {
        zfrProcessingPage.triggerOutputProcessing();
    }

    @Then("the system displays an error message indicating that ZPB1 output determination has failed")
    public void theSystemDisplaysAnErrorMessageIndicatingThatZPB1OutputDeterminationHasFailed() {
        zfrProcessingPage.verifyErrorMessage("ZPB1 output determination has failed");
    }

    @Then("the error logs provide detailed information about the cause of the ZPB1 output determination failure")
    public void theErrorLogsProvideDetailedInformationAboutTheCauseOfTheZPB1OutputDeterminationFailure() {
        zfrProcessingPage.verifyErrorLogs("Detailed information about ZPB1 output determination failure");
    }

    @Then("the ZFR document status indicates that it is unprocessed for output")
    public void theZFRDocumentStatusIndicatesThatItIsUnprocessedForOutput() {
        zfrProcessingPage.verifyDocumentStatus("Unprocessed for output");
    }

    @Then("the system generates error codes corresponding to the misconfiguration or disabled ZPB1 output determination settings")
    public void theSystemGeneratesErrorCodesCorrespondingToTheMisconfigurationOrDisabledZPB1OutputDeterminationSettings() {
        zfrProcessingPage.verifyErrorCodes("Error codes related to ZPB1 output determination failure");
    }

    @When("the user documents the error message and logs for further analysis")
    public void theUserDocumentsTheErrorMessageAndLogsForFurtherAnalysis() {
        zfrProcessingPage.documentErrorDetails();
    }

    @Then("the user logs out of the SAP S/4HANA system")
    public void theUserLogsOutOfTheSAPSystem() {
        zfrProcessingPage.logoutFromSAPSystem();
    }

    @Then("the user communicates the issue to the configuration team for resolution")
    public void theUserCommunicatesTheIssueToTheConfigurationTeamForResolution() {
        zfrProcessingPage.communicateIssueToConfigurationTeam();
    }

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        zfrProcessingPage.validateUserCredentials();
    }

    @When("the user logs into the SAP system")
    public void theUserLogsIntoTheSAPSystem() {
        zfrProcessingPage.loginToSAPSystem();
    }

    @Then("the user is successfully logged into the SAP system")
    public void theUserIsSuccessfullyLoggedIntoTheSAPSystem() {
        zfrProcessingPage.verifySuccessfulLogin();
    }

    @Given("the user is logged into the SAP system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        zfrProcessingPage.ensureUserLoggedIn();
    }

    @When("the user navigates to the periodic billing document processing transaction")
    public void theUserNavigatesToThePeriodicBillingDocumentProcessingTransaction() {
        zfrProcessingPage.navigateToBillingTransaction();
    }

    @Then("the periodic billing document processing transaction screen is displayed")
    public void thePeriodicBillingDocumentProcessingTransactionScreenIsDisplayed() {
        zfrProcessingPage.verifyBillingTransactionScreen();
    }

    @Given("the user is on the periodic billing document processing screen")
    public void theUserIsOnThePeriodicBillingDocumentProcessingScreen() {
        zfrProcessingPage.ensureOnBillingProcessingScreen();
    }

    @When("the user enters the ZFR document ID {string} in the appropriate input field")
    public void theUserEntersTheZFRDocumentIDInTheAppropriateInputField(String documentId) {
        zfrProcessingPage.enterZFRDocumentID(documentId);
    }

    @Then("the ZFR document {string} is selected for processing")
    public void theZFRDocumentIsSelectedForProcessing(String documentId) {
        zfrProcessingPage.verifyDocumentSelected(documentId);
    }

    @Given("the user has selected a ZFR document for processing")
    public void theUserHasSelectedAZFRDocumentForProcessing() {
        zfrProcessingPage.ensureDocumentSelected();
    }

    @When("the user triggers the output processing for the selected ZFR document")
    public void theUserTriggersTheOutputProcessingForTheSelectedZFRDocument() {
        zfrProcessingPage.triggerOutputProcessing();
    }

    @Then("the system initiates the output processing for the ZFR document")
    public void theSystemInitiatesTheOutputProcessingForTheZFRDocument() {
        zfrProcessingPage.verifyOutputProcessingInitiated();
    }

    @Given("the system is processing the ZFR document")
    public void theSystemIsProcessingTheZFRDocument() {
        zfrProcessingPage.ensureDocumentProcessing();
    }

    @When("the output type is configured as ZPB1")
    public void theOutputTypeIsConfiguredAsZPB1() {
        zfrProcessingPage.configureOutputTypeZPB1();
    }

    @Then("the ZPB1 output is successfully generated and attached to the ZFR document")
    public void theZPB1OutputIsSuccessfullyGeneratedAndAttachedToTheZFRDocument() {
        zfrProcessingPage.verifyZPB1OutputGenerated();
    }

    @Given("the ZPB1 output has been generated for the ZFR document")
    public void theZPB1OutputHasBeenGeneratedForTheZFRDocument() {
        zfrProcessingPage.ensureZPB1OutputGenerated();
    }

    @When("the user navigates to the email dispatch logs in the system")
    public void theUserNavigatesToTheEmailDispatchLogsInTheSystem() {
        zfrProcessingPage.navigateToEmailDispatchLogs();
    }

    @Then("the email dispatch logs are displayed")
    public void theEmailDispatchLogsAreDisplayed() {
        zfrProcessingPage.verifyEmailDispatchLogsDisplayed();
    }

    @When("the user searches for the email sent to {string} with the attached ZPB1 form")
    public void theUserSearchesForTheEmailSentToWithTheAttachedZPB1Form(String emailRecipient) {
        zfrProcessingPage.searchEmailWithAttachment(emailRecipient);
    }

    @Then("the email with the attached ZPB1 periodic billing form is found in the dispatch logs")
    public void theEmailWithTheAttachedZPB1PeriodicBillingFormIsFoundInTheDispatchLogs() {
        zfrProcessingPage.verifyEmailFoundInLogs();
    }

    @Given("the email with the attached ZPB1 form is found")
    public void theEmailWithTheAttachedZPB1FormIsFound() {
        zfrProcessingPage.ensureEmailFound();
    }

    @When("the user opens the email")
    public void theUserOpensTheEmail() {
        zfrProcessingPage.openEmail();
    }

    @Then("the email contains the correct subject line {string}")
    public void theEmailContainsTheCorrectSubjectLine(String subjectLine) {
        zfrProcessingPage.verifyEmailSubjectLine(subjectLine);
    }

    @Then("the email contains the correct recipient address {string}")
    public void theEmailContainsTheCorrectRecipientAddress(String recipientAddress) {
        zfrProcessingPage.verifyEmailRecipientAddress(recipientAddress);
    }

    @Then("the email contains the ZPB1 attachment")
    public void theEmailContainsTheZPB1Attachment() {
        zfrProcessingPage.verifyEmailAttachment();
    }

    @Given("the email with the ZPB1 attachment is sent")
    public void theEmailWithTheZPB1AttachmentIsSent() {
        zfrProcessingPage.ensureEmailSent();
    }

    @When("the user downloads the ZPB1 attachment")
    public void theUserDownloadsTheZPB1Attachment() {
        zfrProcessingPage.downloadAttachment();
    }

    @Then("the ZPB1 attachment is successfully downloaded")
    public void theZPB1AttachmentIsSuccessfullyDownloaded() {
        zfrProcessingPage.verifyAttachmentDownloaded();
    }

    @Given("the ZPB1 attachment is downloaded")
    public void theZPB1AttachmentIsDownloaded() {
        zfrProcessingPage.ensureAttachmentDownloaded();
    }

    @When("the user opens the downloaded ZPB1 form")
    public void theUserOpensTheDownloadedZPB1Form() {
        zfrProcessingPage.openDownloadedForm();
    }

    @Then("the ZPB1 form contains all the necessary data required for payment")
    public void theZPB1FormContainsAllTheNecessaryDataRequiredForPayment() {
        zfrProcessingPage.verifyFormData();
    }

    @Given("the ZPB1 form is opened")
    public void theZPB1FormIsOpened() {
        zfrProcessingPage.ensureFormOpened();
    }

    @When("the user verifies the periodic billing form")
    public void theUserVerifiesThePeriodicBillingForm() {
        zfrProcessingPage.verifyBillingForm();
    }

    @Then("the periodic billing form matches the configured ZPB1 template")
    public void thePeriodicBillingFormMatchesTheConfiguredZPB1Template() {
        zfrProcessingPage.verifyFormTemplate();
    }

    @When("the user checks the email dispatch time")
    public void theUserChecksTheEmailDispatchTime() {
        zfrProcessingPage.checkEmailDispatchTime();
    }

    @Then("the email dispatch time is within the configured time frame")
    public void theEmailDispatchTimeIsWithinTheConfiguredTimeFrame() {
        zfrProcessingPage.verifyDispatchTime();
    }
}
