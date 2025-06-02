import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user has items with IDs {string}, {string}, and {string} in the cart", (item1, item2, item3) => {
 cy.addItemToCart(item1);
 cy.addItemToCart(item2);
 cy.addItemToCart(item3);
});

When("the user navigates to the cart page", () => {
 cy.visitCartPage();
});

Then("the cart page is displayed with items {string}, {string}, and {string} listed", (item1, item2, item3) => {
 cy.verifyItemsInCart([item1, item2, item3]);
});

And("the user clicks on the 'Proceed to Checkout' button", () => {
 CheckoutPage.proceedToCheckout();
});

Then("the user is redirected to the checkout page", () => {
 cy.url().should("include", "/checkout");
});

And("the user account is logged in", () => {
 cy.verifyUserLoggedIn();
});

When("the user attempts to complete the checkout without entering any shipping or billing information", () => {
 CheckoutPage.attemptCheckoutWithoutInfo();
});

Then("an error message is displayed indicating that shipping and billing information is required", () => {
 CheckoutPage.verifyErrorMessage("Shipping and billing information is required to proceed.");
});

And("the checkout button remains disabled", () => {
 CheckoutPage.verifyCheckoutButtonDisabled();
});

Given("the user is on the checkout page", () => {
 CheckoutPage.visit();
});

When("the user enters partial shipping information only", () => {
 CheckoutPage.enterPartialShippingInfo();
});

Then("the error message persists", () => {
 CheckoutPage.verifyErrorMessagePersists();
});

And("checkout cannot proceed", () => {
 CheckoutPage.verifyCheckoutCannotProceed();
});

When("the user enters partial billing information only", () => {
 CheckoutPage.enterPartialBillingInfo();
});

When("the user enters invalid shipping and billing information", () => {
 CheckoutPage.enterInvalidShippingAndBillingInfo();
});

Then("the error message indicates invalid information", () => {
 CheckoutPage.verifyInvalidInfoErrorMessage();
});

Then("assistance options such as help links or FAQs are available", () => {
 CheckoutPage.verifyAssistanceOptionsAvailable();
});

When("the user refreshes the page and retries checkout", () => {
 cy.reload();
 CheckoutPage.attemptCheckoutWithoutInfo();
});

Then("page refresh does not bypass the requirement for shipping and billing information", () => {
 CheckoutPage.verifyErrorMessage("Shipping and billing information is required to proceed.");
});

When("the user checks the browser console for any error logs", () => {
 cy.checkBrowserConsoleForErrors();
});

Then("no unexpected errors are logged in the console", () => {
 cy.verifyNoUnexpectedErrorsInConsole();
});

When("the user checks the cart contents", () => {
 cy.checkCartContents();
});

Then("the cart still contains items {string}, {string}, and {string}", (item1, item2, item3) => {
 cy.verifyItemsInCart([item1, item2, item3]);
});

When("the user navigates away and returns to the checkout page", () => {
 cy.navigateAwayAndReturnToCheckout();
});

Then("the checkout page still requires shipping and billing information", () => {
 CheckoutPage.verifyErrorMessage("Shipping and billing information is required to proceed.");
});

When("the user logs out and logs back in, then attempts checkout again", () => {
 cy.logoutAndLogin();
 CheckoutPage.attemptCheckoutWithoutInfo();
});

Then("checkout requirement for shipping and billing information remains", () => {
 CheckoutPage.verifyErrorMessage("Shipping and billing information is required to proceed.");
});

When("the user attempts checkout using a different browser", () => {
 cy.switchBrowser();
 CheckoutPage.attemptCheckoutWithoutInfo();
});

Then("shipping and billing information is required across all browsers", () => {
 CheckoutPage.verifyErrorMessage("Shipping and billing information is required to proceed.");
});