import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is logged in", () => {
 // Implement login steps
});

When("the user navigates to the cart page", () => {
 CheckoutPage.navigateToCart();
});

Then("the cart page is displayed with maximum allowable items", () => {
 CheckoutPage.verifyMaxItemsInCart();
});

Given("the cart is filled with maximum allowable items", () => {
 CheckoutPage.fillCartWithMaxItems();
});

When("the user checks the number of items in the cart", () => {
 CheckoutPage.checkNumberOfItemsInCart();
});

Then("the cart displays the maximum allowable number of items", () => {
 CheckoutPage.verifyMaxItemsDisplayed();
});

Given("the user is on the cart page with maximum allowable items", () => {
 CheckoutPage.verifyOnCartPageWithMaxItems();
});

When("the user clicks on 'Proceed to Checkout' button", () => {
 CheckoutPage.clickProceedToCheckout();
});

Then("the checkout page is displayed", () => {
 CheckoutPage.verifyCheckoutPageDisplayed();
});

Given("the user is on the checkout page", () => {
 CheckoutPage.verifyOnCheckoutPage();
});

When("the user enters valid shipping information", () => {
 CheckoutPage.enterShippingInformation();
});

Then("the shipping information is accepted", () => {
 CheckoutPage.verifyShippingInfoAccepted();
});

When("the user selects a payment method and enters valid payment details", () => {
 CheckoutPage.selectPaymentMethodAndEnterDetails();
});

Then("the payment details are accepted", () => {
 CheckoutPage.verifyPaymentDetailsAccepted();
});

Given("the user has entered valid payment details", () => {
 CheckoutPage.verifyValidPaymentDetailsEntered();
});

When("the user clicks on 'Pay Now' button", () => {
 CheckoutPage.clickPayNow();
});

Then("the payment is processed without performance issues", () => {
 CheckoutPage.verifyPaymentProcessed();
});

Given("the payment is processed", () => {
 CheckoutPage.verifyPaymentProcessed();
});

When("the user checks for the order confirmation message", () => {
 CheckoutPage.checkOrderConfirmationMessage();
});

Then("the order confirmation message is displayed with order details", () => {
 CheckoutPage.verifyOrderConfirmationMessageDisplayed();
});

Given("the order is confirmed", () => {
 CheckoutPage.verifyOrderConfirmed();
});

When("the user checks the order summary in the user account", () => {
 CheckoutPage.checkOrderSummaryInAccount();
});

Then("the order summary matches the transaction details", () => {
 CheckoutPage.verifyOrderSummaryMatchesDetails();
});

Given("the checkout process is completed", () => {
 CheckoutPage.verifyCheckoutCompleted();
});

When("the user verifies system performance metrics", () => {
 CheckoutPage.verifySystemPerformanceMetrics();
});

Then("the system performance metrics are within acceptable limits", () => {
 CheckoutPage.verifyPerformanceMetricsWithinLimits();
});

When("the user checks their email for order confirmation", () => {
 CheckoutPage.checkEmailForOrderConfirmation();
});

Then("the order confirmation email is received with correct details", () => {
 CheckoutPage.verifyOrderConfirmationEmailReceived();
});

When("the user checks the order status in the user dashboard", () => {
 CheckoutPage.checkOrderStatusInDashboard();
});

Then("the order status is displayed as 'Processing' or 'Completed'", () => {
 CheckoutPage.verifyOrderStatusDisplayed();
});

When("the user checks the delivery address details in the order summary", () => {
 CheckoutPage.checkDeliveryAddressInOrderSummary();
});

Then("the correct delivery address is displayed", () => {
 CheckoutPage.verifyCorrectDeliveryAddressDisplayed();
});

When("the user verifies if loyalty points or discounts were applied", () => {
 CheckoutPage.verifyLoyaltyPointsOrDiscountsApplied();
});

Then("the loyalty points/discounts are correctly applied to the order", () => {
 CheckoutPage.verifyCorrectLoyaltyPointsOrDiscounts();
});

When("the user looks for the 'Print Receipt' option", () => {
 CheckoutPage.checkPrintReceiptOption();
});

Then("the 'Print Receipt' option is available and functional", () => {
 CheckoutPage.verifyPrintReceiptOptionAvailable();
});

When("the user logs out and logs back in", () => {
 CheckoutPage.logoutAndLogin();
});

Then("the order details persist after logging back in", () => {
 CheckoutPage.verifyOrderDetailsPersistence();
});