import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShoppingCartPage from "../pages/shoppingCartPage";

Given("a user is logged in", () => {
 // Implement login functionality here
});

And("a product is added to the cart", () => {
 // Implement add product to cart functionality here
});

And("multiple products are added to the cart", () => {
 // Implement add multiple products to cart functionality here
});

When("the user navigates to the shopping cart page", () => {
 ShoppingCartPage.visit();
});

When("the user logs out and logs back in", () => {
 // Implement logout and login functionality here
});

When("the user switches browser", () => {
 // Implement browser switch functionality here
});

When("the user selects a product to adjust its quantity", () => {
 ShoppingCartPage.selectProduct();
});

When("the user selects different products to adjust their quantities", () => {
 ShoppingCartPage.selectDifferentProducts();
});

When("the user enters a non-numeric value {string} in the quantity field", (value) => {
 ShoppingCartPage.enterQuantity(value);
});

When("the user enters a space ' ' in the quantity field", () => {
 ShoppingCartPage.enterQuantity(' ');
});

When("the user attempts to save the changes", () => {
 ShoppingCartPage.saveChanges();
});

When("the user refreshes the page", () => {
 cy.reload();
});

Then("an error message indicating invalid quantity input is displayed", () => {
 ShoppingCartPage.verifyErrorMessage();
});

Then("the system prevents saving and displays an error message", () => {
 ShoppingCartPage.verifySaveErrorMessage();
});

Then("the cart should retain the original quantity before the invalid input was attempted", () => {
 ShoppingCartPage.verifyOriginalQuantity();
});

Then("the error message should suggest entering a numeric value", () => {
 ShoppingCartPage.verifyGuidanceMessage();
});

Then("consistent error message behavior should be observed across different products", () => {
 ShoppingCartPage.verifyConsistentErrorMessages();
});

Then("error message behavior remains consistent after relogging", () => {
 ShoppingCartPage.verifyConsistentErrorMessages();
});

Then("error message should be consistent across different browsers", () => {
 ShoppingCartPage.verifyConsistentErrorMessages();
});

Then("the cart should revert to original quantities and error messages should reset", () => {
 ShoppingCartPage.verifyCartReset();
});

Then("no console errors should appear during the test execution", () => {
 cy.window().then((win) => {
 const logs = win.console.error;
 expect(logs).to.be.empty;
 });
});