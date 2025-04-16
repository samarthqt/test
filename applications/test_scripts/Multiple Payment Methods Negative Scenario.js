describe('Multiple Payment Methods Negative Scenario', () => {
  const loginPage = new LoginPage();
  const checkoutPage = new CheckoutPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log into the customer account', () => {
    loginPage.login('customer@example.com', 'password123');
    cy.url().should('include', '/dashboard');
  });

  it('should initiate checkout process', () => {
    checkoutPage.initiateCheckout();
    cy.url().should('include', '/checkout');
  });

  it('should display error when selecting a disabled payment method', () => {
    checkoutPage.selectPaymentMethod('disabled-method');
    cy.contains('Payment method is unavailable').should('be.visible');
  });
});