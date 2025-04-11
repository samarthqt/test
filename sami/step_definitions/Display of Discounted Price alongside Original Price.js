import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import PricingPage from '../pageObjects/PricingPage';

const pricingPage = new PricingPage();

Given('I am on the product pricing page', () => {
  pricingPage.visitPricingPage();
});

Given('a product has an original price of {string}', (price) => {
  pricingPage.setOriginalPrice(price);
});

Given('the product has a discount of {string}', (discount) => {
  pricingPage.setDiscount(discount);
});

Given('the product has no discount', () => {
  pricingPage.setNoDiscount();
});

Given('the following products exist:', (dataTable) => {
  pricingPage.setMultipleProducts(dataTable.hashes());
});

Given('a product has an invalid discount of {string}', (invalidDiscount) => {
  pricingPage.setInvalidDiscount(invalidDiscount);
});

When('I view the product pricing details', () => {
  pricingPage.viewPricingDetails();
});

When('I calculate the discounted price', () => {
  pricingPage.calculateDiscountedPrice();
});

Then('I should see the original price displayed as {string}', (originalPrice) => {
  pricingPage.verifyOriginalPrice(originalPrice);
});

Then('I should see the discounted price displayed as {string}', (discountedPrice) => {
  pricingPage.verifyDiscountedPrice(discountedPrice);
});

Then('I should not see any discounted price displayed', () => {
  pricingPage.verifyNoDiscountedPrice();
});

Then('I should see the original price for {string} displayed as {string}', (productName, originalPrice) => {
  pricingPage.verifyProductOriginalPrice(productName, originalPrice);
});

Then('I should see the discounted price for {string} displayed as {string}', (productName, discountedPrice) => {
  pricingPage.verifyProductDiscountedPrice(productName, discountedPrice);
});

Then('the discounted price should be calculated as {string}', (calculatedPrice) => {
  pricingPage.verifyCalculatedDiscountedPrice(calculatedPrice);
});

Then('I should see a message indicating {string}', (message) => {
  pricingPage.verifyInvalidDiscountMessage(message);
});