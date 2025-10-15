package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.pageobjects.EmailAttachmentDispatchPage;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class EmailAttachmentDispatchSteps extends EmailAttachmentDispatchPage {

    @Given("the user logs into the SAP S/4HANA Cloud system")
    public void theUserLogsIntoTheSAPSystem() {
        loginToSAPSystem();
    }

    @When("the user navigates to the Billing document module")
    public void theUserNavigatesToTheBillingDocumentModule() {
        navigateToBillingDocumentModule();
    }

    @When("the user searches for the Billing document ID {string}")
    public void theUserSearchesForTheBillingDocumentID(String billingDocumentID) {
        searchBillingDocument(billingDocumentID);
    }

    @Then("the Billing document details are displayed")
    public void theBillingDocumentDetailsAreDisplayed() {
        verifyBillingDocumentDetailsDisplayed();
    }

    @Then("the document type is verified as {string}")
    public void theDocumentTypeIsVerifiedAs(String documentType) {
        verifyDocumentType(documentType);
    }

    @When("the user navigates to the email communication module")
    public void theUserNavigatesToTheEmailCommunicationModule() {
        navigateToEmailCommunicationModule();
    }

    @When("the user searches for the email sent to {string}")
    public void theUserSearchesForTheEmailSentTo(String customerEmail) {
        searchEmailByCustomer(customerEmail);
    }

    @Then("the email record is displayed with status {string}")
    public void theEmailRecordIsDisplayedWithStatus(String emailStatus) {
        verifyEmailRecordStatus(emailStatus);
    }

    @When("the user opens the email record")
    public void theUserOpensTheEmailRecord() {
        openEmailRecord();
    }

    @Then("the attachment is present and accessible")
    public void theAttachmentIsPresentAndAccessible() {
        verifyAttachmentPresenceAndAccessibility();
    }

    @When("the user downloads the attachment")
    public void theUserDownloadsTheAttachment() {
        downloadAttachment();
    }

    @Then("the attachment format is verified as {string}")
    public void theAttachmentFormatIsVerifiedAs(String attachmentFormat) {
        verifyAttachmentFormat(attachmentFormat);
    }

    @Then("the attachment opens without errors")
    public void theAttachmentOpensWithoutErrors() {
        verifyAttachmentOpensWithoutErrors();
    }

    @When("the user compares the attachment content with the Billing document {string}")
    public void theUserComparesTheAttachmentContentWithTheBillingDocument(String billingDocumentID) {
        compareAttachmentContentWithBillingDocument(billingDocumentID);
    }

    @Then("the attachment content matches the Billing document details accurately")
    public void theAttachmentContentMatchesTheBillingDocumentDetailsAccurately() {
        verifyAttachmentContentMatchesBillingDocument();
    }

    @When("the user checks the email logs")
    public void theUserChecksTheEmailLogs() {
        checkEmailLogs();
    }

    @Then("the logs confirm the email was successfully sent with the attachment")
    public void theLogsConfirmTheEmailWasSuccessfullySentWithTheAttachment() {
        verifyEmailLogsForSuccessfulDispatch();
    }

    @When("the user validates the linkage between the Billing document and the email in the system")
    public void theUserValidatesTheLinkageBetweenTheBillingDocumentAndTheEmailInTheSystem() {
        validateBillingDocumentEmailLinkage();
    }

    @Then("the system shows correct linkage between the email and the Billing document")
    public void theSystemShowsCorrectLinkageBetweenTheEmailAndTheBillingDocument() {
        verifyCorrectLinkageBetweenEmailAndBillingDocument();
    }

    @When("the user verifies the overall workflow for email attachment dispatch")
    public void theUserVerifiesTheOverallWorkflowForEmailAttachmentDispatch() {
        verifyOverallWorkflow();
    }

    @Then("the workflow functions correctly without errors or delays")
    public void theWorkflowFunctionsCorrectlyWithoutErrorsOrDelays() {
        verifyWorkflowFunctionality();
    }
}