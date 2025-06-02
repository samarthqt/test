package com.cucumber.steps;

import com.page_objects.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentOptionsSteps extends CheckoutPage {

    @Given("the user logs into the system with valid credentials")
    public void theUserLogsIntoTheSystemWithValidCredentials() {
        loginWithValidCredentials();
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        verifySuccessfulLogin();
    }

    @Given("Stripe and PayPal accounts are set up for testing")
    public void stripeAndPayPalAccountsAreSetUpForTesting() {
        setupStripeAndPayPalAccounts();
    }

    @Given("the user navigates to the checkout page")
    public void theUserNavigatesToTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @Then("the checkout page is displayed with payment options")
    public void theCheckoutPageIsDisplayedWithPaymentOptions() {
        verifyCheckoutPageDisplayed();
    }

    @Given("the user selects Stripe as the payment method")
    public void theUserSelectsStripeAsThePaymentMethod() {
        selectStripePaymentMethod();
    }

    @Then("Stripe payment option is selected successfully")
    public void stripePaymentOptionIsSelectedSuccessfully() {
        verifyStripePaymentMethodSelected();
    }

    @Given("the user enters payment details for Stripe")
    public void theUserEntersPaymentDetailsForStripe() {
        enterStripePaymentDetails();
    }

    @Then("payment details are entered correctly")
    public void paymentDetailsAreEnteredCorrectly() {
        verifyPaymentDetailsEnteredCorrectly();
    }

    @Given("the user confirms the payment using Stripe")
    public void theUserConfirmsThePaymentUsingStripe() {
        confirmStripePayment();
    }

    @Then("payment is processed successfully using Stripe")
    public void paymentIsProcessedSuccessfullyUsingStripe() {
        verifyStripePaymentProcessedSuccessfully();
    }

    @Given("the transaction confirmation for Stripe is verified")
    public void theTransactionConfirmationForStripeIsVerified() {
        verifyStripeTransactionConfirmation();
    }

    @Then("transaction confirmation is received for Stripe")
    public void transactionConfirmationIsReceivedForStripe() {
        verifyStripeTransactionConfirmationReceived();
    }

    @Given("the user selects PayPal as the payment method")
    public void theUserSelectsPayPalAsThePaymentMethod() {
        selectPayPalPaymentMethod();
    }

    @Then("PayPal payment option is selected successfully")
    public void payPalPaymentOptionIsSelectedSuccessfully() {
        verifyPayPalPaymentMethodSelected();
    }

    @When("the user enters payment details for PayPal")
    public void theUserEntersPaymentDetailsForPayPal() {
        enterPayPalPaymentDetails();
    }

    @Then("payment details are entered correctly")
    public void paymentDetailsAreEnteredCorrectlyForPayPal() {
        verifyPayPalPaymentDetailsEnteredCorrectly();
    }

    @Given("the user confirms the payment using PayPal")
    public void theUserConfirmsThePaymentUsingPayPal() {
        confirmPayPalPayment();
    }

    @Then("payment is processed successfully using PayPal")
    public void paymentIsProcessedSuccessfullyUsingPayPal() {
        verifyPayPalPaymentProcessedSuccessfully();
    }

    @Given("transaction confirmation for PayPal is verified")
    public void transactionConfirmationForPayPalIsVerified() {
        verifyPayPalTransactionConfirmation();
    }

    @Then("transaction confirmation is received for PayPal")
    public void transactionConfirmationIsReceivedForPayPal() {
        verifyPayPalTransactionConfirmationReceived();
    }

    @Given("the user checks for alternative payment methods availability")
    public void theUserChecksForAlternativePaymentMethodsAvailability() {
        checkAlternativePaymentMethodsAvailability();
    }

    @Then("alternative payment methods are available and selectable")
    public void alternativePaymentMethodsAreAvailableAndSelectable() {
        verifyAlternativePaymentMethodsAvailable();
    }

    @Given("security measures are ensured during payment processing")
    public void securityMeasuresAreEnsuredDuringPaymentProcessing() {
        ensureSecurityMeasuresDuringPaymentProcessing();
    }

    @Then("security measures like encryption are verified during payment")
    public void securityMeasuresLikeEncryptionAreVerifiedDuringPayment() {
        verifySecurityMeasuresDuringPayment();
    }

    @Given("system logs are monitored for payment-related errors")
    public void systemLogsAreMonitoredForPaymentRelatedErrors() {
        monitorSystemLogsForPaymentErrors();
    }

    @Then("no critical errors are logged during payment processing")
    public void noCriticalErrorsAreLoggedDuringPaymentProcessing() {
        verifyNoCriticalErrorsLogged();
    }

    @Given("user notifications for successful payment are verified")
    public void userNotificationsForSuccessfulPaymentAreVerified() {
        verifyUserNotificationsForSuccessfulPayment();
    }

    @Then("user is notified accurately upon successful payment")
    public void userIsNotifiedAccuratelyUponSuccessfulPayment() {
        verifyUserNotificationAccuracy();
    }

    @Given("the impact of payment failures on user experience is assessed")
    public void theImpactOfPaymentFailuresOnUserExperienceIsAssessed() {
        assessImpactOfPaymentFailuresOnUserExperience();
    }

    @Then("the system handles payment failures gracefully with user notifications")
    public void theSystemHandlesPaymentFailuresGracefullyWithUserNotifications() {
        verifySystemHandlesPaymentFailuresGracefully();
    }

    @Given("system recovery from payment interruptions is tested")
    public void systemRecoveryFromPaymentInterruptionsIsTested() {
        testSystemRecoveryFromPaymentInterruptions();
    }

    @Then("the system recovers and resumes payment processing without data loss")
    public void theSystemRecoversAndResumesPaymentProcessingWithoutDataLoss() {
        verifySystemRecoveryWithoutDataLoss();
    }

    @Given("system performance during peak payment times is evaluated")
    public void systemPerformanceDuringPeakPaymentTimesIsEvaluated() {
        evaluateSystemPerformanceDuringPeakTimes();
    }

    @Then("the system performs efficiently during peak payment times")
    public void theSystemPerformsEfficientlyDuringPeakPaymentTimes() {
        verifySystemPerformanceDuringPeakTimes();
    }
}