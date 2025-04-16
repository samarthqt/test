describe('Guest Checkout Process', () => {
  const shoppingCartPage = new ShoppingCartPage();
  const checkoutPage = new CheckoutPage();

  beforeEach(() => {
    cy.visit('/shopping-cart');
  });

  it('should complete checkout process as a guest', () => {
    // Step 1: Verify shopping cart page is displayed
    shoppingCartPage.verifyPageDisplayed();

    // Step 2: Proceed to checkout
    shoppingCartPage.proceedToCheckout();
    checkoutPage.verifyCheckoutPageDisplayed();

    // Step 3: Select 'Checkout as Guest'
    checkoutPage.selectGuestCheckout();
    checkoutPage.verifyGuestCheckoutFormDisplayed();

    // Step 4: Enter shipping address details
    checkoutPage.enterShippingAddress('123 Test St', 'Testville');
    checkoutPage.verifyShippingAddressDisplayed();

    // Step 5: Select a shipping method
    checkoutPage.selectShippingMethod('Standard Shipping');

    // Step 6: Enter payment details
    checkoutPage.enterPaymentDetails('4111111111111111', '12/23', '123');
    checkoutPage.verifyPaymentDetailsDisplayed();

    // Step 7: Review order summary
    checkoutPage.reviewOrderSummary();

    // Step 8: Place the order
    checkoutPage.placeOrder();
    checkoutPage.verifyOrderPlaced();

    // Step 9: Verify email confirmation
    cy.verifyEmailConfirmation();

    // Step 10: Verify order details in the system
    cy.verifyOrderInSystem();
  });
});