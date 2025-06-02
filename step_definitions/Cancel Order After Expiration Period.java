package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderHistoryPage;
import com.page_objects.CustomerSupportPage;

public class CancelOrderSteps extends OrderHistoryPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user logs in to the account with User ID {int}")
    public void theUserLogsInToTheAccountWithUserID(int userID) {
        loginToAccount(userID);
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Then("the order history page is displayed with a list of past orders")
    public void theOrderHistoryPageIsDisplayedWithAListOfPastOrders() {
        verifyOrderHistoryDisplayed();
    }

    @When("the user selects the order with Order ID {int}")
    public void theUserSelectsTheOrderWithOrderID(int orderID) {
        selectOrder(String.valueOf(orderID));
    }

    @Then("the order details page is displayed for Order ID {int}")
    public void theOrderDetailsPageIsDisplayedForOrderID(int orderID) {
        verifyOrderDetailsDisplayed();
    }

    @Then("the cancellation period is {int} days")
    public void theCancellationPeriodIsDays(int days) {
        verifyCancellationPeriod(days);
    }

    @When("the user attempts to cancel the order")
    public void theUserAttemptsToCancelTheOrder() {
        attemptToCancelOrder();
    }

    @Then("the system displays a message indicating that the cancellation period has expired and the order cannot be canceled")
    public void theSystemDisplaysAMessageIndicatingThatTheCancellationPeriodHasExpiredAndTheOrderCannotBeCanceled() {
        verifyCancellationExpiredMessage();
    }

    @Then("the cancellation button is disabled and cannot be clicked")
    public void theCancellationButtonIsDisabledAndCannotBeClicked() {
        verifyCancellationButtonDisabled();
    }

    @When("the user checks for any alternative actions suggested by the system")
    public void theUserChecksForAnyAlternativeActionsSuggestedByTheSystem() {
        checkAlternativeActions();
    }

    @Then("the system suggests contacting customer support for further assistance")
    public void theSystemSuggestsContactingCustomerSupportForFurtherAssistance() {
        verifyCustomerSupportSuggestion();
    }

    @When("the user navigates to the customer support section")
    public void theUserNavigatesToTheCustomerSupportSection() {
        navigateToCustomerSupport();
    }

    @Then("customer support contact information is displayed")
    public void customerSupportContactInformationIsDisplayed() {
        verifyCustomerSupportInfoDisplayed();
    }

    @When("the user attempts to contact customer support via provided options")
    public void theUserAttemptsToContactCustomerSupportViaProvidedOptions() {
        contactCustomerSupport();
    }

    @Then("customer support is contacted successfully")
    public void customerSupportIsContactedSuccessfully() {
        verifyCustomerSupportContacted();
    }

    @When("the user verifies any email notification received regarding the cancellation attempt")
    public void theUserVerifiesAnyEmailNotificationReceivedRegardingTheCancellationAttempt() {
        verifyEmailNotification();
    }

    @Then("an email notification is received stating the cancellation attempt and its status")
    public void anEmailNotificationIsReceivedStatingTheCancellationAttemptAndItsStatus() {
        verifyEmailNotificationStatus();
    }

    @When("the user checks the order status after the cancellation attempt")
    public void theUserChecksTheOrderStatusAfterTheCancellationAttempt() {
        checkOrderStatus();
    }

    @Then("the order status remains unchanged as 'Processing' or 'Completed'")
    public void theOrderStatusRemainsUnchangedAsProcessingOrCompleted() {
        verifyOrderStatusUnchanged();
    }

    @When("the user reviews any system logs related to the cancellation attempt")
    public void theUserReviewsAnySystemLogsRelatedToTheCancellationAttempt() {
        reviewSystemLogs();
    }

    @Then("system logs indicate the cancellation attempt and its rejection due to expired period")
    public void systemLogsIndicateTheCancellationAttemptAndItsRejectionDueToExpiredPeriod() {
        verifySystemLogsForCancellation();
    }

    @When("the user verifies the account does not show any unauthorized changes")
    public void theUserVerifiesTheAccountDoesNotShowAnyUnauthorizedChanges() {
        verifyAccountSecurity();
    }

    @Then("user account details remain unchanged and secure")
    public void userAccountDetailsRemainUnchangedAndSecure() {
        verifyAccountDetailsUnchanged();
    }

    @When("the user checks if any refund process is initiated mistakenly")
    public void theUserChecksIfAnyRefundProcessIsInitiatedMistakenly() {
        checkRefundProcess();
    }

    @Then("no refund process is initiated as the cancellation was not successful")
    public void noRefundProcessIsInitiatedAsTheCancellationWasNotSuccessful() {
        verifyNoRefundInitiated();
    }

    @When("the user selects another order within the valid cancellation period")
    public void theUserSelectsAnotherOrderWithinTheValidCancellationPeriod() {
        selectOrderWithinValidPeriod();
    }

    @Then("the system allows cancellation and updates the order status accordingly")
    public void theSystemAllowsCancellationAndUpdatesTheOrderStatusAccordingly() {
        verifyOrderCancellationAndUpdate();
    }

    @When("the user attempts to cancel an order")
    public void theUserAttemptsToCancelAnOrder() {
        attemptToCancelOrder();
    }

    @Then("the system responds promptly to the cancellation attempt with appropriate feedback")
    public void theSystemRespondsPromptlyToTheCancellationAttemptWithAppropriateFeedback() {
        verifySystemResponseTime();
    }
}