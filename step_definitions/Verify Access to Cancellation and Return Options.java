package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderDetailsPage;

public class OrderDetailsSteps extends OrderDetailsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account with completed orders")
    public void aUserAccountWithCompletedOrders() {
        loginToAccount();
    }

    @When("the user logs into the account with the provided credentials")
    public void theUserLogsIntoTheAccountWithTheProvidedCredentials() {
        loginToAccount();
    }

    @Then("the user is successfully logged into the account")
    public void theUserIsSuccessfullyLoggedIntoTheAccount() {
        verifyLoginSuccess();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        verifyLoginSuccess();
    }

    @When("the user navigates to the order history section of the account")
    public void theUserNavigatesToTheOrderHistorySectionOfTheAccount() {
        navigateToOrderHistory();
    }

    @Then("the order history section is displayed with a list of orders")
    public void theOrderHistorySectionIsDisplayedWithAListOfOrders() {
        verifyOrderHistoryDisplayed();
    }

    @Given("the order history section is displayed")
    public void theOrderHistorySectionIsDisplayed() {
        verifyOrderHistoryDisplayed();
    }

    @When("the user selects the order with Order ID {string} from the list")
    public void theUserSelectsTheOrderWithOrderIDFromTheList(String orderID) {
        selectOrder(orderID);
    }

    @Then("the order details page for Order ID {string} is displayed")
    public void theOrderDetailsPageForOrderIDIsDisplayed(String orderID) {
        verifyOrderDetailsDisplayed(orderID);
    }

    @Given("the order details page for Order ID {string} is displayed")
    public void theOrderDetailsPageForOrderIDIsDisplayed(String orderID) {
        verifyOrderDetailsDisplayed(orderID);
    }

    @When("the user locates the cancellation and return options on the order details page")
    public void theUserLocatesTheCancellationAndReturnOptionsOnTheOrderDetailsPage() {
        locateCancellationAndReturnOptions();
    }

    @Then("the cancellation and return options are visible on the page")
    public void theCancellationAndReturnOptionsAreVisibleOnThePage() {
        verifyCancellationAndReturnOptionsVisible();
    }

    @Given("the cancellation option is visible")
    public void theCancellationOptionIsVisible() {
        verifyCancellationOptionVisible();
    }

    @When("the user clicks on the cancellation option to initiate the cancellation process")
    public void theUserClicksOnTheCancellationOptionToInitiateTheCancellationProcess() {
        initiateCancellationProcess();
    }

    @Then("the cancellation process is initiated successfully")
    public void theCancellationProcessIsInitiatedSuccessfully() {
        verifyCancellationProcessInitiated();
    }

    @Given("the cancellation process is initiated")
    public void theCancellationProcessIsInitiated() {
        verifyCancellationProcessInitiated();
    }

    @When("the system prompts for confirmation of the cancellation")
    public void theSystemPromptsForConfirmationOfTheCancellation() {
        verifyCancellationConfirmationPrompt();
    }

    @Then("the confirmation prompt is displayed for the cancellation")
    public void theConfirmationPromptIsDisplayedForTheCancellation() {
        verifyCancellationConfirmationPrompt();
    }

    @Given("the confirmation prompt is displayed")
    public void theConfirmationPromptIsDisplayed() {
        verifyCancellationConfirmationPrompt();
    }

    @When("the user confirms the cancellation")
    public void theUserConfirmsTheCancellation() {
        confirmCancellation();
    }

    @Then("the order status is updated to 'Cancelled'")
    public void theOrderStatusIsUpdatedToCancelled() {
        verifyOrderStatusUpdated("Cancelled");
    }

    @Given("the return option is visible")
    public void theReturnOptionIsVisible() {
        verifyReturnOptionVisible();
    }

    @When("the user accesses the return option and initiates the return process")
    public void theUserAccessesTheReturnOptionAndInitiatesTheReturnProcess() {
        initiateReturnProcess();
    }

    @Then("the return process is initiated successfully")
    public void theReturnProcessIsInitiatedSuccessfully() {
        verifyReturnProcessInitiated();
    }

    @Given("the return process is initiated")
    public void theReturnProcessIsInitiated() {
        verifyReturnProcessInitiated();
    }

    @When("the system prompts for confirmation of the return")
    public void theSystemPromptsForConfirmationOfTheReturn() {
        verifyReturnConfirmationPrompt();
    }

    @Then("the confirmation prompt is displayed for the return")
    public void theConfirmationPromptIsDisplayedForTheReturn() {
        verifyReturnConfirmationPrompt();
    }

    @Given("the confirmation prompt is displayed")
    public void theConfirmationPromptIsDisplayed() {
        verifyReturnConfirmationPrompt();
    }

    @When("the user confirms the return")
    public void theUserConfirmsTheReturn() {
        confirmReturn();
    }

    @Then("the order status is updated to 'Return Initiated'")
    public void theOrderStatusIsUpdatedToReturnInitiated() {
        verifyOrderStatusUpdated("Return Initiated");
    }

    @Given("the order details page is displayed")
    public void theOrderDetailsPageIsDisplayed() {
        verifyOrderDetailsDisplayed();
    }

    @When("the order is not eligible for cancellation or return")
    public void theOrderIsNotEligibleForCancellationOrReturn() {
        verifyOrderEligibility();
    }

    @Then("the cancellation and return options are disabled")
    public void theCancellationAndReturnOptionsAreDisabled() {
        verifyOptionsDisabled();
    }

    @Given("the user initiates cancellation or return")
    public void theUserInitiatesCancellationOrReturn() {
        initiateCancellationOrReturn();
    }

    @When("the actions are completed")
    public void theActionsAreCompleted() {
        verifyActionsCompleted();
    }

    @Then("email notifications are sent for both cancellation and return actions")
    public void emailNotificationsAreSentForBothCancellationAndReturnActions() {
        verifyEmailNotificationsSent();
    }

    @Given("the user has completed cancellation or return actions")
    public void theUserHasCompletedCancellationOrReturnActions() {
        verifyActionsCompleted();
    }

    @When("the user checks their account")
    public void theUserChecksTheirAccount() {
        checkAccount();
    }

    @Then("the cancellation and return history is accessible in the account")
    public void theCancellationAndReturnHistoryIsAccessibleInTheAccount() {
        verifyHistoryAccessible();
    }

    @Given("the user has completed cancellation or return actions")
    public void theUserHasCompletedCancellationOrReturnActions() {
        verifyActionsCompleted();
    }

    @When("the user accesses the account")
    public void theUserAccessesTheAccount() {
        accessAccount();
    }

    @Then("the user can download the cancellation and return receipts")
    public void theUserCanDownloadTheCancellationAndReturnReceipts() {
        downloadReceipts();
    }

    @Given("the user has completed orders")
    public void theUserHasCompletedOrders() {
        verifyCompletedOrders();
    }

    @When("the user accesses the order details page on different devices")
    public void theUserAccessesTheOrderDetailsPageOnDifferentDevices() {
        accessOrderDetailsOnDevices();
    }

    @Then("the cancellation and return options are accessible on all supported devices")
    public void theCancellationAndReturnOptionsAreAccessibleOnAllSupportedDevices() {
        verifyOptionsAccessibleOnDevices();
    }
}