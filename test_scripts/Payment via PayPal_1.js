describe('Payment via PayPal', () => {
  const shoppingCartPage = new ShoppingCartPage();
  const checkoutPage = new CheckoutPage();
  const paypalPage = new PayPalPage();

  before(() => {
    cy.visit('/shopping-cart');
  });

  it('should navigate to the shopping cart page', () => {
    shoppingCartPage.verifyPageLoaded();
  });

  it('should proceed to checkout', () => {
    shoppingCartPage.clickProceedToCheckout();
    checkoutPage.verifyPageLoaded();
  });

  it('should select PayPal as the payment method', () => {
    checkoutPage.selectPaymentMethod('PayPal');
  });

  it('should redirect to PayPal login page', () => {
    checkoutPage.clickPayWithPayPal();
    paypalPage.verifyLoginPageLoaded();
  });

  it('should log in to PayPal', () => {
    paypalPage.login('user@example.com', 'password123');
  });

  it('should confirm payment through PayPal', () => {
    paypalPage.confirmPayment();
    checkoutPage.verifyPaymentConfirmation();
  });
});