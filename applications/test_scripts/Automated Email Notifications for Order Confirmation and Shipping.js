describe('Automated Email Notifications for Order Confirmation and Shipping', () => {
  const loginPage = new LoginPage();
  const orderHistoryPage = new OrderHistoryPage();
  const orderPage = new OrderPage();
  const emailService = new EmailService();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should log in to the user account', () => {
    loginPage.enterEmail('user@example.com');
    loginPage.enterPassword('password');
    loginPage.submit();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to Order History', () => {
    orderHistoryPage.navigateToOrderHistory();
    orderHistoryPage.verifyOrderHistoryPage();
  });

  it('should place a new order and verify confirmation email', () => {
    orderPage.placeOrder();
    orderPage.verifyOrderConfirmation();
    emailService.verifyEmailReceived('user@example.com', 'Order Confirmation');
  });

  it('should proceed with shipping and verify shipping email', () => {
    orderPage.proceedWithShipping();
    orderPage.verifyOrderShipped();
    emailService.verifyEmailReceived('user@example.com', 'Shipping Confirmation');
  });
});