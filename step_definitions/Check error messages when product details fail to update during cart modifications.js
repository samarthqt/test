import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CartPage from "../pages/cartPage";

Given("User is logged into the application", () => {
 cy.login();
});

Given("Product ID {string} is added to the cart with an initial quantity of {int}", (productId, quantity) => {
 cy.addProductToCart(productId, quantity);
});

When("User navigates to the shopping cart page", () => {
 CartPage.visit();
});

Then("Shopping cart page displays correctly with initial quantity {int}", (quantity) => {
 CartPage.verifyProductQuantity(quantity);
});

When("User attempts to update the product quantity to {int}", (newQuantity) => {
 CartPage.updateProductQuantity(newQuantity);
});

When("User attempts to update other product details such as price or name", () => {
 CartPage.updateProductDetails();
});

When("User attempts to update the product quantity to {int} multiple times", (newQuantity) => {
 CartPage.updateProductQuantityRepeatedly(newQuantity);
});

When("User attempts to update the product quantity to {int} under high load", (newQuantity) => {
 CartPage.updateProductQuantityUnderHighLoad(newQuantity);
});

And("Simulate a failure in updating the product details", () => {
 CartPage.simulateUpdateFailure();
});

And("Simulate repeated failures in updating the product details", () => {
 CartPage.simulateRepeatedUpdateFailures();
});

Then("System displays an error message indicating the update failure", () => {
 CartPage.verifyErrorMessage();
});

Then("Error message clearly states the issue with updating product details", () => {
 CartPage.verifyErrorMessageDetails();
});

Then("Cart maintains the original quantity and details", () => {
 CartPage.verifyOriginalQuantityAndDetails();
});

Then("Logs should reflect the error handling process for update failures", () => {
 CartPage.verifyLogsForErrorHandling();
});

Then("Users should understand the error message and how to resolve the issue", () => {
 CartPage.verifyUserUnderstandingOfErrorMessage();
});

Then("Product details remain consistent and accurately reflect available information", () => {
 CartPage.verifyProductDetailsConsistency();
});

Then("System scales effectively and maintains performance", () => {
 CartPage.verifySystemScalability();
});

Then("Cart functions should remain unaffected by update failures", () => {
 CartPage.verifyCartFunctionality();
});

Then("System should not display any warnings if functioning correctly", () => {
 CartPage.verifyNoWarnings();
});

Then("System remains responsive and handles errors gracefully", () => {
 CartPage.verifySystemResponsiveness();
});