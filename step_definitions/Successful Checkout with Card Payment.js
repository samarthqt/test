import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is logged in", () => {
 CheckoutPage.login();
});

When("the user navigates to the cart page", () => {
 CheckoutPage.goToCartPage();
});

Then("the cart page is displayed with selected products", () => {
 CheckoutPage.verifyCartPageDisplayed();
});

Then("products are available in the cart", () => {
 CheckoutPage.verifyProductsInCart();
});

Given("the user is on the cart page", () => {
 CheckoutPage.verifyOnCartPage();
});

Then("products in the cart match the selected items", () => {
 CheckoutPage.verifyCartItemsMatch();
});

When("the user clicks on 'Proceed to Checkout' button", () => {
 CheckoutPage.proceedToCheckout();
});

Then("the checkout page is displayed", () => {
 CheckoutPage.verifyCheckoutPageDisplayed();
});

Given("the user is on the checkout page", () => {
 CheckoutPage.verifyOnCheckoutPage();
});

When("the user selects 'Credit Card' as the payment method", () => {
 CheckoutPage.selectCreditCardPayment();
});

Then("the Credit Card payment section is displayed", () => {
 CheckoutPage.verifyCreditCardSectionDisplayed();
});

Given("the user is on the Credit Card payment section", () => {
 CheckoutPage.verifyOnCreditCardSection();
});

When("the user enters valid credit card details", () => {
 CheckoutPage.enterCreditCardDetails();
});

Then("the credit card details are accepted", () => {
 CheckoutPage.verifyCreditCardDetailsAccepted();
});

Given("the user has entered valid credit card details", () => {
 CheckoutPage.verifyCreditCardDetailsEntered();
});

When("the user clicks on 'Pay Now' button", () => {
 CheckoutPage.clickPayNow();
});

Then("the payment is processed", () => {
 CheckoutPage.verifyPaymentProcessed();
});

Then("the confirmation page is displayed", () => {
 CheckoutPage.verifyConfirmationPageDisplayed();
});

Given("the user is on the confirmation page", () => {
 CheckoutPage.verifyOnConfirmationPage();
});

Then("the order confirmation message is displayed with order details", () => {
 CheckoutPage.verifyOrderConfirmationMessage();
});

When("the user checks the order summary in the user account", () => {
 CheckoutPage.checkOrderSummary();
});

Then("the order summary matches the transaction details", () => {
 CheckoutPage.verifyOrderSummaryMatches();
});

Given("the payment has been processed", () => {
 CheckoutPage.verifyPaymentProcessed();
});

When("the user verifies the payment transaction in the payment gateway", () => {
 CheckoutPage.verifyPaymentTransaction();
});

Then("the transaction is recorded and successful", () => {
 CheckoutPage.verifyTransactionRecorded();
});

Given("the order has been confirmed", () => {
 CheckoutPage.verifyOrderConfirmed();
});

When("the user checks email for order confirmation", () => {
 CheckoutPage.checkOrderConfirmationEmail();
});

Then("the order confirmation email is received with correct details", () => {
 CheckoutPage.verifyOrderConfirmationEmailReceived();
});

When("the user verifies the order status in the user dashboard", () => {
 CheckoutPage.verifyOrderStatus();
});

Then("the order status is displayed as 'Processing' or 'Completed'", () => {
 CheckoutPage.verifyOrderStatusDisplayed();
});

When("the user checks the delivery address details in the order summary", () => {
 CheckoutPage.checkDeliveryAddressDetails();
});

Then("the correct delivery address is displayed", () => {
 CheckoutPage.verifyDeliveryAddressDisplayed();
});

When("the user verifies if the loyalty points or discounts were applied correctly", () => {
 CheckoutPage.verifyLoyaltyPointsAndDiscounts();
});

Then("loyalty points/discounts are correctly applied to the order", () => {
 CheckoutPage.verifyLoyaltyPointsDiscountsApplied();
});

When("the user checks for 'Print Receipt' option", () => {
 CheckoutPage.checkPrintReceiptOption();
});

Then("'Print Receipt' option is available and functional", () => {
 CheckoutPage.verifyPrintReceiptOptionAvailable();
});

When("the user logs out and logs back in", () => {
 CheckoutPage.logoutAndLogin();
});

Then("order details persist after logging back in", () => {
 CheckoutPage.verifyOrderDetailsPersistence();
});