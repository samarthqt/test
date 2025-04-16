describe('Free Shipping Negative Scenario', () => {
  it('should not apply free shipping for orders below $100', () => {
    const loginPage = new LoginPage();
    const cartPage = new CartPage();
    const checkoutPage = new CheckoutPage();

    // Step 1: Log into the customer account
    loginPage.visit();
    loginPage.fillUsername('testuser');
    loginPage.fillPassword('password123');
    loginPage.submit();
    cy.url().should('include', '/dashboard');

    // Step 2: Add products to the cart with a total below $100
    cartPage.visit();
    cartPage.addProductToCart('Product1', 2); // assuming each product costs $40
    cartPage.getCartTotal().should('eq', '$80');

    // Step 3: Proceed to checkout
    checkoutPage.visit();
    checkoutPage.getShippingOptions().should('not.contain', 'Free Shipping');
  });
});