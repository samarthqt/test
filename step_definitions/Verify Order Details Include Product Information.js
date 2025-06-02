import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderPage from "../pages/orderPage";

Given("the user is logged into their account", () => {
 OrderPage.login();
});

When("the user navigates to the 'Order History' section", () => {
 OrderPage.navigateToOrderHistory();
});

When("the user selects an order to view detailed information", () => {
 OrderPage.selectOrder();
});

Then("the product names are listed in the order details", () => {
 OrderPage.verifyProductNames();
});

Then("the quantities for each product are displayed", () => {
 OrderPage.verifyProductQuantities();
});

Then("the prices for each product are displayed", () => {
 OrderPage.verifyProductPrices();
});

Then("the total cost of the order is displayed", () => {
 OrderPage.verifyTotalCost();
});

Then("any discounts or promotions applied to the order are displayed", () => {
 OrderPage.verifyDiscounts();
});

Then("the order details include tax information, if applicable", () => {
 OrderPage.verifyTaxInformation();
});

Then("a download or print option for the order details is available", () => {
 OrderPage.verifyDownloadOrPrintOption();
});

Then("product images are displayed alongside product details", () => {
 OrderPage.verifyProductImages();
});

Given("the user is not logged into their account", () => {
 OrderPage.logout();
});

When("the user attempts to view order details", () => {
 OrderPage.attemptToViewOrderDetails();
});

Then("the user is prompted to log in before viewing order details", () => {
 OrderPage.verifyLoginPrompt();
});

Given("the user has past orders with multiple quantities of products", () => {
 OrderPage.verifyPastOrdersWithMultipleQuantities();
});

Then("the total cost accurately reflects the quantities ordered", () => {
 OrderPage.verifyTotalCostAccuracy();
});

Given("the user has international orders", () => {
 OrderPage.verifyInternationalOrders();
});

Then("the currency is displayed correctly according to the user's location", () => {
 OrderPage.verifyCurrencyDisplay();
});

Given("the user is logged out of their account", () => {
 OrderPage.logout();
});

Then("the user is redirected to the login page", () => {
 OrderPage.verifyRedirectToLogin();
});