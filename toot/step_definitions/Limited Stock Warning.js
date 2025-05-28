import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import InventoryPage from "../pages/inventoryPage";

Given("the product inventory system is operational", () => {
 InventoryPage.ensureSystemIsOperational();
});

Given("a product with a stock threshold set to {int} units", (threshold) => {
 InventoryPage.setProductThreshold(threshold);
});

Given("the current stock level is {int} units", (stockLevel) => {
 InventoryPage.setCurrentStockLevel(stockLevel);
});

Given("products with the following stock thresholds and current stock levels:", (dataTable) => {
 dataTable.hashes().forEach((row) => {
 InventoryPage.setProductStockLevels(row['Product ID'], row['Threshold'], row['Current Stock']);
 });
});

Given("a warning message is displayed", () => {
 InventoryPage.ensureWarningMessageIsDisplayed();
});

When("the inventory system checks the stock level", () => {
 InventoryPage.checkStockLevel();
});

When("the inventory system checks the stock levels", () => {
 InventoryPage.checkStockLevels();
});

When("the stock level is updated to {int} units", (newStockLevel) => {
 InventoryPage.updateStockLevel(newStockLevel);
});

Then("a warning message should be displayed indicating the stock is low", () => {
 InventoryPage.verifyWarningMessageDisplayed();
});

Then("no warning message should be displayed", () => {
 InventoryPage.verifyNoWarningMessageDisplayed();
});

Then("the warning message should be removed", () => {
 InventoryPage.verifyWarningMessageRemoved();
});

Then("a warning message should be displayed for Product ID {int} indicating the stock is low", (productId) => {
 InventoryPage.verifyWarningMessageDisplayedForProduct(productId);
});

Then("no warning message should be displayed for Product ID {int}", (productId) => {
 InventoryPage.verifyNoWarningMessageDisplayedForProduct(productId);
});