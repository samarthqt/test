package com.cucumber.steps;

import com.page_objects.PaymentFailurePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentFailureSteps extends PaymentFailurePage {

    @Given("User is logged into the system with valid credentials")
    public void userIsLoggedIntoTheSystemWithValidCredentials() {
        loginWithValidCredentials();
    }

    @When("User navigates to the checkout page")
    public void userNavigatesToTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @When("User selects a payment method and enters invalid credit card details")
    public void userSelectsAPaymentMethodAndEntersInvalidCreditCardDetails() {
        selectPaymentMethodAndEnterInvalidCreditCardDetails();
    }

    @Then("Payment fails due to invalid credit card details")
    public void paymentFailsDueToInvalidCreditCardDetails() {
        verifyPaymentFailureDueToInvalidCreditCard();
    }

    @Then("User receives notification about payment failure")
    public void userReceivesNotificationAboutPaymentFailure() {
        verifyPaymentFailureNotification();
    }

    @Then("Payment failure errors are logged correctly")
    public void paymentFailureErrorsAreLoggedCorrectly() {
        verifyPaymentFailureErrorsLogged();
    }

    @When("User selects a payment method and enters valid payment details")
    public void userSelectsAPaymentMethodAndEntersValidPaymentDetails() {
        selectPaymentMethodAndEnterValidPaymentDetails();
    }

    @When("Network failure occurs during payment processing")
    public void networkFailureOccursDuringPaymentProcessing() {
        simulateNetworkFailure();
    }

    @Then("Payment fails due to network issues")
    public void paymentFailsDueToNetworkIssues() {
        verifyPaymentFailureDueToNetworkIssues();
    }

    @When("User selects a payment method and enters expired PayPal account details")
    public void userSelectsAPaymentMethodAndEntersExpiredPayPalAccountDetails() {
        selectPaymentMethodAndEnterExpiredPayPalDetails();
    }

    @Then("Payment fails due to expired PayPal account")
    public void paymentFailsDueToExpiredPayPalAccount() {
        verifyPaymentFailureDueToExpiredPayPal();
    }

    @When("Payment fails due to any reason")
    public void paymentFailsDueToAnyReason() {
        simulatePaymentFailure();
    }

    @Then("System recovers and allows retry of payment without data loss")
    public void systemRecoversAndAllowsRetryOfPaymentWithoutDataLoss() {
        verifySystemRecoveryAndRetry();
    }

    @Then("User is able to update payment details and retry payment")
    public void userIsAbleToUpdatePaymentDetailsAndRetryPayment() {
        verifyUserCanUpdateAndRetryPayment();
    }

    @When("Payment failure occurs")
    public void paymentFailureOccurs() {
        simulatePaymentFailure();
    }

    @Then("System performs efficiently during payment failure handling")
    public void systemPerformsEfficientlyDuringPaymentFailureHandling() {
        verifySystemPerformanceDuringFailure();
    }

    @Then("System handles payment failures gracefully with user notifications")
    public void systemHandlesPaymentFailuresGracefullyWithUserNotifications() {
        verifyGracefulHandlingWithNotifications();
    }

    @Then("No critical errors are logged during payment failure handling")
    public void noCriticalErrorsAreLoggedDuringPaymentFailureHandling() {
        verifyNoCriticalErrorsLogged();
    }
}