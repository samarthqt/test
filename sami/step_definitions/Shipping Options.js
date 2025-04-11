import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import CheckoutPage from '../pageObjects/CheckoutPage';

const checkoutPage = new CheckoutPage();

Given('I am on the checkout page', () => {
  checkoutPage.visitCheckoutPage();
});

When('I enter my delivery location as {string}', (location) => {
  checkoutPage.enterDeliveryLocation(location);
});

Then('I should see the following shipping options:', (dataTable) => {
  dataTable.hashes().forEach(row => {
    checkoutPage.verifyShippingOption(row['Option Name'], row['Delivery Speed'], row['Availability']);
  });
  checkoutPage.verifyOptionsSortedBySpeed();
});

Given('I have entered my delivery location as {string}', (location) => {
  checkoutPage.enterDeliveryLocation(location);
});

When('I choose {string}', (shippingOption) => {
  checkoutPage.selectShippingOption(shippingOption);
});

Then('the selected shipping option should be {string}', (expectedOption) => {
  checkoutPage.verifySelectedShippingOption(expectedOption);
});

Then('the estimated delivery date should be updated accordingly', () => {
  checkoutPage.verifyEstimatedDeliveryDate();
});

Then('I should see a message indicating {string}', (message) => {
  checkoutPage.verifyUnavailableMessage(message);
});

Then('I should only see the following available options:', (dataTable) => {
  dataTable.hashes().forEach(row => {
    checkoutPage.verifyAvailableOption(row['Option Name'], row['Delivery Speed']);
  });
});

Then('the shipping cost should be calculated based on the selected option', () => {
  checkoutPage.verifyShippingCostCalculation();
});

Then('the total cost should reflect the added shipping cost', () => {
  checkoutPage.verifyTotalCostWithShipping();
});

When('I proceed to checkout without selecting a shipping option', () => {
  checkoutPage.proceedToCheckoutWithoutSelection();
});

Then('{string} should be selected by default', (defaultOption) => {
  checkoutPage.verifyDefaultShippingSelection(defaultOption);
});