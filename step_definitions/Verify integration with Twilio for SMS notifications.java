package com.cucumber.steps;

import com.page_objects.TwilioIntegrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TwilioIntegrationSteps extends TwilioIntegrationPage {

    @Given("the user has a Twilio account configured")
    public void theUserHasATwilioAccountConfigured() {
        verifyTwilioAccountConfigured();
    }

    @When("the user logs into the application")
    public void theUserLogsIntoTheApplication() {
        loginToApplication();
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyUserLoggedIn();
    }

    @Given("the Twilio API key is set up in the application")
    public void theTwilioAPIKeyIsSetUpInTheApplication() {
        verifyTwilioAPIKeySetup();
    }

    @When("the user checks the application settings")
    public void theUserChecksTheApplicationSettings() {
        checkApplicationSettings();
    }

    @Then("the Twilio API key is correctly configured")
    public void theTwilioAPIKeyIsCorrectlyConfigured() {
        verifyAPIKeyConfiguration();
    }

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        verifyUserLoggedIn();
    }

    @When("the user submits a support request")
    public void theUserSubmitsASupportRequest() {
        submitSupportRequest();
    }

    @Then("the support request is successfully submitted and a ticket ID is generated")
    public void theSupportRequestIsSuccessfullySubmittedAndATicketIDIsGenerated() {
        verifySupportRequestSubmission();
    }

    @Given("the support request is submitted")
    public void theSupportRequestIsSubmitted() {
        verifySupportRequestSubmission();
    }

    @When("the support team responds to the request")
    public void theSupportTeamRespondsToTheRequest() {
        respondToSupportRequest();
    }

    @Then("the support team can successfully respond to the support request")
    public void theSupportTeamCanSuccessfullyRespondToTheSupportRequest() {
        verifySupportTeamResponse();
    }

    @Given("the support response is sent")
    public void theSupportResponseIsSent() {
        verifySupportResponseSent();
    }

    @When("the user checks the Twilio dashboard")
    public void theUserChecksTheTwilioDashboard() {
        checkTwilioDashboard();
    }

    @Then("the SMS delivery status is marked as successful")
    public void theSMSDeliveryStatusIsMarkedAsSuccessful() {
        verifySMSDeliveryStatus();
    }

    @Given("the SMS delivery status is successful")
    public void theSMSDeliveryStatusIsSuccessful() {
        verifySMSDeliveryStatus();
    }

    @When("the user checks their phone")
    public void theUserChecksTheirPhone() {
        checkUserPhone();
    }

    @Then("the user receives an SMS notification about the support response")
    public void theUserReceivesAnSMSNotificationAboutTheSupportResponse() {
        verifySMSNotificationReceived();
    }

    @Given("the user receives an SMS notification")
    public void theUserReceivesAnSMSNotification() {
        verifySMSNotificationReceived();
    }

    @When("the user reviews the SMS content")
    public void theUserReviewsTheSMSContent() {
        reviewSMSContent();
    }

    @Then("the SMS contains the correct details of the support response")
    public void theSMSContainsTheCorrectDetailsOfTheSupportResponse() {
        verifySMSContentDetails();
    }

    @When("the user checks the sender number")
    public void theUserChecksTheSenderNumber() {
        checkSenderNumber();
    }

    @Then("the SMS is sent from the designated support number")
    public void theSMSSentFromTheDesignatedSupportNumber() {
        verifySenderNumber();
    }

    @When("the user reviews the SMS format")
    public void theUserReviewsTheSMSFormat() {
        reviewSMSFormat();
    }

    @Then("the SMS is well-formatted and readable")
    public void theSMSIsWellFormattedAndReadable() {
        verifySMSFormat();
    }

    @When("the user checks the SMS delivery time")
    public void theUserChecksTheSMSDeliveryTime() {
        checkSMSDeliveryTime();
    }

    @Then("the SMS is received within 5 minutes of the support response")
    public void theSMSIsReceivedWithin5MinutesOfTheSupportResponse() {
        verifySMSDeliveryTime();
    }

    @When("the user checks the SMS notifications")
    public void theUserChecksTheSMSNotifications() {
        checkSMSNotifications();
    }

    @Then("only one SMS notification is received per support response")
    public void onlyOneSMSNotificationIsReceivedPerSupportResponse() {
        verifySingleSMSNotification();
    }

    @When("the user checks the SMS content")
    public void theUserChecksTheSMSContent() {
        checkSMSContent();
    }

    @Then("the SMS includes a link that redirects to the support request in the portal")
    public void theSMSIncludesALinkThatRedirectsToTheSupportRequestInThePortal() {
        verifySMSLink();
    }

    @When("the user checks the SMS on various mobile networks")
    public void theUserChecksTheSMSOnVariousMobileNetworks() {
        checkSMSOnNetworks();
    }

    @Then("the SMS is accessible and correctly displayed on various mobile networks")
    public void theSMSIsAccessibleAndCorrectlyDisplayedOnVariousMobileNetworks() {
        verifySMSOnNetworks();
    }

    @When("the user reviews the SMS content")
    public void theUserReviewsTheSMSContentAgain() {
        reviewSMSContentAgain();
    }

    @Then("the SMS contains only the necessary information about the support response")
    public void theSMSContainsOnlyTheNecessaryInformationAboutTheSupportResponse() {
        verifySMSNecessaryInformation();
    }

    @When("the user checks for any charges")
    public void theUserChecksForAnyCharges() {
        checkSMSCharges();
    }

    @Then("the user is not charged for receiving the SMS notification")
    public void theUserIsNotChargedForReceivingTheSMSNotification() {
        verifyNoSMSCharges();
    }
}