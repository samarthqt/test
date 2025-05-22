import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderPage from "../pages/orderPage";

Given("a customer has purchased an Achieve access code", () => {
 // Assume customer data setup
});

Given("the purchase was made more than 14 days ago", () => {
 // Assume purchase date setup
});

When("the customer logs in to the BFW store with their account", () => {
 OrderPage.login();
});

Then("the customer's account dashboard is displayed", () => {
 OrderPage.verifyDashboard();
});

Then("the Order ID is 87654", () => {
 OrderPage.verifyOrderID("87654");
});

When("the customer navigates to the 'Order Details' section", () => {
 OrderPage.navigateToOrderDetails();
});

Then("order details are displayed with a list of recent purchases", () => {
 OrderPage.verifyOrderDetails();
});

Then("the Customer Email is customer@example.com", () => {
 OrderPage.verifyCustomerEmail("customer@example.com");
});

When("the customer selects the order with ID 87654", () => {
 OrderPage.selectOrder("87654");
});

Then("order details for order ID 87654 are displayed", () => {
 OrderPage.verifySelectedOrderDetails("87654");
});

Then("the Access Code is ACH54321", () => {
 OrderPage.verifyAccessCode("ACH54321");
});

When("the customer attempts to click on the 'Initiate Return' button for the Achieve access code", () => {
 OrderPage.attemptInitiateReturn();
});

Then("the 'Initiate Return' button is disabled or not present", () => {
 OrderPage.verifyInitiateReturnDisabled();
});

Then("the Purchase Date is 20 days ago", () => {
 OrderPage.verifyPurchaseDate("20 days ago");
});

Then("the system does not allow return initiation", () => {
 OrderPage.verifyReturnNotAllowed();
});

Then("the customer is notified that the return period has expired", () => {
 OrderPage.verifyReturnPeriodExpiredNotification();
});