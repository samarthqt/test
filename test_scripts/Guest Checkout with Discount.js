describe('Guest Checkout with Discount', () => {
  const shoppingCartPage = new ShoppingCartPage();
  const checkoutPage = new CheckoutPage();

  before(() => {
    cy.visit('/shopping-cart');
  });

  it('should apply discount during guest checkout', () => {
    shoppingCartPage.verifyItemsListed();
    shoppingCartPage.clickProceedToCheckout();
    checkoutPage.selectCheckoutAsGuest();
    checkoutPage.enterShippingAddress('456 Elm St, Othertown, USA');
    checkoutPage.selectPaymentMethod('Credit Card');
    checkoutPage.enterDiscountCode('SAVE20');
    checkoutPage.verifyDiscountApplied();
    checkoutPage.clickPlaceOrder();
    checkoutPage.verifyOrderConfirmation();
    checkoutPage.verifyOrderConfirmationEmail();
  });
});