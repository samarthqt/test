describe('Customer Order History Viewing', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const orderFulfillmentPage = new OrderFulfillmentPage();
  const orderHistoryPage = new OrderHistoryPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should log in and view order history', () => {
    loginPage.loginWithCredentials('validUser', 'validPassword');
    dashboardPage.verifyDashboardIsDisplayed();

    dashboardPage.navigateToOrderFulfillment();
    orderFulfillmentPage.verifyOrderFulfillmentPage();

    orderFulfillmentPage.selectOrderHistory();
    orderHistoryPage.verifyOrderHistoryPage();

    orderHistoryPage.searchByCustomerId('CUST789');
    orderHistoryPage.verifyOrderListDisplayed('CUST789');

    orderHistoryPage.viewOrderDetails('ORD123');
    orderHistoryPage.verifyOrderDetails('Laptop, Model XYZ', 'Credit Card', 'Delivered');

    orderHistoryPage.navigateBackToOverview();
    orderHistoryPage.filterOrdersByStatus('Pending');
    orderHistoryPage.selectPendingOrderAndVerifyPaymentMethod();

    orderHistoryPage.exportOrderHistoryToExcel();
    dashboardPage.logout();

    loginPage.loginWithCredentials('validUser', 'validPassword');
    dashboardPage.navigateToOrderFulfillment();
    orderFulfillmentPage.selectOrderHistory();
    orderHistoryPage.searchByCustomerId('NEWCUSTID');
    orderHistoryPage.viewOrderDetails('NEWORDID');
  });
});