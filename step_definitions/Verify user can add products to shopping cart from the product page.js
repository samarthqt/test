import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";
import ShoppingCartPage from "../pages/shoppingCartPage";

Given("the user is logged into the application", () => {
 // Assume user is logged in
});

When("the user navigates to the product page using the product ID {string}", (productId) => {
 ProductPage.visitProductById(productId);
});

Then("the product page is displayed with product details", () => {
 ProductPage.verifyProductDetailsDisplayed();
});

Then("the product must be available in stock", () => {
 ProductPage.verifyProductInStock();
});

Given("the user is on the product page", () => {
 ProductPage.verifyOnProductPage();
});

Then("the 'Add to Cart' button is visible and enabled", () => {
 ProductPage.verifyAddToCartButton();
});

When("the user clicks on the 'Add to Cart' button", () => {
 ProductPage.clickAddToCartButton();
});

Then("the product is added to the shopping cart", () => {
 ShoppingCartPage.verifyProductAdded();
});

Then("a confirmation message is displayed", () => {
 ShoppingCartPage.verifyConfirmationMessage();
});

Given("the product is added to the shopping cart", () => {
 // Assume product is added
});

When("the user navigates to the shopping cart page", () => {
 ShoppingCartPage.visit();
});

Then("the shopping cart page displays the added product with correct details", () => {
 ShoppingCartPage.verifyProductDetailsInCart();
});

Given("the product is in the shopping cart", () => {
 // Assume product is in cart
});

Then("the product name, price, and quantity are displayed correctly", () => {
 ShoppingCartPage.verifyProductDetails();
});

Then("the product details match the selected product", () => {
 ShoppingCartPage.verifySelectedProductDetails();
});

Then("the total price is calculated correctly based on the product price and quantity", () => {
 ShoppingCartPage.verifyTotalPrice();
});

When("the user logs out and logs back in", () => {
 // Assume user logs out and logs back in
});

Then("the product remains in the cart after re-login", () => {
 ShoppingCartPage.verifyCartPersistence();
});

When("the user attempts to add the same product multiple times", () => {
 ProductPage.addSameProductMultipleTimes();
});

Then("the product quantity in the cart increases accordingly", () => {
 ShoppingCartPage.verifyProductQuantityIncrease();
});

Given("the user is on a different product page", () => {
 ProductPage.visitDifferentProductPage();
});

When("the user adds another product to the cart", () => {
 ProductPage.addAnotherProductToCart();
});

Then("both products are present in the cart with correct details", () => {
 ShoppingCartPage.verifyMultipleProductsInCart();
});

When("the user removes the product from the cart", () => {
 ShoppingCartPage.removeProductFromCart();
});

Then("the product is successfully removed from the cart", () => {
 ShoppingCartPage.verifyProductRemoved();
});

Given("the product is removed from the shopping cart", () => {
 // Assume product is removed
});

Then("the cart is empty and displays a message indicating no items", () => {
 ShoppingCartPage.verifyCartIsEmpty();
});

Given("the user is on the shopping cart page", () => {
 ShoppingCartPage.verifyOnShoppingCartPage();
});

When("a product is added or removed", () => {
 ShoppingCartPage.simulateCartUpdate();
});

Then("the cart updates in real-time with accurate product details", () => {
 ShoppingCartPage.verifyRealTimeCartUpdates();
});

Given("the user is not logged into the application", () => {
 // Assume user is not logged in
});

When("the user attempts to add a product to the cart", () => {
 ProductPage.attemptAddToCartWhileLoggedOut();
});

Then("the user is prompted to log in before adding products to the cart", () => {
 ProductPage.verifyLoginPrompt();
});

Given("the user is on the product page with a discount applied", () => {
 ProductPage.verifyDiscountApplied();
});

When("the user adds the product to the cart", () => {
 ProductPage.addProductWithDiscountToCart();
});

Then("the discounted price is reflected correctly in the cart", () => {
 ShoppingCartPage.verifyDiscountedPrice();
});

Given("products are added to the shopping cart", () => {
 // Assume products are added
});

Then("the cart icon displays the correct number of items", () => {
 ShoppingCartPage.verifyCartIconItemCount();
});