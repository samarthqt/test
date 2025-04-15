describe('Product Sorting Functionality', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const catalogPage = new CatalogPage();

  beforeEach(() => {
    cy.visit('/');
    loginPage.login('validUser', 'validPassword');
    homePage.verifyLoginSuccess();
  });

  afterEach(() => {
    homePage.logout();
    homePage.verifyLogoutSuccess();
  });

  it('should sort products by price, popularity, and rating', () => {
    homePage.navigateToCatalog();
    catalogPage.verifyCatalogPage();

    catalogPage.sortBy('Price');
    catalogPage.verifySorting('Price');

    catalogPage.sortBy('Popularity');
    catalogPage.verifySorting('Popularity');

    catalogPage.sortBy('Rating');
    catalogPage.verifySorting('Rating');
  });

  it('should retain sorting preferences after adding a product to the cart', () => {
    homePage.navigateToCatalog();
    catalogPage.sortBy('Price');
    catalogPage.addProductToCart();
    catalogPage.verifySorting('Price');
  });

  it('should verify sorting options on mobile devices', () => {
    cy.viewport('iphone-6');
    homePage.navigateToCatalog();
    catalogPage.verifySortingOptions();
  });

  it('should perform efficiently with a large product catalog', () => {
    homePage.navigateToCatalog();
    catalogPage.verifyLargeCatalogPerformance();
  });

  it('should work accurately with filters applied', () => {
    homePage.navigateToCatalog();
    catalogPage.applyFilter('Category', 'Electronics');
    catalogPage.sortBy('Rating');
    catalogPage.verifySortingWithFilter('Rating');
  });
});