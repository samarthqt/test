import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AdminDashboardPage from "../pages/adminDashboardPage";

Given("an admin is logged into the dashboard", () => {
  AdminDashboardPage.login();
});

When("the admin adds a new product", () => {
  AdminDashboardPage.addProduct();
});

Then("the product should be visible in the product list", () => {
  AdminDashboardPage.verifyProductInList();
});

When("the admin edits an existing product", () => {
  AdminDashboardPage.editProduct();
});

Then("the changes should be reflected in the product details", () => {
  AdminDashboardPage.verifyProductDetails();
});

When("the admin deletes a product", () => {
  AdminDashboardPage.deleteProduct();
});

Then("the product should be removed from the product list", () => {
  AdminDashboardPage.verifyProductRemoved();
});

When("the admin views the order list", () => {
  AdminDashboardPage.viewOrderList();
});

Then("the admin should see all orders with their statuses", () => {
  AdminDashboardPage.verifyOrderStatuses();
});

When("the admin updates an order status", () => {
  AdminDashboardPage.updateOrderStatus();
});

Then("the status change should be reflected in the order details", () => {
  AdminDashboardPage.verifyOrderStatusChange();
});

When("the admin deletes an order", () => {
  AdminDashboardPage.deleteOrder();
});

Then("the order should be removed from the order list", () => {
  AdminDashboardPage.verifyOrderRemoved();
});

When("a customer initiates a live chat", () => {
  AdminDashboardPage.initiateLiveChat();
});

Then("the admin should be able to respond to the customer", () => {
  AdminDashboardPage.respondToLiveChat();
});

When("a customer sends an email", () => {
  AdminDashboardPage.receiveEmail();
});

Then("the admin should be able to reply to the email", () => {
  AdminDashboardPage.replyToEmail();
});

When("the admin selects a different language", () => {
  AdminDashboardPage.selectLanguage();
});

Then("the dashboard should display in the selected language", () => {
  AdminDashboardPage.verifyLanguageChange();
});

When("the admin selects a different currency", () => {
  AdminDashboardPage.selectCurrency();
});

Then("the dashboard should display prices in the selected currency", () => {
  AdminDashboardPage.verifyCurrencyChange();
});

When("the admin accesses sensitive data", () => {
  AdminDashboardPage.accessSensitiveData();
});

Then("the data should be protected by security measures", () => {
  AdminDashboardPage.verifyDataProtection();
});

Given("an admin is performing operations on the dashboard", () => {
  AdminDashboardPage.performOperations();
});

When("an error occurs", () => {
  AdminDashboardPage.triggerError();
});

Then("the admin should receive an appropriate error message", () => {
  AdminDashboardPage.verifyErrorMessage();
});

When("an important change occurs", () => {
  AdminDashboardPage.triggerImportantChange();
});

Then("the admin should receive a notification", () => {
  AdminDashboardPage.verifyNotification();
});

Given("the dashboard is set up for testing", () => {
  AdminDashboardPage.setupForTesting();
});

When("tests are executed", () => {
  AdminDashboardPage.executeTests();
});

Then("all features should function as expected", () => {
  AdminDashboardPage.verifyAllFeatures();
});

When("the admin performs operations", () => {
  AdminDashboardPage.performAdminOperations();
});

Then("the operations should be logged for future reference", () => {
  AdminDashboardPage.verifyLogging();
});

Given("the admin dashboard is available", () => {
  AdminDashboardPage.dashboardAvailable();
});

When("an admin needs guidance", () => {
  AdminDashboardPage.requestGuidance();
});

Then("documentation should be provided for all functionalities", () => {
  AdminDashboardPage.verifyDocumentation();
});