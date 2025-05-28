import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import GuestCheckoutPage from "../pages/guestCheckoutPage";

Given("the user has added items to the shopping cart", () => {
 cy.visit("/cart");
 cy.get(".add-to-cart").click();
});

When("the user proceeds to checkout", () => {
 GuestCheckoutPage.proceedToCheckout();
});

Then("the user should see an option to checkout as a guest", () => {
 GuestCheckoutPage.verifyGuestCheckoutOption();
});

Given("the user has chosen to checkout as a guest", () => {
 GuestCheckoutPage.selectGuestCheckout();
});

When("the user enters the required shipping and payment information", () => {
 GuestCheckoutPage.enterShippingInformation();
 GuestCheckoutPage.enterPaymentInformation();
});

When("the user confirms the order", () => {
 GuestCheckoutPage.confirmOrder();
});

Then("the order should be placed successfully", () => {
 GuestCheckoutPage.verifyOrderSuccess();
});

Then("the user should receive an order confirmation", () => {
 GuestCheckoutPage.verifyOrderConfirmation();
});

Given("the user is on the guest checkout page", () => {
 GuestCheckoutPage.visitGuestCheckoutPage();
});

When("the user tries to proceed without entering required information", () => {
 GuestCheckoutPage.proceedWithoutInformation();
});

Then("the user should be prompted to enter the missing information", () => {
 GuestCheckoutPage.verifyMissingInformationPrompt();
});

When("the user enters invalid payment information", () => {
 GuestCheckoutPage.enterInvalidPaymentInformation();
});

Then("the user should see an error message indicating the issue", () => {
 GuestCheckoutPage.verifyErrorMessage();
});

Then("the user should be able to correct the information and try again", () => {
 GuestCheckoutPage.correctInformationAndRetry();
});

When("the user decides to log in", () => {
 GuestCheckoutPage.chooseToLogin();
});

Then("the user should be redirected to the login page", () => {
 cy.url().should("include", "/login");
});

Then("after logging in, the user should be redirected back to the checkout page", () => {
 GuestCheckoutPage.verifyRedirectToCheckoutAfterLogin();
});