package com.cucumber.steps;

import com.page_objects.SubscriptionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubscriptionSteps extends SubscriptionPage {

    @Given("the user is logged in with User ID {string}")
    public void theUserIsLoggedInWithUserID(String userId) {
        loginUser(userId);
    }

    @When("the user navigates to the product subscription page")
    public void theUserNavigatesToTheProductSubscriptionPage() {
        navigateToSubscriptionPage();
    }

    @Then("the user is directed to the subscription page displaying available products")
    public void theUserIsDirectedToTheSubscriptionPageDisplayingAvailableProducts() {
        verifySubscriptionPage();
    }

    @Given("the user is on the subscription page")
    public void theUserIsOnTheSubscriptionPage() {
        verifySubscriptionPage();
    }

    @When("the user selects a product with Product ID {string}")
    public void theUserSelectsAProductWithProductID(String productId) {
        selectProduct(productId);
    }

    @Then("product details are displayed including subscription options")
    public void productDetailsAreDisplayedIncludingSubscriptionOptions() {
        verifyProductDetails();
    }

    @Given("the user has selected a product for subscription")
    public void theUserHasSelectedAProductForSubscription() {
        verifyProductSelection();
    }

    @When("the user chooses the subscription frequency {string}")
    public void theUserChoosesTheSubscriptionFrequency(String frequency) {
        chooseSubscriptionFrequency(frequency);
    }

    @Then("the selected frequency is highlighted and ready for confirmation")
    public void theSelectedFrequencyIsHighlightedAndReadyForConfirmation() {
        verifyFrequencySelection();
    }

    @Given("the user has chosen the subscription frequency")
    public void theUserHasChosenTheSubscriptionFrequency() {
        verifyFrequencySelection();
    }

    @When("the user enters payment information using Credit Card")
    public void theUserEntersPaymentInformationUsingCreditCard() {
        enterPaymentInformation();
    }

    @Then("the payment information is verified and accepted")
    public void thePaymentInformationIsVerifiedAndAccepted() {
        verifyPaymentAcceptance();
    }

    @Given("the payment information is accepted")
    public void thePaymentInformationIsAccepted() {
        verifyPaymentAcceptance();
    }

    @When("the user confirms the subscription setup")
    public void theUserConfirmsTheSubscriptionSetup() {
        confirmSubscriptionSetup();
    }

    @Then("a confirmation message is displayed indicating successful subscription")
    public void aConfirmationMessageIsDisplayedIndicatingSuccessfulSubscription() {
        verifySubscriptionConfirmation();
    }

    @Given("the subscription setup is confirmed")
    public void theSubscriptionSetupIsConfirmed() {
        verifySubscriptionConfirmation();
    }

    @When("the user checks their email")
    public void theUserChecksTheirEmail() {
        checkEmailForConfirmation();
    }

    @Then("an email is received confirming subscription details")
    public void anEmailIsReceivedConfirmingSubscriptionDetails() {
        verifyEmailConfirmation();
    }

    @Given("the user has received email confirmation")
    public void theUserHasReceivedEmailConfirmation() {
        verifyEmailConfirmation();
    }

    @When("the user checks their account")
    public void theUserChecksTheirAccount() {
        checkAccountForSubscriptionDetails();
    }

    @Then("subscription details are correctly listed under the user account")
    public void subscriptionDetailsAreCorrectlyListedUnderTheUserAccount() {
        verifyAccountSubscriptionDetails();
    }

    @Given("the user has an active subscription")
    public void theUserHasAnActiveSubscription() {
        verifyActiveSubscription();
    }

    @When("the user attempts to change the subscription frequency")
    public void theUserAttemptsToChangeTheSubscriptionFrequency() {
        changeSubscriptionFrequency();
    }

    @Then("the user is able to change subscription frequency successfully")
    public void theUserIsAbleToChangeSubscriptionFrequencySuccessfully() {
        verifyFrequencyChangeSuccess();
    }

    @When("the user attempts to cancel the subscription")
    public void theUserAttemptsToCancelTheSubscription() {
        cancelSubscription();
    }

    @Then("the subscription is canceled and a confirmation message is displayed")
    public void theSubscriptionIsCanceledAndAConfirmationMessageIsDisplayed() {
        verifyCancellationConfirmation();
    }

    @Given("the subscription is canceled within the allowed period")
    public void theSubscriptionIsCanceledWithinTheAllowedPeriod() {
        verifyCancellationWithinAllowedPeriod();
    }

    @When("the user requests a refund")
    public void theUserRequestsARefund() {
        requestRefund();
    }

    @Then("the refund is processed as per policy")
    public void theRefundIsProcessedAsPerPolicy() {
        verifyRefundProcessing();
    }

    @When("the system checks the delivery schedule")
    public void theSystemChecksTheDeliverySchedule() {
        checkDeliverySchedule();
    }

    @Then("no conflicts are found; schedule is clear")
    public void noConflictsAreFoundScheduleIsClear() {
        verifyScheduleClear();
    }

    @When("the user attempts to enable/disable notifications")
    public void theUserAttemptsToEnableDisableNotifications() {
        changeNotificationSettings();
    }

    @Then("the user can enable/disable notifications successfully")
    public void theUserCanEnableDisableNotificationsSuccessfully() {
        verifyNotificationSettingsChange();
    }

    @Given("the user is on the subscription payment page")
    public void theUserIsOnTheSubscriptionPaymentPage() {
        navigateToPaymentPage();
    }

    @When("the user enters an invalid payment method")
    public void theUserEntersAnInvalidPaymentMethod() {
        enterInvalidPaymentMethod();
    }

    @Then("an error message is displayed indicating payment method issue")
    public void anErrorMessageIsDisplayedIndicatingPaymentMethodIssue() {
        verifyPaymentMethodError();
    }

    @Given("the user has changed the subscription frequency")
    public void theUserHasChangedTheSubscriptionFrequency() {
        verifyFrequencyChange();
    }

    @When("the system updates the frequency")
    public void theSystemUpdatesTheFrequency() {
        updateFrequencyInSystem();
    }

    @Then("the system updates frequency without errors")
    public void theSystemUpdatesFrequencyWithoutErrors() {
        verifySystemFrequencyUpdate();
    }

    @When("the subscription renewal period arrives")
    public void theSubscriptionRenewalPeriodArrives() {
        checkRenewalPeriod();
    }

    @Then("the subscription renews automatically as per schedule")
    public void theSubscriptionRenewsAutomaticallyAsPerSchedule() {
        verifyAutomaticRenewal();
    }
}