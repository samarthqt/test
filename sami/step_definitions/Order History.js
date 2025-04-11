import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import OrderHistoryPage from '../pageObjects/OrderHistoryPage';

const orderHistoryPage = new OrderHistoryPage();

Given('the user is logged into their account', () => {
  // Implement login functionality here
});

Given('the user navigates to the Order History page', () => {
  orderHistoryPage.navigateToOrderHistory();
});

When('the page loads successfully', () => {
  orderHistoryPage.verifyPageLoad();
});

Then('the user should see a list of their past orders', () => {
  orderHistoryPage.verifyPastOrdersList();
});

Given('the user is on the Order History page', () => {
  orderHistoryPage.verifyOnOrderHistoryPage();
});

When('the user selects an order from the list', () => {
  orderHistoryPage.selectOrderFromList();
});

Then('the user should see the details of the selected order including the invoice', () => {
  orderHistoryPage.verifyOrderDetailsAndInvoice();
});

Given('the user has no past orders', () => {
  orderHistoryPage.verifyNoPastOrders();
});

Then('the user should see a message indicating that there are no past orders available', () => {
  orderHistoryPage.verifyNoPastOrdersMessage();
});

Given('the user has more orders than can fit on one page', () => {
  orderHistoryPage.verifyOrdersExceedOnePage();
});

When('the user navigates through the pages', () => {
  orderHistoryPage.navigateThroughPages();
});

Then('the user should be able to view all their past orders across multiple pages', () => {
  orderHistoryPage.verifyAllOrdersAcrossPages();
});

When('the user applies a date filter', () => {
  orderHistoryPage.applyDateFilter();
});

Then('the user should see orders that fall within the specified date range', () => {
  orderHistoryPage.verifyFilteredOrdersByDate();
});

When('the user chooses to download the invoice', () => {
  orderHistoryPage.downloadInvoice();
});

Then('the invoice should be downloaded successfully', () => {
  orderHistoryPage.verifyInvoiceDownloaded();
});