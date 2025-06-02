import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("User is logged in", () => {
 // Implement login functionality here
});

Given("User has a valid PayPal account", () => {
 // Ensure PayPal account is valid
});

Given("Products are available in the cart", () => {
 // Add products to cart
});

When("User navigates to the cart page", () => {
 CheckoutPage.visitCartPage();
});

Then("Cart page is displayed with selected products", () => {
 CheckoutPage.verifyCartPage();
});

When("User verifies the products listed in the cart", () => {
 CheckoutPage.verifyProductsInCart();
});

Then("Products in the cart match the selected items", () => {
 CheckoutPage.matchSelectedItems();
});

When("User clicks on 'Proceed to Checkout' button", () => {
 CheckoutPage.proceedToCheckout();
});

Then("Checkout page is displayed", () => {
 CheckoutPage.verifyCheckoutPage();
});

When("User selects 'PayPal' as the payment method", () => {
 CheckoutPage.selectPayPal();
});

Then("PayPal payment section is displayed", () => {
 CheckoutPage.verifyPayPalSection();
});

When("User logs in to PayPal account", () => {
 CheckoutPage.loginToPayPal();
});

Then("PayPal login is successful", () => {
 CheckoutPage.verifyPayPalLogin();
});

When("User confirms the payment in PayPal", () => {
 CheckoutPage.confirmPaymentInPayPal();
});

Then("Payment is confirmed through PayPal", () => {
 CheckoutPage.verifyPaymentConfirmation();
});

When("User returns to the merchant site", () => {
 CheckoutPage.returnToMerchantSite();
});

Then("Redirected back to merchant site with confirmation", () => {
 CheckoutPage.verifyReturnToMerchant();
});

When("User verifies the order confirmation message", () => {
 CheckoutPage.verifyOrderConfirmationMessage();
});

Then("Order confirmation message is displayed with order details", () => {
 CheckoutPage.verifyOrderDetails();
});

When("User checks the order summary in the user account", () => {
 CheckoutPage.checkOrderSummary();
});

Then("Order summary matches the transaction details", () => {
 CheckoutPage.verifyOrderSummary();
});

When("User verifies the payment transaction in PayPal account", () => {
 CheckoutPage.verifyPaymentTransaction();
});

Then("Transaction is recorded and successful in PayPal", () => {
 CheckoutPage.verifyTransactionInPayPal();
});

When("User checks email for order confirmation", () => {
 CheckoutPage.checkOrderConfirmationEmail();
});

Then("Order confirmation email is received with correct details", () => {
 CheckoutPage.verifyConfirmationEmail();
});

When("User verifies the order status in the user dashboard", () => {
 CheckoutPage.verifyOrderStatus();
});

Then("Order status is displayed as 'Processing' or 'Completed'", () => {
 CheckoutPage.checkOrderStatus();
});

When("User checks the delivery address details in the order summary", () => {
 CheckoutPage.checkDeliveryAddress();
});

Then("Correct delivery address is displayed", () => {
 CheckoutPage.verifyDeliveryAddress();
});

When("User verifies if the loyalty points or discounts were applied correctly", () => {
 CheckoutPage.verifyLoyaltyPointsOrDiscounts();
});

Then("Loyalty points/discounts are correctly applied to the order", () => {
 CheckoutPage.checkLoyaltyPointsOrDiscounts();
});

When("User ensures the 'Print Receipt' option is available", () => {
 CheckoutPage.ensurePrintReceiptOption();
});

Then("'Print Receipt' option is available and functional", () => {
 CheckoutPage.verifyPrintReceiptOption();
});