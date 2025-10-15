package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.pageobjects.EmailDispatchPage;
import com.framework.cucumber.TestHarness;

public class EmailDispatchSteps extends EmailDispatchPage {

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        enterCredentials("validUsername", "validPassword");
    }

    @When("the user logs into the SAP S/4HANA Cloud system")
    public void theUserLogsIntoTheSystem() {
        loginToSystem();
    }

    @Then("the user is successfully logged into the system")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyLoginSuccess();
    }

    @Given("the user is logged into the SAP S/4HANA Cloud system")
    public void theUserIsLoggedIn() {
        ensureUserIsLoggedIn();
    }

    @When("the user navigates to the Billing Plan module")
    public void theUserNavigatesToBillingPlanModule() {
        navigateToBillingPlanModule();
    }

    @Then("the last billing plan is confirmed as 'Due'")
    public void theLastBillingPlanIsConfirmedAsDue() {
        verifyLastBillingPlanStatus("Due");
    }

    @Given("the last billing plan is marked as 'Due'")
    public void theLastBillingPlanIsMarkedAsDue() {
        ensureLastBillingPlanIsDue();
    }

    @When("the user triggers the billing document creation for the last billing plan")
    public void theUserTriggersBillingDocumentCreation() {
        triggerBillingDocumentCreation();
    }

    @Then("the billing document is created successfully")
    public void theBillingDocumentIsCreatedSuccessfully() {
        verifyBillingDocumentCreation();
    }

    @Given("the billing document is created successfully")
    public void theBillingDocumentIsCreated() {
        ensureBillingDocumentIsCreated();
    }

    @When("the user checks the email dispatch logs for the created billing document")
    public void theUserChecksEmailDispatchLogs() {
        checkEmailDispatchLogs();
    }

    @Then("the logs display successful email dispatch for the billing document")
    public void theLogsDisplaySuccessfulEmailDispatch() {
        verifyEmailDispatchLogs();
    }

    @Given("the email dispatch logs display successful email dispatch")
    public void theEmailDispatchLogsDisplaySuccess() {
        ensureEmailDispatchLogsSuccess();
    }

    @When("the user verifies the customer receives an email")
    public void theUserVerifiesCustomerReceivesEmail() {
        verifyCustomerEmailReceipt();
    }

    @Then("the customer receives an email with the correct billing form attachment")
    public void theCustomerReceivesEmailWithAttachment() {
        verifyBillingFormAttachment();
    }

    @Given("the customer receives an email with the billing form attachment")
    public void theCustomerReceivesEmailWithBillingForm() {
        ensureEmailWithBillingFormReceived();
    }

    @When("the user opens the email and validates the billing form attachment")
    public void theUserValidatesBillingFormAttachment() {
        validateBillingFormAttachment();
    }

    @Then("the billing form attachment contains accurate details matching the billing document")
    public void theBillingFormAttachmentContainsAccurateDetails() {
        verifyBillingFormDetails();
    }

    @Given("the email is dispatched to the customer")
    public void theEmailIsDispatchedToCustomer() {
        ensureEmailDispatchedToCustomer();
    }

    @When("the user reviews the email subject line and body text")
    public void theUserReviewsEmailSubjectAndBody() {
        reviewEmailSubjectAndBody();
    }

    @Then("the email subject line and body text are accurate and match the configuration")
    public void theEmailSubjectAndBodyAreAccurate() {
        verifyEmailSubjectAndBody();
    }

    @When("the user validates the recipient email address")
    public void theUserValidatesRecipientEmailAddress() {
        validateRecipientEmailAddress();
    }

    @Then("the email is sent to the correct customer email address")
    public void theEmailIsSentToCorrectAddress() {
        verifyCorrectRecipientEmailAddress();
    }

    @When("the user checks the email timestamp")
    public void theUserChecksEmailTimestamp() {
        checkEmailTimestamp();
    }

    @Then("the email timestamp aligns with the billing document creation time")
    public void theEmailTimestampAlignsWithBillingDocumentTime() {
        verifyEmailTimestamp();
    }

    @Given("the email dispatch process is completed")
    public void theEmailDispatchProcessIsCompleted() {
        ensureEmailDispatchProcessCompleted();
    }

    @When("the user checks the email queue for the billing document")
    public void theUserChecksEmailQueue() {
        checkEmailQueue();
    }

    @Then("no pending or failed emails are found in the email queue")
    public void noPendingOrFailedEmailsInQueue() {
        verifyNoPendingOrFailedEmails();
    }

    @Given("the email dispatch process is initiated")
    public void theEmailDispatchProcessIsInitiated() {
        initiateEmailDispatchProcess();
    }

    @When("the user monitors the email dispatch process")
    public void theUserMonitorsEmailDispatchProcess() {
        monitorEmailDispatchProcess();
    }

    @Then("the email dispatch process completes without any system errors")
    public void theEmailDispatchProcessCompletesWithoutErrors() {
        verifyNoSystemErrorsInEmailDispatch();
    }

    @When("the user checks the system logs")
    public void theUserChecksSystemLogs() {
        checkSystemLogs();
    }

    @Then("the email dispatch is logged in the system with all relevant details")
    public void theEmailDispatchIsLoggedInSystem() {
        verifyEmailDispatchLogged();
    }
}