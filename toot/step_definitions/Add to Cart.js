import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";

Given("I am on the product page", () => {
 ProductPage.visitProductPage();
});

Given("I am on the product page of {string}", (product) => {
 ProductPage.visitProductPageOf(product);
});

Given("I am not logged into the website", () => {
 ProductPage.ensureLoggedOut();
});

When("I click on the \"Add to Cart\" button", () => {
 ProductPage.clickAddToCart();
});

When("I click on the \"Add to Cart\" button again", () => {
 ProductPage.clickAddToCart();
});

When("I navigate to the product page of {string}", (product) => {
 ProductPage.visitProductPageOf(product);
});

Then("the product should be added to the shopping cart", () => {
 ProductPage.verifyProductAddedToCart();
});

Then("both products should be present in the shopping cart", () => {
 ProductPage.verifyMultipleProductsInCart();
});

Then("the product quantity in the shopping cart should be updated to 2", () => {
 ProductPage.verifyProductQuantityInCart(2);
});

Then("I should see a confirmation message \"Product added to your cart.\"", () => {
 ProductPage.verifyConfirmationMessage("Product added to your cart.");
});

Then("I should be prompted to log in or register", () => {
 ProductPage.verifyLoginPrompt();
});

Then("the product should be added to the cart after successful login", () => {
 ProductPage.verifyProductAddedAfterLogin();
});

Then("I should see a message \"This product is currently out of stock.\"", () => {
 ProductPage.verifyOutOfStockMessage();
});

Then("the product should not be added to the shopping cart", () => {
 ProductPage.verifyProductNotAddedToCart();
});