package com.cucumber.steps;

import com.page_objects.NotificationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NotificationSteps extends NotificationPage {

    @Given("the user has a valid order ID {string}")
    public void theUserHasAValidOrderID(String orderID) {
        verifyOrderID(orderID);
    }

    @When("the user logs into the account")
    public void theUserLogsIntoTheAccount() {
        loginToAccount();
    }

    @Then("the user should be successfully logged in")
    public void theUserShouldBeSuccessfullyLoggedIn() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Then("the order history page should display all past and current orders")
    public void theOrderHistoryPageShouldDisplayAllPastAndCurrentOrders() {
        verifyOrderHistoryDisplayed();
    }

    @Given("the tracking number is {string}")
    public void theTrackingNumberIs(String trackingNumber) {
        verifyTrackingNumber(trackingNumber);
    }

    @When("the user selects the order with tracking number XYZ789")
    public void theUserSelectsTheOrderWithTrackingNumberXYZ789() {
        selectOrderWithTrackingNumber("XYZ789");
    }

    @Then("the order details should be displayed, including tracking information")
    public void theOrderDetailsShouldBeDisplayedIncludingTrackingInformation() {
        verifyOrderDetailsDisplayed();
    }

    @Given("the notification email is {string}")
    public void theNotificationEmailIs(String email) {
        verifyNotificationEmail(email);
    }

    @Given("the notification phone is {string}")
    public void theNotificationPhoneIs(String phone) {
        verifyNotificationPhone(phone);
    }

    @When("the user checks notification settings for the order")
    public void theUserChecksNotificationSettingsForTheOrder() {
        checkNotificationSettings();
    }

    @Then("notification settings should be enabled")
    public void notificationSettingsShouldBeEnabled() {
        verifyNotificationSettingsEnabled();
    }

    @When("a change in package status is simulated to 'Out for Delivery'")
    public void aChangeInPackageStatusIsSimulatedToOutForDelivery() {
        simulateStatusChange("Out for Delivery");
    }

    @Then("a notification should be sent to the user regarding the status change")
    public void aNotificationShouldBeSentToTheUserRegardingTheStatusChange() {
        verifyNotificationSent();
    }

    @When("the user checks the email notifications")
    public void theUserChecksTheEmailNotifications() {
        checkEmailNotifications();
    }

    @Then("an email notification should be received with the updated status")
    public void anEmailNotificationShouldBeReceivedWithTheUpdatedStatus() {
        verifyEmailNotificationReceived();
    }

    @When("the user checks the SMS notifications")
    public void theUserChecksTheSMSNotifications() {
        checkSMSNotifications();
    }

    @Then("an SMS notification should be received with the updated status")
    public void anSMSNotificationShouldBeReceivedWithTheUpdatedStatus() {
        verifySMSNotificationReceived();
    }

    @When("delivery completion is simulated")
    public void deliveryCompletionIsSimulated() {
        simulateDeliveryCompletion();
    }

    @Then("a notification should be sent to the user regarding delivery completion")
    public void aNotificationShouldBeSentToTheUserRegardingDeliveryCompletion() {
        verifyDeliveryCompletionNotificationSent();
    }

    @Then("an email notification should be received confirming delivery")
    public void anEmailNotificationShouldBeReceivedConfirmingDelivery() {
        verifyEmailDeliveryConfirmation();
    }

    @Then("an SMS notification should be received confirming delivery")
    public void anSMSNotificationShouldBeReceivedConfirmingDelivery() {
        verifySMSDeliveryConfirmation();
    }

    @When("the user logs out of the account")
    public void theUserLogsOutOfTheAccount() {
        logoutOfAccount();
    }

    @Then("the user should be successfully logged out")
    public void theUserShouldBeSuccessfullyLoggedOut() {
        verifyLogoutSuccess();
    }

    @When("the user logs back into the account")
    public void theUserLogsBackIntoTheAccount() {
        loginToAccount();
    }

    @Then("the user should be successfully logged in again")
    public void theUserShouldBeSuccessfullyLoggedInAgain() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the 'Order History' section again")
    public void theUserNavigatesToTheOrderHistorySectionAgain() {
        navigateToOrderHistory();
    }

    @Then("the order history page should display all past and current orders")
    public void theOrderHistoryPageShouldDisplayAllPastAndCurrentOrdersAgain() {
        verifyOrderHistoryDisplayed();
    }

    @When("the user selects the order with tracking number XYZ789 again")
    public void theUserSelectsTheOrderWithTrackingNumberXYZ789Again() {
        selectOrderWithTrackingNumber("XYZ789");
    }

    @Then("the order details should be displayed, including updated tracking information")
    public void theOrderDetailsShouldBeDisplayedIncludingUpdatedTrackingInformation() {
        verifyOrderDetailsDisplayed();
    }

    @When("the user checks the notification history")
    public void theUserChecksTheNotificationHistory() {
        checkNotificationHistory();
    }

    @Then("the notification history should display all sent notifications for the order")
    public void theNotificationHistoryShouldDisplayAllSentNotificationsForTheOrder() {
        verifyNotificationHistoryDisplayed();
    }
}