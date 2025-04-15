describe('Product Price Comparison', () => {
  const productCategoryPage = new ProductCategoryPage();
  const comparisonPage = new ComparisonPage();

  beforeEach(() => {
    cy.login();
    productCategoryPage.navigate();
  });

  it('should allow users to compare prices of similar products', () => {
    productCategoryPage.selectProducts(['P123', 'P456', 'P789']);
    productCategoryPage.clickCompareButton();

    comparisonPage.verifyComparisonPageDisplayed();
    comparisonPage.verifyProductDetails();
    comparisonPage.verifyPriceVariationsAndDiscounts();
    comparisonPage.verifyResponsiveness();
    comparisonPage.addToCartFromComparison();
    comparisonPage.removeProductFromComparison('P456');
    comparisonPage.verifySharingOptions();
    comparisonPage.verifySortingFunctionality();
    comparisonPage.verifyPageLoadPerformance();
    comparisonPage.verifyBackButtonFunctionality();
    comparisonPage.verifyProductImagesAccuracy();
    comparisonPage.verifyAccessibility();
    comparisonPage.verifyRealTimeDataUpdate();
  });
});