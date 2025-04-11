const { Given, When, Then } = require('cypress-cucumber-preprocessor/steps');
const ProductPage = require('../../pageObjects/ProductPage');

Given('I am on the product page', () => {
  ProductPage.visitProductPage();
});

When('I click on the "Add to Cart" button', () => {
  ProductPage.clickAddToCart();
});

Then('the product should be added to the shopping cart', () => {
  ProductPage.verifyProductAddedToCart();
});

Then('I should see a confirmation message "Product added to your cart."', () => {
  ProductPage.verifyConfirmationMessage();
});

Given('I am on the product page of {string}', (productName) => {
  ProductPage.visitProductPage(productName);
});

When('I navigate to the product page of {string}', (productName) => {
  ProductPage.visitProductPage(productName);
});

Then('both products should be present in the shopping cart', () => {
  ProductPage.verifyMultipleProductsInCart();
});

When('I click on the "Add to Cart" button again', () => {
  ProductPage.clickAddToCart();
});

Then('the product quantity in the shopping cart should be updated to 2', () => {
  ProductPage.verifyProductQuantityInCart(2);
});

Given('I am not logged into the website', () => {
  ProductPage.verifyNotLoggedIn();
});

Then('I should be prompted to log in or register', () => {
  ProductPage.verifyLoginPrompt();
});

Then('the product should be added to the cart after successful login', () => {
  ProductPage.verifyProductAddedAfterLogin();
});

Given('I am on the product page of an out-of-stock product', () => {
  ProductPage.visitOutOfStockProductPage();
});

Then('I should see a message "This product is currently out of stock."', () => {
  ProductPage.verifyOutOfStockMessage();
});

Then('the product should not be added to the shopping cart', () => {
  ProductPage.verifyProductNotAddedToCart();
});