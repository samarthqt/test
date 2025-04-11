const { Given, When, Then } = require('cypress-cucumber-preprocessor/steps');
const productPricingPage = require('../../pageObjects/ProductPricingPage');

Given('a user is on the product pricing page', () => {
  productPricingPage.visit();
});

Given('a product with a known price history', () => {
  productPricingPage.selectProductWithPriceHistory();
});

Given('a product has had price changes over time', () => {
  productPricingPage.selectProductWithPriceChanges();
});

Given('a product with no recorded price history', () => {
  productPricingPage.selectProductWithoutPriceHistory();
});

Given('a user with accessibility needs', () => {
  productPricingPage.enableAccessibilityFeatures();
});

When('the user views the product details', () => {
  productPricingPage.viewProductDetails();
});

When('the user views the price history', () => {
  productPricingPage.viewPriceHistory();
});

When('the user interacts with the price history graph or list', () => {
  productPricingPage.interactWithPriceHistory();
});

When('the user accesses the price history feature', () => {
  productPricingPage.accessPriceHistoryFeature();
});

When('the user applies a date range filter', () => {
  productPricingPage.applyDateRangeFilter();
});

Then('the price history of the product should be displayed', () => {
  productPricingPage.verifyPriceHistoryDisplayed();
});

Then('the user should be able to see historical prices and dates', () => {
  productPricingPage.verifyHistoricalPricesAndDates();
});

Then('the user should be able to identify periods of discounts', () => {
  productPricingPage.verifyDiscountPeriods();
});

Then('a message should be displayed stating "No price history available"', () => {
  productPricingPage.verifyNoPriceHistoryMessage();
});

Then('the price history should be displayed in a chronological order', () => {
  productPricingPage.verifyChronologicalOrderDisplay();
});

Then('each entry should show the date and price', () => {
  productPricingPage.verifyDateAndPriceEntries();
});

Then('the user should be able to hover over points to see exact prices and dates', () => {
  productPricingPage.verifyHoverDetails();
});

Then('the feature should be compatible with screen readers', () => {
  productPricingPage.verifyScreenReaderCompatibility();
});

Then('all elements should have appropriate labels for accessibility', () => {
  productPricingPage.verifyAccessibilityLabels();
});

Then('only the price history within the selected date range should be displayed', () => {
  productPricingPage.verifyFilteredPriceHistory();
});