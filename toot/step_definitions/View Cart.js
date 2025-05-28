import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShoppingCartPage from "../pages/shoppingCartPage";

Given("the user is logged into their account", () => {
 // Implement login logic
});

Given("the user has added products to the shopping cart", () => {
 // Implement adding products logic
});

When("the user navigates to the shopping cart page", () => {
 ShoppingCartPage.visit();
});

Then("the user should see all the products they have added to the cart", () => {
 ShoppingCartPage.verifyProductsInCart();
});

Then("each product should display its name, quantity, price, and total price", () => {
 ShoppingCartPage.verifyProductDetails();
});

Given("the shopping cart is empty", () => {
 ShoppingCartPage.emptyCart();
});

Then("the user should see a message indicating that the cart is empty", () => {
 ShoppingCartPage.verifyEmptyCartMessage();
});

Given("the user is on the shopping cart page", () => {
 ShoppingCartPage.visit();
});

Given("the cart contains products", () => {
 // Ensure cart has products
});

When("the user updates the quantity of a product", () => {
 ShoppingCartPage.updateProductQuantity();
});

Then("the cart should reflect the updated quantity", () => {
 ShoppingCartPage.verifyUpdatedQuantity();
});

Then("the total price should be recalculated accordingly", () => {
 ShoppingCartPage.verifyTotalPrice();
});

When("the user removes a product from the cart", () => {
 ShoppingCartPage.removeProduct();
});

Then("the product should no longer appear in the cart", () => {
 ShoppingCartPage.verifyProductRemoved();
});

Then("the total price should be updated accordingly", () => {
 ShoppingCartPage.verifyTotalPrice();
});

When("the user proceeds to checkout", () => {
 ShoppingCartPage.proceedToCheckout();
});

Then("the user should be directed to the checkout process", () => {
 cy.url().should("include", "/checkout");
});