describe('Verify Discounted Price Display for Product Bundles', () => {
  const productBundlesPage = new ProductBundlesPage();
  const shoppingCartPage = new ShoppingCartPage();

  before(() => {
    cy.login();
  });

  it('should navigate to the product bundles section', () => {
    productBundlesPage.navigateToProductBundles();
    productBundlesPage.verifyOnProductBundlesPage();
  });

  it('should select the Summer Fun Pack bundle', () => {
    productBundlesPage.selectBundle('Summer Fun Pack');
    productBundlesPage.verifyBundleSelected('Summer Fun Pack');
  });

  it('should verify the discounted price is displayed', () => {
    productBundlesPage.verifyDiscountedPrice();
  });

  it('should add the bundle to the shopping cart', () => {
    productBundlesPage.addBundleToCart();
    shoppingCartPage.verifyBundleInCart('Summer Fun Pack');
  });

  it('should verify the price in the shopping cart', () => {
    shoppingCartPage.verifyDiscountedPriceInCart('Summer Fun Pack');
  });
});