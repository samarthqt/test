package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.SendGridPage;

public class SendGridSteps extends SendGridPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a SendGrid account is configured")
    public void aSendGridAccountIsConfigured() {
        verifySendGridAccountConfigured();
    }

    @Given("the SendGrid API key is set up in the application")
    public void theSendGridAPIKeyIsSetUpInTheApplication() {
        verifySendGridAPIKeySetup();
    }

    @When("the user logs in to the application with email {string}")
    public void theUserLogsInToTheApplicationWithEmail(String email) {
        loginUser(email);
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyUserLoggedIn();
    }

    @Given("the SendGrid API key is configured in the application settings")
    public void theSendGridAPIKeyIsConfiguredInTheApplicationSettings() {
        verifySendGridAPIKeyConfigured();
    }

    @Then("the SendGrid API key is correctly configured")
    public void theSendGridAPIKeyIsCorrectlyConfigured() {
        verifyAPIKeyCorrectness();
    }

    @Given("the user has logged in")
    public void theUserHasLoggedIn() {
        verifyUserLoggedIn();
    }

    @When("the user submits a support request via the support portal")
    public void theUserSubmitsASupportRequestViaTheSupportPortal() {
        submitSupportRequest();
    }

    @Then("the support request is successfully submitted")
    public void theSupportRequestIsSuccessfullySubmitted() {
        verifySupportRequestSubmission();
    }

    @Then("a ticket ID is generated")
    public void aTicketIDIsGenerated() {
        verifyTicketIDGenerated();
    }

    @Given("the support request is submitted")
    public void theSupportRequestIsSubmitted() {
        verifySupportRequestSubmission();
    }

    @When("the support team responds to the support request from the support team dashboard")
    public void theSupportTeamRespondsToTheSupportRequestFromTheSupportTeamDashboard() {
        respondToSupportRequest();
    }

    @Then("the support team can successfully respond to the support request")
    public void theSupportTeamCanSuccessfullyRespondToTheSupportRequest() {
        verifySupportTeamResponse();
    }

    @Given("the support team has responded to the support request")
    public void theSupportTeamHasRespondedToTheSupportRequest() {
        verifySupportTeamResponse();
    }

    @When("checking the SendGrid dashboard")
    public void checkingTheSendGridDashboard() {
        checkSendGridDashboard();
    }

    @Then("the email delivery status is marked as successful")
    public void theEmailDeliveryStatusIsMarkedAsSuccessful() {
        verifyEmailDeliveryStatus();
    }

    @Given("the email delivery status is successful")
    public void theEmailDeliveryStatusIsSuccessful() {
        verifyEmailDeliveryStatus();
    }

    @When("checking the user's inbox")
    public void checkingTheUsersInbox() {
        checkUserInbox();
    }

    @Then("the user receives an email notification about the support response")
    public void theUserReceivesAnEmailNotificationAboutTheSupportResponse() {
        verifyEmailNotificationReceived();
    }

    @Given("the user receives the email notification")
    public void theUserReceivesTheEmailNotification() {
        verifyEmailNotificationReceived();
    }

    @When("checking the email content")
    public void checkingTheEmailContent() {
        checkEmailContent();
    }

    @Then("the email contains the correct details of the support response")
    public void theEmailContainsTheCorrectDetailsOfTheSupportResponse() {
        verifyEmailContentDetails();
    }

    @Given("the email is received")
    public void theEmailIsReceived() {
        verifyEmailNotificationReceived();
    }

    @When("checking the sender address")
    public void checkingTheSenderAddress() {
        checkEmailSenderAddress();
    }

    @Then("the email is sent from the designated support email address")
    public void theEmailIsSentFromTheDesignatedSupportEmailAddress() {
        verifyEmailSenderAddress();
    }

    @When("checking the email subject line")
    public void checkingTheEmailSubjectLine() {
        checkEmailSubjectLine();
    }

    @Then("the email subject line clearly indicates a response to the support request")
    public void theEmailSubjectLineClearlyIndicatesAResponseToTheSupportRequest() {
        verifyEmailSubjectLine();
    }

    @When("checking for formatting issues")
    public void checkingForFormattingIssues() {
        checkEmailFormatting();
    }

    @Then("the email is well-formatted and readable")
    public void theEmailIsWellFormattedAndReadable() {
        verifyEmailFormatting();
    }

    @When("checking the time of reception")
    public void checkingTheTimeOfReception() {
        checkEmailReceptionTime();
    }

    @Then("the email is received within 5 minutes of the support response")
    public void theEmailIsReceivedWithin5MinutesOfTheSupportResponse() {
        verifyEmailReceptionTime();
    }

    @When("verifying the number of emails")
    public void verifyingTheNumberOfEmails() {
        verifyNumberOfEmails();
    }

    @Then("only one email notification is received per support response")
    public void onlyOneEmailNotificationIsReceivedPerSupportResponse() {
        verifySingleEmailNotification();
    }

    @When("checking for attachments")
    public void checkingForAttachments() {
        checkEmailAttachments();
    }

    @Then("the email does not contain any unnecessary attachments unless specified")
    public void theEmailDoesNotContainAnyUnnecessaryAttachmentsUnlessSpecified() {
        verifyEmailAttachments();
    }

    @When("opening the email on various email clients")
    public void openingTheEmailOnVariousEmailClients() {
        openEmailOnVariousClients();
    }

    @Then("the email is accessible and correctly displayed on various email clients")
    public void theEmailIsAccessibleAndCorrectlyDisplayedOnVariousEmailClients() {
        verifyEmailCompatibility();
    }

    @When("the user replies to the email")
    public void theUserRepliesToTheEmail() {
        replyToEmail();
    }

    @Then("the reply is directed to the support team")
    public void theReplyIsDirectedToTheSupportTeam() {
        verifyReplyDirection();
    }
}