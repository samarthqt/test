import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShoppingCartPage from "../pages/shoppingCartPage";

Given("the user is logged into the application", () => {
  cy.login();
});

When("the user adds Product ID {int} to the cart with a quantity of {int}", (productId, quantity) => {
  ShoppingCartPage.addProductToCart(productId, quantity);
});

Then("the product is added to the cart successfully", () => {
  ShoppingCartPage.verifyProductAdded();
});

When("the user navigates to the shopping cart page", () => {
  ShoppingCartPage.navigateToCart();
});

Then("the shopping cart page displays correctly", () => {
  ShoppingCartPage.verifyCartPageDisplayed();
});

Given("the product is in the cart", () => {
  ShoppingCartPage.verifyProductInCart();
});

Then("the product name matches {string}", (productName) => {
  ShoppingCartPage.verifyProductName(productName);
});

Then("the price matches {string}", (price) => {
  ShoppingCartPage.verifyProductPrice(price);
});

Then("the quantity matches {int}", (quantity) => {
  ShoppingCartPage.verifyProductQuantity(quantity);
});

Then("the subtotal matches {string}", (subtotal) => {
  ShoppingCartPage.verifyProductSubtotal(subtotal);
});

Then("all details match the expected values without discrepancies", () => {
  ShoppingCartPage.verifyProductDetails();
});

When("the user changes the product quantity in the cart", () => {
  ShoppingCartPage.changeProductQuantity();
});

Then("the cart reflects the updated quantity and recalculates the subtotal", () => {
  ShoppingCartPage.verifyUpdatedQuantityAndSubtotal();
});

When("the user views the cart details", () => {
  ShoppingCartPage.viewCartDetails();
});

Then("the system remains responsive and displays details efficiently", () => {
  ShoppingCartPage.verifySystemPerformance();
});

Given("multiple products are added to the cart", () => {
  ShoppingCartPage.addMultipleProductsToCart();
});

Then("the cart displays all products with correct details", () => {
  ShoppingCartPage.verifyMultipleProductsDisplayed();
});

Given("multiple products are in the cart", () => {
  ShoppingCartPage.verifyMultipleProductsInCart();
});

Then("the total cart value matches the sum of all product subtotals", () => {
  ShoppingCartPage.verifyTotalCartValue();
});

When("the user views the cart", () => {
  ShoppingCartPage.viewCart();
});

Then("the system should not display any warnings if functioning correctly", () => {
  ShoppingCartPage.verifyNoSystemWarnings();
});

Then("users should find the display clear and informative", () => {
  ShoppingCartPage.verifyUserSatisfaction();
});

Then("the system logs should reflect the cart display process and any errors encountered", () => {
  ShoppingCartPage.verifySystemLogs();
});

Given("the system is under high load with multiple cart displays", () => {
  ShoppingCartPage.simulateHighLoad();
});

Then("the system scales effectively and maintains performance", () => {
  ShoppingCartPage.verifySystemScalability();
});