describe('Price History Display Verification', () => {
  const productPage = new ProductPage();

  before(() => {
    cy.visit('/product');
  });

  it('should navigate to the product module and search for the product using Product ID: 12345', () => {
    productPage.searchProduct('12345');
    productPage.verifyProductDetails('Test Product');
  });

  it('should display the price history section when clicking on the Price History tab', () => {
    productPage.clickPriceHistoryTab();
    productPage.verifyPriceHistoryDisplayed();
  });

  it('should review the displayed price history data for completeness and accuracy', () => {
    productPage.verifyPriceHistoryData();
  });
});