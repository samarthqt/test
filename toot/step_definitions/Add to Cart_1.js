import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";
import CartPage from "../pages/cartPage";

Given("I am a registered user", () => {
 // Implement login logic
});

Given("I am logged into the e-commerce platform", () => {
 // Implement login verification
});

Given("I have navigated to the product listing page", () => {
 // Implement navigation to product listing page
});

Given("I am viewing a product on the product details page", () => {
 ProductPage.visitProductDetails();
});

When("I click on the \"Add to Cart\" button", () => {
 ProductPage.clickAddToCart();
});

Then("the product should be added to the shopping cart", () => {
 CartPage.verifyProductAdded();
});

Then("the cart icon should display the correct number of items", () => {
 CartPage.verifyCartItemCount();
});

When("I select a quantity of {string}", (quantity) => {
 ProductPage.selectQuantity(quantity);
});

Given("I am viewing the first product on the product details page", () => {
 ProductPage.visitFirstProductDetails();
});

When("I navigate to another product details page", () => {
 ProductPage.visitAnotherProductDetails();
});

Given("I have added products to my shopping cart", () => {
 // Implement adding products to cart
});

When("I click on the cart icon", () => {
 CartPage.clickCartIcon();
});

Then("I should be taken to the cart page", () => {
 CartPage.verifyCartPage();
});

Then("I should see all the products I have added", () => {
 CartPage.verifyAllProductsPresent();
});

Then("the total price should be correctly calculated", () => {
 CartPage.verifyTotalPrice();
});

Given("I am not logged into the e-commerce platform", () => {
 // Implement logic to ensure user is not logged in
});

When("I try to add a product to the cart", () => {
 ProductPage.tryAddToCart();
});

Then("I should be prompted to log in or register", () => {
 CartPage.verifyLoginOrRegisterPrompt();
});

When("I view my cart", () => {
 CartPage.viewCart();
});

Then("I should see the correct product name, price, and quantity", () => {
 CartPage.verifyProductDetails();
});

When("I choose to remove a product", () => {
 CartPage.removeProduct();
});

Then("the product should no longer appear in my cart", () => {
 CartPage.verifyProductRemoved();
});

Then("the cart icon should update to reflect the correct number of items", () => {
 CartPage.verifyCartIconUpdate();
});