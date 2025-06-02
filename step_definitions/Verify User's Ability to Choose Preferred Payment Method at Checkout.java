package com.cucumber.steps;

import com.page_objects.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps extends CheckoutPage {

    @Given("user is logged in and on the checkout page")
    public void userIsLoggedInAndOnTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @Given("user is logged in and on the checkout page on a mobile device")
    public void userIsLoggedInAndOnTheCheckoutPageOnAMobileDevice() {
        navigateToCheckoutPageOnMobile();
    }

    @Given("user is logged in and on the checkout page in a browser")
    public void userIsLoggedInAndOnTheCheckoutPageInABrowser() {
        navigateToCheckoutPageInBrowser();
    }

    @Given("user is logged in and on the checkout page with a slow internet connection")
    public void userIsLoggedInAndOnTheCheckoutPageWithASlowInternetConnection() {
        simulateSlowInternetConnection();
    }

    @Given("user is logged in and on the checkout page with multiple items in the cart")
    public void userIsLoggedInAndOnTheCheckoutPageWithMultipleItemsInTheCart() {
        navigateToCheckoutPageWithMultipleItems();
    }

    @When("user selects Credit Card as the payment method")
    public void userSelectsCreditCardAsThePaymentMethod() {
        selectPaymentMethod("Credit Card");
    }

    @When("user selects PayPal as the payment method")
    public void userSelectsPayPalAsThePaymentMethod() {
        selectPaymentMethod("PayPal");
    }

    @When("user selects a payment method")
    public void userSelectsAPaymentMethod() {
        selectPaymentMethod("Default");
    }

    @When("user decides to change payment method")
    public void userDecidesToChangePaymentMethod() {
        changePaymentMethod();
    }

    @When("user attempts to select an unsupported payment method")
    public void userAttemptsToSelectAnUnsupportedPaymentMethod() {
        attemptUnsupportedPaymentMethod();
    }

    @When("user enters valid Credit Card details")
    public void userEntersValidCreditCardDetails() {
        enterCreditCardDetails("4111111111111111", "12/23", "123");
    }

    @When("user enters valid PayPal account details")
    public void userEntersValidPayPalAccountDetails() {
        enterPayPalDetails("user@example.com", "password123");
    }

    @When("user enters maximum transaction amount")
    public void userEntersMaximumTransactionAmount() {
        enterTransactionAmount("10000");
    }

    @When("user completes a transaction with a selected payment method")
    public void userCompletesATransactionWithASelectedPaymentMethod() {
        completeTransaction();
    }

    @When("user selects a payment method and attempts a transaction")
    public void userSelectsAPaymentMethodAndAttemptsATransaction() {
        attemptTransactionWithSelectedMethod();
    }

    @Then("Credit Card details are accepted and validated")
    public void creditCardDetailsAreAcceptedAndValidated() {
        validateCreditCardDetails();
    }

    @Then("PayPal account details are accepted and validated")
    public void payPalAccountDetailsAreAcceptedAndValidated() {
        validatePayPalDetails();
    }

    @Then("transaction is processed successfully with confirmation message")
    public void transactionIsProcessedSuccessfullyWithConfirmationMessage() {
        verifyTransactionConfirmation();
    }

    @Then("user can change payment method before completing transaction")
    public void userCanChangePaymentMethodBeforeCompletingTransaction() {
        verifyPaymentMethodChange();
    }

    @Then("payment method selection is accessible and functional on mobile")
    public void paymentMethodSelectionIsAccessibleAndFunctionalOnMobile() {
        verifyMobilePaymentMethodSelection();
    }

    @Then("unsupported payment method is not selectable")
    public void unsupportedPaymentMethodIsNotSelectable() {
        verifyUnsupportedPaymentMethod();
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        verifyErrorMessage();
    }

    @Then("payment method selection is consistent across browsers")
    public void paymentMethodSelectionIsConsistentAcrossBrowsers() {
        verifyBrowserConsistency();
    }

    @Then("payment method selection remains functional under slow connection")
    public void paymentMethodSelectionRemainsFunctionalUnderSlowConnection() {
        verifySlowConnectionFunctionality();
    }

    @Then("UI remains responsive during payment method selection")
    public void uiRemainsResponsiveDuringPaymentMethodSelection() {
        verifyUIResponsiveness();
    }

    @Then("payment method selection is functional with multiple items")
    public void paymentMethodSelectionIsFunctionalWithMultipleItems() {
        verifyMultipleItemsFunctionality();
    }

    @Then("payment method selection accommodates maximum transaction amount")
    public void paymentMethodSelectionAccommodatesMaximumTransactionAmount() {
        verifyMaximumTransactionAmount();
    }

    @Then("transaction confirmation reflects selected payment method")
    public void transactionConfirmationReflectsSelectedPaymentMethod() {
        verifyTransactionConfirmationWithSelectedMethod();
    }

    @Then("error message is displayed for declined payment method")
    public void errorMessageIsDisplayedForDeclinedPaymentMethod() {
        verifyDeclinedPaymentMethodError();
    }
}