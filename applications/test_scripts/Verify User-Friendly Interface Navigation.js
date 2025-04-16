describe('TC-62 45 Verify User-Friendly Interface Navigation', () => {
  const homepage = new Homepage();
  const productPage = new ProductPage();
  const checkoutPage = new CheckoutPage();
  const accountPage = new AccountPage();

  before(() => {
    cy.login('John Doe');
  });

  it('should display the homepage with navigation menus and search bar', () => {
    homepage.visit();
    homepage.verifyNavigationMenus();
    homepage.verifySearchBar();
  });

  it('should navigate to product category section', () => {
    homepage.navigateToProductCategory('Laptop');
    productPage.verifyProductList();
  });

  it('should select a product to view its details', () => {
    productPage.selectProduct('Laptop');
    productPage.verifyProductDetails();
  });

  it('should add the product to the cart', () => {
    productPage.addToCart();
    productPage.verifyCartIconUpdate();
  });

  it('should proceed to checkout', () => {
    checkoutPage.visit();
    checkoutPage.verifyCheckoutPage();
  });

  it('should fill in the shipping information', () => {
    checkoutPage.fillShippingInformation();
    checkoutPage.verifyShippingInformation();
  });

  it('should select a payment method and enter payment details', () => {
    checkoutPage.enterPaymentDetails();
    checkoutPage.verifyPaymentSummary();
  });

  it('should review the order and confirm the purchase', () => {
    checkoutPage.confirmOrder();
    checkoutPage.verifyOrderConfirmation();
  });

  it('should navigate back to the homepage', () => {
    homepage.visit();
    homepage.verifyNavigation();
  });

  it('should use the search bar to find a specific product', () => {
    homepage.searchProduct('Laptop');
    homepage.verifySearchResults();
  });

  it('should access the user account settings from the homepage', () => {
    accountPage.visit();
    accountPage.verifyAccountSettings();
  });

  it('should log out from the user account', () => {
    accountPage.logout();
    accountPage.verifyLogout();
  });

  it('should attempt to navigate to a protected page without logging in', () => {
    cy.visitProtectedPage();
    cy.verifyRedirectToLogin();
  });

  it('should log in again and check if the cart retains the previous session's items', () => {
    cy.login('John Doe');
    homepage.verifyCartRetention();
  });

  it('should check the website's responsiveness on a mobile device', () => {
    cy.viewport('iphone-x');
    homepage.verifyResponsiveDesign();
  });
});