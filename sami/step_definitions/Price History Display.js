import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ProductPage from '../pageObjects/ProductPage';

const productPage = new ProductPage();

Given('the user is on the product pricing page', () => {
  productPage.visitProductPricingPage();
});

Given('the user selects a product', () => {
  productPage.selectProduct();
});

Given('the user selects a product with no price history', () => {
  productPage.selectProductWithNoHistory();
});

When('the user requests the price history', () => {
  productPage.requestPriceHistory();
});

When('the price history is displayed', () => {
  productPage.verifyPriceHistoryDisplayed();
});

When('the user requests price history for multiple products', () => {
  productPage.requestMultipleProductsPriceHistory();
});

Then('the system should display the historical pricing of the selected product', () => {
  productPage.verifyHistoricalPricingDisplayed();
});

Then('the historical pricing should be shown in a chronological order', () => {
  productPage.verifyChronologicalOrder();
});

Then('each entry should include the date and price', () => {
  productPage.verifyDateAndPriceInEntries();
});

Then('the user should be able to identify periods of discounts', () => {
  productPage.identifyDiscountPeriods();
});

Then('the system should display the historical pricing for each selected product', () => {
  productPage.verifyMultipleProductsHistoricalPricing();
});

Then('the system should inform the user that no historical pricing is available', () => {
  productPage.verifyNoHistoricalPricingMessage();
});

Then('the system should provide the historical pricing data with low priority', () => {
  productPage.verifyLowPriorityData();
});

Then('the system performance should not be impacted', () => {
  productPage.verifySystemPerformance();
});