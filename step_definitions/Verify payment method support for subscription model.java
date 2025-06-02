package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.PaymentMethodUpdatePage;

public class PaymentMethodUpdateSteps extends PaymentMethodUpdatePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a registered account")
    public void theUserHasARegisteredAccount() {
        verifyUserAccountExists();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the payment method update page")
    public void theUserNavigatesToThePaymentMethodUpdatePage() {
        navigateToPaymentMethodUpdatePage();
    }

    @Then("the user is directed to the payment method update page displaying current payment options")
    public void theUserIsDirectedToThePaymentMethodUpdatePageDisplayingCurrentPaymentOptions() {
        verifyPaymentMethodUpdatePageDisplayed();
    }

    @Given("the user is on the payment method update page")
    public void theUserIsOnThePaymentMethodUpdatePage() {
        verifyOnPaymentMethodUpdatePage();
    }

    @When("the user selects a payment method to update")
    public void theUserSelectsAPaymentMethodToUpdate() {
        selectPaymentMethodToUpdate();
    }

    @Then("current payment details are displayed for editing")
    public void currentPaymentDetailsAreDisplayedForEditing() {
        verifyPaymentDetailsDisplayedForEditing();
    }

    @Given("the user has selected a payment method to update")
    public void theUserHasSelectedAPaymentMethodToUpdate() {
        verifyPaymentMethodSelectedForUpdate();
    }

    @When("the user enters new payment information")
    public void theUserEntersNewPaymentInformation() {
        enterNewPaymentInformation();
    }

    @Then("new payment information is verified and accepted")
    public void newPaymentInformationIsVerifiedAndAccepted() {
        verifyNewPaymentInformationAccepted();
    }

    @Given("the user has entered new payment information")
    public void theUserHasEnteredNewPaymentInformation() {
        verifyNewPaymentInformationEntered();
    }

    @When("the user confirms the payment method update")
    public void theUserConfirmsThePaymentMethodUpdate() {
        confirmPaymentMethodUpdate();
    }

    @Then("a confirmation message is displayed indicating successful update")
    public void aConfirmationMessageIsDisplayedIndicatingSuccessfulUpdate() {
        verifyConfirmationMessageDisplayed();
    }

    @Given("the payment method update is successful")
    public void thePaymentMethodUpdateIsSuccessful() {
        verifyPaymentMethodUpdateSuccessful();
    }

    @When("the user checks their email")
    public void theUserChecksTheirEmail() {
        checkEmailForConfirmation();
    }

    @Then("an email is received confirming payment method update")
    public void anEmailIsReceivedConfirmingPaymentMethodUpdate() {
        verifyEmailConfirmationReceived();
    }

    @Given("the payment method update is confirmed")
    public void thePaymentMethodUpdateIsConfirmed() {
        verifyPaymentMethodUpdateConfirmed();
    }

    @When("the user checks their account")
    public void theUserChecksTheirAccount() {
        checkUserAccountForUpdatedMethod();
    }

    @Then("the updated payment method is correctly listed under user account")
    public void theUpdatedPaymentMethodIsCorrectlyListedUnderUserAccount() {
        verifyUpdatedPaymentMethodListed();
    }

    @Given("the payment method is updated")
    public void thePaymentMethodIsUpdated() {
        verifyPaymentMethodUpdated();
    }

    @When("the user attempts to use the updated payment method for subscription")
    public void theUserAttemptsToUseTheUpdatedPaymentMethodForSubscription() {
        attemptSubscriptionWithUpdatedMethod();
    }

    @Then("subscription payment is processed successfully using the updated method")
    public void subscriptionPaymentIsProcessedSuccessfullyUsingTheUpdatedMethod() {
        verifySubscriptionPaymentProcessed();
    }

    @When("the user attempts to revert the payment method update")
    public void theUserAttemptsToRevertThePaymentMethodUpdate() {
        attemptToRevertPaymentMethodUpdate();
    }

    @Then("the user is able to revert payment method successfully")
    public void theUserIsAbleToRevertPaymentMethodSuccessfully() {
        verifyPaymentMethodReverted();
    }

    @Given("the payment method update is reverted within the allowed period")
    public void thePaymentMethodUpdateIsRevertedWithinTheAllowedPeriod() {
        verifyPaymentMethodRevertedWithinAllowedPeriod();
    }

    @When("the refund process is initiated")
    public void theRefundProcessIsInitiated() {
        initiateRefundProcess();
    }

    @Then("refund is processed as per policy")
    public void refundIsProcessedAsPerPolicy() {
        verifyRefundProcessedAsPerPolicy();
    }

    @When("the user checks for subscription payment conflicts")
    public void theUserChecksForSubscriptionPaymentConflicts() {
        checkForSubscriptionPaymentConflicts();
    }

    @Then("no conflicts are found; payment schedule is clear")
    public void noConflictsAreFoundPaymentScheduleIsClear() {
        verifyNoPaymentConflicts();
    }

    @Given("the user wants to manage notifications for payment updates")
    public void theUserWantsToManageNotificationsForPaymentUpdates() {
        navigateToNotificationSettings();
    }

    @When("the user enables or disables notifications")
    public void theUserEnablesOrDisablesNotifications() {
        manageNotificationSettings();
    }

    @Then("user can enable/disable notifications successfully")
    public void userCanEnableDisableNotificationsSuccessfully() {
        verifyNotificationSettingsUpdated();
    }

    @Given("the user attempts to update payment method")
    public void theUserAttemptsToUpdatePaymentMethod() {
        attemptPaymentMethodUpdate();
    }

    @When("the user enters invalid payment method information")
    public void theUserEntersInvalidPaymentMethodInformation() {
        enterInvalidPaymentInformation();
    }

    @Then("an error message is displayed indicating payment method issue")
    public void anErrorMessageIsDisplayedIndicatingPaymentMethodIssue() {
        verifyErrorMessageDisplayed();
    }

    @Given("the user updates the payment method")
    public void theUserUpdatesThePaymentMethod() {
        updatePaymentMethod();
    }

    @When("the system processes the payment method change")
    public void theSystemProcessesThePaymentMethodChange() {
        processPaymentMethodChange();
    }

    @Then("system updates payment method without errors")
    public void systemUpdatesPaymentMethodWithoutErrors() {
        verifySystemUpdateWithoutErrors();
    }

    @When("the payment renewal process occurs")
    public void thePaymentRenewalProcessOccurs() {
        initiatePaymentRenewalProcess();
    }

    @Then("payment renews automatically as per schedule using updated method")
    public void paymentRenewsAutomaticallyAsPerScheduleUsingUpdatedMethod() {
        verifyAutomaticPaymentRenewal();
    }

    @Given("the subscription renewal is due")
    public void theSubscriptionRenewalIsDue() {
        verifySubscriptionRenewalDue();
    }

    @When("the user updates the payment method during subscription renewal")
    public void theUserUpdatesThePaymentMethodDuringSubscriptionRenewal() {
        updatePaymentMethodDuringRenewal();
    }

    @Then("payment method update is processed without affecting renewal")
    public void paymentMethodUpdateIsProcessedWithoutAffectingRenewal() {
        verifyUpdateWithoutAffectingRenewal();
    }
}