package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.SupportPage;

public class SupportSteps extends SupportPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a registered email address {string}")
    public void theUserHasARegisteredEmailAddress(String email) {
        verifyRegisteredEmail(email);
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
        verifyTicketIDGeneration();
    }

    @Given("the system configuration settings confirm email notifications are enabled")
    public void theSystemConfigurationSettingsConfirmEmailNotificationsAreEnabled() {
        verifyEmailNotificationsEnabled();
    }

    @Given("the support ticket ID is {string}")
    public void theSupportTicketIDIs(String ticketID) {
        verifySupportTicketID(ticketID);
    }

    @Then("email notifications should be sent for support responses")
    public void emailNotificationsShouldBeSentForSupportResponses() {
        verifyEmailNotificationSent();
    }

    @Given("the support team dashboard is accessible")
    public void theSupportTeamDashboardIsAccessible() {
        accessSupportTeamDashboard();
    }

    @When("the support team responds to the support request")
    public void theSupportTeamRespondsToTheSupportRequest() {
        respondToSupportRequest();
    }

    @Then("the response should be successful")
    public void theResponseShouldBeSuccessful() {
        verifyResponseSuccess();
    }

    @Given("the support team has responded to the support request")
    public void theSupportTeamHasRespondedToTheSupportRequest() {
        verifySupportTeamResponse();
    }

    @When("the user checks their email inbox")
    public void theUserChecksTheirEmailInbox() {
        checkEmailInbox();
    }

    @Then("the user should receive an email notification about the support response")
    public void theUserShouldReceiveAnEmailNotificationAboutTheSupportResponse() {
        verifyEmailNotificationReceived();
    }

    @Given("the user has received an email notification")
    public void theUserHasReceivedAnEmailNotification() {
        verifyEmailNotificationReceived();
    }

    @When("the user opens the email")
    public void theUserOpensTheEmail() {
        openEmail();
    }

    @Then("the email should contain the correct details of the support response")
    public void theEmailShouldContainTheCorrectDetailsOfTheSupportResponse() {
        verifyEmailContentDetails();
    }

    @When("the user checks the sender's email address")
    public void theUserChecksTheSendersEmailAddress() {
        checkSenderEmailAddress();
    }

    @Then("the email should be sent from the designated support email address")
    public void theEmailShouldBeSentFromTheDesignatedSupportEmailAddress() {
        verifySenderEmailAddress();
    }

    @When("the user checks the email subject line")
    public void theUserChecksTheEmailSubjectLine() {
        checkEmailSubjectLine();
    }

    @Then("the subject line should clearly indicate a response to the support request")
    public void theSubjectLineShouldClearlyIndicateAResponseToTheSupportRequest() {
        verifyEmailSubjectLine();
    }

    @When("the user checks the email content")
    public void theUserChecksTheEmailContent() {
        checkEmailContent();
    }

    @Then("the email should include a link that redirects to the support request in the portal")
    public void theEmailShouldIncludeALinkThatRedirectsToTheSupportRequestInThePortal() {
        verifyEmailLinkToSupportRequest();
    }

    @Then("the email should be received within 5 minutes of the support response")
    public void theEmailShouldBeReceivedWithin5MinutesOfTheSupportResponse() {
        verifyEmailReceivedWithinTimeFrame();
    }

    @Then("the email should be well-formatted and readable")
    public void theEmailShouldBeWellFormattedAndReadable() {
        verifyEmailFormatting();
    }

    @When("the user checks their spam/junk folder")
    public void theUserChecksTheirSpamJunkFolder() {
        checkSpamJunkFolder();
    }

    @Then("the email should be delivered to the inbox and not the spam/junk folder")
    public void theEmailShouldBeDeliveredToTheInboxAndNotTheSpamJunkFolder() {
        verifyEmailNotInSpam();
    }

    @Then("only one email notification should be received per support response")
    public void onlyOneEmailNotificationShouldBeReceivedPerSupportResponse() {
        verifyNoDuplicateEmails();
    }

    @Then("the email should not contain any unnecessary attachments unless specified")
    public void theEmailShouldNotContainAnyUnnecessaryAttachmentsUnlessSpecified() {
        verifyEmailAttachments();
    }

    @When("the user opens the email on various email clients")
    public void theUserOpensTheEmailOnVariousEmailClients() {
        openEmailOnDifferentClients();
    }

    @Then("the email should be accessible and correctly displayed")
    public void theEmailShouldBeAccessibleAndCorrectlyDisplayed() {
        verifyEmailAccessibility();
    }

    @When("the user replies to the email")
    public void theUserRepliesToTheEmail() {
        replyToEmail();
    }

    @Then("the reply should be directed to the support team")
    public void theReplyShouldBeDirectedToTheSupportTeam() {
        verifyReplyDirectedToSupportTeam();
    }
}