import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AdminDashboardPage from "../pages/adminDashboardPage";

Given("an admin is logged into the dashboard", () => {
 AdminDashboardPage.login();
});

When("the admin adds a new product with details like name, description, price, image, stock, and category", () => {
 AdminDashboardPage.addNewProduct();
});

Then("the product should be successfully added to the catalog", () => {
 AdminDashboardPage.verifyProductAdded();
});

Given("there is an existing product in the catalog", () => {
 AdminDashboardPage.verifyExistingProduct();
});

When("the admin edits the product details", () => {
 AdminDashboardPage.editProductDetails();
});

Then("the product details should be successfully updated", () => {
 AdminDashboardPage.verifyProductUpdated();
});

When("the admin deletes the product", () => {
 AdminDashboardPage.deleteProduct();
});

Then("the product should be successfully removed from the catalog", () => {
 AdminDashboardPage.verifyProductDeleted();
});

When("the admin views all orders", () => {
 AdminDashboardPage.viewAllOrders();
});

Then("the admin should see details like order number, customer info, and status for each order", () => {
 AdminDashboardPage.verifyOrderDetails();
});

Given("there is an existing order", () => {
 AdminDashboardPage.verifyExistingOrder();
});

When("the admin processes the order and updates its status", () => {
 AdminDashboardPage.processOrder();
});

Then("the order status should be successfully updated", () => {
 AdminDashboardPage.verifyOrderStatusUpdated();
});

Given("an admin is entering product or order details", () => {
 AdminDashboardPage.enterProductOrOrderDetails();
});

When("the admin provides invalid inputs", () => {
 AdminDashboardPage.provideInvalidInputs();
});

Then("the system should display appropriate error messages", () => {
 AdminDashboardPage.verifyErrorMessages();
});

Given("an admin performs actions like adding, editing, or deleting products", () => {
 AdminDashboardPage.performAdminActions();
});

When("the actions are completed", () => {
 AdminDashboardPage.completeActions();
});

Then("the system should log these actions for auditing purposes", () => {
 AdminDashboardPage.verifyActionsLogged();
});

Given("there is a new order placed", () => {
 AdminDashboardPage.verifyNewOrder();
});

When("the order is processed by the system", () => {
 AdminDashboardPage.processOrderBySystem();
});

Then("the admin should receive a notification about the new order", () => {
 AdminDashboardPage.verifyOrderNotification();
});

Given("a product's stock reaches a predefined threshold", () => {
 AdminDashboardPage.verifyStockThreshold();
});

When("the system checks the stock levels", () => {
 AdminDashboardPage.checkStockLevels();
});

Then("the admin should receive a stock alert notification", () => {
 AdminDashboardPage.verifyStockAlert();
});

Given("a user attempts to access the admin dashboard", () => {
 AdminDashboardPage.attemptAccessDashboard();
});

When("the user is not authorized", () => {
 AdminDashboardPage.verifyUserNotAuthorized();
});

Then("the user should be denied access to the dashboard", () => {
 AdminDashboardPage.verifyAccessDenied();
});

Given("an authorized admin user", () => {
 AdminDashboardPage.verifyAuthorizedUser();
});

When("the admin logs into the dashboard", () => {
 AdminDashboardPage.login();
});

Then("the admin should be granted access to the dashboard", () => {
 AdminDashboardPage.verifyAccessGranted();
});