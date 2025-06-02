package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import com.page_objects.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        loginUser();
    }

    @Given("navigates to the cart page")
    public void navigatesToTheCartPage() {
        navigateToCartPage();
    }

    @Then("the cart page is displayed with selected products")
    public void theCartPageIsDisplayedWithSelectedProducts() {
        verifyCartPageDisplayed();
    }

    @When("the user verifies the products listed in the cart")
    public void theUserVerifiesTheProductsListedInTheCart() {
        verifyProductsInCart();
    }

    @Then("products in the cart match the selected items")
    public void productsInTheCartMatchTheSelectedItems() {
        assertProductsMatch();
    }

    @When("the user clicks on 'Proceed to Checkout' button")
    public void theUserClicksOnProceedToCheckoutButton() {
        proceedToCheckout();
    }

    @Then("the checkout page is displayed")
    public void theCheckoutPageIsDisplayed() {
        verifyCheckoutPageDisplayed();
    }

    @When("the user selects 'Credit Card' as the payment method")
    public void theUserSelectsCreditCardAsThePaymentMethod() {
        selectPaymentMethod("Credit Card");
    }

    @Then("the Credit Card payment section is displayed")
    public void theCreditCardPaymentSectionIsDisplayed() {
        verifyCreditCardSectionDisplayed();
    }

    @When("the user enters an invalid credit card number")
    public void theUserEntersAnInvalidCreditCardNumber() {
        enterInvalidCreditCardDetails();
    }

    @Then("the system displays an error message for invalid card number")
    public void theSystemDisplaysAnErrorMessageForInvalidCardNumber() {
        verifyInvalidCardNumberError();
    }

    @When("the user attempts to proceed with payment")
    public void theUserAttemptsToProceedWithPayment() {
        attemptPayment();
    }

    @Then("payment is not processed, and error message is displayed")
    public void paymentIsNotProcessedAndErrorMessageIsDisplayed() {
        verifyPaymentNotProcessed();
    }

    @Then("no order is created in the system")
    public void noOrderIsCreatedInTheSystem() {
        verifyNoOrderCreated();
    }

    @Then("no order confirmation email is received")
    public void noOrderConfirmationEmailIsReceived() {
        verifyNoConfirmationEmail();
    }

    @Then("the cart retains the products for future checkout attempts")
    public void theCartRetainsTheProductsForFutureCheckoutAttempts() {
        verifyCartRetention();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @Then("cart contents persist after logging back in")
    public void cartContentsPersistAfterLoggingBackIn() {
        verifyCartPersistence();
    }

    @When("the user retries with a different payment method")
    public void theUserRetriesWithADifferentPaymentMethod() {
        retryWithDifferentPaymentMethod();
    }

    @Then("the user is able to retry checkout with a different payment method")
    public void theUserIsAbleToRetryCheckoutWithADifferentPaymentMethod() {
        verifyRetrySuccess();
    }

    @Then("no transaction is recorded in the payment gateway")
    public void noTransactionIsRecordedInThePaymentGateway() {
        verifyNoTransactionRecorded();
    }

    @Then("the system logs the error for audit purposes")
    public void theSystemLogsTheErrorForAuditPurposes() {
        verifyErrorLogged();
    }

    @When("the user enters expired credit card details")
    public void theUserEntersExpiredCreditCardDetails() {
        enterExpiredCreditCardDetails();
    }

    @Then("the system displays an error message for expired card")
    public void theSystemDisplaysAnErrorMessageForExpiredCard() {
        verifyExpiredCardError();
    }

    @When("the user enters incorrect CVV number")
    public void theUserEntersIncorrectCVVNumber() {
        enterIncorrectCVV();
    }

    @Then("the system displays an error message for incorrect CVV")
    public void theSystemDisplaysAnErrorMessageForIncorrectCVV() {
        verifyIncorrectCVVError();
    }
}