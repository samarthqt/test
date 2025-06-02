import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";

Given("I navigate to the product page with ID {int}", (productId) => {
 ProductPage.visit(productId);
});

Then("the product page loads successfully", () => {
 ProductPage.verifyPageLoad();
});

Then("I verify the initial stock availability is displayed as {int} units", (stock) => {
 ProductPage.verifyStockAvailability(stock);
});

Given("I am on the product page with ID {int}", (productId) => {
 ProductPage.visit(productId);
});

When("I simulate a purchase to reduce stock by {int} units", (units) => {
 ProductPage.simulatePurchase(units);
});

Then("the purchase is successful", () => {
 ProductPage.verifyPurchaseSuccess();
});

Then("the stock is updated", () => {
 ProductPage.verifyStockUpdate();
});

When("I refresh the product page", () => {
 ProductPage.refreshPage();
});

Then("the updated stock of {int} units is displayed correctly", (stock) => {
 ProductPage.verifyStockAvailability(stock);
});

Given("the stock has been updated to {int} units", (stock) => {
 ProductPage.verifyStockUpdate(stock);
});

Then("the inventory management system reflects the updated stock correctly", () => {
 ProductPage.verifyInventorySystemUpdate();
});

When("I check the stock updates on different browsers", () => {
 ProductPage.verifyStockOnDifferentBrowsers();
});

Then("the stock updates are consistent across all browsers", () => {
 ProductPage.verifyConsistencyAcrossBrowsers();
});

When("I check the stock updates on mobile devices", () => {
 ProductPage.verifyStockOnMobileDevices();
});

Then("the stock updates are displayed correctly on mobile", () => {
 ProductPage.verifyMobileStockDisplay();
});

Then("the database entry matches the updated stock", () => {
 ProductPage.verifyDatabaseEntry();
});

Given("the product page is experiencing high traffic", () => {
 ProductPage.simulateHighTraffic();
});

Then("the stock updates remain consistent without delays", () => {
 ProductPage.verifyNoDelayInUpdates();
});

Then("no unexpected notifications are triggered", () => {
 ProductPage.verifyNoUnexpectedNotifications();
});

Given("there is network latency", () => {
 ProductPage.simulateNetworkLatency();
});

Then("the stock updates are displayed correctly despite network latency", () => {
 ProductPage.verifyStockWithLatency();
});

Given("the product details have been updated", () => {
 ProductPage.updateProductDetails();
});

Then("the stock remains updated correctly after product updates", () => {
 ProductPage.verifyStockAfterProductUpdate();
});

Given("I am at the checkout process", () => {
 ProductPage.navigateToCheckout();
});

Then("the checkout process reflects the updated stock correctly", () => {
 ProductPage.verifyCheckoutStock();
});

Given("I change the purchase quantity", () => {
 ProductPage.changePurchaseQuantity();
});

Then("the stock updates are displayed correctly with various quantities", () => {
 ProductPage.verifyStockWithVariousQuantities();
});

Then("the audit logs show stock updates with timestamp and user ID", () => {
 ProductPage.verifyAuditLogs();
});