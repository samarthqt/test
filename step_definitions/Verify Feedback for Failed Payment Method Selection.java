package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("User is logged into the application")
    public void userIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @Given("User navigates to the shopping cart page")
    public void userNavigatesToTheShoppingCartPage() {
        navigateToShoppingCart();
    }

    @When("User clicks on the 'Proceed to Checkout' button")
    public void userClicksOnTheProceedToCheckoutButton() {
        proceedToCheckout();
    }

    @When("User selects 'Credit Card' as the payment method")
    public void userSelectsCreditCardAsThePaymentMethod() {
        selectPaymentMethod("Credit Card");
    }

    @When("User enters invalid credit card details")
    public void userEntersInvalidCreditCardDetails() {
        enterCreditCardDetails("1234567890123456", "12/20", "123");
    }

    @Then("System displays an error message indicating invalid credit card details")
    public void systemDisplaysAnErrorMessageIndicatingInvalidCreditCardDetails() {
        verifyErrorMessage("Invalid credit card details.");
    }

    @When("User selects 'PayPal' as the payment method")
    public void userSelectsPayPalAsThePaymentMethod() {
        selectPaymentMethod("PayPal");
    }

    @When("User attempts to use an expired PayPal account")
    public void userAttemptsToUseAnExpiredPayPalAccount() {
        attemptExpiredPayPalAccount();
    }

    @Then("System displays an error message indicating account expiration")
    public void systemDisplaysAnErrorMessageIndicatingAccountExpiration() {
        verifyErrorMessage("PayPal account expired.");
    }

    @When("User selects 'Gift Card' as the payment method")
    public void userSelectsGiftCardAsThePaymentMethod() {
        selectPaymentMethod("Gift Card");
    }

    @When("User attempts to use a Gift Card with depleted balance")
    public void userAttemptsToUseAGiftCardWithDepletedBalance() {
        attemptDepletedGiftCard();
    }

    @Then("System displays an error message indicating insufficient balance")
    public void systemDisplaysAnErrorMessageIndicatingInsufficientBalance() {
        verifyErrorMessage("Insufficient gift card balance.");
    }

    @Then("System provides options to retry or select a different payment method")
    public void systemProvidesOptionsToRetryOrSelectADifferentPaymentMethod() {
        verifyRetryOptions();
    }

    @When("User logs out from the user account")
    public void userLogsOutFromTheUserAccount() {
        logoutFromApplication();
    }

    @Then("User is logged out successfully")
    public void userIsLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }
}