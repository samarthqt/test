import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import InventoryPage from '../../support/pageObjects/InventoryPage';

const inventoryPage = new InventoryPage();

Given('the product inventory system is operational', () => {
  inventoryPage.verifySystemOperational();
});

Given('a product with a stock threshold set to {int} units', (threshold) => {
  inventoryPage.setProductThreshold(threshold);
});

Given('the current stock level is {int} units', (stockLevel) => {
  inventoryPage.setCurrentStockLevel(stockLevel);
});

When('the inventory system checks the stock level', () => {
  inventoryPage.checkStockLevel();
});

Then('a warning message should be displayed indicating the stock is low', () => {
  inventoryPage.verifyWarningMessageDisplayed();
});

Then('no warning message should be displayed', () => {
  inventoryPage.verifyNoWarningMessage();
});

Given('a warning message is displayed', () => {
  inventoryPage.ensureWarningMessageDisplayed();
});

When('the stock level is updated to {int} units', (newStockLevel) => {
  inventoryPage.updateStockLevel(newStockLevel);
});

Then('the warning message should be removed', () => {
  inventoryPage.verifyWarningMessageRemoved();
});

Given('products with the following stock thresholds and current stock levels:', (dataTable) => {
  inventoryPage.setMultipleProducts(dataTable.hashes());
});

When('the inventory system checks the stock levels', () => {
  inventoryPage.checkMultipleStockLevels();
});

Then('a warning message should be displayed for Product ID {int} indicating the stock is low', (productId) => {
  inventoryPage.verifyWarningForProduct(productId);
});

Then('no warning message should be displayed for Product ID {int}', (productId) => {
  inventoryPage.verifyNoWarningForProduct(productId);
});