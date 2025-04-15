describe('Email Notification on Order Delivery', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const ordersPage = new OrdersPage();
  const emailService = new EmailService();

  before(() => {
    cy.visit('/login');
  });

  it('should log in successfully and navigate to dashboard', () => {
    loginPage.login('user@example.com', 'password123');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to the Orders section', () => {
    dashboardPage.goToOrders();
    ordersPage.verifyOrdersPage();
  });

  it('should select and update order status to delivered', () => {
    ordersPage.selectOrder('123457');
    ordersPage.changeOrderStatusToDelivered();
    ordersPage.verifyOrderStatus('123457', 'delivered');
  });

  it('should verify email notification is sent', () => {
    emailService.checkEmailReceived('user@example.com', 'Your Order has been Delivered');
  });

  it('should open the email and verify its content', () => {
    emailService.openEmail('Your Order has been Delivered');
    emailService.verifyEmailContent('Order ID: 123457', 'thank you');
  });
});