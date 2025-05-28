import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CartPage from "../pages/cartPage";

Given("the user is logged into the e-commerce platform", () => {
 CartPage.login();
});

Given("the user has items in their cart", () => {
 CartPage.ensureItemsInCart();
});

Given("the price threshold is set to {string}", (threshold) => {
 CartPage.setPriceThreshold(threshold);
});

Given("the current total price of items in the cart is {string}", (currentTotal) => {
 CartPage.setCurrentTotalPrice(currentTotal);
});

When("the user adds an item with price {string}", (itemPrice) => {
 CartPage.addItem(itemPrice);
});

When("the user removes an item with price {string}", (itemPrice) => {
 CartPage.removeItem(itemPrice);
});

Then("the user should receive a notification that their cart has exceeded the threshold", () => {
 CartPage.verifyNotificationExceedsThreshold();
});

Then("the user should not receive a notification", () => {
 CartPage.verifyNoNotification();
});

Then("the user should receive only one notification that their cart has exceeded the threshold", () => {
 CartPage.verifySingleNotification();
});

Then("the user should receive a notification that their cart is now below the threshold", () => {
 CartPage.verifyNotificationBelowThreshold();
});