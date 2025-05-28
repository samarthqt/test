import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("I am a guest user on the website", () => {
 cy.visit("/");
});

Given("I have added items to my shopping cart", () => {
 CheckoutPage.addItemToCart();
});

Given("my shopping cart is empty", () => {
 CheckoutPage.ensureCartIsEmpty();
});

Given("I am a guest user on the checkout page", () => {
 CheckoutPage.visitCheckoutPage();
});

Given("I have entered invalid shipping details", () => {
 CheckoutPage.enterInvalidShippingDetails();
});

Given("I have entered invalid payment information", () => {
 CheckoutPage.enterInvalidPaymentInformation();
});

Given("I have entered valid shipping and payment information", () => {
 CheckoutPage.enterValidShippingAndPaymentInformation();
});

When("I proceed to the checkout page", () => {
 CheckoutPage.proceedToCheckout();
});

When("I attempt to proceed with the checkout", () => {
 CheckoutPage.attemptCheckout();
});

When("I review my order", () => {
 CheckoutPage.reviewOrder();
});

Then("I should be able to enter my shipping details", () => {
 CheckoutPage.verifyShippingDetailsEntry();
});

Then("I should be able to enter my payment information", () => {
 CheckoutPage.verifyPaymentInformationEntry();
});

Then("I should be able to review my order", () => {
 CheckoutPage.verifyOrderReview();
});

Then("I should be able to place the order without logging in", () => {
 CheckoutPage.verifyOrderPlacementWithoutLogin();
});

Then("I should see a message indicating that my cart is empty", () => {
 CheckoutPage.verifyEmptyCartMessage();
});

Then("I should not be able to proceed with the checkout", () => {
 CheckoutPage.verifyCannotProceedWithEmptyCart();
});

Then("I should see an error message indicating invalid shipping details", () => {
 CheckoutPage.verifyInvalidShippingErrorMessage();
});

Then("I should be prompted to correct the shipping details", () => {
 CheckoutPage.verifyPromptToCorrectShippingDetails();
});

Then("I should see an error message indicating invalid payment information", () => {
 CheckoutPage.verifyInvalidPaymentErrorMessage();
});

Then("I should be prompted to correct the payment information", () => {
 CheckoutPage.verifyPromptToCorrectPaymentInformation();
});

Then("I should see a summary of my order details", () => {
 CheckoutPage.verifyOrderSummary();
});

Then("I should see the total cost including any taxes and shipping fees", () => {
 CheckoutPage.verifyTotalCostIncludingTaxesAndFees();
});

Then("I should see an option to edit my order before placing it", () => {
 CheckoutPage.verifyEditOrderOption();
});