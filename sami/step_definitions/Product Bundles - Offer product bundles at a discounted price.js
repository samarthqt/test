const { Given, When, Then } = require('cypress-cucumber-preprocessor/steps');
const ProductBundlesPage = require('../../support/pageObjects/ProductBundlesPage');

Given('the user is on the product bundles page', () => {
  ProductBundlesPage.visit();
});

When('the user navigates to the product bundles section', () => {
  ProductBundlesPage.navigateToBundlesSection();
});

Then('the system should display a list of available product bundles', () => {
  ProductBundlesPage.verifyBundlesListDisplayed();
});

Given('a list of available product bundles is displayed', () => {
  ProductBundlesPage.verifyBundlesListDisplayed();
});

When('the user selects a product bundle', () => {
  ProductBundlesPage.selectProductBundle();
});

Then('the system should display the details of the selected product bundle', () => {
  ProductBundlesPage.verifyBundleDetailsDisplayed();
});

Then('the details should include the original price, discounted price, and items included in the bundle', () => {
  ProductBundlesPage.verifyBundleDetailsContent();
});

When('the user selects a product bundle and adds it to the cart', () => {
  ProductBundlesPage.addBundleToCart();
});

Then('the product bundle should be added to the cart', () => {
  ProductBundlesPage.verifyBundleAddedToCart();
});

Then('the cart should display the discounted price of the product bundle', () => {
  ProductBundlesPage.verifyCartDiscountedPrice();
});

Given('a product bundle is added to the cart', () => {
  ProductBundlesPage.verifyBundleAddedToCart();
});

When('the user removes the product bundle from the cart', () => {
  ProductBundlesPage.removeBundleFromCart();
});

Then('the product bundle should be removed from the cart', () => {
  ProductBundlesPage.verifyBundleRemovedFromCart();
});

Then('the cart should update to reflect the removal', () => {
  ProductBundlesPage.verifyCartUpdatedAfterRemoval();
});

When('the user proceeds to checkout', () => {
  ProductBundlesPage.proceedToCheckout();
});

Then('the checkout page should display the product bundle with the discounted price', () => {
  ProductBundlesPage.verifyCheckoutBundleDisplayed();
});

Then('the total price should reflect the discount applied to the product bundle', () => {
  ProductBundlesPage.verifyCheckoutTotalPrice();
});

When('the user verifies the cart total', () => {
  ProductBundlesPage.verifyCartTotal();
});

Then('the total should correctly reflect the sum of the discounted prices of all product bundles in the cart', () => {
  ProductBundlesPage.verifyCartTotalDiscountedPrices();
});

Given('there are no product bundles available', () => {
  ProductBundlesPage.verifyNoBundlesAvailable();
});

Then('the system should display a message indicating that no product bundles are currently available', () => {
  ProductBundlesPage.verifyNoBundlesMessageDisplayed();
});