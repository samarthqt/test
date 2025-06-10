import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShoppingCartPage from "../pages/shoppingCartPage";

Given("a user is on the product page", () => {
 ShoppingCartPage.visitProductPage();
});

When("the user adds a product to the shopping cart", () => {
 ShoppingCartPage.addProductToCart();
});

Then("the product should be added to the shopping cart", () => {
 ShoppingCartPage.verifyProductAdded();
});

Then("the user should receive a notification of successful addition", () => {
 ShoppingCartPage.verifyAdditionNotification();
});

Then("the system should log the add operation for auditing", () => {
 ShoppingCartPage.verifyAddOperationLogged();
});

Given("a product is present in the shopping cart", () => {
 ShoppingCartPage.verifyProductInCart();
});

When("the user removes the product from the shopping cart", () => {
 ShoppingCartPage.removeProductFromCart();
});

Then("the product should be removed from the shopping cart", () => {
 ShoppingCartPage.verifyProductRemoved();
});

Then("the user should receive a notification of successful removal", () => {
 ShoppingCartPage.verifyRemovalNotification();
});

Then("the system should log the remove operation for auditing", () => {
 ShoppingCartPage.verifyRemoveOperationLogged();
});

When("the user modifies the quantity of the product", () => {
 ShoppingCartPage.modifyProductQuantity();
});

Then("the quantity should be updated immediately in the shopping cart", () => {
 ShoppingCartPage.verifyQuantityUpdated();
});

Then("the system should update the subtotal based on the new quantity", () => {
 ShoppingCartPage.verifySubtotalUpdated();
});

Then("the user should receive a notification of successful modification", () => {
 ShoppingCartPage.verifyModificationNotification();
});

Then("the system should log the modify operation for auditing", () => {
 ShoppingCartPage.verifyModifyOperationLogged();
});

When("the user attempts to set a negative quantity for the product", () => {
 ShoppingCartPage.setNegativeQuantity();
});

Then("the system should prevent the negative quantity", () => {
 ShoppingCartPage.verifyNegativeQuantityPrevented();
});

Then("the user should receive an error message that is user-friendly", () => {
 ShoppingCartPage.verifyErrorMessage();
});

Given("a user is on a desktop or mobile platform", () => {
 ShoppingCartPage.verifyPlatformAccess();
});

When("the user performs cart operations", () => {
 ShoppingCartPage.performCartOperations();
});

Then("the operations should be accessible and function correctly on both platforms", () => {
 ShoppingCartPage.verifyOperationsFunctionality();
});

Given("a user is performing cart operations", () => {
 ShoppingCartPage.performCartOperations();
});

When("an error occurs", () => {
 ShoppingCartPage.simulateError();
});

Then("the system should handle the error gracefully", () => {
 ShoppingCartPage.verifyErrorHandling();
});

Then("provide a user-friendly message to the user", () => {
 ShoppingCartPage.verifyUserFriendlyMessage();
});