describe('Edge Case: Price History with No Changes', () => {
  it('should display price history for a product with no historical changes', () => {
    const productPage = new ProductPage();
    productPage.navigateToProductModule();
    productPage.searchProductById('67890');
    productPage.verifyProductDetailsDisplayed('Static Price Product');
    productPage.clickPriceHistoryTab();
    productPage.verifyNoPriceHistoryChanges();
  });
});