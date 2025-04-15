describe('Email Notification on Order Shipment', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const ordersPage = new OrdersPage();
  const emailPage = new EmailPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in to the web application', () => {
    loginPage.login('user@example.com', 'password123');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to the Orders section', () => {
    dashboardPage.navigateToOrders();
    ordersPage.verifyOrdersPage();
  });

  it('should select an order with Order ID: 123456', () => {
    ordersPage.selectOrder('123456');
    ordersPage.verifyOrderDetails('123456');
  });

  it('should change the order status to shipped', () => {
    ordersPage.changeOrderStatusToShipped('123456');
    ordersPage.verifyOrderStatus('shipped');
  });

  it('should verify that an email notification is sent', () => {
    emailPage.verifyEmailReceived('Your Order has Shipped');
  });

  it('should open the email received', () => {
    emailPage.openEmail('Your Order has Shipped');
    emailPage.verifyEmailContent('123456');
  });
});