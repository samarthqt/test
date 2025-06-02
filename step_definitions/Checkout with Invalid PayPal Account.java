package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        loginUser();
    }

    @When("the user navigates to the cart page")
    public void theUserNavigatesToTheCartPage() {
        navigateToCartPage();
    }

    @Then("the cart page is displayed with selected products")
    public void theCartPageIsDisplayedWithSelectedProducts() {
        verifyCartPageDisplayed();
    }

    @Then("products are available in the cart")
    public void productsAreAvailableInTheCart() {
        verifyProductsInCart();
    }

    @Given("the user is on the cart page")
    public void theUserIsOnTheCartPage() {
        verifyCartPageDisplayed();
    }

    @Then("products in the cart match the selected items")
    public void productsInTheCartMatchTheSelectedItems() {
        verifySelectedItemsInCart();
    }

    @When("the user clicks on 'Proceed to Checkout' button")
    public void theUserClicksOnProceedToCheckoutButton() {
        clickProceedToCheckout();
    }

    @Then("the checkout page is displayed")
    public void theCheckoutPageIsDisplayed() {
        verifyCheckoutPageDisplayed();
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        verifyCheckoutPageDisplayed();
    }

    @When("the user selects 'PayPal' as the payment method")
    public void theUserSelectsPayPalAsThePaymentMethod() {
        selectPayPalPaymentMethod();
    }

    @Then("the PayPal payment section is displayed")
    public void thePayPalPaymentSectionIsDisplayed() {
        verifyPayPalSectionDisplayed();
    }

    @Given("the PayPal payment section is displayed")
    public void thePayPalPaymentSectionIsDisplayedAgain() {
        verifyPayPalSectionDisplayed();
    }

    @When("the user enters an invalid PayPal email")
    public void theUserEntersAnInvalidPayPalEmail() {
        enterInvalidPayPalEmail();
    }

    @Then("the system displays an error message for invalid PayPal email")
    public void theSystemDisplaysAnErrorMessageForInvalidPayPalEmail() {
        verifyInvalidEmailErrorMessage();
    }

    @Given("the user has entered an invalid PayPal email")
    public void theUserHasEnteredAnInvalidPayPalEmail() {
        enterInvalidPayPalEmail();
    }

    @When("the user attempts to log in to PayPal")
    public void theUserAttemptsToLogInToPayPal() {
        attemptPayPalLogin();
    }

    @Then("PayPal login fails with an error message")
    public void payPalLoginFailsWithAnErrorMessage() {
        verifyPayPalLoginErrorMessage();
    }

    @When("the user enters a PayPal account with insufficient funds")
    public void theUserEntersAPayPalAccountWithInsufficientFunds() {
        enterPayPalAccountWithInsufficientFunds();
    }

    @Then("the system displays an error message for insufficient funds")
    public void theSystemDisplaysAnErrorMessageForInsufficientFunds() {
        verifyInsufficientFundsErrorMessage();
    }

    @Given("the user has entered a PayPal account with insufficient funds")
    public void theUserHasEnteredAPayPalAccountWithInsufficientFunds() {
        enterPayPalAccountWithInsufficientFunds();
    }

    @When("the user attempts to proceed with payment")
    public void theUserAttemptsToProceedWithPayment() {
        attemptPayment();
    }

    @Then("payment is not processed, and an error message is displayed")
    public void paymentIsNotProcessedAndAnErrorMessageIsDisplayed() {
        verifyPaymentNotProcessedErrorMessage();
    }

    @Given("the payment was not processed")
    public void thePaymentWasNotProcessed() {
        verifyPaymentNotProcessed();
    }

    @Then("no order is created in the system")
    public void noOrderIsCreatedInTheSystem() {
        verifyNoOrderCreated();
    }

    @Then("no order confirmation email is received")
    public void noOrderConfirmationEmailIsReceived() {
        verifyNoOrderConfirmationEmail();
    }

    @Then("products remain in the cart for future checkout attempts")
    public void productsRemainInTheCartForFutureCheckoutAttempts() {
        verifyProductsRemainInCart();
    }

    @Given("the user logs out")
    public void theUserLogsOut() {
        logoutUser();
    }

    @When("the user logs back in")
    public void theUserLogsBackIn() {
        loginUser();
    }

    @Then("cart contents persist after logging back in")
    public void cartContentsPersistAfterLoggingBackIn() {
        verifyCartContentsPersist();
    }

    @When("the user retries checkout with a different payment method")
    public void theUserRetriesCheckoutWithADifferentPaymentMethod() {
        retryCheckoutWithDifferentPaymentMethod();
    }

    @Then("the user is able to retry checkout successfully")
    public void theUserIsAbleToRetryCheckoutSuccessfully() {
        verifySuccessfulCheckoutRetry();
    }

    @Then("no transaction is recorded in the PayPal account")
    public void noTransactionIsRecordedInThePayPalAccount() {
        verifyNoTransactionInPayPal();
    }

    @Then("the error is logged in the system for auditing")
    public void theErrorIsLoggedInTheSystemForAuditing() {
        verifyErrorLoggedForAudit();
    }
}