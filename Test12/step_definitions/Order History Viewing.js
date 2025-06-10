import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("the user is logged into their account", () => {
 // Logic to ensure user is logged in
});

When("the user navigates to the order history page", () => {
 OrderHistoryPage.navigateToOrderHistory();
});

Then("the user should see a list of their past orders", () => {
 OrderHistoryPage.verifyOrderListVisible();
});

Given("the user is on the order history page", () => {
 OrderHistoryPage.verifyOnOrderHistoryPage();
});

When("the user selects an order from the list", () => {
 OrderHistoryPage.selectOrderFromList();
});

Then("the user should see the order status, payment method, and transaction date", () => {
 OrderHistoryPage.verifyOrderDetails();
});

When("the user filters orders by a specific date range", () => {
 OrderHistoryPage.filterOrdersByDate();
});

Then("the user should see orders within that date range", () => {
 OrderHistoryPage.verifyFilteredOrdersByDate();
});

When("the user filters orders by a specific status", () => {
 OrderHistoryPage.filterOrdersByStatus();
});

Then("the user should see orders with that status", () => {
 OrderHistoryPage.verifyFilteredOrdersByStatus();
});

When("the user selects an order for detailed view", () => {
 OrderHistoryPage.selectOrderForDetailedView();
});

Then("the user should see detailed information for that order", () => {
 OrderHistoryPage.verifyDetailedOrderInfo();
});

Given("the user is using a web browser", () => {
 // Logic to ensure user is on a web browser
});

When("the user logs into their account and navigates to the order history page", () => {
 // Logic to log in and navigate to order history page
});

Then("the user should see their order history", () => {
 OrderHistoryPage.verifyOrderHistoryVisible();
});

Given("the user is using a mobile device", () => {
 // Logic to ensure user is on a mobile device
});
