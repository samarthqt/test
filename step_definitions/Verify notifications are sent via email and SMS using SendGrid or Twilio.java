package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.NotificationPage;

public class NotificationSteps extends NotificationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("User {string} has a valid account with email {string} and phone number {string}")
    public void userHasValidAccount(String userName, String email, String phoneNumber) {
        verifyUserAccount(userName, email, phoneNumber);
    }

    @When("User logs into the application using valid credentials")
    public void userLogsIntoApplication() {
        loginToApplication();
    }

    @Then("User is successfully logged in and navigated to the homepage")
    public void userIsLoggedIn() {
        verifyHomePageNavigation();
    }

    @Given("User is on the homepage")
    public void userIsOnHomepage() {
        verifyUserOnHomepage();
    }

    @When("User navigates to notification settings")
    public void userNavigatesToNotificationSettings() {
        navigateToNotificationSettings();
    }

    @Then("Notification settings page is displayed with options for email and SMS notifications")
    public void notificationSettingsPageIsDisplayed() {
        verifyNotificationSettingsPage();
    }

    @Given("User is on the notification settings page")
    public void userIsOnNotificationSettingsPage() {
        verifyUserOnNotificationSettingsPage();
    }

    @When("User ensures email and phone number are correctly registered")
    public void userEnsuresEmailAndPhoneNumber() {
        verifyEmailAndPhoneNumberRegistration();
    }

    @Then("Email and phone number are verified and saved")
    public void emailAndPhoneNumberAreVerified() {
        verifyEmailAndPhoneNumberSaved();
    }

    @When("User places an order")
    public void userPlacesAnOrder() {
        placeOrder();
    }

    @Then("Order is successfully placed and notifications are triggered")
    public void orderIsPlacedAndNotificationsTriggered() {
        verifyOrderPlacementAndNotifications();
    }

    @Given("Notifications are triggered")
    public void notificationsAreTriggered() {
        verifyNotificationsTriggered();
    }

    @When("User checks for email notification")
    public void userChecksForEmailNotification() {
        checkEmailNotification();
    }

    @Then("Email notification is received with order details")
    public void emailNotificationIsReceived() {
        verifyEmailNotificationReceived();
    }

    @When("User checks for SMS notification")
    public void userChecksForSMSNotification() {
        checkSMSNotification();
    }

    @Then("SMS notification is received with order details")
    public void smsNotificationIsReceived() {
        verifySMSNotificationReceived();
    }

    @Given("Email notification is received")
    public void emailNotificationIsReceivedGiven() {
        verifyEmailNotificationReceived();
    }

    @When("User checks the format and content of the email notification")
    public void userChecksEmailNotificationFormat() {
        checkEmailNotificationFormat();
    }

    @Then("Email notification is correctly formatted and contains accurate order information")
    public void emailNotificationIsCorrectlyFormatted() {
        verifyEmailNotificationFormat();
    }

    @Given("SMS notification is received")
    public void smsNotificationIsReceivedGiven() {
        verifySMSNotificationReceived();
    }

    @When("User checks the format and content of the SMS notification")
    public void userChecksSMSNotificationFormat() {
        checkSMSNotificationFormat();
    }

    @Then("SMS notification is correctly formatted and contains accurate order information")
    public void smsNotificationIsCorrectlyFormatted() {
        verifySMSNotificationFormat();
    }

    @Given("Notifications are sent")
    public void notificationsAreSent() {
        verifyNotificationsSent();
    }

    @When("User verifies logging of notification delivery status")
    public void userVerifiesNotificationLogging() {
        verifyNotificationLogging();
    }

    @Then("Notification delivery status is logged for auditing purposes")
    public void notificationDeliveryStatusIsLogged() {
        verifyNotificationDeliveryLogging();
    }

    @When("User logs out from the application")
    public void userLogsOut() {
        logoutFromApplication();
    }

    @Then("User is successfully logged out")
    public void userIsLoggedOut() {
        verifyUserLoggedOut();
    }

    @Given("User is logged out")
    public void userIsLoggedOutGiven() {
        verifyUserLoggedOut();
    }

    @When("User re-logs into the application and navigates to notification history")
    public void userReLogsIntoApplication() {
        reLoginAndNavigateToNotificationHistory();
    }

    @Then("Notification history displays recent notifications with delivery status")
    public void notificationHistoryDisplays() {
        verifyNotificationHistory();
    }

    @Given("Notifications have a delivery status")
    public void notificationsHaveDeliveryStatus() {
        verifyNotificationsDeliveryStatus();
    }

    @When("User attempts to resend notifications if delivery fails")
    public void userAttemptsToResendNotifications() {
        attemptToResendNotifications();
    }

    @Then("System allows resending of notifications and logs the attempt")
    public void systemAllowsResendingNotifications() {
        verifyResendNotifications();
    }

    @When("User edits notification preferences to disable SMS")
    public void userEditsNotificationPreferences() {
        editNotificationPreferences();
    }

    @Then("SMS notifications are disabled and only email notifications are sent")
    public void smsNotificationsAreDisabled() {
        verifySMSNotificationsDisabled();
    }

    @Given("SMS notifications are disabled")
    public void smsNotificationsAreDisabledGiven() {
        verifySMSNotificationsDisabled();
    }

    @When("User places another order")
    public void userPlacesAnotherOrder() {
        placeAnotherOrder();
    }

    @Then("Only email notification is sent for the new order")
    public void onlyEmailNotificationIsSent() {
        verifyOnlyEmailNotificationSent();
    }

    @Given("Email notification is expected")
    public void emailNotificationIsExpected() {
        verifyEmailNotificationExpected();
    }

    @When("Email sending fails")
    public void emailSendingFails() {
        simulateEmailSendingFailure();
    }

    @Then("System logs the failure and provides options to retry or contact support")
    public void systemLogsFailure() {
        verifySystemLogsFailure();
    }
}