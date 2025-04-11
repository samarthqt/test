const { Given, When, Then } = require('cypress-cucumber-preprocessor/steps');
const ProductPage = require('../../pageObjects/ProductPage');

Given('the user is on the product page', () => {
  ProductPage.visitProductPage();
});

When('the user selects a product', () => {
  ProductPage.selectProduct();
});

When('the user clicks on the "Add to Cart" button', () => {
  ProductPage.clickAddToCart();
});

Then('the product should be added to the shopping cart', () => {
  ProductPage.verifyProductAddedToCart();
});

Then('the cart icon should display the correct number of items', () => {
  ProductPage.verifyCartItemCount();
});

When('the user selects multiple products', () => {
  ProductPage.selectMultipleProducts();
});

When('the user clicks on the "Add to Cart" button for each product', () => {
  ProductPage.clickAddToCartForMultipleProducts();
});

Then('all selected products should be added to the shopping cart', () => {
  ProductPage.verifyMultipleProductsAddedToCart();
});

Given('the product has multiple options', () => {
  ProductPage.verifyProductOptionsExist();
});

When('the user tries to add the product to the cart without selecting options', () => {
  ProductPage.tryAddToCartWithoutOptions();
});

Then('the user should be prompted to select the required options', () => {
  ProductPage.verifyOptionsPrompt();
});

When('the user adds a product to the cart', () => {
  ProductPage.addProductToCart();
});

When('the user clicks on the "View Cart" button', () => {
  ProductPage.clickViewCart();
});

Then('the user should be navigated to the shopping cart page', () => {
  ProductPage.verifyNavigationToCartPage();
});

Then('the added product should be displayed in the cart', () => {
  ProductPage.verifyProductDisplayedInCart();
});

Given('the product is out of stock', () => {
  ProductPage.verifyProductOutOfStock();
});

When('the user tries to add the product to the cart', () => {
  ProductPage.tryAddOutOfStockProductToCart();
});

Then('the user should receive a notification that the product is out of stock', () => {
  ProductPage.verifyOutOfStockNotification();
});

Then('the product should not be added to the cart', () => {
  ProductPage.verifyProductNotAddedToCart();
});

Given('the user has products in the cart', () => {
  ProductPage.verifyProductsInCart();
});

When('the user decides to remove a product', () => {
  ProductPage.removeProductFromCart();
});

When('the user clicks on the "Remove" button next to the product', () => {
  ProductPage.clickRemoveProduct();
});

Then('the product should be removed from the shopping cart', () => {
  ProductPage.verifyProductRemovedFromCart();
});

Then('the cart icon should update to reflect the correct number of items', () => {
  ProductPage.verifyCartItemCountAfterRemoval();
});

Given('the user has a product in the cart', () => {
  ProductPage.verifySingleProductInCart();
});

When('the user updates the quantity of the product', () => {
  ProductPage.updateProductQuantity();
});

Then('the cart should reflect the updated quantity', () => {
  ProductPage.verifyUpdatedQuantityInCart();
});

Then('the total price should be recalculated based on the updated quantity', () => {
  ProductPage.verifyTotalPriceRecalculated();
});