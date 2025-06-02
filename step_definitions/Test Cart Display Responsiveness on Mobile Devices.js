import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CartPage from "../pages/cartPage";

Given("the retail application is opened on {string}", (device) => {
  CartPage.openApplicationOnDevice(device);
});

Given("user account with items added to the cart is logged in", () => {
  CartPage.loginWithItemsInCart();
});

Given("the retail application is opened on {string} in landscape mode", (device) => {
  CartPage.openApplicationOnDeviceInLandscape(device);
});

When("the user navigates to the cart page", () => {
  CartPage.navigateToCartPage();
});

When("the user adds an item to the cart", () => {
  CartPage.addItemToCart();
});

When("the user removes an item from the cart", () => {
  CartPage.removeItemFromCart();
});

Then("the cart page loads with items correctly displayed", () => {
  CartPage.verifyItemsDisplayedCorrectly();
});

Then("the text in the cart is clear and readable without needing to zoom", () => {
  CartPage.verifyTextReadability();
});

Then("the cart layout adjusts correctly to the screen size without overlapping elements", () => {
  CartPage.verifyLayoutAdjustment();
});

Then("similar positive results as observed on iPhone 12 are seen", () => {
  CartPage.verifySimilarResultsAsIPhone12();
});

Then("the cart display adjusts correctly without losing readability", () => {
  CartPage.verifyDisplayAdjustmentInLandscape();
});

Then("the item is successfully added and displayed in the cart", () => {
  CartPage.verifyItemAddedToCart();
});

Then("the item is successfully removed and no longer displayed in the cart", () => {
  CartPage.verifyItemRemovedFromCart();
});