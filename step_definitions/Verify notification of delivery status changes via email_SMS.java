package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.NotificationPage;

public class NotificationSteps extends NotificationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has an active account with email {string} and phone number {string}")
    public void theUserHasAnActiveAccountWithEmailAndPhoneNumber(String email, String phoneNumber) {
        verifyUserAccount(email, phoneNumber);
    }

    @Given("the user has logged in with valid credentials")
    public void theUserHasLoggedInWithValidCredentials() {
        loginUser();
    }

    @Given("the user has placed an order with ID {int}")
    public void theUserHasPlacedAnOrderWithID(int orderId) {
        placeOrder(orderId);
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @When("selects the order with ID {int} to view its details")
    public void selectsTheOrderWithIDToViewItsDetails(int orderId) {
        selectOrder(orderId);
    }

    @When("simulates a change in the delivery status to {string}")
    public void simulatesAChangeInTheDeliveryStatusTo(String status) {
        simulateStatusChange(status);
    }

    @Then("the system updates the delivery status to {string}")
    public void theSystemUpdatesTheDeliveryStatusTo(String status) {
        verifyStatusUpdate(status);
    }

    @Then("an email notification is received indicating the status change to {string}")
    public void anEmailNotificationIsReceivedIndicatingTheStatusChangeTo(String status) {
        verifyEmailNotification(status);
    }

    @Then("an SMS notification is received indicating the status change to {string}")
    public void anSMSNotificationIsReceivedIndicatingTheStatusChangeTo(String status) {
        verifySMSNotification(status);
    }

    @Given("the delivery status of order ID {int} is {string}")
    public void theDeliveryStatusOfOrderIDIs(int orderId, String status) {
        verifyOrderStatus(orderId, status);
    }

    @When("the delivery status is changed to {string}")
    public void theDeliveryStatusIsChangedTo(String status) {
        changeDeliveryStatus(status);
    }

    @Given("the notifications for order ID {int} have been sent")
    public void theNotificationsForOrderIDHaveBeenSent(int orderId) {
        verifyNotificationsSent(orderId);
    }

    @When("the user checks the notification logs in the system")
    public void theUserChecksTheNotificationLogsInTheSystem() {
        checkNotificationLogs();
    }

    @Then("log entries confirm the delivery of email and SMS notifications for each status change")
    public void logEntriesConfirmTheDeliveryOfEmailAndSMSNotificationsForEachStatusChange() {
        confirmLogEntries();
    }

    @Then("notifications include order ID, new status, and timestamp of the update")
    public void notificationsIncludeOrderIDNewStatusAndTimestampOfTheUpdate() {
        verifyNotificationContent();
    }

    @Given("the system is simulating a failed delivery status update")
    public void theSystemIsSimulatingAFailedDeliveryStatusUpdate() {
        simulateFailedStatusUpdate();
    }

    @When("the failure occurs")
    public void theFailureOccurs() {
        triggerFailure();
    }

    @Then("the system handles the failure gracefully and retries sending the notification")
    public void theSystemHandlesTheFailureGracefullyAndRetriesSendingTheNotification() {
        handleFailureGracefully();
    }

    @Given("multiple status changes have occurred for order ID {int}")
    public void multipleStatusChangesHaveOccurredForOrderID(int orderId) {
        simulateMultipleStatusChanges(orderId);
    }

    @When("checking the notifications sent")
    public void checkingTheNotificationsSent() {
        checkSentNotifications();
    }

    @Then("each status change results in a single email and SMS notification")
    public void eachStatusChangeResultsInASingleEmailAndSMSNotification() {
        verifySingleNotificationPerChange();
    }

    @Given("the user updates their email to {string} and phone number to {string}")
    public void theUserUpdatesTheirEmailToAndPhoneNumberTo(String newEmail, String newPhoneNumber) {
        updateUserContactInfo(newEmail, newPhoneNumber);
    }

    @When("the notification process is repeated")
    public void theNotificationProcessIsRepeated() {
        repeatNotificationProcess();
    }

    @Then("notifications are sent to the updated email and phone number")
    public void notificationsAreSentToTheUpdatedEmailAndPhoneNumber() {
        verifyUpdatedContactNotifications();
    }

    @Given("the user's account is deactivated")
    public void theUserSAccountIsDeactivated() {
        deactivateUserAccount();
    }

    @When("a delivery status change occurs")
    public void aDeliveryStatusChangeOccurs() {
        triggerStatusChange();
    }

    @Then("no notifications are sent to the deactivated account")
    public void noNotificationsAreSentToTheDeactivatedAccount() {
        verifyNoNotificationsForDeactivatedAccount();
    }
}