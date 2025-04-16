describe('Customizable Products Failure Test', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const productPage = new ProductPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in and navigate to the home page', () => {
    loginPage.login('validUsername', 'validPassword');
    homePage.verifyHomePage();
  });

  it('should search for the customizable product using Product ID: 33445', () => {
    homePage.searchProductById('33445');
    productPage.verifyProductDetails();
  });

  it('should display error when selecting a non-existent customization option', () => {
    productPage.selectCustomizationOption('Non-existent');
    productPage.verifyInvalidCustomizationError();
  });

  it('should display error when entering invalid engraving text', () => {
    productPage.enterEngravingText('Invalid');
    productPage.verifyInvalidEngravingError();
  });

  it('should not add product with invalid customization to the cart', () => {
    productPage.addToCart();
    productPage.verifyProductNotAddedToCart();
  });

  after(() => {
    homePage.logout();
    loginPage.verifyLogout();
  });
});