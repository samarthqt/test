package com.cucumber.steps;

import com.page_objects.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps extends CheckoutPage {

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the shopping cart")
    public void theUserNavigatesToTheShoppingCart() {
        navigateToShoppingCart();
    }

    @Then("the shopping cart is displayed with all added items")
    public void theShoppingCartIsDisplayedWithAllAddedItems() {
        verifyShoppingCartItems();
    }

    @Given("the user has items in the shopping cart")
    public void theUserHasItemsInTheShoppingCart() {
        verifyItemsInCart();
    }

    @When("the user proceeds to the checkout page")
    public void theUserProceedsToTheCheckoutPage() {
        proceedToCheckoutPage();
    }

    @Then("the checkout page is displayed with the order summary")
    public void theCheckoutPageIsDisplayedWithTheOrderSummary() {
        verifyOrderSummary();
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        verifyCheckoutPage();
    }

    @When("the user views the list of available payment options")
    public void theUserViewsTheListOfAvailablePaymentOptions() {
        viewPaymentOptions();
    }

    @Then("the list includes Credit Card, PayPal, and Gift Card")
    public void theListIncludesCreditCardPayPalAndGiftCard() {
        verifyPaymentOptionsList();
    }

    @When("the user selects 'Credit Card' as the payment option and enters valid card details")
    public void theUserSelectsCreditCardAsThePaymentOptionAndEntersValidCardDetails() {
        selectCreditCardAndEnterDetails();
    }

    @Then("the system accepts the card details and proceeds to the next step")
    public void theSystemAcceptsTheCardDetailsAndProceedsToTheNextStep() {
        verifyCardDetailsAccepted();
    }

    @When("the user goes back to the payment options and selects 'PayPal'")
    public void theUserGoesBackToThePaymentOptionsAndSelectsPayPal() {
        selectPayPalOption();
    }

    @Then("the system redirects to the PayPal login page")
    public void theSystemRedirectsToThePayPalLoginPage() {
        verifyPayPalLoginPage();
    }

    @Given("the user is on the PayPal login page")
    public void theUserIsOnThePayPalLoginPage() {
        verifyPayPalLoginPage();
    }

    @When("the user logs in to PayPal and confirms the payment")
    public void theUserLogsInToPayPalAndConfirmsThePayment() {
        loginAndConfirmPayPalPayment();
    }

    @Then("the payment is confirmed and the order is processed")
    public void thePaymentIsConfirmedAndTheOrderIsProcessed() {
        verifyPaymentConfirmationAndOrderProcessing();
    }

    @When("the user returns to the payment options and selects 'Gift Card'")
    public void theUserReturnsToThePaymentOptionsAndSelectsGiftCard() {
        selectGiftCardOption();
    }

    @Then("the system prompts for the gift card code")
    public void theSystemPromptsForTheGiftCardCode() {
        verifyGiftCardCodePrompt();
    }

    @Given("the user is prompted for the gift card code")
    public void theUserIsPromptedForTheGiftCardCode() {
        verifyGiftCardCodePrompt();
    }

    @When("the user enters a valid gift card code and applies it")
    public void theUserEntersAValidGiftCardCodeAndAppliesIt() {
        enterAndApplyGiftCardCode();
    }

    @Then("the gift card code is accepted and the order total is updated")
    public void theGiftCardCodeIsAcceptedAndTheOrderTotalIsUpdated() {
        verifyGiftCardCodeAcceptanceAndTotalUpdate();
    }

    @Given("the user has selected a payment option")
    public void theUserHasSelectedAPaymentOption() {
        verifyPaymentOptionSelected();
    }

    @When("the user attempts to place the order")
    public void theUserAttemptsToPlaceTheOrder() {
        attemptToPlaceOrder();
    }

    @Then("the order is successfully placed with the selected payment option")
    public void theOrderIsSuccessfullyPlacedWithTheSelectedPaymentOption() {
        verifyOrderPlacementWithSelectedOption();
    }

    @Given("the order is successfully placed")
    public void theOrderIsSuccessfullyPlaced() {
        verifyOrderPlacement();
    }

    @When("the user views the order confirmation page")
    public void theUserViewsTheOrderConfirmationPage() {
        viewOrderConfirmationPage();
    }

    @Then("the page displays the correct payment option used")
    public void thePageDisplaysTheCorrectPaymentOptionUsed() {
        verifyCorrectPaymentOptionDisplayed();
    }

    @When("the user checks the email confirmation for the order")
    public void theUserChecksTheEmailConfirmationForTheOrder() {
        checkEmailConfirmation();
    }

    @Then("the email confirmation includes accurate payment details")
    public void theEmailConfirmationIncludesAccuratePaymentDetails() {
        verifyEmailPaymentDetails();
    }

    @When("the user selects an invalid payment option")
    public void theUserSelectsAnInvalidPaymentOption() {
        selectInvalidPaymentOption();
    }

    @Then("the system displays an appropriate error message")
    public void theSystemDisplaysAnAppropriateErrorMessage() {
        verifyErrorMessageForInvalidOption();
    }

    @When("the user tests the responsiveness of the payment options section on different devices")
    public void theUserTestsTheResponsivenessOfThePaymentOptionsSectionOnDifferentDevices() {
        testPaymentOptionsResponsiveness();
    }

    @Then("the payment options section is responsive and user-friendly on all devices")
    public void thePaymentOptionsSectionIsResponsiveAndUserFriendlyOnAllDevices() {
        verifyResponsivenessOnAllDevices();
    }

    @When("the user enters payment information during checkout")
    public void theUserEntersPaymentInformationDuringCheckout() {
        enterPaymentInformation();
    }

    @Then("the payment information is securely transmitted and stored")
    public void thePaymentInformationIsSecurelyTransmittedAndStored() {
        verifySecureTransmissionAndStorage();
    }

    @When("the user proceeds through the checkout process with multiple payment options")
    public void theUserProceedsThroughTheCheckoutProcessWithMultiplePaymentOptions() {
        proceedThroughCheckoutWithMultipleOptions();
    }

    @Then("the checkout process is smooth and efficient")
    public void theCheckoutProcessIsSmoothAndEfficient() {
        verifySmoothAndEfficientCheckout();
    }
}