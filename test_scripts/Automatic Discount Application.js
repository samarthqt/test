describe('Automatic Discount Application', () => {
  const checkoutPage = new CheckoutPage();

  before(() => {
    cy.visit('/checkout');
  });

  it('should display the checkout page with items listed', () => {
    checkoutPage.verifyPageIsDisplayed();
    checkoutPage.verifyCartTotal('$100');
  });

  it('should apply discount automatically and update cart total', () => {
    checkoutPage.proceedToPayment();
    checkoutPage.verifyUpdatedCartTotal('$90');
  });
});