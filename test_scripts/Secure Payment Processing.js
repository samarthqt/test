describe('Secure Payment Processing', () => {
  const loginPage = new LoginPage();
  const cartPage = new CartPage();
  const checkoutPage = new CheckoutPage();
  const orderHistoryPage = new OrderHistoryPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in with valid credentials', () => {
    loginPage.login('testuser@example.com', 'password123');
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the shopping cart page', () => {
    cartPage.goToCart();
    cartPage.cartItems().should('contain', 'Product A').and('contain', 'Product B');
  });

  it('should proceed to checkout', () => {
    cartPage.proceedToCheckout();
    checkoutPage.verifyOrderSummary();
  });

  it('should select Credit Card as the payment method', () => {
    checkoutPage.selectPaymentMethod('Credit Card');
    checkoutPage.paymentForm().should('be.visible');
  });

  it('should enter valid credit card details', () => {
    checkoutPage.enterCreditCardDetails('4111 1111 1111 1111', '12/25', '123');
    checkoutPage.verifyCreditCardDetailsAccepted();
  });

  it('should submit the payment', () => {
    checkoutPage.submitPayment();
    checkoutPage.verifyOrderConfirmation();
  });

  it('should check the network requests for encryption', () => {
    cy.intercept('POST', '/api/payment', (req) => {
      expect(req.headers['Content-Type']).to.include('application/json');
      expect(req.body).to.have.property('encrypted', true);
    });
  });

  it('should verify the payment status in the order history', () => {
    orderHistoryPage.goToOrderHistory();
    orderHistoryPage.verifyOrderStatus('Paid');
  });

  after(() => {
    loginPage.logout();
    cy.url().should('include', '/login');
  });
});