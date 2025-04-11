import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import OrderManagementPage from '../page-objects/OrderManagementPage';

const orderManagementPage = new OrderManagementPage();

Given('a user is logged into the order management system', () => {
  orderManagementPage.login();
});

When('the user navigates to the past orders section', () => {
  orderManagementPage.goToPastOrders();
});

Then('the user should see a list of their past orders', () => {
  orderManagementPage.verifyPastOrdersList();
});

Then('each order should display the order status and payment details', () => {
  orderManagementPage.verifyOrderDetails();
});

Given('a user has placed an order', () => {
  orderManagementPage.placeOrder();
});

When('the user navigates to the order details page', () => {
  orderManagementPage.goToOrderDetails();
});

Then('the user should be able to track the delivery status of the order', () => {
  orderManagementPage.verifyDeliveryStatus();
});

Then('the delivery status should be updated on both the website and mobile app', () => {
  orderManagementPage.verifyDeliveryStatusUpdate();
});

Given('the order is eligible for cancellation', () => {
  orderManagementPage.checkOrderEligibilityForCancellation();
});

When('the user selects the cancel option for the order', () => {
  orderManagementPage.cancelOrder();
});

Then('the order should be successfully canceled', () => {
  orderManagementPage.verifyOrderCancellation();
});

Then('the user should receive a notification of the order status change', () => {
  orderManagementPage.verifyOrderStatusChangeNotification();
});

Given('a user has received an order', () => {
  orderManagementPage.receiveOrder();
});

Given('the order is eligible for return based on the merchant's return policy', () => {
  orderManagementPage.checkOrderEligibilityForReturn();
});

When('the user selects the request return option for the order', () => {
  orderManagementPage.requestReturn();
});

Then('the return request should be successfully placed', () => {
  orderManagementPage.verifyReturnRequest();
});

Then('the user should receive a notification of the return status change', () => {
  orderManagementPage.verifyReturnStatusChangeNotification();
});

Given('a user attempts to perform an invalid operation on an order', () => {
  orderManagementPage.attemptInvalidOperation();
});

When('the system detects the invalid operation', () => {
  orderManagementPage.detectInvalidOperation();
});

Then('an error message should be displayed to the user', () => {
  orderManagementPage.verifyErrorMessage();
});

Given('a user performs any order management operation', () => {
  orderManagementPage.performOrderManagementOperation();
});

When('the operation is completed', () => {
  orderManagementPage.completeOperation();
});

Then('the system should log the details of the operation for tracking purposes', () => {
  orderManagementPage.verifyOperationLogging();
});