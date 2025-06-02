package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("User is logged in")
    public void userIsLoggedIn() {
        loginUser();
    }

    @Given("User has items in the cart")
    public void userHasItemsInTheCart() {
        addItemsToCart();
    }

    @When("User navigates to the checkout page")
    public void userNavigatesToTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @Then("User is directed to the checkout page")
    public void userIsDirectedToTheCheckoutPage() {
        verifyCheckoutPage();
    }

    @When("User selects 'Credit Card' as the payment method")
    public void userSelectsCreditCardAsThePaymentMethod() {
        selectPaymentMethod("Credit Card");
    }

    @Then("Credit Card option is selected")
    public void creditCardOptionIsSelected() {
        verifyPaymentMethodSelected("Credit Card");
    }

    @When("User enters credit card details")
    public void userEntersCreditCardDetails() {
        enterCreditCardDetails("4111111111111111", "12/23", "123");
    }

    @Then("Credit card details are entered successfully")
    public void creditCardDetailsAreEnteredSuccessfully() {
        verifyCreditCardDetailsEntered();
    }

    @When("User proceeds to payment")
    public void userProceedsToPayment() {
        proceedToPayment();
    }

    @Then("Payment process initiates with credit card")
    public void paymentProcessInitiatesWithCreditCard() {
        verifyPaymentInitiation("Credit Card");
    }

    @Then("Payment is confirmed and receipt is generated")
    public void paymentIsConfirmedAndReceiptIsGenerated() {
        verifyPaymentConfirmation();
    }

    @Then("Billing Address is \"123 Main St\"")
    public void billingAddressIs() {
        verifyBillingAddress("123 Main St");
    }

    @Given("User logs out and logs back in")
    public void userLogsOutAndLogsBackIn() {
        logoutAndLogin();
    }

    @When("User navigates to the checkout page again")
    public void userNavigatesToTheCheckoutPageAgain() {
        navigateToCheckoutPage();
    }

    @When("User selects 'PayPal' as the payment method")
    public void userSelectsPayPalAsThePaymentMethod() {
        selectPaymentMethod("PayPal");
    }

    @Then("PayPal option is selected")
    public void payPalOptionIsSelected() {
        verifyPaymentMethodSelected("PayPal");
    }

    @When("User enters PayPal account details")
    public void userEntersPayPalAccountDetails() {
        enterPayPalDetails("user@example.com");
    }

    @Then("PayPal account details are entered successfully")
    public void payPalAccountDetailsAreEnteredSuccessfully() {
        verifyPayPalDetailsEntered();
    }

    @Then("Payment process initiates with PayPal")
    public void paymentProcessInitiatesWithPayPal() {
        verifyPaymentInitiation("PayPal");
    }

    @Given("User switches browser")
    public void userSwitchesBrowser() {
        switchBrowser();
    }

    @When("User repeats the test")
    public void userRepeatsTheTest() {
        repeatTest();
    }

    @Then("Payment method selection should work across different browsers")
    public void paymentMethodSelectionShouldWorkAcrossDifferentBrowsers() {
        verifyCrossBrowserFunctionality();
    }

    @When("User checks for any discrepancies in transaction details")
    public void userChecksForAnyDiscrepanciesInTransactionDetails() {
        checkTransactionDetails();
    }

    @Then("Transaction details should be accurate and consistent")
    public void transactionDetailsShouldBeAccurateAndConsistent() {
        verifyTransactionDetails();
    }

    @When("User attempts to checkout using guest account")
    public void userAttemptsToCheckoutUsingGuestAccount() {
        checkoutAsGuest();
    }

    @Then("Guest account should be able to select payment method")
    public void guestAccountShouldBeAbleToSelectPaymentMethod() {
        verifyGuestPaymentMethodSelection();
    }

    @When("User performs payment selection")
    public void userPerformsPaymentSelection() {
        performPaymentSelection();
    }

    @Then("No console errors should appear during the test execution")
    public void noConsoleErrorsShouldAppearDuringTheTestExecution() {
        verifyNoConsoleErrors();
    }
}