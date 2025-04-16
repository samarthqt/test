describe('Multiple Payment Methods Availability', () => {
  const loginPage = new LoginPage();
  const checkoutPage = new CheckoutPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log into the customer account', () => {
    loginPage.enterUsername('customer');
    loginPage.enterPassword('password');
    loginPage.submit();
    cy.url().should('include', '/dashboard');
  });

  it('should initiate checkout process', () => {
    checkoutPage.initiateCheckout();
    cy.url().should('include', '/checkout');
  });

  it('should display multiple payment methods', () => {
    checkoutPage.getPaymentMethods().should('contain', 'Credit Card');
    checkoutPage.getPaymentMethods().should('contain', 'PayPal');
    checkoutPage.getPaymentMethods().should('contain', 'Apple Pay');
  });

  it('should complete payment using Credit Card', () => {
    checkoutPage.selectPaymentMethod('Credit Card');
    checkoutPage.completePayment();
    cy.get('.confirmation').should('contain', 'Payment processed successfully');
  });
});