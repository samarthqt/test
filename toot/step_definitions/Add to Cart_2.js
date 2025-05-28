import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";

Given("the user is on the product listing page", () => {
 ProductPage.visitProductListing();
});

When("the user selects a product", () => {
 ProductPage.selectProduct();
});

When("the user clicks on the \"Add to Cart\" button", () => {
 ProductPage.clickAddToCart();
});

Then("the product should be added to the shopping cart", () => {
 ProductPage.verifyProductAdded();
});

Then("the cart should display the added product", () => {
 ProductPage.verifyCartDisplaysProduct();
});

When("the user selects multiple products", () => {
 ProductPage.selectMultipleProducts();
});

When("the user clicks on the \"Add to Cart\" button for each product", () => {
 ProductPage.clickAddToCartForEach();
});

Then("all selected products should be added to the shopping cart", () => {
 ProductPage.verifyMultipleProductsAdded();
});

Then("the cart should display all the added products", () => {
 ProductPage.verifyCartDisplaysAllProducts();
});

When("the user clicks on the \"Add to Cart\" button multiple times", () => {
 ProductPage.clickAddToCartMultipleTimes();
});

Then("the cart should reflect the correct quantity of the product", () => {
 ProductPage.verifyCorrectProductQuantity();
});

When("the user adds a product to the cart", () => {
 ProductPage.addProductToCart();
});

When("the user navigates to the shopping cart page", () => {
 ProductPage.navigateToCartPage();
});

Then("the cart should list all products added", () => {
 ProductPage.verifyCartListsAllProducts();
});

Then("the total cost should be correctly calculated", () => {
 ProductPage.verifyTotalCost();
});

Given("the user is not logged in", () => {
 ProductPage.verifyUserNotLoggedIn();
});

Then("the user should be prompted to log in or register", () => {
 ProductPage.verifyLoginOrRegisterPrompt();
});

Given("the product is out of stock", () => {
 ProductPage.verifyProductOutOfStock();
});

When("the user selects the out-of-stock product", () => {
 ProductPage.selectOutOfStockProduct();
});

Then("the user should be notified that the product is out of stock", () => {
 ProductPage.verifyOutOfStockNotification();
});

Then("the product should not be added to the cart", () => {
 ProductPage.verifyProductNotAdded();
});