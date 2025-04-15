describe('Verify Shipping Options Display', () => {
  const checkoutPage = new CheckoutPage();

  beforeEach(() => {
    cy.login('12345');
    cy.addItemsToCart('56789');
    cy.visit('/checkout');
  });

  it('should display order summary and shipping options', () => {
    checkoutPage.verifyOrderSummary();
    checkoutPage.verifyShippingOptionsDisplayed();
  });

  it('should update shipping options based on entered location', () => {
    checkoutPage.enterShippingAddress('123 Main St, Springfield');
    checkoutPage.verifyShippingOptionsUpdated();
  });

  it('should display available shipping options with estimates and costs', () => {
    checkoutPage.viewShippingOptions();
    checkoutPage.verifyShippingEstimatesAndCosts();
  });

  it('should highlight selected shipping option in order summary', () => {
    checkoutPage.selectShippingOption('Express Shipping');
    checkoutPage.verifySelectedShippingOption();
  });

  it('should update shipping options for new location', () => {
    checkoutPage.changeShippingAddress('456 Elm St, Springfield');
    checkoutPage.verifyShippingOptionsUpdated();
  });

  it('should reflect accurate shipping cost for chosen delivery speed', () => {
    checkoutPage.verifyShippingCostChanges();
  });
});