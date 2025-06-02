package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.SubscriptionCustomizationPage;

public class SubscriptionCustomizationSteps extends SubscriptionCustomizationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged in with User ID: {string}")
    public void theUserIsLoggedInWithUserID(String userId) {
        loginUser(userId);
    }

    @When("the user navigates to the subscription customization page")
    public void theUserNavigatesToTheSubscriptionCustomizationPage() {
        navigateToCustomizationPage();
    }

    @Then("the user should be directed to the customization page displaying available options")
    public void theUserShouldBeDirectedToTheCustomizationPageDisplayingAvailableOptions() {
        verifyCustomizationPageDisplayed();
    }

    @Given("the user is on the subscription customization page")
    public void theUserIsOnTheSubscriptionCustomizationPage() {
        verifyCustomizationPageDisplayed();
    }

    @When("the user selects a product with Product ID: {string} for customization")
    public void theUserSelectsAProductWithProductIDForCustomization(String productId) {
        selectProductForCustomization(productId);
    }

    @Then("the product details should be displayed including customization options")
    public void theProductDetailsShouldBeDisplayedIncludingCustomizationOptions() {
        verifyProductDetailsDisplayed();
    }

    @Given("the user is customizing a product")
    public void theUserIsCustomizingAProduct() {
        verifyProductDetailsDisplayed();
    }

    @When("the user chooses a delivery frequency of {string}")
    public void theUserChoosesADeliveryFrequencyOf(String frequency) {
        chooseDeliveryFrequency(frequency);
    }

    @Then("the selected frequency should be highlighted and ready for confirmation")
    public void theSelectedFrequencyShouldBeHighlightedAndReadyForConfirmation() {
        verifyFrequencyHighlighted();
    }

    @Given("the user has chosen a delivery frequency")
    public void theUserHasChosenADeliveryFrequency() {
        verifyFrequencyHighlighted();
    }

    @When("the user enters payment information using {string}")
    public void theUserEntersPaymentInformationUsing(String paymentMethod) {
        enterPaymentInformation(paymentMethod);
    }

    @Then("the payment information should be verified and accepted")
    public void thePaymentInformationShouldBeVerifiedAndAccepted() {
        verifyPaymentAccepted();
    }

    @Given("the payment information is accepted")
    public void thePaymentInformationIsAccepted() {
        verifyPaymentAccepted();
    }

    @When("the user confirms the customization setup")
    public void theUserConfirmsTheCustomizationSetup() {
        confirmCustomizationSetup();
    }

    @Then("a confirmation message should be displayed indicating successful customization")
    public void aConfirmationMessageShouldBeDisplayedIndicatingSuccessfulCustomization() {
        verifyConfirmationMessageDisplayed();
    }

    @Given("the customization setup is confirmed")
    public void theCustomizationSetupIsConfirmed() {
        verifyConfirmationMessageDisplayed();
    }

    @When("the user checks their email")
    public void theUserChecksTheirEmail() {
        checkEmailForConfirmation();
    }

    @Then("an email confirming customization details should be received")
    public void anEmailConfirmingCustomizationDetailsShouldBeReceived() {
        verifyEmailConfirmationReceived();
    }

    @Given("the user has received email confirmation")
    public void theUserHasReceivedEmailConfirmation() {
        verifyEmailConfirmationReceived();
    }

    @When("the user checks their account")
    public void theUserChecksTheirAccount() {
        checkAccountForCustomizationDetails();
    }

    @Then("customization details should be correctly listed under the user account")
    public void customizationDetailsShouldBeCorrectlyListedUnderTheUserAccount() {
        verifyCustomizationDetailsInAccount();
    }

    @Given("the user has an active customization")
    public void theUserHasAnActiveCustomization() {
        verifyActiveCustomization();
    }

    @When("the user attempts to modify the delivery frequency")
    public void theUserAttemptsToModifyTheDeliveryFrequency() {
        modifyDeliveryFrequency();
    }

    @Then("the user should be able to change delivery frequency successfully")
    public void theUserShouldBeAbleToChangeDeliveryFrequencySuccessfully() {
        verifyFrequencyModificationSuccess();
    }

    @When("the user attempts to cancel the customization")
    public void theUserAttemptsToCancelTheCustomization() {
        cancelCustomization();
    }

    @Then("the customization should be canceled and a confirmation message displayed")
    public void theCustomizationShouldBeCanceledAndAConfirmationMessageDisplayed() {
        verifyCancellationConfirmationMessage();
    }

    @Given("the customization is canceled within the allowed period")
    public void theCustomizationIsCanceledWithinTheAllowedPeriod() {
        verifyCancellationWithinAllowedPeriod();
    }

    @When("the user checks the refund process")
    public void theUserChecksTheRefundProcess() {
        checkRefundProcess();
    }

    @Then("the refund should be processed as per policy")
    public void theRefundShouldBeProcessedAsPerPolicy() {
        verifyRefundProcessed();
    }

    @When("the user checks the delivery schedule")
    public void theUserChecksTheDeliverySchedule() {
        checkDeliverySchedule();
    }

    @Then("no conflicts should be found; schedule is clear")
    public void noConflictsShouldBeFoundScheduleIsClear() {
        verifyNoScheduleConflicts();
    }

    @When("the user attempts to enable\/disable notifications")
    public void theUserAttemptsToEnableDisableNotifications() {
        changeNotificationSettings();
    }

    @Then("the user should be able to successfully change notification settings")
    public void theUserShouldBeAbleToSuccessfullyChangeNotificationSettings() {
        verifyNotificationSettingsChanged();
    }

    @When("the user enters invalid payment information")
    public void theUserEntersInvalidPaymentInformation() {
        enterInvalidPaymentInformation();
    }

    @Then("an error message should be displayed indicating payment method issue")
    public void anErrorMessageShouldBeDisplayedIndicatingPaymentMethodIssue() {
        verifyPaymentMethodErrorMessage();
    }

    @When("the user changes the customization frequency")
    public void theUserChangesTheCustomizationFrequency() {
        changeCustomizationFrequency();
    }

    @Then("the system should update frequency without errors")
    public void theSystemShouldUpdateFrequencyWithoutErrors() {
        verifyFrequencyUpdateSuccess();
    }

    @Given("the renewal period is reached")
    public void theRenewalPeriodIsReached() {
        verifyRenewalPeriodReached();
    }

    @Then("the customization should renew automatically as per schedule")
    public void theCustomizationShouldRenewAutomaticallyAsPerSchedule() {
        verifyAutomaticRenewal();
    }
}