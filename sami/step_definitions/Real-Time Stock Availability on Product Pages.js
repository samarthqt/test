import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ProductPage from '../page_objects/ProductPage';

const productPage = new ProductPage();

Given('the user is on the product page', () => {
  productPage.visitProductPage();
});

When('the product page is loaded', () => {
  productPage.verifyPageLoaded();
});

Then('the system should display the current stock availability status of the product', () => {
  productPage.checkStockAvailability();
});

Given('the stock level of a product changes in the inventory', () => {
  productPage.simulateStockChange();
});

When('the product page is refreshed', () => {
  productPage.refreshPage();
});

Then('the system should display the updated stock availability status', () => {
  productPage.checkUpdatedStockAvailability();
});

Given('the stock level of a product is zero', () => {
  productPage.setStockLevelToZero();
});

Then('the system should display an "Out of Stock" message', () => {
  productPage.verifyOutOfStockMessage();
});

Given('the stock level of a product is less than the predefined threshold', () => {
  productPage.setStockLevelBelowThreshold();
});

Then('the system should display a "Limited Stock Available" message', () => {
  productPage.verifyLimitedStockMessage();
});

Given('the user adds a product to the cart', () => {
  productPage.addProductToCart();
});

When('the stock availability is checked', () => {
  productPage.checkStockAvailabilityInCart();
});

Then('the system should ensure the stock level is accurately reflected in the cart', () => {
  productPage.verifyStockInCart();
});

Given('the user is viewing a product with limited stock', () => {
  productPage.viewProductWithLimitedStock();
});

When('the stock level changes to zero', () => {
  productPage.simulateStockChangeToZero();
});

Then('the system should notify the user that the product is now out of stock', () => {
  productPage.verifyOutOfStockNotification();
});