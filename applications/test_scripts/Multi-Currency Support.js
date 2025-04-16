describe('Multi-currency Support Test Suite', () => {
  const currencySupportPage = new CurrencySupportPage();
  const loginPage = new LoginPage();
  const orderPage = new OrderPage();
  const checkoutPage = new CheckoutPage();

  before(() => {
    // Log into the system with admin credentials
    cy.visit('/login');
    loginPage.loginAsAdmin();
    cy.url().should('include', '/dashboard');
  });

  it('should verify exchange rates for GBP', () => {
    // Navigate to the 'Currency Support' module
    currencySupportPage.navigateToCurrencySupport();
    cy.url().should('include', '/currency-support');

    // Verify that exchange rates are configured for GBP
    currencySupportPage.verifyExchangeRate('GBP', 0.75);
  });

  it('should locate order ID 11223 and verify price conversion to GBP', () => {
    // Locate order ID 11223 in the system
    orderPage.locateOrderById('11223');
    orderPage.verifyOrderDetailsDisplayed();

    // Select the option to view prices in GBP
    orderPage.viewPricesInGBP();

    // Verify the product price in GBP
    orderPage.verifyProductPriceInGBP(75);
  });

  it('should proceed to checkout and complete payment in GBP', () => {
    // Proceed to checkout and select GBP as the payment currency
    checkoutPage.proceedToCheckoutWithCurrency('GBP');

    // Complete the payment process using GBP
    checkoutPage.completePayment();

    // Verify the order confirmation details
    checkoutPage.verifyOrderConfirmationInGBP();
  });

  after(() => {
    // Log out of the system
    loginPage.logout();
    cy.url().should('include', '/login');
  });
});