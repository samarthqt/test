import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShoppingCartPage from "../pages/shoppingCartPage";

Given("a user is on the product page", () => {
 ShoppingCartPage.visitProductPage();
});

When("the user adds a product to the shopping cart", () => {
 ShoppingCartPage.addProductToCart();
});

Then("the product should appear in the shopping cart", () => {
 ShoppingCartPage.verifyProductInCart();
});

Then("the cart should display the product's name, price, quantity, and subtotal", () => {
 ShoppingCartPage.verifyCartDetails();
});

Given("a user has a product in the shopping cart", () => {
 ShoppingCartPage.ensureProductInCart();
});

When("the user updates the quantity of the product in the cart", () => {
 ShoppingCartPage.updateProductQuantity();
});

Then("the cart should reflect the updated quantity", () => {
 ShoppingCartPage.verifyUpdatedQuantity();
});

Then("the subtotal should be recalculated accordingly", () => {
 ShoppingCartPage.verifyRecalculatedSubtotal();
});

When("the user removes the product from the cart", () => {
 ShoppingCartPage.removeProductFromCart();
});

Then("the product should no longer appear in the shopping cart", () => {
 ShoppingCartPage.verifyProductRemoved();
});

Given("a user has multiple products in the shopping cart", () => {
 ShoppingCartPage.ensureMultipleProductsInCart();
});

When("the user updates the quantity or removes a product", () => {
 ShoppingCartPage.updateOrRemoveProduct();
});

Then("the cart totals should update in real-time", () => {
 ShoppingCartPage.verifyRealTimeUpdates();
});

Given("a user encounters an error while managing the shopping cart", () => {
 ShoppingCartPage.simulateCartError();
});

When("the error occurs", () => {
 ShoppingCartPage.triggerError();
});

Then("the system should handle the error gracefully", () => {
 ShoppingCartPage.verifyErrorHandling();
});

Then("provide an appropriate error message to the user", () => {
 ShoppingCartPage.verifyErrorMessage();
});

Given("a user updates the shopping cart successfully", () => {
 ShoppingCartPage.performSuccessfulUpdate();
});

When("the update is processed", () => {
 ShoppingCartPage.processUpdate();
});

Then("the user should receive a notification confirming the successful update", () => {
 ShoppingCartPage.verifySuccessNotification();
});

Given("a user has items in the shopping cart", () => {
 ShoppingCartPage.ensureItemsInCart();
});

When("the user navigates away from the cart page", () => {
 ShoppingCartPage.navigateAwayFromCart();
});

Then("the cart data should be stored securely", () => {
 ShoppingCartPage.verifySecureStorage();
});

Given("a user has items in the shopping cart on a desktop device", () => {
 ShoppingCartPage.ensureItemsOnDesktop();
});

When("the user accesses the shopping cart on a mobile device", () => {
 ShoppingCartPage.accessCartOnMobile();
});

Then("the cart should be accessible with the same items", () => {
 ShoppingCartPage.verifyCartAccessibility();
});

Given("a user performs actions on the shopping cart", () => {
 ShoppingCartPage.performCartActions();
});

When("the actions are completed", () => {
 ShoppingCartPage.completeActions();
});

Then("the system should log all interactions for user tracking purposes", () => {
 ShoppingCartPage.verifyLogging();
});