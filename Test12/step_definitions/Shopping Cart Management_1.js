import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShoppingCartPage from "../pages/shoppingCartPage";

Given("I am a user on any page of the website", () => {
 ShoppingCartPage.visitAnyPage();
});

When("I attempt to access the shopping cart", () => {
 ShoppingCartPage.accessCart();
});

Then("I should be able to view the shopping cart", () => {
 ShoppingCartPage.verifyCartVisible();
});

Given("I am viewing a product on the website", () => {
 ShoppingCartPage.viewProduct();
});

When("I add the product to the shopping cart", () => {
 ShoppingCartPage.addProductToCart();
});

Then("the product should appear in the shopping cart with its name, price, quantity, and subtotal", () => {
 ShoppingCartPage.verifyProductInCart();
});

Given("I have a product in the shopping cart", () => {
 ShoppingCartPage.ensureProductInCart();
});

When("I remove the product from the shopping cart", () => {
 ShoppingCartPage.removeProductFromCart();
});

Then("the product should no longer be visible in the shopping cart", () => {
 ShoppingCartPage.verifyProductNotInCart();
});

When("I update the quantity of the product", () => {
 ShoppingCartPage.updateProductQuantity();
});

Then("the shopping cart should reflect the updated quantity and correct subtotal", () => {
 ShoppingCartPage.verifyUpdatedQuantityAndSubtotal();
});

Given("I am a user with items in my shopping cart", () => {
 ShoppingCartPage.ensureItemsInCart();
});

When("I attempt to tamper with cart data", () => {
 ShoppingCartPage.tamperWithCartData();
});

Then("the system should prevent unauthorized changes to the cart data", () => {
 ShoppingCartPage.verifyCartDataIntegrity();
});

Given("I am updating my shopping cart", () => {
 ShoppingCartPage.beginCartUpdate();
});

When("an error occurs during the update", () => {
 ShoppingCartPage.simulateCartUpdateError();
});

Then("I should receive a notification about the issue", () => {
 ShoppingCartPage.verifyErrorNotification();
});

Given("I am using the website on a desktop or mobile device", () => {
 ShoppingCartPage.verifyPlatformCompatibility();
});

When("I access the shopping cart", () => {
 ShoppingCartPage.accessCart();
});

Then("the cart functionality should be consistent across both platforms", () => {
 ShoppingCartPage.verifyCartFunctionalityConsistency();
});

Given("I am performing actions in the shopping cart", () => {
 ShoppingCartPage.performCartActions();
});

When("I add, remove, or update product quantities", () => {
 ShoppingCartPage.logCartActions();
});

Then("the system should log these actions for analytics purposes", () => {
 ShoppingCartPage.verifyCartActionsLogged();
});

Given("I have products in my shopping cart", () => {
 ShoppingCartPage.ensureProductsInCart();
});

When("I view the cart details", () => {
 ShoppingCartPage.viewCartDetails();
});

Then("the cart should display accurate product information, synchronized with the product database", () => {
 ShoppingCartPage.verifyCartDetailsWithDatabase();
});

Given("I am updating product quantities in the shopping cart", () => {
 ShoppingCartPage.beginQuantityUpdate();
});

When("I submit the update", () => {
 ShoppingCartPage.submitQuantityUpdate();
});

Then("the cart should process the update within 3 seconds", () => {
 ShoppingCartPage.verifyUpdatePerformance();
});

Given("there is an issue with my shopping cart", () => {
 ShoppingCartPage.simulateCartIssue();
});

When("the issue is detected", () => {
 ShoppingCartPage.detectCartIssue();
});

Then("I should receive a notification alerting me to the issue", () => {
 ShoppingCartPage.verifyIssueNotification();
});