import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user has items in the shopping cart", () => {
 CheckoutPage.verifyItemsInCart();
});

When("the user clicks on the {string} button", (button) => {
 CheckoutPage.clickButton(button);
});

Then("the user is redirected to the checkout page", () => {
 CheckoutPage.verifyOnCheckoutPage();
});

Given("the user is on the checkout page", () => {
 CheckoutPage.verifyOnCheckoutPage();
});

When("the user enters new shipping information", () => {
 CheckoutPage.enterNewShippingInformation();
});

Then("the system validates the shipping information for accuracy", () => {
 CheckoutPage.validateShippingInformation();
});

Given("the user has saved shipping information", () => {
 CheckoutPage.verifySavedShippingInformation();
});

When("the user selects saved shipping information", () => {
 CheckoutPage.selectSavedShippingInformation();
});

When("the user enters new billing information", () => {
 CheckoutPage.enterNewBillingInformation();
});

Then("the system validates the billing information for accuracy", () => {
 CheckoutPage.validateBillingInformation();
});

Given("the user has saved billing information", () => {
 CheckoutPage.verifySavedBillingInformation();
});

When("the user selects saved billing information", () => {
 CheckoutPage.selectSavedBillingInformation();
});

When("the user proceeds to select a shipping method", () => {
 CheckoutPage.proceedToSelectShippingMethod();
});

Then("the system provides options for different shipping methods", () => {
 CheckoutPage.verifyShippingMethodsOptions();
});

When("the user enters personal information", () => {
 CheckoutPage.enterPersonalInformation();
});

Then("the checkout process is secure and complies with data protection regulations", () => {
 CheckoutPage.verifySecurityCompliance();
});

Given("the user has entered shipping and billing information", () => {
 CheckoutPage.verifyShippingAndBillingInformationEntered();
});

When("the user proceeds to the order review step", () => {
 CheckoutPage.proceedToOrderReview();
});

Then("the system displays a summary of the order before final confirmation", () => {
 CheckoutPage.verifyOrderSummaryDisplayed();
});

Given("the user is on the order summary page", () => {
 CheckoutPage.verifyOnOrderSummaryPage();
});

When("the user reviews the order details", () => {
 CheckoutPage.reviewOrderDetails();
});

When("the user edits the order details", () => {
 CheckoutPage.editOrderDetails();
});

Then("the system updates the order summary with the edited details", () => {
 CheckoutPage.verifyOrderSummaryUpdated();
});

When("the user completes all required steps", () => {
 CheckoutPage.completeAllSteps();
});

Then("the checkout process should be quick and efficient", () => {
 CheckoutPage.verifyQuickCompletion();
});

When("the user enters incorrect information", () => {
 CheckoutPage.enterIncorrectInformation();
});

Then("the system displays an error message with clear instructions for correction", () => {
 CheckoutPage.verifyErrorMessageDisplayed();
});