describe('Guest Checkout Process', () => {
  const checkoutPage = new CheckoutPage();

  before(() => {
    cy.visit('/shopping-cart');
  });

  it('should navigate to the shopping cart page with items listed', () => {
    cy.url().should('include', '/shopping-cart');
    cy.get('.cart-items').should('be.visible');
  });

  it('should proceed to checkout as guest', () => {
    checkoutPage.proceedToCheckout();
    cy.get('.login-prompt').should('be.visible');
    checkoutPage.checkoutAsGuest();
    cy.url().should('include', '/guest-checkout');
  });

  it('should enter shipping address and select PayPal as payment method', () => {
    checkoutPage.enterShippingAddress('123 Main St, Anytown, USA');
    checkoutPage.selectPaymentMethod('PayPal');
    cy.get('.shipping-address').should('contain', '123 Main St, Anytown, USA');
    cy.get('.payment-method').should('contain', 'PayPal');
  });

  it('should place the order successfully', () => {
    checkoutPage.placeOrder();
    cy.get('.confirmation-message').should('be.visible');
  });

  it('should verify order confirmation email is received', () => {
    cy.wait(5000); // Wait for email to be received
    cy.getInboxEmails().then(emails => {
      const confirmationEmail = emails.find(email => email.subject.includes('Order Confirmation'));
      expect(confirmationEmail).to.exist;
    });
  });
});