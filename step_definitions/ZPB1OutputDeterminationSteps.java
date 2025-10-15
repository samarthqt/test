package com.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.pageobjects.ZPB1OutputDeterminationPage;
import com.framework.cucumber.TestHarness;

public class ZPB1OutputDeterminationSteps {

    private ZPB1OutputDeterminationPage zpb1Page = new ZPB1OutputDeterminationPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user has authorized credentials")
    public void theUserHasAuthorizedCredentials() {
        zpb1Page.loginToSystem("authorizedUser", "password123");
    }

    @When("the user logs into the SAP S/4HANA system")
    public void theUserLogsIntoTheSAPSystem() {
        zpb1Page.verifyLoginSuccess();
    }

    @Then("the user is successfully logged into the system")
    public void theUserIsSuccessfullyLoggedIntoTheSystem() {
        zpb1Page.verifyLoginSuccess();
    }

    @Given("the user has the necessary authorization to process periodic billing documents")
    public void theUserHasAuthorizationForBillingDocuments() {
        zpb1Page.verifyUserAuthorization("VF31");
    }

    @When("the user navigates to the periodic billing document processing transaction \\(VF31\\)")
    public void theUserNavigatesToVF31Transaction() {
        zpb1Page.navigateToTransaction("VF31");
    }

    @Then("the VF31 transaction screen is displayed")
    public void theVF31TransactionScreenIsDisplayed() {
        zpb1Page.verifyTransactionScreen("VF31");
    }

    @Given("the output type configuration is {string}")
    public void theOutputTypeConfigurationIs(String outputConfiguration) {
        zpb1Page.configureOutputType(outputConfiguration);
    }

    @Given("the user has credentials with VF31 access")
    public void theUserHasCredentialsWithVF31Access() {
        zpb1Page.verifyUserAuthorization("VF31");
    }

    @When("the user enters the ZFR document number {string} in the appropriate field")
    public void theUserEntersTheZFRDocumentNumber(String documentNumber) {
        zpb1Page.enterDocumentNumber(documentNumber);
    }

    @Then("the system retrieves the ZFR document details")
    public void theSystemRetrievesTheZFRDocumentDetails() {
        zpb1Page.verifyDocumentDetailsRetrieved();
    }

    @When("the user selects the ZFR document for processing")
    public void theUserSelectsTheZFRDocumentForProcessing() {
        zpb1Page.selectDocumentForProcessing();
    }

    @Then("the ZFR document is selected and highlighted for processing")
    public void theZFRDocumentIsSelectedAndHighlighted() {
        zpb1Page.verifyDocumentSelectedAndHighlighted();
    }

    @When("the user triggers the output processing for the ZFR document")
    public void theUserTriggersOutputProcessing() {
        zpb1Page.triggerOutputProcessing();
    }

    @Then("the system attempts to process the output for the ZFR document")
    public void theSystemAttemptsToProcessOutput() {
        zpb1Page.verifyOutputProcessingAttempt();
    }

    @When("the user attempts to manually override the output determination settings")
    public void theUserAttemptsManualOverride() {
        zpb1Page.attemptManualOverride();
    }

    @Then("the system prevents manual overrides and maintains the error state")
    public void theSystemPreventsManualOverrides() {
        zpb1Page.verifyManualOverridePrevention();
    }

    @When("the user attempts to process the ZFR document with an alternative output type")
    public void theUserAttemptsAlternativeOutputType() {
        zpb1Page.attemptAlternativeOutputTypeProcessing();
    }

    @Then("the system blocks further processing and displays an error message")
    public void theSystemBlocksFurtherProcessing() {
        zpb1Page.verifyErrorMessageDisplayed();
    }

    @When("the user verifies the system logs for any additional error messages")
    public void theUserVerifiesSystemLogs() {
        zpb1Page.verifySystemLogsForErrors();
    }

    @Then("the logs confirm the failure of ZPB1 output determination and the prevention of further processing")
    public void theLogsConfirmFailure() {
        zpb1Page.verifyLogsConfirmFailure();
    }

    @When("the user checks the ZFR document status in the system")
    public void theUserChecksDocumentStatus() {
        zpb1Page.checkDocumentStatus();
    }

    @Then("the ZFR document remains unprocessed for output")
    public void theDocumentRemainsUnprocessed() {
        zpb1Page.verifyDocumentUnprocessed();
    }

    @When("the user attempts to process another ZFR document with the same output settings")
    public void theUserAttemptsProcessingAnotherDocument() {
        zpb1Page.attemptProcessingAnotherDocument();
    }

    @Then("the system displays the same error message for the second document")
    public void theSystemDisplaysSameErrorMessage() {
        zpb1Page.verifyErrorMessageDisplayedForSecondDocument();
    }

    @Given("the user is logged into the SAP S/4HANA system")
    public void theUserIsLoggedIntoTheSystem() {
        zpb1Page.verifyLoginSuccess();
    }

    @When("the user logs out of the SAP S/4HANA system")
    public void theUserLogsOutOfTheSystem() {
        zpb1Page.logoutFromSystem();
    }

    @Then("the user is successfully logged out of the system")
    public void theUserIsSuccessfullyLoggedOut() {
        zpb1Page.verifyLogoutSuccess();
    }

    @Given("the user identifies the issue with ZPB1 output determination")
    public void theUserIdentifiesIssue() {
        zpb1Page.identifyIssueWithOutputDetermination();
    }

    @When("the user reports the issue to the support team for further investigation")
    public void theUserReportsIssue() {
        zpb1Page.reportIssueToSupportTeam();
    }

    @Then("the support team is notified about the issue for further investigation")
    public void theSupportTeamIsNotified() {
        zpb1Page.verifySupportTeamNotification();
    }
}
