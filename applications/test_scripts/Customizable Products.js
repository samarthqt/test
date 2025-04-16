describe('Customizable Products Test Suite', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const productPage = new ProductPage();
  const cartPage = new CartPage();
  const checkoutPage = new CheckoutPage();
  const orderHistoryPage = new OrderHistoryPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in to the user account', () => {
    loginPage.login('validUsername', 'validPassword');
    homePage.verifyUserLoggedIn();
  });

  it('should search for the customizable product using Product ID: 11223', () => {
    homePage.searchProductById('11223');
    productPage.verifyProductDetails();
  });

  it('should select the customization option for engraving', () => {
    productPage.selectCustomizationOption('Engraving');
    productPage.verifyEngravingOptionSelected();
  });

  it('should enter the engraving text Happy Birthday', () => {
    productPage.enterEngravingText('Happy Birthday');
    productPage.verifyEngravingTextEntered();
  });

  it('should add the customized product to the cart', () => {
    productPage.addToCart();
    cartPage.verifyProductAddedToCart();
  });

  it('should proceed to checkout', () => {
    cartPage.proceedToCheckout();
    checkoutPage.verifyCheckoutPage();
  });

  it('should verify the customization details in the order summary', () => {
    checkoutPage.verifyCustomizationDetailsInSummary();
  });

  it('should complete the payment process', () => {
    checkoutPage.completePayment();
    checkoutPage.verifyOrderConfirmation();
  });

  it('should verify the customization details in the order confirmation', () => {
    checkoutPage.verifyCustomizationDetailsInConfirmation();
  });

  it('should navigate to the order history page', () => {
    orderHistoryPage.navigate();
    orderHistoryPage.verifyRecentOrderDetails();
  });

  it('should log out from the user account', () => {
    homePage.logout();
    loginPage.verifyUserLoggedOut();
  });
});