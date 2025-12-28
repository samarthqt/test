package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.EmailCommunicationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class EmailCommunicationSteps extends EmailCommunicationPage {

    @Given("user is on the SAP S/4HANA Cloud login page")
    public void userIsOnLoginPage() {
        navigateToLoginPage();
    }

    @When("user enters valid credentials")
    public void userEntersValidCredentials() {
        enterCredentials("validUsername", "validPassword");
    }

    @Then("user is successfully logged in and navigates to the main dashboard")
    public void userIsLoggedInAndNavigatesToDashboard() {
        verifyDashboardDisplayed();
    }

    @Given("user is on the main dashboard")
    public void userIsOnMainDashboard() {
        verifyDashboardDisplayed();
    }

    @When("user navigates to the Billing document module")
    public void userNavigatesToBillingDocumentModule() {
        navigateToBillingDocumentModule();
    }

    @Then("the Billing document module is displayed")
    public void billingDocumentModuleIsDisplayed() {
        verifyBillingDocumentModuleDisplayed();
    }

    @Given("user is in the Billing document module")
    public void userIsInBillingDocumentModule() {
        verifyBillingDocumentModuleDisplayed();
    }

    @When("user searches for the Billing document ID {string}")
    public void userSearchesForBillingDocument(String billingDocumentID) {
        searchBillingDocument(billingDocumentID);
    }

    @Then("the Billing document {string} is displayed with details")
    public void billingDocumentIsDisplayedWithDetails(String billingDocumentID) {
        verifyBillingDocumentDetails(billingDocumentID);
    }

    @Given("user is on the Billing document details page")
    public void userIsOnBillingDocumentDetailsPage() {
        verifyBillingDocumentDetailsPageDisplayed();
    }

    @When("user navigates to the email communication module")
    public void userNavigatesToEmailCommunicationModule() {
        navigateToEmailCommunicationModule();
    }

    @Then("the email communication module is displayed")
    public void emailCommunicationModuleIsDisplayed() {
        verifyEmailCommunicationModuleDisplayed();
    }

    @Given("user is in the email communication module")
    public void userIsInEmailCommunicationModule() {
        verifyEmailCommunicationModuleDisplayed();
    }

    @When("user searches for the email record linked to Billing document {string}")
    public void userSearchesForEmailRecord(String billingDocumentID) {
        searchEmailRecord(billingDocumentID);
    }

    @Then("the email record is displayed with status {string}")
    public void emailRecordIsDisplayedWithStatus(String status) {
        verifyEmailRecordStatus(status);
    }

    @Given("the email record linked to Billing document {string} has status {string}")
    public void emailRecordHasStatus(String billingDocumentID, String status) {
        verifyEmailRecordStatus(status);
    }

    @When("user views the error message for the email record")
    public void userViewsErrorMessage() {
        viewErrorMessage();
    }

    @Then("the error message indicates misconfigured email settings")
    public void errorMessageIndicatesMisconfiguredSettings() {
        verifyErrorMessageContent("Misconfigured email settings");
    }

    @When("user reviews the system logs for the error")
    public void userReviewsSystemLogsForError() {
        reviewSystemLogsForError();
    }

    @Then("the system logs provide detailed information on the misconfiguration")
    public void systemLogsProvideErrorDetails() {
        verifySystemLogsForMisconfigurationDetails();
    }

    @When("user attempts to resend the email manually")
    public void userAttemptsToResendEmailManually() {
        attemptManualResend();
    }

    @Then("the system prevents manual resend due to misconfiguration")
    public void systemPreventsManualResend() {
        verifyManualResendBlocked();
    }

    @When("user corrects the email settings")
    public void userCorrectsEmailSettings() {
        correctEmailSettings();
    }

    @Then("the email is successfully resent")
    public void emailIsSuccessfullyResent() {
        verifyEmailResentSuccessfully();
    }

    @Then("the linkage between the corrected email and Billing document {string} is accurate and complete")
    public void linkageBetweenEmailAndBillingDocumentIsAccurate(String billingDocumentID) {
        verifyEmailBillingDocumentLinkage(billingDocumentID);
    }

    @Given("the system has handled an email dispatch error for Billing document {string}")
    public void systemHasHandledEmailDispatchError(String billingDocumentID) {
        verifyErrorHandlingForBillingDocument(billingDocumentID);
    }

    @When("user reviews the workflow for error handling")
    public void userReviewsWorkflowForErrorHandling() {
        reviewErrorHandlingWorkflow();
    }

    @Then("the workflow functions correctly with proper error handling")
    public void workflowFunctionsCorrectly() {
        verifyWorkflowErrorHandling();
    }

    @Given("the email settings for Billing document {string} have been corrected")
    public void emailSettingsHaveBeenCorrected(String billingDocumentID) {
        verifyEmailSettingsCorrected(billingDocumentID);
    }

    @When("user reviews the system logs")
    public void userReviewsSystemLogs() {
        reviewSystemLogs();
    }

    @Then("the logs confirm corrections and successful email dispatch")
    public void logsConfirmCorrectionsAndSuccessfulDispatch() {
        verifyLogsForCorrectionsAndDispatch();
    }
}