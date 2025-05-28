import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("the user is logged into their account", () => {
 // Assume user login functionality is handled elsewhere
});

Given("the user navigates to the Order History page", () => {
 OrderHistoryPage.visit();
});

When("the page loads successfully", () => {
 OrderHistoryPage.verifyPageLoad();
});

Then("the user should see a list of their past orders", () => {
 OrderHistoryPage.verifyOrderListVisible();
});

Given("the user is on the Order History page", () => {
 OrderHistoryPage.visit();
});

When("the user selects an order from the list", () => {
 OrderHistoryPage.selectOrder();
});

Then("the user should see the details of the selected order including the invoice", () => {
 OrderHistoryPage.verifyOrderDetails();
});

Given("the user has no past orders", () => {
 OrderHistoryPage.setNoOrders();
});

Then("the user should see a message indicating that there are no past orders available", () => {
 OrderHistoryPage.verifyNoOrdersMessage();
});

Given("the user has more orders than can fit on one page", () => {
 OrderHistoryPage.setMultiplePages();
});

When("the user navigates through the pages", () => {
 OrderHistoryPage.navigatePages();
});

Then("the user should be able to view all their past orders across multiple pages", () => {
 OrderHistoryPage.verifyAllOrdersVisible();
});

When("the user applies a date filter", () => {
 OrderHistoryPage.applyDateFilter();
});

Then("the user should see orders that fall within the specified date range", () => {
 OrderHistoryPage.verifyFilteredOrdersVisible();
});

When("the user selects an order", () => {
 OrderHistoryPage.selectOrder();
});

And("the user chooses to download the invoice", () => {
 OrderHistoryPage.downloadInvoice();
});

Then("the invoice should be downloaded successfully", () => {
 OrderHistoryPage.verifyInvoiceDownloaded();
});