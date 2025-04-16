describe('Eco-Friendly Packaging Option', () => {
  const checkoutPage = new CheckoutPage();
  const orderHistoryPage = new OrderHistoryPage();
  const emailConfirmationPage = new EmailConfirmationPage();
  const packagingOptionsPage = new PackagingOptionsPage();

  beforeEach(() => {
    cy.login('Jane Smith');
    cy.addItemToCart('Smartphone');
    checkoutPage.visit();
  });

  it('should allow selecting eco-friendly packaging during checkout', () => {
    checkoutPage.selectEcoFriendlyPackaging();
    checkoutPage.verifyEcoFriendlyPackagingSelected();
  });

  it('should display eco-friendly packaging in the order summary', () => {
    checkoutPage.reviewOrderSummary();
    checkoutPage.verifyOrderSummaryIncludesEcoFriendlyPackaging();
  });

  it('should complete checkout with eco-friendly packaging noted', () => {
    checkoutPage.completeCheckout();
    checkoutPage.verifyOrderConfirmationIncludesEcoFriendlyPackaging();
  });

  it('should show eco-friendly packaging in order history', () => {
    orderHistoryPage.visit();
    orderHistoryPage.verifyEcoFriendlyPackagingInOrder();
  });

  it('should include eco-friendly packaging details in email confirmation', () => {
    emailConfirmationPage.visit();
    emailConfirmationPage.verifyEcoFriendlyPackagingDetails();
  });

  it('should not allow changing packaging option after confirmation', () => {
    checkoutPage.attemptToChangePackagingOption();
    checkoutPage.verifyPackagingOptionCannotBeChanged();
  });

  it('should display packaging options page with eco-friendly info', () => {
    packagingOptionsPage.visit();
    packagingOptionsPage.verifyEcoFriendlyInfoDisplayed();
  });

  it('should display additional charges for eco-friendly packaging', () => {
    packagingOptionsPage.verifyAdditionalChargesForEcoFriendly();
  });

  it('should allow eco-friendly packaging selection on mobile devices', () => {
    cy.viewport('iphone-6');
    checkoutPage.visit();
    checkoutPage.verifyEcoFriendlyPackagingSelectable();
  });

  it('should have eco-friendly packaging option for all products', () => {
    cy.addItemToCart('Laptop');
    checkoutPage.visit();
    checkoutPage.verifyEcoFriendlyPackagingAvailable();
  });

  it('should allow guest checkout with eco-friendly packaging', () => {
    cy.logout();
    cy.addItemToCart('Smartphone');
    checkoutPage.visit();
    checkoutPage.verifyGuestCanSelectEcoFriendlyPackaging();
  });

  it('should save eco-friendly packaging option for future orders', () => {
    checkoutPage.verifyPackagingPreferenceSaved();
  });

  it('should allow deselecting eco-friendly packaging option', () => {
    checkoutPage.deselectEcoFriendlyPackaging();
    checkoutPage.verifyPackagingOptionDeselected();
  });

  it('should consistently display eco-friendly packaging across browsers', () => {
    cy.visit('https://example.com', { browser: 'firefox' });
    checkoutPage.verifyEcoFriendlyPackagingDisplayed();
  });
});