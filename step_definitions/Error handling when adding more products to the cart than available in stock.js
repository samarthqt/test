import { Given, When, Then, And } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";

Given("the user is logged into the application", () => {
  cy.login();
});

When("the user navigates to the product page for Product ID {string}", (productId) => {
  ProductPage.visit(productId);
});

Then("the product page displays correctly with stock information", () => {
  ProductPage.verifyStockInformation();
});

And("the product stock information is accurately updated in the system", () => {
  ProductPage.checkStockUpdate();
});

Given("the available stock for Product ID {string} is {int}", (productId, stock) => {
  ProductPage.setStock(productId, stock);
});

When("the user enters a quantity of {int} into the quantity field", (quantity) => {
  ProductPage.enterQuantity(quantity);
});

And("clicks the 'Add to Cart' button", () => {
  ProductPage.addToCart();
});

Then("the system displays an error message indicating insufficient stock", () => {
  ProductPage.verifyInsufficientStockError();
});

And("the cart does not contain the requested quantity", () => {
  ProductPage.verifyCartQuantity(0);
});

Given("the user attempted to add more products than available in stock", () => {
  ProductPage.attemptOverStockAdd();
});

Then("the error message clearly states the issue and available stock", () => {
  ProductPage.verifyErrorMessageClarity();
});

Given("the user adjusts the quantity to the available stock limit", () => {
  ProductPage.adjustQuantityToStockLimit();
});

When("the user adds the product to the cart", () => {
  ProductPage.addToCart();
});

Then("the system successfully adds the product to the cart", () => {
  ProductPage.verifyProductAdded();
});

And("the cart displays the correct quantity reflecting available stock", () => {
  ProductPage.verifyCartQuantityReflectsStock();
});

When("the user enters a quantity of 0 into the quantity field", () => {
  ProductPage.enterQuantity(0);
});

Then("the system should not add the product and may display a relevant message", () => {
  ProductPage.verifyNoProductAddedForZeroQuantity();
});

When("the user enters a negative quantity into the quantity field", () => {
  ProductPage.enterNegativeQuantity();
});

Then("the system should reject the input and display an error message", () => {
  ProductPage.verifyNegativeQuantityError();
});

When("the user enters a non-numeric quantity into the quantity field", () => {
  ProductPage.enterNonNumericQuantity();
});

Then("the system should reject the input and display an error message", () => {
  ProductPage.verifyNonNumericQuantityError();
});

When("the user attempts actions that breach stock limits", () => {
  ProductPage.attemptStockLimitBreach();
});

Then("the system logs should reflect the error handling process", () => {
  ProductPage.verifySystemLogsForErrors();
});

When("the user repeatedly attempts to add more products than available in stock", () => {
  ProductPage.repeatOverStockAttempts();
});

Then("the system remains responsive and handles errors gracefully", () => {
  ProductPage.verifySystemResponsiveness();
});

Given("the user encounters error messages due to stock limit breaches", () => {
  ProductPage.encounterErrorMessages();
});

Then("users should understand the error message and how to resolve the issue", () => {
  ProductPage.verifyUserUnderstandingOfErrors();
});

Given("the user attempts various actions related to stock limits", () => {
  ProductPage.attemptVariousStockActions();
});

Then("stock levels remain consistent and accurately reflect available inventory", () => {
  ProductPage.verifyStockConsistency();
});