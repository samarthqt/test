package com.cucumber.steps;

import com.page_objects.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps extends CheckoutPage {

    @Given("User is logged in")
    public void userIsLoggedIn() {
        verifyUserLoggedIn();
    }

    @Given("User has a valid PayPal account")
    public void userHasValidPayPalAccount() {
        verifyPayPalAccount();
    }

    @Given("Products are available in the cart")
    public void productsAreAvailableInCart() {
        verifyProductsInCart();
    }

    @When("User navigates to the cart page")
    public void userNavigatesToCartPage() {
        navigateToCartPage();
    }

    @Then("Cart page is displayed with selected products")
    public void cartPageIsDisplayedWithSelectedProducts() {
        verifyCartPageDisplayed();
    }

    @When("User verifies the products listed in the cart")
    public void userVerifiesProductsListedInCart() {
        verifyProductsListedInCart();
    }

    @Then("Products in the cart match the selected items")
    public void productsInCartMatchSelectedItems() {
        assertProductsMatchSelectedItems();
    }

    @Given("User is on the cart page")
    public void userIsOnCartPage() {
        verifyUserOnCartPage();
    }

    @When("User clicks on 'Proceed to Checkout' button")
    public void userClicksOnProceedToCheckoutButton() {
        clickProceedToCheckout();
    }

    @Then("Checkout page is displayed")
    public void checkoutPageIsDisplayed() {
        verifyCheckoutPageDisplayed();
    }

    @Given("User is on the checkout page")
    public void userIsOnCheckoutPage() {
        verifyUserOnCheckoutPage();
    }

    @When("User selects 'PayPal' as the payment method")
    public void userSelectsPayPalAsPaymentMethod() {
        selectPayPalPaymentMethod();
    }

    @Then("PayPal payment section is displayed")
    public void paypalPaymentSectionIsDisplayed() {
        verifyPayPalPaymentSectionDisplayed();
    }

    @Given("User is on the PayPal payment section")
    public void userIsOnPayPalPaymentSection() {
        verifyUserOnPayPalPaymentSection();
    }

    @When("User logs in to PayPal account")
    public void userLogsInToPayPalAccount() {
        loginToPayPal();
    }

    @Then("PayPal login is successful")
    public void paypalLoginIsSuccessful() {
        verifyPayPalLoginSuccessful();
    }

    @Given("User is logged in to PayPal")
    public void userIsLoggedInToPayPal() {
        verifyUserLoggedInToPayPal();
    }

    @When("User confirms the payment in PayPal")
    public void userConfirmsPaymentInPayPal() {
        confirmPaymentInPayPal();
    }

    @Then("Payment is confirmed through PayPal")
    public void paymentIsConfirmedThroughPayPal() {
        verifyPaymentConfirmedThroughPayPal();
    }

    @Given("Payment is confirmed through PayPal")
    public void paymentIsConfirmedThroughPayPalGiven() {
        verifyPaymentConfirmedThroughPayPal();
    }

    @When("User returns to the merchant site")
    public void userReturnsToMerchantSite() {
        returnToMerchantSite();
    }

    @Then("Redirected back to merchant site with confirmation")
    public void redirectedBackToMerchantSiteWithConfirmation() {
        verifyRedirectedBackToMerchantSite();
    }

    @Given("User is redirected back to merchant site")
    public void userIsRedirectedBackToMerchantSite() {
        verifyUserRedirectedBackToMerchantSite();
    }

    @When("User verifies the order confirmation message")
    public void userVerifiesOrderConfirmationMessage() {
        verifyOrderConfirmationMessage();
    }

    @Then("Order confirmation message is displayed with order details")
    public void orderConfirmationMessageIsDisplayedWithOrderDetails() {
        assertOrderConfirmationMessageDisplayed();
    }

    @Given("Order confirmation message is displayed")
    public void orderConfirmationMessageIsDisplayed() {
        verifyOrderConfirmationMessageDisplayed();
    }

    @When("User checks the order summary in the user account")
    public void userChecksOrderSummaryInUserAccount() {
        checkOrderSummaryInUserAccount();
    }

    @Then("Order summary matches the transaction details")
    public void orderSummaryMatchesTransactionDetails() {
        assertOrderSummaryMatchesTransactionDetails();
    }

    @When("User verifies the payment transaction in PayPal account")
    public void userVerifiesPaymentTransactionInPayPalAccount() {
        verifyPaymentTransactionInPayPalAccount();
    }

    @Then("Transaction is recorded and successful in PayPal")
    public void transactionIsRecordedAndSuccessfulInPayPal() {
        assertTransactionRecordedInPayPal();
    }

    @When("User checks email for order confirmation")
    public void userChecksEmailForOrderConfirmation() {
        checkEmailForOrderConfirmation();
    }

    @Then("Order confirmation email is received with correct details")
    public void orderConfirmationEmailIsReceivedWithCorrectDetails() {
        assertOrderConfirmationEmailReceived();
    }

    @When("User verifies the order status in the user dashboard")
    public void userVerifiesOrderStatusInUserDashboard() {
        verifyOrderStatusInUserDashboard();
    }

    @Then("Order status is displayed as 'Processing' or 'Completed'")
    public void orderStatusIsDisplayedAsProcessingOrCompleted() {
        assertOrderStatusDisplayed();
    }

    @When("User checks the delivery address details in the order summary")
    public void userChecksDeliveryAddressDetailsInOrderSummary() {
        checkDeliveryAddressDetailsInOrderSummary();
    }

    @Then("Correct delivery address is displayed")
    public void correctDeliveryAddressIsDisplayed() {
        assertCorrectDeliveryAddressDisplayed();
    }

    @When("User verifies if the loyalty points or discounts were applied correctly")
    public void userVerifiesLoyaltyPointsOrDiscountsAppliedCorrectly() {
        verifyLoyaltyPointsOrDiscountsApplied();
    }

    @Then("Loyalty points/discounts are correctly applied to the order")
    public void loyaltyPointsDiscountsAreCorrectlyAppliedToOrder() {
        assertLoyaltyPointsDiscountsApplied();
    }

    @When("User ensures the 'Print Receipt' option is available")
    public void userEnsuresPrintReceiptOptionIsAvailable() {
        ensurePrintReceiptOptionAvailable();
    }

    @Then("'Print Receipt' option is available and functional")
    public void printReceiptOptionIsAvailableAndFunctional() {
        assertPrintReceiptOptionFunctional();
    }
}