import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";

Given("the user is on the product page", () => {
  ProductPage.visit();
});

When("the product page is loaded", () => {
  ProductPage.checkPageLoaded();
});

Then("the system should display the current stock availability status of the product", () => {
  ProductPage.verifyStockAvailability();
});

Given("the stock level of a product changes in the inventory", () => {
  ProductPage.updateStockLevel();
});

When("the product page is refreshed", () => {
  ProductPage.refreshPage();
});

Then("the system should display the updated stock availability status", () => {
  ProductPage.verifyUpdatedStockAvailability();
});

Given("the stock level of a product is zero", () => {
  ProductPage.setStockLevelToZero();
});

Then("the system should display an \"Out of Stock\" message", () => {
  ProductPage.verifyOutOfStockMessage();
});

Given("the stock level of a product is less than the predefined threshold", () => {
  ProductPage.setStockLevelBelowThreshold();
});

Then("the system should display a \"Limited Stock Available\" message", () => {
  ProductPage.verifyLimitedStockMessage();
});

Given("the user adds a product to the cart", () => {
  ProductPage.addToCart();
});

When("the stock availability is checked", () => {
  ProductPage.checkStockAvailabilityInCart();
});

Then("the system should ensure the stock level is accurately reflected in the cart", () => {
  ProductPage.verifyStockInCart();
});

Given("the user is viewing a product with limited stock", () => {
  ProductPage.viewLimitedStockProduct();
});

When("the stock level changes to zero", () => {
  ProductPage.changeStockLevelToZero();
});

Then("the system should notify the user that the product is now out of stock", () => {
  ProductPage.notifyUserOutOfStock();
});