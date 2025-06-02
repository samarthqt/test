package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.SMSNotificationPage;

public class SMSNotificationSteps extends SMSNotificationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a registered phone number {string}")
    public void theUserHasARegisteredPhoneNumber(String phoneNumber) {
        verifyRegisteredPhoneNumber(phoneNumber);
    }

    @When("the user submits a support request via the support portal")
    public void theUserSubmitsASupportRequestViaTheSupportPortal() {
        submitSupportRequest();
    }

    @Then("the support request is successfully submitted and a ticket ID is generated")
    public void theSupportRequestIsSuccessfullySubmittedAndATicketIDIsGenerated() {
        verifyTicketIDGenerated();
    }

    @Given("the system configuration settings confirm SMS notifications are enabled")
    public void theSystemConfigurationSettingsConfirmSMSNotificationsAreEnabled() {
        verifySMSNotificationsEnabled();
    }

    @Given("the user has a support ticket ID {string}")
    public void theUserHasASupportTicketID(String ticketID) {
        verifySupportTicketID(ticketID);
    }

    @When("a support response is sent to the user")
    public void aSupportResponseIsSentToTheUser() {
        sendSupportResponse();
    }

    @Then("the user receives an SMS notification about the support response")
    public void theUserReceivesAnSMSNotificationAboutTheSupportResponse() {
        verifySMSNotificationReceived();
    }

    @Then("the SMS contains the correct details of the support response")
    public void theSMSContainsTheCorrectDetailsOfTheSupportResponse() {
        verifySMSContentDetails();
    }

    @Then("the SMS is sent from the designated support number")
    public void theSMSSentFromTheDesignatedSupportNumber() {
        verifySMSSenderNumber();
    }

    @Then("the SMS is well-formatted and readable")
    public void theSMSIsWellFormattedAndReadable() {
        verifySMSFormatting();
    }

    @Then("the SMS is received within 5 minutes of the support response")
    public void theSMSIsReceivedWithin5MinutesOfTheSupportResponse() {
        verifySMSDeliveryTime();
    }

    @Then("only one SMS notification is received per support response")
    public void onlyOneSMSNotificationIsReceivedPerSupportResponse() {
        verifyNoDuplicateSMS();
    }

    @Then("the SMS includes a link that redirects to the support request in the portal")
    public void theSMSIncludesALinkThatRedirectsToTheSupportRequestInThePortal() {
        verifySMSLinkToSupportRequest();
    }

    @Then("the SMS is accessible and correctly displayed on various mobile networks")
    public void theSMSIsAccessibleAndCorrectlyDisplayedOnVariousMobileNetworks() {
        verifySMSOnDifferentNetworks();
    }

    @Then("the SMS contains only the necessary information about the support response")
    public void theSMSContainsOnlyTheNecessaryInformationAboutTheSupportResponse() {
        verifySMSContainsNecessaryInfo();
    }

    @Then("the user is not charged for receiving the SMS notification")
    public void theUserIsNotChargedForReceivingTheSMSNotification() {
        verifyNoChargesForSMS();
    }

    @When("the user replies to the SMS")
    public void theUserRepliesToTheSMS() {
        replyToSMS();
    }

    @Then("the reply is directed to the support team")
    public void theReplyIsDirectedToTheSupportTeam() {
        verifyReplyDirectedToSupportTeam();
    }

    @Then("the SMS is delivered to the inbox and not marked as spam")
    public void theSMSIsDeliveredToTheInboxAndNotMarkedAsSpam() {
        verifySMSNotMarkedAsSpam();
    }
}