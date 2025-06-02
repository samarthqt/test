import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountPage from "../pages/accountPage";
import OrderHistoryPage from "../pages/orderHistoryPage";
import OrderDetailsPage from "../pages/orderDetailsPage";
import CustomerSupportPage from "../pages/customerSupportPage";

Given("the user has a valid account with User ID 78911", () => {
  // Assume user data is set up in fixtures or environment variables
});

When("the user logs in to the account", () => {
  AccountPage.login();
});

Then("the user is successfully logged in and navigated to the account dashboard", () => {
  AccountPage.verifyDashboard();
});

Given("the user is on the account dashboard", () => {
  AccountPage.verifyDashboard();
});

When("the user navigates to the 'Order History' section", () => {
  AccountPage.goToOrderHistory();
});

Then("the order history page is displayed with a list of past orders", () => {
  OrderHistoryPage.verifyOrderList();
});

Given("the user is on the order history page", () => {
  OrderHistoryPage.verifyOrderList();
});

When("the user selects the order with Order ID 123457", () => {
  OrderHistoryPage.selectOrderById('123457');
});

Then("the order details page is displayed for Order ID 123457", () => {
  OrderDetailsPage.verifyOrderDetails('123457');
});

Given("the user is on the order details page for Order ID 123457", () => {
  OrderDetailsPage.verifyOrderDetails('123457');
});

When("the user checks the expected and actual delivery dates", () => {
  OrderDetailsPage.checkDeliveryDates();
});

Then("the expected delivery date is 2023-06-01 and actual delivery date is 2023-06-05", () => {
  OrderDetailsPage.verifyDeliveryDates('2023-06-01', '2023-06-05');
});

Given("the user is aware of the delivery delay", () => {
  // Assume delay notification is acknowledged
});

When("the user checks for notifications", () => {
  OrderDetailsPage.checkNotifications();
});

Then("a notification is received informing the user of the delivery delay", () => {
  OrderDetailsPage.verifyDelayNotification();
});

Given("the user has received a delivery delay notification", () => {
  OrderDetailsPage.verifyDelayNotification();
});

When("the user checks for compensation or alternative options", () => {
  OrderDetailsPage.checkCompensationOptions();
});

Then("the system provides options for compensation or alternative delivery arrangements", () => {
  OrderDetailsPage.verifyCompensationOptions();
});

Given("the user is on the order details page", () => {
  OrderDetailsPage.verifyOrderDetails('123457');
});

When("the user navigates to the customer support section", () => {
  OrderDetailsPage.goToCustomerSupport();
});

Then("customer support contact information is displayed", () => {
  CustomerSupportPage.verifyContactInformation();
});

Given("the user has customer support contact information", () => {
  CustomerSupportPage.verifyContactInformation();
});

When("the user attempts to contact customer support via provided options", () => {
  CustomerSupportPage.contactSupport();
});

Then("customer support is contacted successfully", () => {
  CustomerSupportPage.verifyContactSuccess();
});

When("the user checks for email notifications", () => {
  OrderDetailsPage.checkEmailNotifications();
});

Then("an email notification is received stating the delay and its status", () => {
  OrderDetailsPage.verifyEmailDelayNotification();
});

When("the user checks the order status after the delivery delay", () => {
  OrderDetailsPage.checkOrderStatus();
});

Then("the order status remains unchanged as 'Processing' or 'Delayed'", () => {
  OrderDetailsPage.verifyOrderStatus(['Processing', 'Delayed']);
});

Given("the user has access to system logs", () => {
  // Assume access to logs is granted
});

When("the user reviews any system logs related to the delivery delay", () => {
  OrderDetailsPage.reviewSystemLogs();
});

Then("system logs indicate the delivery delay and any actions taken", () => {
  OrderDetailsPage.verifySystemLogs();
});

Given("the user is logged in to the account", () => {
  AccountPage.verifyLogin();
});

When("the user checks the account details", () => {
  AccountPage.checkAccountDetails();
});

Then("user account details remain unchanged and secure", () => {
  AccountPage.verifyAccountSecurity();
});

Given("the order is still in progress", () => {
  OrderDetailsPage.verifyOrderInProgress();
});

When("the user checks for any refund processes", () => {
  OrderDetailsPage.checkRefundProcesses();
});

Then("no refund process is initiated", () => {
  OrderDetailsPage.verifyNoRefundInitiated();
});

Given("the order delivery is delayed", () => {
  OrderDetailsPage.verifyOrderDelayed();
});

When("the user attempts to track the order delivery status", () => {
  OrderDetailsPage.trackOrderStatus();
});

Then("tracking information is updated to reflect the delay and new expected delivery date", () => {
  OrderDetailsPage.verifyTrackingUpdate();
});

When("the user checks the system's response time", () => {
  OrderDetailsPage.checkSystemResponseTime();
});

Then("the system responds promptly to the delivery delay with appropriate feedback", () => {
  OrderDetailsPage.verifyPromptResponse();
});