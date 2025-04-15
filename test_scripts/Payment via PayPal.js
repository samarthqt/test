describe('PayPal Payment Test', () => {
  const checkoutPage = new CheckoutPage();
  const paypalPage = new PayPalPage();

  beforeEach(() => {
    cy.visit('/checkout');
  });

  it('should allow user to make payment via PayPal', () => {
    checkoutPage.verifyItemsListed();
    checkoutPage.selectPayPalAsPaymentMethod();
    paypalPage.verifyRedirectToPayPalLogin();
    paypalPage.enterEmail('user@example.com');
    paypalPage.completeLogin();
    paypalPage.confirmPayment();
    checkoutPage.verifyRedirectToConfirmationPage();
  });
});