describe('Validate Payment Method Error Handling', () => {
  const checkoutPage = new CheckoutPage();

  beforeEach(() => {
    cy.login('12345'); // Assuming a custom command for login
    cy.visit('/cart');
    cy.addItemsToCart('56789'); // Assuming a custom command to add items to cart
    cy.visit('/checkout');
  });

  it('should display error for invalid credit card details', () => {
    checkoutPage.selectPaymentMethod('Credit Card');
    checkoutPage.enterCreditCardDetails('1111222233334444', '12/23', '123');
    checkoutPage.submitPayment();
    checkoutPage.getErrorMessage().should('contain', 'invalid credit card number');
  });

  it('should process payment successfully with valid credit card details', () => {
    checkoutPage.selectPaymentMethod('Credit Card');
    checkoutPage.enterCreditCardDetails('4111111111111111', '12/23', '123');
    checkoutPage.submitPayment();
    checkoutPage.getConfirmationMessage().should('contain', 'Payment is processed successfully');
  });

  it('should display error when submitting without selecting a payment method', () => {
    checkoutPage.submitPayment();
    checkoutPage.getErrorMessage().should('contain', 'requesting payment method selection');
  });
});