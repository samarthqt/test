describe('TC-61: View Prices in Multiple Currencies', () => {
  const productPage = new ProductPage();
  const cartPage = new CartPage();
  const checkoutPage = new CheckoutPage();
  const accountPage = new AccountPage();

  before(() => {
    cy.login();
  });

  it('should display product page with default currency USD', () => {
    productPage.navigateToProduct('P12345');
    productPage.verifyCurrency('USD');
  });

  it('should change currency to EUR and verify price', () => {
    productPage.selectCurrency('EUR');
    productPage.verifyCurrencySymbol('€');
  });

  it('should change currency back to USD', () => {
    productPage.selectCurrency('USD');
    productPage.verifyCurrencySymbol('$');
  });

  it('should add product to cart and verify currency in cart', () => {
    productPage.addToCart();
    cartPage.navigateToCart();
    cartPage.verifyProductCurrency('USD');
  });

  it('should proceed to checkout and verify currency', () => {
    cartPage.proceedToCheckout();
    checkoutPage.verifyTotalCurrency('USD');
    checkoutPage.verifyCurrencyConversionRate();
  });

  it('should complete the purchase and verify confirmation', () => {
    checkoutPage.completePurchase();
    checkoutPage.verifyOrderConfirmationCurrency('USD');
  });

  it('should verify order confirmation email currency', () => {
    cy.checkOrderConfirmationEmail('USD');
  });

  it('should retain currency setting after logout and login', () => {
    cy.logout();
    cy.login();
    accountPage.verifyCurrencySetting('USD');
  });

  it('should handle non-supported currency selection', () => {
    productPage.selectCurrency('XYZ');
    productPage.verifyCurrencyErrorOrDefault('USD');
  });

  it('should allow currency change during checkout', () => {
    checkoutPage.changeCurrencyDuringCheckout('EUR');
    checkoutPage.verifyTotalCurrency('EUR');
  });

  it('should verify currency change reflects in user account settings', () => {
    accountPage.verifyCurrencySetting('EUR');
  });
});