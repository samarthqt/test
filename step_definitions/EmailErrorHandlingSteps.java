package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.pageobjects.EmailErrorHandlingPage;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class EmailErrorHandlingSteps extends EmailErrorHandlingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the SAP S/4HANA Cloud system")
    public void theUserIsLoggedIntoTheSystem() {
        loginToSystem();
    }

    @Given("the user navigates to the Billing Plan module")
    public void theUserNavigatesToBillingPlanModule() {
        navigateToBillingPlanModule();
    }

    @Given("the user sets the billing plan ID {string} as {string}")
    public void theUserSetsBillingPlanID(String billingPlanID, String billingStatus) {
        setBillingPlanID(billingPlanID, billingStatus);
    }

    @When("the system attempts to trigger the creation of a Billing document")
    public void theSystemAttemptsToTriggerBillingDocumentCreation() {
        triggerBillingDocumentCreation();
    }

    @Then("the billing document creation is initiated without errors")
    public void theBillingDocumentCreationIsInitiatedWithoutErrors() {
        verifyBillingDocumentCreation();
    }

    @Then("the user navigates to the email communication module")
    public void theUserNavigatesToEmailCommunicationModule() {
        navigateToEmailCommunicationModule();
    }

    @Then("the user searches for the email record linked to {string}")
    public void theUserSearchesForEmailRecord(String billingPlanID) {
        searchEmailRecord(billingPlanID);
    }

    @Then("the email record is displayed with status {string}")
    public void theEmailRecordIsDisplayedWithStatus(String emailStatus) {
        verifyEmailRecordStatus(emailStatus);
    }

    @Then("the error message displayed for the email record indicates {string}")
    public void theErrorMessageDisplayedForEmailRecord(String errorMessage) {
        verifyEmailErrorMessage(errorMessage);
    }

    @When("the user reviews the system logs for additional details")
    public void theUserReviewsSystemLogs() {
        reviewSystemLogs();
    }

    @Then("the system logs provide detailed information on the misconfiguration")
    public void theSystemLogsProvideDetailsOnMisconfiguration() {
        verifySystemLogsForMisconfiguration();
    }

    @When("the user attempts to resend the email manually")
    public void theUserAttemptsToResendEmailManually() {
        attemptManualEmailResend();
    }

    @Then("the system prevents manual resend due to misconfiguration")
    public void theSystemPreventsManualResend() {
        verifyManualResendPrevention();
    }

    @When("the user corrects the email settings and attempts to resend the email")
    public void theUserCorrectsEmailSettingsAndResends() {
        correctEmailSettingsAndResend();
    }

    @Then("the email is successfully resent after correcting the settings")
    public void theEmailIsSuccessfullyResent() {
        verifyEmailResentSuccessfully();
    }

    @Then("the linkage between the corrected email and Billing document is validated as {string}")
    public void theLinkageBetweenEmailAndBillingDocument(String linkageStatus) {
        verifyEmailBillingLinkage(linkageStatus);
    }

    @Then("the overall workflow for error handling during email dispatch is verified to function correctly")
    public void theOverallWorkflowIsVerified() {
        verifyErrorHandlingWorkflow();
    }
}