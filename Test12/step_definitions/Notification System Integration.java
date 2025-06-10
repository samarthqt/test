package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.NotificationPage;

public class NotificationSteps extends NotificationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("SendGrid and Twilio are integrated with the system")
    public void sendGridAndTwilioAreIntegratedWithTheSystem() {
        verifyIntegration();
    }

    @When("I configure the system to send notifications via SendGrid and Twilio")
    public void iConfigureTheSystemToSendNotificationsViaSendGridAndTwilio() {
        configureNotificationSystem();
    }

    @Then("the system should be able to send email and SMS notifications")
    public void theSystemShouldBeAbleToSendEmailAndSMSNotifications() {
        verifyNotificationCapability();
    }

    @Given("an order is confirmed or tracking updates are available")
    public void anOrderIsConfirmedOrTrackingUpdatesAreAvailable() {
        checkOrderOrTrackingStatus();
    }

    @When("the system sends notifications")
    public void theSystemSendsNotifications() {
        sendNotifications();
    }

    @Then("the user should receive an order confirmation or tracking update notification")
    public void theUserShouldReceiveAnOrderConfirmationOrTrackingUpdateNotification() {
        verifyUserReceivedNotification();
    }

    @Given("a notification is sent for order confirmation or tracking updates")
    public void aNotificationIsSentForOrderConfirmationOrTrackingUpdates() {
        sendNotificationForOrderOrTracking();
    }

    @When("I check the content of the notification")
    public void iCheckTheContentOfTheNotification() {
        checkNotificationContent();
    }

    @Then("the notification content should accurately reflect the order status or tracking information")
    public void theNotificationContentShouldAccuratelyReflectTheOrderStatusOrTrackingInformation() {
        verifyNotificationContentAccuracy();
    }

    @Given("a user with {string} preference")
    public void aUserWithPreference(String notificationType) {
        setUserNotificationPreference(notificationType);
    }

    @When("a notification is sent for order confirmation or tracking updates")
    public void aNotificationIsSentForOrderConfirmationOrTrackingUpdates() {
        sendNotificationForOrderOrTracking();
    }

    @Then("the user should receive the notification via {string}")
    public void theUserShouldReceiveTheNotificationVia(String notificationType) {
        verifyNotificationReceivedVia(notificationType);
    }

    @Given("a notification fails to be delivered")
    public void aNotificationFailsToBeDelivered() {
        simulateNotificationFailure();
    }

    @When("the system detects the failure")
    public void theSystemDetectsTheFailure() {
        detectNotificationFailure();
    }

    @Then("the system should implement error handling procedures")
    public void theSystemShouldImplementErrorHandlingProcedures() {
        implementErrorHandling();
    }

    @Given("a user has set preferences for notification types")
    public void aUserHasSetPreferencesForNotificationTypes() {
        setUserPreferences();
    }

    @When("notifications are sent")
    public void notificationsAreSent() {
        sendNotifications();
    }

    @Then("the notifications should be sent according to the user's preferences")
    public void theNotificationsShouldBeSentAccordingToTheUsersPreferences() {
        verifyNotificationsSentAccordingToPreferences();
    }

    @Given("notifications are sent to users")
    public void notificationsAreSentToUsers() {
        sendNotifications();
    }

    @When("I check the system logs")
    public void iCheckTheSystemLogs() {
        checkSystemLogs();
    }

    @Then("all notification activities should be logged for auditing purposes")
    public void allNotificationActivitiesShouldBeLoggedForAuditingPurposes() {
        verifyNotificationLogs();
    }

    @Given("the notification system is integrated with user account management")
    public void theNotificationSystemIsIntegratedWithUserAccountManagement() {
        verifyUserAccountIntegration();
    }

    @When("a notification is sent")
    public void aNotificationIsSent() {
        sendNotification();
    }

    @Then("it should validate the user's account status and preferences before sending")
    public void itShouldValidateTheUsersAccountStatusAndPreferencesBeforeSending() {
        validateUserAccountAndPreferences();
    }

    @Given("the notification system is operational")
    public void theNotificationSystemIsOperational() {
        verifySystemOperational();
    }

    @When("notifications are sent to users")
    public void notificationsAreSentToUsers() {
        sendNotifications();
    }

    @Then("the system should ensure compliance with communication regulations")
    public void theSystemShouldEnsureComplianceWithCommunicationRegulations() {
        ensureComplianceWithRegulations();
    }
}