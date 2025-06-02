package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.SubscriptionSetupPage;

public class SubscriptionSetupSteps extends SubscriptionSetupPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged in with User ID: {int}")
    public void theUserIsLoggedInWithUserID(int userId) {
        loginUser(userId);
    }

    @When("the user navigates to the subscription setup page")
    public void theUserNavigatesToTheSubscriptionSetupPage() {
        navigateToSubscriptionSetupPage();
    }

    @Then("the user is directed to the subscription setup page displaying available options")
    public void theUserIsDirectedToTheSubscriptionSetupPageDisplayingAvailableOptions() {
        verifySubscriptionSetupPage();
    }

    @Given("the user is on the subscription setup page")
    public void theUserIsOnTheSubscriptionSetupPage() {
        verifySubscriptionSetupPage();
    }

    @When("the user selects a product for subscription setup")
    public void theUserSelectsAProductForSubscriptionSetup() {
        selectProductForSubscription();
    }

    @Then("product details are displayed including subscription options")
    public void productDetailsAreDisplayedIncludingSubscriptionOptions() {
        verifyProductDetails();
    }

    @Given("the user has selected a product for subscription setup")
    public void theUserHasSelectedAProductForSubscriptionSetup() {
        selectProductForSubscription();
    }

    @When("the user chooses a delivery frequency of weekly")
    public void theUserChoosesADeliveryFrequencyOfWeekly() {
        chooseDeliveryFrequency("weekly");
    }

    @Then("the selected frequency is highlighted and ready for confirmation")
    public void theSelectedFrequencyIsHighlightedAndReadyForConfirmation() {
        verifySelectedFrequency();
    }

    @When("the user enters invalid payment information such as expired Credit Card details")
    public void theUserEntersInvalidPaymentInformation() {
        enterInvalidPaymentInformation();
    }

    @Then("the system detects invalid payment information and displays an error message")
    public void theSystemDetectsInvalidPaymentInformationAndDisplaysAnErrorMessage() {
        verifyInvalidPaymentErrorMessage();
    }

    @When("the user attempts to confirm the subscription setup")
    public void theUserAttemptsToConfirmTheSubscriptionSetup() {
        attemptToConfirmSubscriptionSetup();
    }

    @Then("the subscription setup fails and an error message is displayed indicating payment issue")
    public void theSubscriptionSetupFailsAndAnErrorMessageIsDisplayedIndicatingPaymentIssue() {
        verifySubscriptionSetupFailure();
    }

    @Given("the subscription setup has failed due to payment issue")
    public void theSubscriptionSetupHasFailedDueToPaymentIssue() {
        verifySubscriptionSetupFailure();
    }

    @When("the user checks their email")
    public void theUserChecksTheirEmail() {
        checkEmailForFailureNotification();
    }

    @Then("an email is received indicating subscription setup failure due to payment issue")
    public void anEmailIsReceivedIndicatingSubscriptionSetupFailureDueToPaymentIssue() {
        verifyEmailNotification();
    }

    @When("the user checks error message details in their account")
    public void theUserChecksErrorMessageDetailsInTheirAccount() {
        checkErrorMessageDetailsInAccount();
    }

    @Then("error message details are correctly listed under user account")
    public void errorMessageDetailsAreCorrectlyListedUnderUserAccount() {
        verifyErrorMessageDetailsInAccount();
    }

    @Given("the user has invalid payment information")
    public void theUserHasInvalidPaymentInformation() {
        verifyInvalidPaymentInformation();
    }

    @When("the user attempts to update payment information")
    public void theUserAttemptsToUpdatePaymentInformation() {
        updatePaymentInformation();
    }

    @Then("the user is able to update payment information successfully")
    public void theUserIsAbleToUpdatePaymentInformationSuccessfully() {
        verifyPaymentInformationUpdate();
    }

    @Given("the user has rectified payment information")
    public void theUserHasRectifiedPaymentInformation() {
        verifyPaymentInformationUpdate();
    }

    @When("the user attempts the subscription setup again")
    public void theUserAttemptsTheSubscriptionSetupAgain() {
        attemptSubscriptionSetupAgain();
    }

    @Then("the subscription setup is processed successfully with updated payment information")
    public void theSubscriptionSetupIsProcessedSuccessfullyWithUpdatedPaymentInformation() {
        verifySuccessfulSubscriptionSetup();
    }

    @When("the user checks for any subscription setup conflicts")
    public void theUserChecksForAnySubscriptionSetupConflicts() {
        checkForSubscriptionSetupConflicts();
    }

    @Then("no conflicts are found; setup is clear")
    public void noConflictsAreFoundSetupIsClear() {
        verifyNoSubscriptionSetupConflicts();
    }

    @Given("the user wants to manage notifications for subscription setup issues")
    public void theUserWantsToManageNotificationsForSubscriptionSetupIssues() {
        navigateToNotificationSettings();
    }

    @When("the user attempts to enable or disable notifications")
    public void theUserAttemptsToEnableOrDisableNotifications() {
        manageNotificationSettings();
    }

    @Then("the user can enable/disable notifications successfully")
    public void theUserCanEnableDisableNotificationsSuccessfully() {
        verifyNotificationSettings();
    }

    @When("the user attempts subscription setup with another invalid payment method")
    public void theUserAttemptsSubscriptionSetupWithAnotherInvalidPaymentMethod() {
        attemptSubscriptionSetupWithInvalidPayment();
    }

    @Then("an error message is displayed indicating payment method issue")
    public void anErrorMessageIsDisplayedIndicatingPaymentMethodIssue() {
        verifyPaymentMethodErrorMessage();
    }

    @Given("the user has attempted subscription setup multiple times with invalid payment methods")
    public void theUserHasAttemptedSubscriptionSetupMultipleTimesWithInvalidPaymentMethods() {
        verifyMultipleInvalidPaymentAttempts();
    }

    @When("the user checks system response")
    public void theUserChecksSystemResponse() {
        checkSystemResponseToInvalidPayments();
    }

    @Then("the system continues to display error messages without processing setup")
    public void theSystemContinuesToDisplayErrorMessagesWithoutProcessingSetup() {
        verifySystemResponseToInvalidPayments();
    }

    @When("the subscription renewal process is initiated")
    public void theSubscriptionRenewalProcessIsInitiated() {
        initiateSubscriptionRenewal();
    }

    @Then("the subscription renews automatically as per schedule with updated payment")
    public void theSubscriptionRenewsAutomaticallyAsPerScheduleWithUpdatedPayment() {
        verifySubscriptionRenewal();
    }

    @Given("the subscription is due for renewal")
    public void theSubscriptionIsDueForRenewal() {
        verifySubscriptionDueForRenewal();
    }

    @When("the user attempts to setup subscription with invalid payment during renewal")
    public void theUserAttemptsToSetupSubscriptionWithInvalidPaymentDuringRenewal() {
        attemptSubscriptionSetupDuringRenewal();
    }

    @Then("the subscription setup fails and an error message is displayed indicating payment issue")
    public void theSubscriptionSetupFailsAndAnErrorMessageIsDisplayedIndicatingPaymentIssue() {
        verifySubscriptionSetupFailureDuringRenewal();
    }
}