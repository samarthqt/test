describe('Tax Calculation Based on User Location', () => {
  const username = 'testuser';
  const password = 'password123';
  const productPrice = 100;
  const nyTaxRate = 0.08875;
  const caTaxRate = 0.0725;

  before(() => {
    cy.visit('/login');
    cy.login(username, password);
  });

  it('should verify tax calculation for New York location', () => {
    cy.navigateToAccountSettings();
    cy.verifyLocationServicesEnabled();
    cy.addProductToCart(productPrice);
    cy.proceedToCheckout();
    cy.verifyTaxCalculation(nyTaxRate);
  });

  it('should update location to California and verify tax', () => {
    cy.changeUserLocation('California');
    cy.refreshCheckoutPage();
    cy.verifyTaxCalculation(caTaxRate);
  });

  it('should complete the purchase and verify order', () => {
    cy.completePurchase();
    cy.verifyOrderConfirmationEmail();
  });

  it('should verify tax calculation with different product price', () => {
    const newProductPrice = 200;
    cy.addProductToCart(newProductPrice);
    cy.proceedToCheckout();
    cy.verifyTaxCalculation(nyTaxRate, newProductPrice);
  });

  it('should verify tax calculation for international location', () => {
    cy.changeUserLocation('Canada');
    cy.refreshCheckoutPage();
    cy.verifyInternationalTaxCalculation();
  });

  it('should verify tax calculation is disabled when location services are off', () => {
    cy.disableLocationServices();
    cy.proceedToCheckout();
    cy.verifyTaxCalculationDisabled();
  });

  after(() => {
    cy.logout();
  });
});